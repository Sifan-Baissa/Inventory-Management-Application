package inventorymanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InventoryManagerTest {
    @Test
    public void testFindItemIndex() {
        String[][] inventory = {
            {"Apple", "10"},
            {"Banana", "5"},
            {"Carrot", "20"}
        };

        int index = InventoryManager.findItemIndex(inventory, "Banana");
        assertEquals(1, index, "Expected index of Banana to be 1");
    }

    @Test
    public void testUpdateInventory() {
        String[][] inventory = {
            {"Apple", "10"},
            {"Banana", "5"},
            {"Carrot", "20"}
        };

        InventoryManager.updateInventory(inventory, 1, 15);
        assertEquals("15", inventory[1][1], "Quantity should be updated to 15");
    }
}
