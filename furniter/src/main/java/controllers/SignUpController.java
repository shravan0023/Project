package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.customer;

import dao.customerServices;

@Controller
//@RequestMapping("/customer")
public class SignUpController {
	
	@Autowired
	  public customerServices customerService;
	
	@Qualifier(value="customerService")
  public void setPersonService(customerServices ps){
      this.customerService = ps;
  }

	@RequestMapping(value = "/customer/signup", method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute ("customer") customer c, BindingResult result) {

		if (result.hasErrors()) {
			return "registrationform";
		} else {
			if(c.getId() == 0){
	            //new person, add it
	            this.customerService.addcustomer(c);
	        }else{
	            //existing person, call update
	            this.customerService.editcustomer(c);
	        }
			return "SignIn";
		}

	}

	@RequestMapping(value="/customer",method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {

		model.addAttribute("customer", new customer());
		return "registrationform";

	}
	
	

}
