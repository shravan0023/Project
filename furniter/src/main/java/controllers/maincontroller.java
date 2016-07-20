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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dao.productservice;
import model.productVO;

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
    public String showprodcuct()
    {
    	return "product";
    }
     @RequestMapping("SignUp")
     public String showSignUp()
     {
     	return "SignUp";
     }
     @RequestMapping("addproduct")
     public String showaddproduct()
     {
     	return "addproduct";
     }
     @RequestMapping("Home")
     public String showHome()
     {
     	return "index";
     }
   
     
     @RequestMapping(value="/add" ,method = RequestMethod.GET )
     public String addProduct(@ModelAttribute ("product") productVO p){
     	if (p.getID()==0){
     	this.productService.addProduct(p);
     	}
     	
     	return "add";
     }
   
} 
     
