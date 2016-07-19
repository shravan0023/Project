package dao;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.product;



 
@Repository
public class productdaoimpl  {
     
    private static final Logger logger = LoggerFactory.getLogger(productdaoimpl.class);
 
    @Autowired
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
  
    public void addProduct(product p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Product saved successfully, Product Details="+p);
    }
 
  
    public void updateProduct(product p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Product updated successfully, Product Details="+p);
    }
 
    @SuppressWarnings("unchecked")
   
    public List<product> listproduct() {
        Session session = this.sessionFactory.getCurrentSession();
        List<product> productList = session.createQuery("from Product").list();
        for(product p : productList)
        {
            logger.info("Product List::"+p);
        }
        return productList;
    }
 
    
    public product getProductById(int ID) {
        Session session = this.sessionFactory.getCurrentSession();      
        product p = (product) session.load(product.class, new Integer(ID));
        logger.info("Product loaded successfully, Person details="+p);
        return p;
    }
 

    public void removeProduct(int iD) {
        Session session = this.sessionFactory.getCurrentSession();
        product p = (product) session.load(product.class, new Integer(iD));
        if(null != p){
            session.delete(p);
        }
        logger.info("Product deleted successfully, Product details="+p);
    }
 
}


		
	
