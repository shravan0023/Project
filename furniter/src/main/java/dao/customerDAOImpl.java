package dao;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.customer;


 
@Repository
public class customerDAOImpl  {
     
    private static final Logger logger = LoggerFactory.getLogger(customerDAOImpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
  
    public void addcustomer(customer c)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("customer saved successfully, customer Details="+c);
    }
 
  
    public void editcustomer(customer c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("customer edited successfully, customer Details="+c);
    }
 
    @SuppressWarnings("unchecked")
   
    public List<customer> listcustomer() {
        Session session = this.sessionFactory.getCurrentSession();
        List<customer> customerList = session.createQuery("from customer").list();
        for(customer c : customerList)
        {
            logger.info("customer List::"+c);
        }
        return customerList;
    }
 
    
    public customer getcustomerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        customer c = (customer) session.load(customer.class, new Integer(id));
        logger.info("customer loaded successfully, Person details="+c);
        return c;
    }
 

    public void removecustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        customer c = (customer) session.load(customer.class, new Integer(id));
        if(null != c){
            session.delete(c);
        }
        logger.info("customer deleted successfully, customer details="+c);
    }
    
    
 
}