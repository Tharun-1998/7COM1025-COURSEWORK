
import java.io.IOException;
import java.util.Scanner;


public class WFC {
    
    public static Scanner get_user_input = new Scanner(System.in);
    
    
    //Main Method Of Class
    public static void main(String[] arg) throws IOException{
        System.out.println("\n***************************  Welcome to Weekend Fitness Club  *************************** ");
        System.out.println();
        int menu_option = displayMainInteface();
        
        /* Call Functions According to Menu Option Selected */
        while (menu_option != 6) {
            switch (menu_option)
            {
                case 1 -> Functions.scheduleFitnessLesson();
                case 2 -> Functions.updateOrCancelFitnessLesson();
                case 3 -> Functions.writeReviewForFitnessLesson();
                case 4 -> Functions.downloadMonthlyLessonReport();
                case 5 -> Functions.downloadMonthlyChampionFitnessTypeReport();
                case 6 -> System.exit(0);
                default -> System.out.println("\nYou entered an Invalid Option.\n");
            }
            menu_option = displayMainInteface();
        }
    }
    
    
    //Main Interface with Menu Options
    private static int displayMainInteface(){
        System.out.println("\nSelect your choice => ");
        System.out.println("1. Schedule a Group Fitness Lesson");
        System.out.println("2. Cancel / Update Booking Details");
        System.out.println("3. Write a Review For Lesson");
        System.out.println("4. Download Monthly Lesson Report");
        System.out.println("5. Download Monthly Champion Fitness Type Report");
        System.out.println("6. Exit Program");
        
        String option  = "";
        
        /* Validation for Menu Options */
        while (true) {
            System.out.print("\nEnter Valid Option ==> ");
            option = get_user_input.nextLine();
            if (option.isEmpty()) {
                System.out.println("\nPlease Select an Option. ");
            } else if (!containsOnlyDigits(option)) {
                System.out.println("\nYou must enter an integer value. ");
            } else {
                break;
            }
        }
        return Integer.parseInt(option);
    }
    
    
    // Validation for Menu Option to check whethet the enter option is string or integer
    public static boolean containsOnlyDigits(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
