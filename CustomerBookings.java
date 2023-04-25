
import java.util.ArrayList;
import java.util.List;


public class CustomerBookings {
    
    private String booking_no;
    private String customer_no;
    private String lesson;
    private String booking_status;

    public static final String BookedStatus = "booked";
    public static final String CancelledStatus = "cancelled";
    public static final String AttendedStatus = "attended";
    public static final String ChangedStatus = "changed";
    public static final int MAX_BOOKING = 5;
    
    public static List<CustomerBookings> bookingList = new ArrayList<>();
    
    public CustomerBookings(String booking_no, String customer_no, String lesson, String booking_status) {
        this.booking_no = booking_no;
        this.customer_no = customer_no;
        this.lesson = lesson;
        this.booking_status = booking_status;
    }

    public String getBooking_no() {
        return booking_no;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public String getLesson() {
        return lesson;
    }

    public String getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(String booking_status) {
        this.booking_status = booking_status;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
    
    
    
    public static  List<CustomerBookings> getBookings(){
        return bookingList;
    }
    
}
