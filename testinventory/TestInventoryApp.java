/*
 * Student name: Sifan Baissa
 * Student number: 041120738
 * Professor: James Mwangi
 * Assessment: Assignment 1
 * Section: 310
 * */
package testinventory;
import grocerystore.GroceryStore;
import inventoryexception.InventoryException;

// Class to test the inventory management application
public class TestInventoryApp {
    
    // Main method to run the inventory management application
    public static void main(String[] args) throws InventoryException {
        // Creating an instance of the GroceryStore class
        GroceryStore grocery = new GroceryStore();
        
        // Displaying the initial inventory
        System.out.println("Initial Inventory");
        grocery.displayInventory();
        
        // Managing the inventory through the GroceryStore instance
        grocery.manageInventory();
        grocery.input.close();
    }
}

