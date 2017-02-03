/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: DVDItem
 * Description: subclass of Item class, intended for record keeping of DVD items
 * *******************************************************/

public class DvdItem extends Item
{
    private String genre;

    public DvdItem(String title, String type, int totalQuantity, String genre) {
        super(title, type, totalQuantity);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
