package model;


import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name="PRODUCT")
public class product implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    
    public String name;
   
    public String Category;
   
    public String Price;
 
    //Setters and Getters
   
    public int getid() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public String getname() {
		return name;
	}
	public void setname(String Name) {
		name = Name;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	
	
    
}