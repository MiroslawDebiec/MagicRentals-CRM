/********************************************************
 * Created by Miroslaw Debiec - B00540796 on 10/12/2016.
 * Coursework Three - Magic DVD/Game rentals.
 * Class Name: GameItem
 * Description: subclass of Item class, intended for record keeping of Game items
 * *******************************************************/

public class GameItem extends Item {
    private String genre;
    private String platform;

    public GameItem(String title, String type, int totalQuantity, String genre, String platform) {
        super(title, type, totalQuantity);
        this.genre = genre;
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
