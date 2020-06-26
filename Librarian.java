
public class Librarian
{
    private String Name;
    private String Email;
    private String Pass;
    private String MobileNumber;

    private Book [] inused = new Book [5];
    private int latestComponent =0 ;

    Librarian (String name, String email, String pass, String mobile)
    {
        this.Name = name;
        // chech email
        this.Email = email;
        this.Pass = pass;
        // chech Mob
        this.MobileNumber = mobile;

    }

    public void setName (String name)
    {
        Name = name;
    }
    public String getName ()
    {

        return Name;
    }
    public void setEmail (String email)
    {
        this.Email = email;
    }
    public String getEmail ()
    {
        return Email;
    }
    public void setPass (String pass)
    {
        this.Pass = pass;
    }
    public String getPass ()
    {
        return Pass;
    }
    public void setMobileNumber (String mobileNumber)
    {
        this.MobileNumber = mobileNumber;
    }
    public void addBookInInused (Book b)
    {
        if (latestComponent < 5) {
            inused[latestComponent] = b;
            latestComponent++;
        }else {
            System.out.println("Give Book Is Limited!");
        }
    }
    public Book setinused (int i)
    {
        return inused[i] = inused[i+1];
    }
    public Book getinused (int i)
    {
        return inused[i];
    }
    public void settaheshBL (int tahBL)
    {
        latestComponent = tahBL;
    }
    public int gettaheshBL ()
    {
        return latestComponent;
    }
    public String toString() {
        return Name + "" + Email +""+ Pass +""+ MobileNumber;
    }
    public static String showBookOfLibrarian (Librarian l) {
        String total ="";
        for (int i=0 ; i<l.gettaheshBL(); i++)
        {
            Book BL = l.getinused(i);
            total += BL + "\n";
        }
        // l.inused(i).title()+""+l.getinused(i).getauther()+""+ l.getinused(i).getid()+"" +l.getinused(i).getquantity()+""+ "\n";
        return total;
    }

}

