import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    private List<Literature> literatureList; // name of the Book-list


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
    public void deleteLiterature(Literature iteratureToRemove) {
        if (iteratureToRemove != null) {
            this.literatureList.remove(iteratureToRemove);
        }
    }

    public Iterator<Literature> getIterator() {
        return this.literatureList.iterator();
    }

    /**
     * Searches for a book by its title, then returns the object its inside
     * @param title Searches for a book by its title.
     * @return returns the correct object with the following title inside it.
     */
    public Literature searchForLiteratureTitle(String title) {

        Literature literature = null;
        boolean found = false;

        Iterator<Literature> it = this.literatureList.iterator();
        //This while loop will run as long as there are objects left to visit
        //in the collection (ArrayList) AND we have still not found the literature
        //we are looking for.
        while (it.hasNext() && !found){

            Literature literatureNext = it.next();

            if (literatureNext.getTitle().equals(title))
            {
                literature = literatureNext;
                found = true;
            }
        }
        return literature;
    }

    /**
     * List the number of literature added.
     * @return the number of books
     */
    public int getNumberOfLiterature() {
        return this.literatureList.size();
    }
}
