/*
 * Student name: Sifan Baissa
 * Student number: 041120738
 * Professor: James Mwangi
 * Assessment: Assignment 1
 * Section: 310
 * */
package inventorymanager;
import inventoryexception.InventoryException;

// Class to manage inventory operations
public class InventoryManager {
    
    // Method to find the index of an item in the inventory array
    public static int findItemIndex(String[][] inventory, String itemName) {
        // Initialize index variable
        int index = 0;
        // Iterate through the inventory array
        for(int i = 0; i < inventory.length; i++) {
            // Check if the item name matches the itemName parameter (case insensitive)
            if (inventory[i][0].equalsIgnoreCase(itemName)) {
                // If found, store the index
                index = i;
            }
        }
        // Return the index of the item
        return index;
    }

    // Method to update the quantity of an item in the inventory array
    public static void updateInventory(String[][] inventory, int index, int quantity) {
        // Convert the quantity to a string
        String num = "" + quantity + "";
        // Update the quantity of the item at the specified index in the inventory array
        inventory[index][1] = num;
    }
}

