
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
    private int published;
    private int edition;


    public Book(String title, String author, int published, int edition){
        this.title = title;
        this.author = author;
        this.published = published;
        this.edition = edition;
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

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return ("Title: "+this.getTitle()+ ", " +
                " Author: "+ this.getAuthor() + ", " + "Edition: "
                + getEdition() +", " + "Published in: " + getPublished());
    }
}