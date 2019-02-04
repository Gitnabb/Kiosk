import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Registry registry = new Registry();
        Scanner in = new Scanner(System.in);
        Book testBook = new Book("Peer Gynt", "H.Ibsen", 1990, 5);
        registry.addBook(testBook);


        /**
         *         Book testBook = new Book("Per Gynt", "H.Ibsen", 1990, 5);
         *         Book testBook2 = new Book("How to train arms", "M.Kvendseth", 2035, 7);
         *
         *
         *         registry.addBook(testBook);
         *         registry.addBook(testBook2);
         *         //Remove
         *         registry.removeBook(testBook);
         *
         *         // SEARCH
         *
         *
         *         // SHOW ALL BOOKS
         *         registry.showBooks();
         */
        System.out.println("Search for book by title: ");
        String title = in.nextLine();
        Book book = registry.findBookByTitle(title);

        if(book != null ){

            System.out.println(book.toString());

        }
        else{
            System.out.println("Could not find book");
        }

    }

}
