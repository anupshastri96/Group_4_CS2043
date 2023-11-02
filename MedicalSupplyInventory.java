/*
@author Divyanshu Kumar Sharma 3724476
@author Cameron MacDonald
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalSupplyInventory {
    private List<MedicalSupply> supplies = new ArrayList<>();

    /*
    Add a new supply to the inventory
    */
    public void addSupply(String name, int quantity, Date expirationDate) {
        MedicalSupply supply = new MedicalSupply(name, quantity, expirationDate);
        supplies.add(supply);
    }

    /* 
    Check for supplies that need to be ordered 
    */
    public List<MedicalSupply> getSuppliesToOrder(int minStockQuantity) {
        List<MedicalSupply> suppliesToOrder = new ArrayList<>();
        for (MedicalSupply supply : supplies) {
            if (supply.getQuantity() < minStockQuantity) {
                suppliesToOrder.add(supply);
            }
        }
        return suppliesToOrder;
    }

    /*
    Update supply information 
    */
    public void updateSupply(String name, int newQuantity, Date newExpirationDate) {
        for (MedicalSupply supply : supplies) {
            if (supply.getName().equals(name)) {
                supply.setQuantity(newQuantity);
                supply.setExpiryDate(newExpirationDate);
            }
        }
    }
    
    public static void main(String[] args) {
		MedicalSupplyInventory inventory = new MedicalSupplyInventory();

		inventory.addSupply("Bandages", 50, new Date());
		inventory.addSupply("Antiseptic Wipes", 30, new Date());
		inventory.addSupply("Needles", 100, new Date());

		List<MedicalSupply> suppliesToOrder = inventory.getSuppliesToOrder(40);
		System.out.println("Supplies to order:");
		for (MedicalSupply supply : suppliesToOrder) {
			System.out.println(supply.getName());
		}

		inventory.updateSupply("Bandages", 60, new Date());
    }
    
}