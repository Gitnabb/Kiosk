public class Main {

    public static void main(String args[]){
        Registry registry = new Registry();
        Book testBook = new Book("Per Gynt", "H.Ibsen", 1990, 5);
        Book testBook2 = new Book("How to train arms", "M.Kvendseth", 2035, 7);


        registry.addBook(testBook);
        registry.addBook(testBook2);
        //Remove
        registry.removeBook(testBook);
        registry.showBooks();

    }

}
