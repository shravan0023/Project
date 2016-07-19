package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dao.productservice;
import model.product;

//import dao.servicesImpl;

@EnableWebMvc
@Controller
public class maincontroller {
	
	@Autowired
	  public dao.productservice productService;
	
	@Qualifier(value="productService")
    public void setPersonService(dao.productservice ps){
        this.productService = ps;
    }
	
    @RequestMapping("/")
    public String showIndex()
    {
    	return "index";
    }
    @RequestMapping("product")
    public String showproduct()
    {
    	return "product";
    }
   
   
    
     @RequestMapping("SignUp")
     public String showSignUp()
     {
     	return "SignUp";
     }
    
     @RequestMapping("Home")
     public String showHome()
     {
     	return "index";
     }
    
     
         
     
     //For add and update person both
     @RequestMapping(value= "/addproduct", method = RequestMethod.GET)
     public String addaddProduct(@ModelAttribute("product") product p){
          
         if(p.getid() == 0){
             //new person, add it
             this.productService.addProduct(p);
         }else{
             //existing person, call update
             this.productService.updateProduct(p);
         }
          
         return "addproduct";
          
     }

     @RequestMapping("/ProductDescription")
     public String showProductDescription()
     {
     	return "ProductDescription";
     }
         
        
    /* @RequestMapping("/addproduct" )
     public String listProducts(Model model)
     {
         model.addAttribute("product", new product());
         model.addAttribute("listProduct", this.productService.listProduct());
         return "addproduct";
     }*/
        
        
          
         @RequestMapping("/remove/{id}")
         public String removeProduct(@PathVariable("id") int id){
              
             this.productService.removeProduct(id);
             return "redirect:/productTable";
         }
       
        
         @RequestMapping("/edit/{id}")
         public String editProduct(@PathVariable("id") int id, Model model){
             model.addAttribute("product", this.productService.getProductById(id));
             model.addAttribute("listProduct", this.productService.listProduct());
             return "productTable";
         }
         
        
     	
         
     	
             
     }

    
   

     
