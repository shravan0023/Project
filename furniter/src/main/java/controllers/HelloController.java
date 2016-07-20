package controllers;

import org.springframework.stereotype.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.validation.Valid;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
  /*import org.springframework.mail.SimpleMailMessage;*/
/*import org.springframework.mail.javamail.JavaMailSender;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


import dao.productServices;
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
    @RequestMapping("/index")
    public String showIndexNow()
    {
    	return "index";
    }
    
    
  /*  @RequestMapping(value="/customer" ,method = RequestMethod.POST )
    public String listProduct(Model model) {
    	
    	model.addAttribute("product", new Product());
        model.addAttribute("listProduct", this.productService.listProduct());
    	return "productTableUser";
    }*/
    @RequestMapping("/signin")
	public String signin()
	{
		return "signin";
	}
    @RequestMapping("Register")
    public String showRegisterPage(){
    	
    	return "Register";
    }
    
    @RequestMapping("product")
    public String showProduct(){
    	
    	return "product";
    }
 /*  @RequestMapping("addProduct")
    public String showProductTable(){
    	
    	
    	return "addProduct";
    }
*/
    @RequestMapping(value = "/Products", method=RequestMethod.GET )
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProduct", this.productService.listProduct());
        return "Products";
    }
   
     
    //For add and update person both
    @RequestMapping(value= "/addProduct", method = RequestMethod.GET)
    public String addProduct(@ModelAttribute("product") Product p){
         
     
    	
    	if(p.getId() == 0){
            //new person, add it
            this.productService.addProduct(p);
        }else{
            //existing person, call update
            this.productService.updateProduct(p);
        }
         
        return "addProduct";
         
    }
    
    @RequestMapping("/updProduct")
    public String updateProduct(@ModelAttribute("product") Product p)
    {
    	this.productService.updateProduct(p);
        return "index";
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
        return "redirect:/Products";
    } 
	
        
}
