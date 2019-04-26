import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a database for registering the different literature
 * This class is designed to in the future, hold different types of literature
 *
 * @author <Andreas Øie>
 * @version 1.0
 *
 */

public class Registry {

    //defining fields
    private ArrayList<Literature> literatureList; // name of the Book-list

    /**
     * Constructs the list available to store the different literature
     */
    public Registry() {

        this.literatureList = new ArrayList<>();
    }

    /**
     * Registers a literature
     * @param literatureTooAdd Registers a literature
     */
    public void registerLiterature(Literature literatureTooAdd) {
        if (literatureTooAdd != null) {
            this.literatureList.add(literatureTooAdd);
        }
    }

    /**
     * Returns an iterator to be used to iterate over the literature in the literature registry.
     * @return an iterator to be used to iterate over the literature in the literature registry.
     */
    public Iterator<Literature> getIterator() {
        return this.literatureList.iterator();
    }

    /**
     * Searches for a book by its title, then returns the object its inside
     * @param title Searches for a book by its title.
     * @return returns the correct object with the following title inside it.
     */
    public Literature searchForLiterature(String title, String publisher) {

        Literature foundLiterature = null;
        boolean found = false;

        Iterator<Literature> it = this.literatureList.iterator();
        //This while loop will run as long as there are objects left to visit
        //in the collection (ArrayList) AND we have still not found the literature
        //we are looking for.
        while (it.hasNext() && !found){

            Literature tempLiterature = it.next();

            if (tempLiterature.getTitle().equals(title) && tempLiterature.getPublisher().equals(publisher)) {
                foundLiterature = tempLiterature;
                found = true;
            }
        }
        return foundLiterature;
    }

    /**
     * List the number of literature added.
     * @return the number of books
     */
    public int getNumberOfLiterature() {
        return this.literatureList.size();
    }
}
