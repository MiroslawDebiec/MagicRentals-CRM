/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: Inventory
 * Description: reads data from InputReader(.txt) or new
 *   Item window and converts DVDItem and GameItem into
 *   Item superclass for display in Inventory table
 *   and to perform operations on Item objects.
 *******************************************************/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Item> ItemList = FXCollections.observableArrayList();;
    private static ObservableList<DvdItem> DVDList = FXCollections.observableArrayList();;
    private static ObservableList<GameItem> GameList = FXCollections.observableArrayList();;

    private static ObservableList<Item>selectedItems = FXCollections.observableArrayList();;

    //Adds DVD to subclass.
    public static void addDvD(DvdItem newDvd)
    {
        DVDList.add(newDvd);
        addDvDToItemList(newDvd);
    }

    //Adds Game to subclass
    public static void  addGame(GameItem newGame)
    {
        GameList.add(newGame);
        addGameToItemList(newGame);
    }

    //Adds DVD to Item superclass
    private static void addDvDToItemList(DvdItem newDvd)
    {
        ItemList.add(convertDVDToItem(newDvd));
    }

    //Adds Game to Item superclass
    private static void addGameToItemList(GameItem newGame)
    {
        ItemList.add(convertGameToItem(newGame));
    }

    //Reaplces Old item with New
    public static void replaceItem(Item oldItem, Item newItem)
    {
        ItemList.remove(oldItem);
        ItemList.add(newItem);
    }

    //Removes from Item list
    public static void removeItem(Item item)
    {
        ItemList.remove(item);
    }
    //Removes from DVD list
    public static void removeDVD(DvdItem dvd)
    {
        DVDList.remove(dvd);
    }

    //Removes from Game list
    public static void removeGame(GameItem game)
    {
        GameList.remove(game);
    }

    //Converts DVD to Item
    public static Item convertDVDToItem(DvdItem dvd)
    {
        Item item = new Item(dvd.getTitle(), dvd.getType(), dvd.getTotalQuantity(),"genre: " + dvd.getGenre());
        return item;
    }

    //Converts Game to Item
    public static Item convertGameToItem(GameItem game)
    {
        Item item = new Item(game.getTitle(), game.getType(), game.getTotalQuantity(),"genre: " + game.getGenre() + " platform: " + game.getPlatform());
        return item;
    }

    //Returns list of superclass
    public static ObservableList<Item> getItemList() {
        return ItemList;
    }
    //Returns list of subclass
    public static ObservableList<DvdItem> getDVDList() {
        return DVDList;
    }
    //Returns list of subclass
    public static ObservableList<GameItem> getGameList() {
        return GameList;
    }

}
