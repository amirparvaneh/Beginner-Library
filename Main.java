import java.util.regex.*;
import java.util.Scanner;

public class Main {
    private static boolean IsAlive = true;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String Args[]) {
        System.out.println("Hi");
        System.out.println("manager or librarian?");
        String usertypes = sc.next();

        while (true) {

            if (usertypes.equals("librarian")) {
                System.out.println("Plz Enter Username:");
                String user = sc.next();
                System.out.println("Plz Enter Password:");
                String pass = sc.next();
                if (Manager.usercheckerlibrarian(user, pass)) {
                    System.out.println("User And Pass Correct");
                    break;
                } else {
                    System.out.println("User Or Pass Incorrect");
                }
            } else {

                System.out.println("Plz Enter Username:");
                String user = sc.next();
                System.out.println("Plz Enter Password:");
                String pass = sc.next();
                if (Manager.usercheckermanager(user, pass)) {
                    System.out.println("User And Pass Correct");
                    break;
                } else {
                    System.out.println("User Or Pass Incorrect");
                }
            }
        }
        System.out.println("Welcome, Plz Enter Action");
        while (IsAlive) {
            Scanner sc2 = new Scanner(System.in);
            String input = sc2.nextLine();
            if (usertypes.equals("librarian")) {
                String result = routInputLibrarian(input);
                System.out.println(result);
            } else {
                String result = routInputManager(input);
                System.out.println(result);
            }

        }

        sc.close();

    }

    public static String routInputManager(String input) {
        input = input.toLowerCase();

        switch (input) {
            case "/add librarian":
                return AddLibrarian();
            case "/delete librarian":
                return DeleteLibrarian();
            case "/edit librarian":
                return EditLibrarian();
            case "/search librarian":
                return SearchLibrarian();
            case "/list librarian":
                return Manager.showalllibrarian();
            case "/add book":
                return AddBook();
            case "/delete book":
                return DeleteBook();
            case "/edit book":
                return EditBook();
            case "/search book":
                return SearchBook();
            case "/list book":
                return Manager.showallbook();
            case "/get book":
                return GetBook();
            case "/give back book":
                return GiveBackBook();
            case "/list book of librarian":
                return ListBookOfLibrarian();
            case "/switch user":
                return SwitchUser();
            case "/help":
                return help();
            case "/exit":
                return exit();
            default:
                return WrongInput();
        }
    }

    public static String routInputLibrarian(String input) {
        input = input.toLowerCase();

        switch (input) {

            case "/search book":
                return SearchBook();
            case "/list book":
                return Manager.showallbook();
            case "/get book":
                return GetBook();
            case "/give back book":
                return GiveBackBook();
            case "/list book of librarian":
                return ListBookOfLibrarian();
            case "/switch user":
                return SwitchUser();case "/help":
                return help();
            case "/exit":
                return exit();
            default:
                return WrongInput();
        }
    }


    private static String SwitchUser() {
        while (true) {
            System.out.println("manager or librarian?");
            String usertype = sc.next();
            if (usertype.equals("librarian")) {
                System.out.println("Plz Enter Username:");
                String user = sc.next();
                System.out.println("Plz Enter Password:");
                String pass = sc.next();
                if (Manager.usercheckerlibrarian(user, pass)) {
                    System.out.println("User And Pass Correct");
                    break;
                } else {
                    System.out.println("User Or Pass Incorrect");
                }
            } else {

                System.out.println("Plz Enter Username:");
                String user = sc.next();
                System.out.println("Plz Enter Password:");
                String pass = sc.next();
                if (Manager.usercheckermanager(user, pass)) {
                    System.out.println("User And Pass Correct");
                    break;
                } else {
                    System.out.println("User Or Pass Incorrect");
                }
            }
        }
        return"Plz Enter Action";
    }

    private static String ListBookOfLibrarian() {
        System.out.println("Plz Enter Librarian's name");
        String name = sc.next();
        Manager.ListBookOfLibrarian(name);
        return " Process Show List Book of Librarian Is Done";
    }

    private static String GiveBackBook() {
        System.out.println("Plz Enter Book's name");
        String name = sc.next();
        Manager.GiveBackBook(name);
        return " Process Give Back Book Is Done";
    }

    private static String GetBook() {
        System.out.println("Plz Enter Book's name");
        String name = sc.next();
        Manager.GetBook(name);
        return " Process Get Book Is Done";

    }

    private static String WrongInput() {
        return "input wrong";

    }

    private static String exit() {
        IsAlive = false;
        return "By";

    }

    private static String help() {
        return "/add librarian new librarian(just manager)\n" + "/delete librarian remove librarian(just manager)\n"
                + "/edit librarian edit librarian(just manager)\n" + "/search librarian find librarian(just manager)\n"
                + "/list librarian show all librarian(just manager)\n" + "/add book new book(just manager)\n"
                + "/delet book remove book(just manager)\n" + "/edit book edit book(just manager)\n"
                + "/search book find book\n" + "/get book got a book (just librarian)\n" + "/giva back book (just librarian)\n"
                + "/list book of librarian\n" + "/switch user(just manager) \n" + "/help\n" + "/exit logout\n";

    }

    private static String SearchBook() {
        System.out.println("Plz Enter name");
        String name = sc.next();
        Manager.searchbook(name);
        return " Process Search Book Is Done";
    }

    private static String EditBook() {
        System.out.println("Plz Enter title");
        String title = sc.next();
        Manager.editbook(title);
        return "Process Edit Book Is Done";

    }

    private static String DeleteBook() {
        System.out.println("Plz Enter name");
        String name = sc.next();
        Manager.deletebook(name);
        return "Process Delete Book Is Done";
    }

    private static String AddBook() {
        System.out.println("Plz Enter InfoBook = title,auther,id,quantity (is number)");
        String title = sc.next();
        String auther = sc.next();
        String id = sc.next();
        int quantity = sc.nextInt();
        Manager.addbook(title, auther, id, quantity);
        return "Process New Book Is Done";
    }

    private static String SearchLibrarian() {
        System.out.println("Plz Enter name");
        String name = sc.next();
        Manager.searchlibrarian(name);
        return "Process Search Librarian Is Done";
    }

    private static String EditLibrarian() {
        System.out.println("Plz Enter name");
        String name = sc.next();
        Manager.editlibrarian(name);
        return "Process Edit Librarian Is Done";
    }

    private static String DeleteLibrarian() {
        System.out.println("Plz Enter name");
        String name = sc.next();
        Manager.deletelibrarian(name);
        return "Process Delete Librarian Is Done";
    }

    private static String AddLibrarian() {
        {
            System.out.println("Plz Enter InfoLibrarian = name,email,pass,mobile");
            String name = sc.next();
            String email = sc.next();
            String pass = sc.next();
            String mobile = sc.next();
            Manager.addlibrarian(name, email, pass, mobile);
            return "Process New Librarian Is Done";
        }

    }
}
