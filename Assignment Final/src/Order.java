/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: Order
 * Description: class comabaning both Customer and Item
 *              classes in order to populate Order Table.
 * *******************************************************/

public class Order {
    private String orderId;
    private Item item;
    private String itemName;
    private String itemType;
    private Customer customer;
    private String customerName;

    private static int orderNumber = 0;
    private boolean complete;

    public Order()
    {

    }

    public Order(Customer _customer, Item _item){
        this.customer = _customer;
        this.customerName = _customer.getName();
        this.item = _item;
        this.itemName = _item.getTitle();
        this.itemType = _item.getType();
        this.orderNumber++;
        generateOrderId();
    }

    public Order(String orderId, int orderNumber, Item item, Customer customer, boolean complete) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.item = item;
        this.customer = customer;
        this.complete = complete;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private void generateOrderId(){
        this.orderId = "OR" + orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getCustomerName() {
        return customerName;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
