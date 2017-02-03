/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: Item
 * Description: superclass used for populating InventoryTableview
 * *******************************************************/

public class Item {
    private String title;
    private String type;

    public Item(String title, String type, int totalQuantity, int rentedQuantity, int availableQuantity, String description) {
        this.title = title;
        this.type = type;
        this.totalQuantity = totalQuantity;
        this.rentedQuantity = rentedQuantity;
        this.availableQuantity = availableQuantity;
        Description = description;
    }

    private int totalQuantity;
    private int rentedQuantity;
    private int availableQuantity;
    private String Description;

    public Item()
    {

    }

    public Item(String title, String type, int totalQuantity, String description) {
        this.title = title;
        this.type = type;
        this.totalQuantity = totalQuantity;
        this.rentedQuantity = 0;
        this.availableQuantity = totalQuantity;
        Description = description;
    }

    public Item(String title, String type, int totalQuantity) {
        this.title = title;
        this.type = type;
        this.totalQuantity = totalQuantity;
        this.rentedQuantity = 0;
        this.availableQuantity = totalQuantity;
        Description = "";
    }

    public Item(String title, String quantity)
    {
        this.title = title;
        this.totalQuantity = Integer.parseInt(quantity);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getRentedQuantity() {
        return rentedQuantity;
    }

    public void setRentedQuantity(int rentedQuantity) {
        this.rentedQuantity = rentedQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity = totalQuantity -rentedQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
