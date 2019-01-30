/**
 *
 *
 *
 */


import java.util.ArrayList;



public class Registry {

    private ArrayList<Book> bookList;

    public Registry(){

        this.bookList = new ArrayList<>();

    }

    public void addBook(Book book){

        bookList.add(book);
    }

    public void showBooks(){

        for(int i = 0; i < bookList.size(); i++){
                // TODO create PROPER error handler for exception if Book = null (empty array)
                System.out.println(bookList.get(i).toString());
            }

    }

}
