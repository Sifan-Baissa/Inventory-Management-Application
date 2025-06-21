package inventoryexception;

/**
 * Custom exception class for inventory-related errors.
 */
public class InventoryException extends Exception {
    /**
     * Creates a new InventoryException with the specified message.
     *
     * @param message detailed message for the exception
     */
    public InventoryException(String message) {
        super(message);
    }
}
