/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: Customer
 * Description: class for creating users
 *******************************************************/

import javafx.collections.ObservableList;


public class Customer {
    private String name;
    private int age;
    private long phone;
    private String email;

    //Default Constructor
    public Customer()
    {

    }

    //Overloaded Constructor
    public Customer(String _name, String _age, String _phone, String _email)
    {
        this.name = _name;
        this.age = convertToInt(_age);
        this.phone = convertToLong(_phone);
        this.email = _email;
    }
    //Name setter/getter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Age setter/getter
    public Integer getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //Phone setter/gether
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }

    //Email setter/getter
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Helper methode String to Int (Age)
    private int convertToInt(String input)
    {
        int value = Integer.parseInt(input);
        return  value;
    }
    //Helper methode String to Long (Phone)
    private long convertToLong(String input)
    {
        long value = Long.parseLong(input);
        return  value;
    }
}
