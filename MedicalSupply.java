/*
@author Divyanshu Kumar Sharma 3724476
@author Cameron MacDonald
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class MedicalSupply {

    private String name;
    private int quantity;
    private Date expirationDate;

    public MedicalSupply(String name, int quantity, Date expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public String getName(){
    	return name;
    }
    
    public int getQuantity(){
    	return quantity;
    }
    
    public Date expirationDate(){
    	return expirationDate;
    }
    
    public void setName(String newName){
    	name = newName;
    }
    
    public void setQuantity(int quantityNew){
    	quantity = quantityNew;
    }
    
    public void setExpiryDate(Date newExpiryDate){
    	expirationDate = newExpiryDate;
    }
}

