/*
 * Student name: Sifan Baissa
 * Student number: 041120738
 * Professor: James Mwangi
 * Assessment: Assignment 1
 * Section: 310
 * */
package grocerystore;

// Importing required classes
import java.util.InputMismatchException;
import java.util.Scanner;
import inventoryexception.InventoryException;
import inventorymanager.InventoryManager;

// Defining the GroceryStore class
public class GroceryStore {
    // Declaring class variables
    private String[][] inventory;
    public Scanner input = new Scanner(System.in);

    // Constructor to initialize the inventory with some default items
    public GroceryStore() {
        this.inventory = new String[][] {{"Broccoli", "14"}, {"Sausages", "35"}, {"Bread", "20"}, {"Tortilla", "40"}, {"Eggs", "48"}};
    }

    // Method to display the inventory
    public void displayInventory() {
        for(int i=0; i<this.inventory.length; i++) {
            System.out.println(this.inventory[i][0] + ": " + this.inventory[i][1]);
        }
    }

    // Method to purchase items
    public void purchaseItems() throws InventoryException{
        boolean isValidName = false;
        boolean isValidQuantity = false;
        String name = "";
        String quantity;
        System.out.print("Enter item name to purchase or 'exit' to exit: ");
        do {
            try {
                name = input.next();
                // Check if the input is "exit" to exit the purchase process
                switch(name.trim().toUpperCase()) {
                    case "EXIT":
                        displayInventory();
                        return;
                    // Checking if the entered item name matches any item in the inventory
                    case "BROCCOLI":
                    case "SAUSAGES":
                    case "BREAD":
                    case "TORTILLA":
                    case "EGGS":
                        isValidName = true;
                        break;
                    // If the entered item name is not in the inventory, throw an exception
                    default:
                        throw new InventoryException("Invalid item name: Please try again: ");
                }
            }
            catch(InventoryException e) {
                System.out.print(e.getMessage());
            }
            catch (InputMismatchException e) {
                System.out.print(e.getMessage());
            }
        } while(isValidName == false);
        System.out.print("Enter the quantity to purchase: ");
        do {
            try {
                int index = InventoryManager.findItemIndex(this.inventory, name);
                String availableQuantity = this.inventory[index][1];
                quantity = input.next();
                // Check if the entered quantity is valid
                if((Integer.parseInt(quantity) > Integer.parseInt(availableQuantity))) {
                    throw new InventoryException("Not enough stock available. Please choose a smaller quantity: ");
                } else if(Integer.parseInt(quantity) < 0) {
                    throw new InventoryException("Invalid input: Enter a positive number: ");
                } else {
                    isValidQuantity = true;
                    int updatedQuantity = Integer.parseInt(availableQuantity) - Integer.parseInt(quantity);
                    InventoryManager.updateInventory(this.inventory, index, updatedQuantity);
                }
            }
            catch(InventoryException e) {
                System.out.print(e.getMessage());
            }
            catch(NumberFormatException e) {
                System.out.print(e.getMessage());
            }
        } while(isValidQuantity == false);
        System.out.println("Purchase successful! Updated Inventory.");
        displayInventory();
    }

    // Method to restock items
    public void restockItems() {
        boolean isValidName = false;
        boolean isValidQuantity = false;
        String name = "";
        String quantity;
        System.out.print("Enter item name to restock or 'exit' to exit: ");
        do {
            try {
                name = input.next();
                // Check if the input is "exit" to exit the restocking process
                switch(name.trim().toUpperCase()) {
                    case "EXIT":
                        displayInventory();
                        return;
                    // Checking if the entered item name matches any item in the inventory
                    case "BROCCOLI":
                    case "SAUSAGES":
                    case "BREAD":
                    case "TORTILLA":
                    case "EGGS":
                        isValidName = true;
                        break;
                    // If the entered item name is not in the inventory, throw an exception
                    default:
                        throw new InventoryException("Invalid item name: Please try again.");
                }
            }
            catch(InventoryException e) {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        } while(isValidName == false);

        System.out.print("Enter the quantity to restock: ");
        do {
            try {
                int index = InventoryManager.findItemIndex(this.inventory, name);
                String availableQuantity = this.inventory[index][1];
                quantity = input.next();
                // Check if the entered quantity is valid
                if(Integer.parseInt(quantity) < 0) {
                    throw new InventoryException("Invalid input: Enter a positive number. ");
                } else {
                    isValidQuantity = true;
                    int updatedQuantity = Integer.parseInt(availableQuantity) + Integer.parseInt(quantity);
                    InventoryManager.updateInventory(this.inventory, index, updatedQuantity);
                }
            }
            catch(InventoryException e) {
                System.out.print(e.getMessage());
            }
            catch(NumberFormatException e) {
                System.out.print("Enter an integer: ");
            }
        } while(isValidQuantity == false);
        System.out.println("Restock successful! Updated Inventory.");
        displayInventory();
    }

    // Method to manage the inventory
    public void manageInventory() {
        boolean quit = false;
        String choice = "";
        do {
            operationsMenu();
            try {
                choice = input.next();
                switch(choice) {
                    case "1":
                        purchaseItems();
                        break;
                    case "2":
                        restockItems();
                        break;
                    case "3":
                        System.out.println("...exiting...bye...");
                        quit=true;
                        break;
                    default:
                        throw new InventoryException("Invalid entry: enter an integer between 1 and 3. ");
                }
            }
            catch(InventoryException e) {
                System.out.println(e.getMessage());
            }
        } while(quit==false);
    }

    // Method to display operations menu
    public void operationsMenu() {
        System.out.println("\nMenu:\n1. Purchase items\n2. Restock items\n3. Exit");
        System.out.print("Choose an option: ");
    }
}



