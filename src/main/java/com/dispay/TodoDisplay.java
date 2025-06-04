package src.main.java.com.dispay;

public class TodoDisplay {

    private TodoDisplay() {

        throw new UnsupportedOperationException("Unimplemented method 'displayMenu'");

    }

    public static void displayMenu() {

        System.out.println("Tommy's Todo");
        System.out.println("1 => Add New Item");
        System.out.println("2 => Edit Item");
        System.out.println("3 => Delete Item");
        System.out.println("4 => Quit");

    }

}
