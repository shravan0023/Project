package controllers;

import org.springframework.stereotype.Controller;
import dao.productServices;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.validation.Valid;*/
import javax.validation.Valid;

import org.hibernate.cfg.annotations.MapBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.MailSender;
/*import org.springframework.mail.SimpleMailMessage;*/
/*import org.springframework.mail.javamail.JavaMailSender;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

import dao.productServices;
import model.customer;
import model.Product;




@EnableWebMvc
@Controller
public class HelloController {
	

	  
    @Autowired
  public productServices productService;
    /*@Autowired
  public customerServices customerService; 
  */

    @RequestMapping("/")
    public String showIndex()
    {
    	return "index";
    }
    
    /*@RequestMapping("admin")
    public String showSignIn()
    {
    	return "Products";
    }*/
    @RequestMapping("signin")
    public String showloginIn()
    {
    	return "signin";
    }

    @RequestMapping("registrationform")
    public String showreg()
    {
    	return "registrationform";
    }
    @RequestMapping("index")
    public String showMain()
    {
    	return "index";
    }
    @RequestMapping("productDescription")
    public String showproductdesc()
    {
    	return "productDescription";
    }
    
    
    
    /*@RequestMapping(value="/customer" ,method = RequestMethod.POST )
    public String listProduct(Model model) {
    	
    	model.addAttribute("product", new Product());
        model.addAttribute("listProduct", this.productService.listProduct());
    	return "productTableUser";
    }*/
   
    
    
    /*@RequestMapping("Products")
    public String showProduct(){
    	
    	return "Products";
    }*/
    @RequestMapping("Home")
    public String showHome(){
    	
    	return "index";
    }
    

    @RequestMapping(value = "/Products", method=RequestMethod.GET )
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProduct", this.productService.listProduct());
        return "Products";
    }
   
     
    //For add and update person both
    @RequestMapping(value= "addProduct", method = RequestMethod.GET)
    public String addProduct(@ModelAttribute("product") Product p){
         
     
    	
    	if(p.getId() == 0){
            //new person, add it
            this.productService.addProduct(p);
        }else{
            //existing person, call update
            this.productService.editProduct(p);
        }
         
        return "addProduct";
         
    }
    
    @RequestMapping("/updProduct")
    public String updateProduct(@ModelAttribute("product") Product p)
    {
    	this.productService.editProduct(p);
        return "redirect/updProduct";
    }
 

    	


    
  /*  @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
         
        this.productService.removeProduct(id);
        return "redirect:/product";
    }
  
    */
    
    @RequestMapping("/details/{id}")
    public String getProductById(@PathVariable("id") int id,Model model) 
    {
    	model.addAttribute("product", this.productService.getProductById(id));    
        model.addAttribute("listProduct",this.productService.listProduct());
        return "redirect:/productDescription";
    }
    
    
    
    @RequestMapping("/delete/{id}")
    public String removeProduct(@PathVariable("id") int id)
    {
        this.productService.removeProduct(id);
        return "redirect:/Products";
    }
   
    @RequestMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProduct", this.productService.listProduct());
        return "redirect:/updProduct";
    } 
	
	/*@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("Products");

		return model;

	}}*/

	/*//Spring Security see this :
	@RequestMapping(value = "/admin_login", method = RequestMethod.POST)
	public ModelAndView SignIn(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("Products");

		return model;
		}
*/
    	
	@RequestMapping("/customerproduct")
	//@ResponseBody
	public ModelAndView showcustproduct()
	{
		List<Product> listtojsp=new ArrayList<Product>();
		listtojsp=productService.listProduct();
		String json = new Gson().toJson(listtojsp);  // converting list into Google Gson object which is a string
		System.out.println(json);
		ModelAndView mv=new ModelAndView("customerproduct");
		mv.addObject("myJson", json);
		return mv;
	}
	 @RequestMapping("/mailing")
	    public String showmail()
	    {
	    	return "mailing";
	    }
	
	  @Autowired
	    private JavaMailSender mailSender;

    @RequestMapping(value="/sendEmail", method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {
        // takes input from e-mail form
        String recipientAddress = request.getParameter("email");
        String fname=request.getParameter("first_name");
        String subject ="musichub :: Your Friend Recommends..." +request.getParameter("musichub alert");
        String message = request.getParameter("comments");
        String finalmessage="Hi "+fname+", "+" "+message+"!!! "+"Check this out!!!";
         
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + finalmessage);
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(finalmessage);
         
        // sends the e-mail
        mailSender.send(email);
         
        // forwards to the view named "Result"
        return "redirect:/customerproduct";
    }
  
}
