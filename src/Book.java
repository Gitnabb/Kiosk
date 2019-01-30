
/*
*
*
*
*
*
*
*/

public class Book{

    private String title;
    private String author;
    private String published;
    private int totalEditions;


    public Book(String author, String published, int totalEditions){
        this.author = author;
        this.published = published;
        this.totalEditions = totalEditions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public int getTotalEditions() {
        return totalEditions;
    }

    public void setTotalEditions(int totalEditions) {
        this.totalEditions = totalEditions;
    }
}