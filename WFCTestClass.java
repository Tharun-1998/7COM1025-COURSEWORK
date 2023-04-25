import java.io.IOException;
import org.junit.Test;

public class WFCTestClass {
    
    @Test
    public void weekDaySchedule(){
        System.out.println("\n**************************************  Test Case 1 ************************************** ");
        System.out.println("Test Case to check whether the schedule is displayed according to day i.e. Sunday or saturday");
        String day = "saturday";
        Functions.displayweekDaySchedule(day);
    }
    
    
    @Test
    public void exerciseSchedule(){
        System.out.println("\n**************************************  Test Case 2 ************************************** ");
        System.out.println("Test Case to check whether the schedule is displayed according to exercise name i.e. Zumba or yoga etc.");
        String exercise = "box fit";
        Functions.displayParticularExerciseSchedule(exercise);
    }
    
    
    @Test
    public void writeReview(){
        System.out.println("\n**************************************  Test Case 3 ************************************** ");
        System.out.println("Test Case to check whether the review is added for lesson");
        String customer_number = "C002";
        String fitness_lesson = "Hatha Yoga";
        String review = "Excellent";
        int rating = 5;
        Reviews ratings = new Reviews(customer_number,fitness_lesson,review,rating);
        Reviews.reviews.add(ratings);
        System.out.println("\nReview Added");
    }
    
    
    @Test
    public void addBooking(){
        System.out.println("\n**************************************  Test Case 4 ************************************** ");
        System.out.println("Test Case to add booking");
        String customer_number = "C002";
        String fitness_lesson = "Hatha Yoga";
        CustomerBookings booking = new CustomerBookings("B101",customer_number, fitness_lesson, CustomerBookings.BookedStatus);
        CustomerBookings.bookingList.add(booking);
        System.out.println("\nYou have scheduled for Lesson :"+fitness_lesson);
    }
    
    
    @Test
    public void downloadLessonReport() throws IOException{
        System.out.println("\n**************************************  Test Case 5 ************************************** ");
        System.out.println("Test Case to download lesson report");
        int month_num = 02;
        Functions.downloadLessonReport(month_num);
    }
    
    
    
    @Test
    public void downloadChampionReport() throws IOException{
        System.out.println("\n**************************************  Test Case 6 ************************************** ");
        System.out.println("Test Case to download monthly champion report");
        int month_num = 02;
        Functions.downloadChampionReport(month_num);
    }
    
}
