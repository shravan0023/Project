package dao;
import model.customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 

 
@Service
public class customerServices {
     
	@Autowired
    private customerDAOImpl customerDAO;
 
    public void setPersonDAO(customerDAOImpl customerDAO) {
        this.customerDAO = customerDAO;
    }
 
   
    @Transactional
    public void addcustomer(customer c) {
        this.customerDAO.addcustomer(c);
    }
 
  
    @Transactional
    public void editcustomer(customer c) {
        this.customerDAO.editcustomer(c);
    }
 
  
    @Transactional
    public List<customer> listcustomer() {
        return this.customerDAO.listcustomer();
    }
 
  
    @Transactional
    public customer getcustomerById(int id) {
        return this.customerDAO.getcustomerById(id);
    }
 
 
    @Transactional
    public void removecustomer(int id) 
    {
        this.customerDAO.removecustomer(id);
    }


	public customer findByUsername(customer username) {
		
		return username;
	}
 
}



