
public class Book
{
    private  String title;
    private  String auther;
    private  String id;
    private  int quantity;

    Book (String title, String auther, String id, int quantity)
    {
        this.title = title;
        this.auther = auther;
        this.id = id;
        //TODO
        /*
         * Pattern p = Pattern.compile("\f"); Matcher m = p.matcher(quantity); boolean b
         * = m.matches(); boolean b = Pattern.matches(p, m);
         */
        this.quantity = quantity;
    }

    public void settitle (String ti)
    {
        title = ti;
    }
    public String gettitle()
    {
        return title;
    }
    public void setauther (String au)
    {
        auther = au;
    }
    public void setid (String i)
    {
        id = i;
    }
    public void setquantity (int qu)
    {
        quantity = qu;
    }
    public int getquantity()
    {
        return quantity;
    }
    public String toString() {
        return title +""+ auther +""+ id +""+ quantity;
    }
}
