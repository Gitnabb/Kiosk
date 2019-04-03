
public class Main {

    public static void main(String args[]) {
        try {
            KioskApplicationUI appUI = new KioskApplicationUI();
            appUI.start();
        }
        catch (Exception e) {
            System.out.println("Sorry, something went wrong!");
        }
    }

}
