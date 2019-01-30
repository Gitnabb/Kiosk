public class Main {

    public static void main(String args[]){
        Registry registry = new Registry();
        Book testBook = new Book("Per Gynt", "H.Ibsen", 1990, 5);

        registry.addBook(testBook);
        registry.showBooks();

    }

}
