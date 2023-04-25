
import java.util.ArrayList;


public class Customers {
    
    private String customer_no;
    private String username;

    public Customers(String customer_no, String username) {
        this.customer_no = customer_no;
        this.username = username;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public String getUsername() {
        return username;
    }
    
    public static ArrayList getCustomers() {
       ArrayList <Customers> cust = new ArrayList<>();
       Customers obj1 = new Customers("C001","Lewis");
       Customers obj2 = new Customers("C002","Robin");
       Customers obj3 = new Customers("C003","Jack");
       Customers obj4 = new Customers("C004","Marry");

       cust.add(obj1);
       cust.add(obj2);
       cust.add(obj3);
       cust.add(obj4);
       return cust;
   }
}
