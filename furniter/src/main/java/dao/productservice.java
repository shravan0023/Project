package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.productdaoimpl;
import model.product;


 

 
@Service
public class productservice {
     
	@Autowired
    private productdaoimpl productDAO;
 
    public void setPersonDAO(productdaoimpl productDAO) {
        this.productDAO = productDAO;
    }
 
   
   
   
  @Transactional
    public void addProduct(product p) {
        this.productDAO.addProduct(p);
    }
 
  
    @Transactional
    public void updateProduct(product p) {
        this.productDAO.updateProduct(p);
    }
 
  
    @Transactional
    public List<product> listProduct() {
        return this.productDAO.listproduct();
    }
 
  
    @Transactional
    public product getProductById(int ID) {
        return this.productDAO.getProductById(ID);
    }
 
 
    @Transactional
    public void removeProduct(int ID) 
    {
        this.productDAO.removeProduct(ID);
    }
    
 
}
