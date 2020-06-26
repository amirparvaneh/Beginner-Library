import java.util.ArrayList;
import java.util.Scanner;
public class Manager
{

    private static String UserName = "amir" ;
    private static String PassWord = "1234" ;
    private static ArrayList<Librarian> librarians = new ArrayList<Librarian>();
    private static ArrayList<Book> books = new ArrayList<Book>();
    private static Scanner sc = new Scanner (System.in);
    private static  String userlogin ="";

    static boolean usercheckermanager (String user , String pass)
    {
        if (user.equals(UserName) && pass.equals(PassWord))
        {
            userlogin =user;
            return true;
        }else {
            return false;
        }
    }
    static boolean usercheckerlibrarian (String user , String pass)
    {
        for (int i=0 ; i<librarians.size(); i++){
            Librarian l = librarians.get(i);
            if (l.getName().equals(user) && l.getPass().equals(pass)) {
                //TODO
                userlogin =user;
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    static void addbook (String title,String auther,String id,int quantity)
    {
        Book b = new Book (title,auther,id,quantity);
        books.add(b);
    }
    static void editbook (String title)
    {
        int editindex = -1;
        if (books.size() == 0) {
            System.out.println("There is no Book");
        }else{
            for (int i=0 ; i<books.size(); i++){
                Book b = books.get(i);
                if (b.gettitle().equals(title)) {
                    editindex = i;
                    break;
                }
            }
            if (editindex == -1) {
                System.out.println("Book Not Found");
            }else {
                System.out.println("Plz Enter NewInfoBook = title,auther,id,quantity");
                String Newtitle = sc.next();
                String Newauther = sc.next();
                String Newid = sc.next();
                int Newquantity = sc.nextInt();
                books.get(editindex).settitle(Newtitle);
                books.get(editindex).setauther(Newauther);
                books.get(editindex).setid(Newid);
                books.get(editindex).setquantity(Newquantity);
            }
        }
    }
    static void deletebook (String name)
    {
        int removeindex = -1;
        if (books.size() == 0) {
            System.out.println("There is no book");
        }else{
            for (int i=0 ; i<books.size(); i++){
                Book b = books.get(i);
                if (b.gettitle().equals(name)) {
                    removeindex = i;
                    break;
                }
            }if (removeindex == -1) {
                System.out.println("Book Not Fund");
            }else {
                books.remove(removeindex);
            }
        }
    }
    static String showallbook()
    {
        String total="";
        if (books.size() == 0) {
            total = "Not Book Found!" ;
        }else{
            for (int i=0 ; i<books.size() ; i++)
            {
                Book b = books.get(i);
                total += b + "\n";
            }
        }
        return total;
    }
    static void searchbook(String name)
    {
        int showindex = -1;
        for (int i=0 ; i<books.size(); i++){
            Book b = books.get(i);
            if (b.gettitle().equals(name)) {
                showindex = i;
                break;
            }
        }
        if(showindex == -1){
            System.out.println("Book Not Fund");
        }else {
            System.out.println(books.get(showindex));
        }
    }
    static  void addlibrarian (String name,String email, String pass, String mobile)
    {
        Librarian m = new Librarian (name, email, pass, mobile);
        librarians.add(m);
    }
    static void editlibrarian (String name)
    {
        int editindex = -1;
        if (librarians.size() == 0) {
            System.out.println("There is no Librarian");
        }else{
            for (int i=0 ; i<librarians.size(); i++){
                Librarian l = librarians.get(i);
                if (l.getName().equals(name)) {
                    editindex = i;
                    break;
                }
            }
            if (editindex == -1) {
                System.out.println("Librarian Not Found");
            }else {
                System.out.println("Plz Enter NewInfoLibrarian = name,email,pass,mobile");
                String Newname = sc.next();
                String Newemail = sc.next();
                String Newpass = sc.next();
                String Newmobile = sc.next();
                librarians.get(editindex).setName(Newname);
                librarians.get(editindex).setEmail(Newemail);
                librarians.get(editindex).setPass(Newpass);
                librarians.get(editindex).setMobileNumber(Newmobile);
            }
        }
    }
    static void deletelibrarian (String name)
    {
        int removeindex = -1;
        if (librarians.size() == 0) {
            System.out.println("There is no Librarian");
        }else{
            for (int i=0 ; i<librarians.size(); i++){
                Librarian l = librarians.get(i);
                if (l.getName().equals(name)) {
                    removeindex = i;
                    break;
                }
            }if (removeindex == -1) {
                System.out.println("Librarian Not Fund");
            }else {
                librarians.remove(removeindex);
            }
        }
    }
    static String showalllibrarian()
    {
        String total = "";
        if (librarians.size() == 0) {
            total = "Not Librarian Found!" ;
        }else{
            for (int i=0 ; i<librarians.size(); i++)
            {
                Librarian l = librarians.get(i);
                total += l + "\n";
                //l.getinused(i).gettitle()+""+l.getinused(i).getauther()+""+ l.getinused(i).getid()+"" +l.getinused(i).getquantity()+""+ "\n";
            }
        }
        return total;
    }
    static void searchlibrarian(String name)
    {
        int showindex = -1;
        for (int i=0 ; i<librarians.size(); i++){
            Librarian l = librarians.get(i);
            if (l.getName().equals(name)) {
                showindex = i;
                break;
            }
        }
        if(showindex == -1){
            System.out.println("librarian Not Fund");
        }else {
            System.out.println(librarians.get(showindex));
        }
    }
    static void GetBook (String name)
    {
        for (int i =0 ; i <books.size(); i++) {
            Book b = books.get(i);
            if (b.gettitle().equals(name)) {
                for (int j=0 ; j<librarians.size(); j++){
                    Librarian l = librarians.get(j);
                    //TODO
                    if (l.getName().equals(userlogin)) {
                        if(l.gettaheshBL () <5 && b.getquantity() > 0) {
                            l.addBookInInused(b);
                            l.settaheshBL(l.gettaheshBL() +1);
                            b.setquantity(b.getquantity() -1);
                        }
                    }
                }
            }
        }
    }
    static void GiveBackBook (String name)
    {
        for (int i =0 ; i <books.size(); i++) {
            Book b = books.get(i);
            if (b.gettitle().equals(name)) {
                for (int j=0 ; j<librarians.size(); j++){
                    Librarian l = librarians.get(j);
                    if (l.getName().equals(userlogin)) {
                        for (int k = 0; k< l.gettaheshBL(); k++) {
                            if(l.getinused(k).equals(b)) {
                                for (int m=k ; m< l.gettaheshBL() ; m++) {
                                    l.setinused(m);
                                }
                            }
                        }
                        l.settaheshBL(l.gettaheshBL() -1);
                        b.setquantity(b.getquantity() +1);
                    }
                }
            }
        }
    }
    static void ListBookOfLibrarian(String name)
    {
        if (librarians.size() == 0) {
            System.out.println("There is no Librarian");
        }else{
            for (int i=0 ; i<librarians.size(); i++){
                Librarian l = librarians.get(i);
                if (l.getName().equals(name)) {
                    System.out.println(Librarian.showBookOfLibrarian(l));
                }
            }
        }
    }
}

