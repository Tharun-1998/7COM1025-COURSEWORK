
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;


public class Functions{
    
    public static FileWriter fw = null;
    public static BufferedWriter bw = null;
    public static PrintWriter pw = null;
        

    public static void scheduleFitnessLesson(){
        
        // Schdule for Weekday
        System.out.print("\nDo you wish to view the lesson schedule for the weekdays? (Y/N) ==> ");
        String weekDayChoice = WFC.get_user_input.nextLine();

        if(!weekDayChoice.equalsIgnoreCase("yes") && !weekDayChoice.equalsIgnoreCase("y") && !weekDayChoice.equalsIgnoreCase("no") 
                && !weekDayChoice.equalsIgnoreCase("n")){
            do{
                System.out.print("\nPress Y/N ==> ");
                weekDayChoice = WFC.get_user_input.nextLine();
            }while(!weekDayChoice.equalsIgnoreCase("yes") && !weekDayChoice.equalsIgnoreCase("y") && !weekDayChoice.equalsIgnoreCase("no") 
                    && !weekDayChoice.equalsIgnoreCase("n"));
        }
        
        // If user wants to view day wise schedule
        if(weekDayChoice.equalsIgnoreCase("yes") || weekDayChoice.equalsIgnoreCase("y")){
            System.out.print("\nEnter Either Saturday or Sunday ==> ");
            String input_day = WFC.get_user_input.nextLine();
            if(!input_day.equalsIgnoreCase("sunday") && !input_day.equalsIgnoreCase("saturday")){
                do{
                    System.out.print("\nEnter Valid Day ==> ");
                    input_day = WFC.get_user_input.nextLine();
                }while(!input_day.equalsIgnoreCase("sunday") && !input_day.equalsIgnoreCase("saturday"));
            }
             
            //Display day wise schedule
            displayweekDaySchedule(input_day);
            
            // Take user choice whether to schedule a class or not
            System.out.print("\nPress 'Y' to Schedule a Fitness Lesson ==> ");
            String isSchedule = WFC.get_user_input.nextLine();
            
            if(!isSchedule.equalsIgnoreCase("yes") && !isSchedule.equalsIgnoreCase("y") && !isSchedule.equalsIgnoreCase("no") 
                && !isSchedule.equalsIgnoreCase("n")){
                do{
                    System.out.print("\nnPress Y/N ==> ");
                    isSchedule = WFC.get_user_input.nextLine();
                }while(!isSchedule.equalsIgnoreCase("yes") && !isSchedule.equalsIgnoreCase("y") && !isSchedule.equalsIgnoreCase("no") 
                && !isSchedule.equalsIgnoreCase("n"));
            }
            
            // If user wants to schedule a lesson 
            if(isSchedule.equalsIgnoreCase("yes") || isSchedule.equalsIgnoreCase("y")){
                scheduleLesson();
            }
        }
         
        
        // Schdule for Particular Exercise
        else{
            System.out.print("\nDo you wish to view the lesson schedule for Fitness Exercise? ==> ");
            String exerciseChoice = WFC.get_user_input.nextLine();

            if(!exerciseChoice.equalsIgnoreCase("yes") && !exerciseChoice.equalsIgnoreCase("y") && !exerciseChoice.equalsIgnoreCase("no") 
                    && !exerciseChoice.equalsIgnoreCase("n")){
                do{
                    System.out.print("\nPress Y/N ==> ");
                    exerciseChoice = WFC.get_user_input.nextLine();
                }while(!exerciseChoice.equalsIgnoreCase("yes") && !exerciseChoice.equalsIgnoreCase("y") && !exerciseChoice.equalsIgnoreCase("no") 
                        && !exerciseChoice.equalsIgnoreCase("n"));
            }
            
            // If user wants to view schedule for particular exercise
            List<FitnessExercises> exercises = FitnessExercises.getExerciseList();
            if(exerciseChoice.equalsIgnoreCase("yes") || exerciseChoice.equalsIgnoreCase("y")){
                System.out.print("\nEnter Fitness Exercise Name [Box Fit, Yoga, Aquacise, Zumba] ==> ");
                String input_exercise = WFC.get_user_input.nextLine();
                
                String[] arr = new String[4];
                
                for(int i=0; i<exercises.size(); i++){
                    arr[i] = exercises.get(i).getExercise();
                }
                
                //Check entered exercise exists in the schedule
                boolean checkValue = checkExercise(arr,input_exercise);
                    
                if(!checkValue){
                do{
                        System.out.print("\nEnter Valid Exercise name [Box Fit, Yoga, Aquacise, Zumba] ==> ");
                        input_exercise = WFC.get_user_input.nextLine();
                        checkValue = checkExercise(arr,input_exercise);
                    }while(!checkValue);
                }

                //Display entered exercise schedule
                displayParticularExerciseSchedule(input_exercise);
                
                // Take user choice whether to schedule a class or not
                System.out.print("\nPress 'Y' to Schedule a Fitness Lesson ==> ");
                String isSchedule = WFC.get_user_input.nextLine();
                
                if(!isSchedule.equalsIgnoreCase("yes") && !isSchedule.equalsIgnoreCase("y") && !isSchedule.equalsIgnoreCase("no") 
                && !isSchedule.equalsIgnoreCase("n")){
                    do{
                        System.out.print("\nnPress Y/N ==> ");
                        isSchedule = WFC.get_user_input.nextLine();
                    }while(!isSchedule.equalsIgnoreCase("yes") && !isSchedule.equalsIgnoreCase("y") && !isSchedule.equalsIgnoreCase("no") 
                    && !isSchedule.equalsIgnoreCase("n"));
                }
            
                // If user wants to schedule a lesson 
                if(isSchedule.equalsIgnoreCase("yes") || isSchedule.equalsIgnoreCase("y")){
                    scheduleLesson();
                }
            }
        }
    }
    
    // Schedule a lesson
    private static void scheduleLesson(){
        System.out.println("\nList Of Pre-Registered Users shown below -");
        System.out.println();
        System.out.printf("%-10s %-30s %-30s %n","S.No.","Customer No.","Username");
        System.out.println("-----------------------------------------------------");
        
        // Get Customers
        List<Customers> customers = Customers.getCustomers();
        getCustomer();
        
        System.out.print("\nEnter Customer No. ==> ");
        String cust_no = WFC.get_user_input.nextLine();
        
        String[] arr = new String[4];
                
        for(int i=0; i<customers.size(); i++){
            arr[i] = customers.get(i).getCustomer_no();
        }

        //Check entered customerno. exists in the records
        boolean checkValue = checkCustomer(arr,cust_no);

        if(!checkValue){
            do{
                System.out.print("\nEnter Customer No. from above Registered Customers ==> ");
                cust_no = WFC.get_user_input.nextLine();
                checkValue = checkCustomer(arr,cust_no);
            }while(!checkValue);
        }

        System.out.print("\nEnter Fitness Lesson Name ==> ");
        String fitness_lesson = WFC.get_user_input.nextLine();
        
        // Get Lessons
        List<FitnessLessons> lessons = FitnessLessons.getLessonList();
        String[] arr1 = new String[32];
                
        for(int i=0; i<lessons.size(); i++){
            arr1[i] = lessons.get(i).getFitness_lesson();
        }
        
        //Check entered lesson exists in the records
        boolean checkLessonValue = checkLesson(arr1,fitness_lesson);
        if(!checkLessonValue){
            do{
                System.out.print("\nEnter Valid Fitness Lesson Name ==> ");
                fitness_lesson = WFC.get_user_input.nextLine();
                checkLessonValue = checkLesson(arr1,fitness_lesson);
            }while(!checkLessonValue);
        }
        
        
        //validate so that customer cannot book same lesson twice
        boolean is_twice_scheduled = isLessonScheduledTwice(fitness_lesson,cust_no);
        if(is_twice_scheduled){
            System.out.println("You have already scheduled this lesson.");
            return;
        }

        //Validate Lesson capacity
        int totalBookings = checkLessonCapacity(fitness_lesson);
        if(totalBookings >= CustomerBookings.MAX_BOOKING){
            System.out.println("This lesson's available seats are all taken. You can change Fitness Lesson.");
            return;
        }

        //Generate Booking No
        String generate_booking_no = generateBookingNo();
        // Save Booking
        CustomerBookings booking = new CustomerBookings(generate_booking_no,cust_no, fitness_lesson, CustomerBookings.BookedStatus);
        CustomerBookings.bookingList.add(booking);
        System.out.println("\nYour Booking for Lesson '"+fitness_lesson+"' is confirmed successfully!");
        
        displayLatestBookedLesson();
    }
    
    
    
    //validate customer cannot book same lesson twice
    private static boolean isLessonScheduledTwice(String lesson, String customer_no){
        List<CustomerBookings> bookings = CustomerBookings.getBookings();
        String status = CustomerBookings.BookedStatus;
        for (CustomerBookings booking : bookings) {
            if (lesson.equalsIgnoreCase(booking.getLesson()) && status.equalsIgnoreCase(booking.getBooking_status())
                    && customer_no.equalsIgnoreCase(booking.getCustomer_no())) {
                return true;
            }
        }
        return false;
    }
    
    
    //Validate Lesson capacity
    private static int checkLessonCapacity(String lesson){
        List<CustomerBookings> bookings = CustomerBookings.getBookings();
        int count = 0;
        String status = CustomerBookings.BookedStatus;
        for (CustomerBookings booking : bookings) {
            if (booking.getLesson().equalsIgnoreCase(lesson) && booking.getBooking_status().equalsIgnoreCase(status)) {
                count++;
            }
        }
        return count;
    }
    
    
    
    //display latest booked lesson 
    private static void displayLatestBookedLesson(){

        System.out.println("\n\n********************************* Your Booking Details ************************************* ");
        List<CustomerBookings> bookingList = CustomerBookings.getBookings();
        List<FitnessLessons> lessons = FitnessLessons.getLessonList();
        List<FitnessExercises> exercises = FitnessExercises.getExerciseList();
        List<LessonSchedules> schedule = LessonSchedules.getSchedule();
        
        
        System.out.println();
        System.out.printf("%-20s %-30s %-30s %-30s %n", "Booking No.","Customer No.","Fitness Lesson", "Booking Status");
        System.out.println("----------------------------------------------------------------------------------------------------");


        //Display Bookings Details
        for(int m=bookingList.size(); m>0; m--){
            
            System.out.printf("%-20s %-30s %-30s %-30s %n", bookingList.get(bookingList.size()-1).getBooking_no(),bookingList.get(bookingList.size()-1).getCustomer_no(),  bookingList.get(bookingList.size()-1).getLesson(), bookingList.get(bookingList.size()-1).getBooking_status());
            
            //Display Lesson Details
            System.out.println("\n\n********************************* Fitness Lesson Details ************************************* ");
            System.out.println();
            System.out.printf("%-20s %-30s %-30s %-30s %-30s %n", "Exercise","Fitness Lesson","Amount","Day", "Scheduled On");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

            for(int i=0; i<schedule.size(); i++){
                for(int j=0; j<lessons.size(); j++){
                    for(int k=0; k<exercises.size(); k++){
                        if(bookingList.get(bookingList.size()-1).getLesson().equalsIgnoreCase(lessons.get(j).getFitness_lesson())){   
                            System.out.printf("%-20s %-30s $%-30s %-30s %-30s %n%n", exercises.get(k).getExercise(), 
                                lessons.get(j).getFitness_lesson(),exercises.get(k).getAmount(), schedule.get(i).getDay(),schedule.get(i).getScheduled_on());
                            break;
                        }
                    }
                }
                break;
            }
            break;
        }
    }
    
    
    
    //Generate booking No.
    private static String generateBookingNo(){
        Random rand = new Random();
        int rand_int = rand.nextInt(1000);
        String booking_no = "B"+rand_int;
        return booking_no;
    }
    
    
    
    //Check Pre Registered Customers
    private static void getCustomer(){
        List<Customers> customers = Customers.getCustomers();
        for(int i=0; i<customers.size(); i++){
            System.out.printf("%-10s %-30s %-30s %n%n", (i+1),customers.get(i).getCustomer_no(),customers.get(i).getUsername());
            System.out.println("-----------------------------------------------------");
        }
        
    }
    
    // Check the entered exercise exists in the schedule
    private static boolean checkExercise(String[] arr, String str){
        for (String arr1 : arr) {
            if (arr1.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
    
     // Check entered lesson exists or not
    private static boolean checkLesson(String[] arr, String str){
        for (String arr1 : arr) {
            if (arr1.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
    
    
    // Check customer exists or not
    private static boolean checkCustomer(String[] arr, String str){
        for (String arr1 : arr) {
            if (arr1.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
          
    //Display day wise schedule
    public static void displayweekDaySchedule(String day){
        List<LessonSchedules> schedule = LessonSchedules.getSchedule();
        List<FitnessLessons> lessons = FitnessLessons.getLessonList();
        List<FitnessExercises> exercises = FitnessExercises.getExerciseList();
        
        int counter = 1;
        System.out.println();
        System.out.println();
        System.out.printf("%-10s %-30s %-30s %-30s %-30s %-30s %n", "S.No.","Fitness Exercise", "Lesson", "Amount", "Day", "Scheduled On");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                
        for(int i=0; i<schedule.size(); i++){
            String lesson_name = String.valueOf(schedule.get(i).getLesson_no());
            String week_day = String.valueOf(schedule.get(i).getDay());
            
            for(int j=0; j<lessons.size(); j++){
                
                for(int k=0; k<exercises.size(); k++){
                
                    if(lesson_name.equalsIgnoreCase(lessons.get(j).getLesson_no()) && 
                            lessons.get(j).getExercise_no().equalsIgnoreCase(exercises.get(k).getExercise_no()) && week_day.equalsIgnoreCase(day)){
                        System.out.printf("%-10s %-30s %-30s $%-30s %-30s %-30s %n%n", counter,exercises.get(k).getExercise(), 
                                lessons.get(j).getFitness_lesson(),exercises.get(k).getAmount(), 
                                schedule.get(i).getDay(),schedule.get(i).getScheduled_on());
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                        counter = counter + 1;
                    }
                }
            }
        }
    }
    
    
    // Display Particular exercise schedule
    public static void displayParticularExerciseSchedule(String exercise){
        List<LessonSchedules> schedule = LessonSchedules.getSchedule();
        List<FitnessLessons> lessons = FitnessLessons.getLessonList();
        List<FitnessExercises> exercises = FitnessExercises.getExerciseList();
        
        int counter = 1;
        System.out.println();
        System.out.println();
        System.out.printf("%-10s %-30s %-30s %-30s %-30s %-30s %n", "S.No.","Fitness Exercise", "Lesson", "Amount", "Day","Scheduled On");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
                
        for(int i=0; i<schedule.size(); i++){
            String lesson_name = String.valueOf(schedule.get(i).getLesson_no());
          
            
            for(int j=0; j<lessons.size(); j++){
                
                for(int k=0; k<exercises.size(); k++){
                
                    String exercise_name = String.valueOf(exercises.get(k).getExercise());
                      
                    if(lesson_name.equalsIgnoreCase(lessons.get(j).getLesson_no()) && 
                            lessons.get(j).getExercise_no().equalsIgnoreCase(exercises.get(k).getExercise_no()) && 
                            exercise_name.equalsIgnoreCase(exercise)){
                        System.out.printf("%-10s %-30s %-30s $%-30s %-30s %-30s %n%n", counter,exercises.get(k).getExercise(), 
                                lessons.get(j).getFitness_lesson(),exercises.get(k).getAmount(), schedule.get(i).getDay(), 
                                schedule.get(i).getScheduled_on());
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
                        counter = counter + 1;
                    }
                }
            }
        }
    }
        
    
    public static void updateOrCancelFitnessLesson(){
        //Cancel Booking
        System.out.print("\nDo you want to cancel booking? Press (Y/N) ==> ");
        String cancel_choice = WFC.get_user_input.nextLine();

        if(!cancel_choice.equalsIgnoreCase("yes") && cancel_choice.equalsIgnoreCase("y") && !cancel_choice.equalsIgnoreCase("no") 
                && !cancel_choice.equalsIgnoreCase("n")){
            do{
                System.out.print("\nConfirm you choice by pressing Y/N  ==> ");
                cancel_choice = WFC.get_user_input.nextLine();
            }while(!cancel_choice.equalsIgnoreCase("yes") && !cancel_choice.equalsIgnoreCase("y") && !cancel_choice.equalsIgnoreCase("no") 
                    && !cancel_choice.equalsIgnoreCase("n"));
        }
        
        // If user wants to cancel scheduled lesson
        if(cancel_choice.equalsIgnoreCase("yes") || cancel_choice.equalsIgnoreCase("y")){
            System.out.print("\nEnter Booking No. ==> ");
            String booking_no = WFC.get_user_input.nextLine();
            
            //Validate Booking No.
            boolean isBookingNoExists = validateBookingNo(booking_no);
            if(isBookingNoExists){
                System.out.println("\nBooking No. does not exists.");
                return;
            }
            
            //Validate Booking Status
            String isBookingStatusBooked = validateBookingStatus(booking_no);
            if(isBookingStatusBooked.equalsIgnoreCase(CustomerBookings.AttendedStatus)){
                System.out.println("You already participated in this lesson. .");
                return;
            }
            
            cancelScheduledLesson(booking_no);
        }
        
        //If user wants to update booking details
        else{
            System.out.print("\nDo you want to update booking details? Press (Y/N) ==> ");
            String change_choice = WFC.get_user_input.nextLine();
            
            if(!change_choice.equalsIgnoreCase("yes") && change_choice.equalsIgnoreCase("y") && !change_choice.equalsIgnoreCase("no") 
                && !change_choice.equalsIgnoreCase("n")){
                do{
                    System.out.print("\nConfirm you choice by pressing Y/N ==> ");
                    change_choice = WFC.get_user_input.nextLine();
                }while(!change_choice.equalsIgnoreCase("yes") && !change_choice.equalsIgnoreCase("y") && !change_choice.equalsIgnoreCase("no") 
                    && !change_choice.equalsIgnoreCase("n"));
            }
            
            if(change_choice.equalsIgnoreCase("yes") || change_choice.equalsIgnoreCase("y")){
                System.out.print("\nEnter Booking No. ==> ");
                String booking_no = WFC.get_user_input.nextLine();

                //Validate Booking No.
                boolean isBookingNoExists = validateBookingNo(booking_no);
                if(isBookingNoExists){
                    System.out.println("\nBooking No. does not exists.");
                    return;
                }

                //Validate Booking Status whether attended or not
                String isBookingStatusBooked = validateBookingStatus(booking_no);
                if(isBookingStatusBooked.equalsIgnoreCase(CustomerBookings.AttendedStatus)){
                    System.out.println("You already participated in this lesson. .");
                    return;
                }

                updateLessonDetails(booking_no);
            }
        
            
        }
    }
    
    //Cancel Scheduled Lesson
    private static void cancelScheduledLesson(String booking_no){
        // Cancel Booking
        List<CustomerBookings> bookingList = CustomerBookings.getBookings();
        for(int i=0; i<bookingList.size(); i++){
            if(String.valueOf(bookingList.get(i).getBooking_no()).equalsIgnoreCase(booking_no)){
                bookingList.get(i).setBooking_status(CustomerBookings.CancelledStatus);
            }
        }
        
        System.out.println("\nYou have cancelled your booking against Booking No. : "+booking_no);
        
        displayUpdatedScheduledLesson(booking_no);
    }
       
    
    //update Scheduled lesson
    private static void updateLessonDetails(String booking_no){
        System.out.print("\nEnter New Fitness Lesson Name To Schedule ==> ");
        String fitness_lesson = WFC.get_user_input.nextLine();
        
        
        // Get Lessons
        List<FitnessLessons> lessons = FitnessLessons.getLessonList();
        String[] arr1 = new String[32];
                
        for(int i=0; i<lessons.size(); i++){
            arr1[i] = lessons.get(i).getFitness_lesson();
        }
        
        //Check entered lesson exists in the records
        boolean checkLessonValue = checkLesson(arr1,fitness_lesson);
        if(!checkLessonValue){
            do{
                System.out.print("\nEnter Valid Fitness Lesson Name ==> ");
                fitness_lesson = WFC.get_user_input.nextLine();
                checkLessonValue = checkLesson(arr1,fitness_lesson);
            }while(!checkLessonValue);
        }
 
        
        List<CustomerBookings> bookingList = CustomerBookings.getBookings();
        
        //Get Customer No.
        String customer_no = "";
        for(int i=0; i<bookingList.size(); i++){
            if(String.valueOf(bookingList.get(i).getBooking_no()).equalsIgnoreCase(booking_no)){
                customer_no = bookingList.get(i).getCustomer_no();
            }
        }
        
        //Is user scheduling lesson twice
        boolean is_twice_scheduled = isLessonScheduledTwice(fitness_lesson,customer_no);
        if(is_twice_scheduled){
            System.out.println("You have already scheduled this lesson.");
            return;
        }


        //Validate Lesson capacity
        int totalBookings = checkLessonCapacity(fitness_lesson);
        if(totalBookings >= CustomerBookings.MAX_BOOKING){
            System.out.println("This lesson's available seats are all taken. You can change Fitness Lesson.");
            return;
        }
        
            
        //Update Bookings Details
        for(int i=0; i<bookingList.size(); i++){
            if(String.valueOf(bookingList.get(i).getBooking_no()).equalsIgnoreCase(booking_no)){
                bookingList.get(i).setLesson(fitness_lesson);
                bookingList.get(i).setBooking_status(CustomerBookings.ChangedStatus);
            }
        }
        
        //Display Updated Booking Details
        displayUpdatedScheduledLesson(booking_no);
    }
    
    
    // Show Details when booking details are updated
    private static void displayUpdatedScheduledLesson(String booking_no){
        System.out.println("\n********************************* Your New Scheduled Lesson Details *************************************  \n");
        
        List<CustomerBookings> bookingList = CustomerBookings.getBookings();
        List<LessonSchedules> schedule = LessonSchedules.getSchedule();
        List<FitnessLessons> lessons = FitnessLessons.getLessonList();
        List<FitnessExercises> exercises = FitnessExercises.getExerciseList();
        
        System.out.println();
        System.out.printf("%-20s %-30s %-30s %-30s %n", "Booking No.","Customer No.","Fitness Lesson", "Booking Status");
        System.out.println("----------------------------------------------------------------------------------------------------");

        
        for(int m=0; m<bookingList.size(); m++){
            
            if(bookingList.get(m).getBooking_no().equalsIgnoreCase(booking_no)){
                System.out.printf("%-20s %-30s %-30s %-30s %n", bookingList.get(bookingList.size()-1).getBooking_no(),bookingList.get(bookingList.size()-1).getCustomer_no(),  bookingList.get(bookingList.size()-1).getLesson(), bookingList.get(bookingList.size()-1).getBooking_status());
            
                //Display Lesson Details
                System.out.println("\n\n********************************* Fitness Lesson Details ************************************* ");
                System.out.println();
                System.out.printf("%-20s %-30s %-30s %-30s %-30s %n", "Exercise","Fitness Lesson","Amount","Day", "Scheduled On");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

                for(int i=0; i<schedule.size(); i++){
                    for(int j=0; j<lessons.size(); j++){
                        for(int k=0; k<exercises.size(); k++){
                            if(bookingList.get(bookingList.size()-1).getLesson().equalsIgnoreCase(lessons.get(j).getFitness_lesson())){   
                                System.out.printf("%-20s %-30s $%-30s %-30s %-30s %n%n", exercises.get(k).getExercise(), 
                                    lessons.get(j).getFitness_lesson(),exercises.get(k).getAmount(), schedule.get(i).getDay(), schedule.get(i).getScheduled_on());
                                break;
                            }
                        }
                    }
                    break;
                }
                break;
            }
        }
    }
        
        
    // Validate Booking No.
    private static boolean validateBookingNo(String booking_no){
        List<CustomerBookings> bookingList = CustomerBookings.getBookings();
        for(int i=0; i<bookingList.size(); i++){
            boolean bookingIdValue = bookingList.stream().anyMatch(o ->String.valueOf(booking_no).equalsIgnoreCase(String.valueOf(o.getBooking_no())));
            if(bookingIdValue){
                return false;
            }
        }
        return true;
    }
    
    
    //Validate Booking Status
    private static String validateBookingStatus(String booking_no){
        List<CustomerBookings> bookingList = CustomerBookings.getBookings();
        String status = "";

        for (CustomerBookings booking : bookingList) {
            if (String.valueOf(booking.getBooking_no()).equalsIgnoreCase(booking_no)) {
                status = booking.getBooking_status();
                break;
            }
        }

        return status;
    }
    
    public static void writeReviewForFitnessLesson(){
        System.out.print("\nDo you want to add review for a lesson? Press (Y/N) ==> ");
        String is_review = WFC.get_user_input.nextLine();

        if(!is_review.equalsIgnoreCase("yes") && is_review.equalsIgnoreCase("y") && !is_review.equalsIgnoreCase("no") 
                && !is_review.equalsIgnoreCase("n")){
            do{
                System.out.print("\nConfirm you choice by pressing Y/N ==> ");
                is_review = WFC.get_user_input.nextLine();
            }while(!is_review.equalsIgnoreCase("yes") && !is_review.equalsIgnoreCase("y") && !is_review.equalsIgnoreCase("no") 
                    && !is_review.equalsIgnoreCase("n"));
        }
        
        // If user wants to cancel scheduled lesson
        if(is_review.equalsIgnoreCase("yes") || is_review.equalsIgnoreCase("y")){
            
            System.out.print("\nEnter Customer No. ==> ");
            String cust_no = WFC.get_user_input.nextLine();

            String[] arr = new String[4];
            
            List<Customers> customers = Customers.getCustomers();

            for(int i=0; i<customers.size(); i++){
                arr[i] = customers.get(i).getCustomer_no();
            }

            //Check entered customerno. exists in the records
            boolean checkValue = checkCustomer(arr,cust_no);

            if(!checkValue){
                do{
                    System.out.print("\nEnter Customer No. from above Registered Customers ==> ");
                    cust_no = WFC.get_user_input.nextLine();
                    checkValue = checkCustomer(arr,cust_no);
                }while(!checkValue);
            }

            System.out.print("\nEnter Fitness Lesson Name ==> ");
            String fitness_lesson = WFC.get_user_input.nextLine();

            // Get Lessons
            List<FitnessLessons> lessons = FitnessLessons.getLessonList();
            String[] arr1 = new String[32];

            for(int i=0; i<lessons.size(); i++){
                arr1[i] = lessons.get(i).getFitness_lesson();
            }

            //Check entered lesson exists in the records
            boolean checkLessonValue = checkLesson(arr1,fitness_lesson);
            if(!checkLessonValue){
                do{
                    System.out.print("\nEnter Valid Fitness Lesson Name ==> ");
                    fitness_lesson = WFC.get_user_input.nextLine();
                    checkLessonValue = checkLesson(arr1,fitness_lesson);
                }while(!checkLessonValue);
            }
            
            
            //Check entered lesson has booking or not by the customer
            boolean check_booking = validateCustomerBookingStatus(cust_no,fitness_lesson);
           
            if(!check_booking){
                System.out.print("\nEither you didn't schedule or you have cancelled this lesson.\n");
                return;
            }
            
            
            //Check entered lesson has review or not by the customer
            boolean check_review = validateAddedReview(cust_no,fitness_lesson);
           
            if(check_review){
                System.out.print("\nYou have already added a review for this lesson.\n");
                return;
            }
            
            System.out.print("\nEnter Review/Comment for the Fitness Lesson ==> ");
            String comment = WFC.get_user_input.nextLine();
            
            System.out.print("\nSelect Rating from below options : \n\n");
            System.out.println(Reviews.VeryDissatisfied+" for Very dissatisfied");
            System.out.println(Reviews.Dissatisfied+" for Dissatisfied");
            System.out.println(Reviews.Ok+" for OK");
            System.out.println(Reviews.Satisfied+" for Satisfied");
            System.out.println(Reviews.VerySatisfied+" for Very Satisfied");
            String rating = WFC.get_user_input.nextLine();
            
            if(!WFC.containsOnlyDigits(rating)){
                do{
                    System.out.print("\nEnter Valid Integer Value ==> ");
                    rating = WFC.get_user_input.nextLine();
                }while(!WFC.containsOnlyDigits(rating));
            }
            
            if(Integer.parseInt(rating) < 0  || Integer.parseInt(rating) > 5 ){
                do{
                    System.out.print("\nEnter Valid Rating between 1 to 5 ==> ");
                    rating = WFC.get_user_input.nextLine();
                }while(Integer.parseInt(rating) < 0  || Integer.parseInt(rating) > 5);
            }
            
            
            Reviews ratings = new Reviews(cust_no,fitness_lesson,comment,Integer.parseInt(rating));
            Reviews.reviews.add(ratings);
            
            System.out.println("\nThanks for adding review for '"+fitness_lesson+"'");
        }
    }
    
    
    //Check whether the customer has made booking
    private static boolean validateCustomerBookingStatus(String cust_no ,String fitness_lesson ){
        
        List<CustomerBookings> bookings = CustomerBookings.getBookings();
        String status1 = "booked";
        String status2 = "changed";
        for(int i=0; i<bookings.size(); i++){
            boolean lesson_name = bookings.stream().anyMatch(o ->fitness_lesson.equalsIgnoreCase(o.getLesson()));
            boolean cust_num = bookings.stream().anyMatch(o ->cust_no.equalsIgnoreCase(o.getCustomer_no()));
            boolean b_status1 = bookings.stream().anyMatch(o ->status1.equalsIgnoreCase(o.getBooking_status()));
            boolean b_status2 = bookings.stream().anyMatch(o ->status2.equalsIgnoreCase(o.getBooking_status()));

            if(lesson_name && cust_num && b_status1 || b_status2){
                return true;
            }
        }
        return false;
    }
        
        
    //Validate review cannot be added twice for same lesson by user
    private static boolean validateAddedReview(String cust_no, String fitness_lesson){
        List<Reviews> reviews = Reviews.getReviews();
        for(int i=0; i<reviews .size(); i++){
            if(reviews .get(i).getCustomer_no().equalsIgnoreCase(cust_no) && reviews.get(i).getFitness_lesson().equalsIgnoreCase(fitness_lesson)){
                return true;
            }
        }
        return false;
    }
    
    public static void downloadMonthlyLessonReport() throws IOException{
        System.out.print("\nEnter Month Number ==> ");
        int month_num = WFC.get_user_input.nextInt();
         
        downloadLessonReport(month_num);
    }
    
    public static void downloadLessonReport(int month_num) throws IOException{
        try {
            fw = new FileWriter("lesson_report.txt", false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            
            List<CustomerBookings> bookingList = CustomerBookings.getBookings();
            List<LessonSchedules> schedule = LessonSchedules.getSchedule();
            List<FitnessLessons> lessons = FitnessLessons.getLessonList();
            List<Reviews> rating = Reviews.getReviews();
            int total_cust = 0;
            int num_of_rating = 0;
            int total_rating = 0;

            String lesson = "";
            String lesson_name = "";
            System.out.println();

            for(int i=0; i<schedule.size(); i++){
                
                String date_value = schedule.get(i).getScheduled_on();
                LocalDate localDate = LocalDate.parse(date_value);
                int schedule_month = localDate.getMonthValue();
                
                for(int m=0; m<lessons.size(); m++){

                    //Get total customers
                    for(int j=0; j<bookingList.size(); j++){

                        for(int k=0; k<lessons.size(); k++){

                            if(schedule.get(i).getLesson_no().equalsIgnoreCase(lessons.get(k).getLesson_no()) &&
                                    bookingList.get(j).getLesson().equalsIgnoreCase(lessons.get(k).getFitness_lesson())
                                    && schedule_month == month_num){
                                total_cust = total_cust + 1;
                                lesson = bookingList.get(j).getLesson();
                            }  
                        }             
                    }

                    //Average Rating
                    for(int k=0; k<rating.size(); k++){

                        if(schedule.get(i).getLesson_no().equalsIgnoreCase(lessons.get(k).getLesson_no()) &&
                                    rating.get(k).getFitness_lesson().equalsIgnoreCase(lessons.get(k).getFitness_lesson())){
                            num_of_rating = num_of_rating + 1;
                            total_rating = total_rating + rating.get(k).getRatings();
                            lesson_name = rating.get(k).getFitness_lesson();
                        }
                    }

                    if(!lessons.get(m).getFitness_lesson().equalsIgnoreCase(lesson)){
                        total_cust = 0;
                    }

                    if(!lessons.get(m).getFitness_lesson().equalsIgnoreCase(lesson_name)){
                        num_of_rating = 0;
                        total_rating = 0;
                    }
                    double get_avg_rating = 0.0;
                    if(num_of_rating != 0){
                        get_avg_rating = total_rating/num_of_rating;
                    }else{
                        get_avg_rating = 0;
                    }
                                        
                    pw.write("\nLesson : "+lessons.get(m).getFitness_lesson()+", Total Customers : "+total_cust+", Avg Rating : "+get_avg_rating);
                }
            }
            System.out.println("\nReport Downloaded Successfully!");
            pw.flush();

        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {
            }
        }
    }
    
    public static void downloadMonthlyChampionFitnessTypeReport() throws IOException{
        
        System.out.print("\nEnter Month Number ==> ");
        int month_num = WFC.get_user_input.nextInt();
        
        downloadChampionReport(month_num);
    }
    
    public static void downloadChampionReport(int month_num) throws IOException{
        try {
            fw = new FileWriter("champion_report.txt", false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            List<CustomerBookings> bookingList = CustomerBookings.getBookings();
            List<LessonSchedules> schedule = LessonSchedules.getSchedule();
            List<FitnessLessons> lessons = FitnessLessons.getLessonList();
            List<FitnessExercises> exercises = FitnessExercises.getExerciseList();

            int total_amount = 0;
            String lesson = "";
            System.out.println();
          
            for(int i=0; i<schedule.size(); i++){
                String date_value = schedule.get(i).getScheduled_on();
                LocalDate localDate = LocalDate.parse(date_value);
                int schedule_month = localDate.getMonthValue();
                
                for(int n=0; n<exercises.size(); n++){
                    for(int m=0; m<lessons.size(); m++){
                        for(int j=0; j<bookingList.size(); j++){
                            if(schedule.get(i).getLesson_no().equalsIgnoreCase(lessons.get(m).getLesson_no()) 
                                    && bookingList.get(j).getLesson().equalsIgnoreCase(lessons.get(m).getFitness_lesson())
                                    && lessons.get(m).getExercise_no().equalsIgnoreCase(exercises.get(n).getExercise_no())
                                    && schedule_month == month_num){
                                total_amount = total_amount +  exercises.get(n).getAmount();
                                lesson = bookingList.get(j).getLesson();
                            }            
                            break;
                        }
                        if(!lessons.get(m).getFitness_lesson().equalsIgnoreCase(lesson)){
                            total_amount = 0;
                        }
                        pw.write("\nLesson :"+lessons.get(m).getFitness_lesson()+", Total Amount Earned : $"+total_amount);
                    }
                }
            }

            System.out.println("\nReport Downloaded Successfully!");
            pw.flush();

        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {
            }

        }
    }
    
}
