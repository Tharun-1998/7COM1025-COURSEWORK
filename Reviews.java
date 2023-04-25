
import java.util.ArrayList;
import java.util.List;


public class Reviews {
    
    private String customer_no;
    private String fitness_lesson;
    private String lesson_review;
    private int ratings;
    
    public static final int VeryDissatisfied = 1;
    public static final int Dissatisfied = 2;
    public static final int Ok = 3;
    public static final int Satisfied = 4;
    public static final int VerySatisfied = 5;

    public static List<Reviews> reviews = new ArrayList<>();

    public Reviews(String customer_no, String fitness_lesson, String lesson_review, int ratings) {
        this.customer_no = customer_no;
        this.fitness_lesson = fitness_lesson;
        this.lesson_review = lesson_review;
        this.ratings = ratings;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public String getFitness_lesson() {
        return fitness_lesson;
    }

    public String getLesson_review() {
        return lesson_review;
    }

    public int getRatings() {
        return ratings;
    }
    
    public static  List<Reviews> getReviews(){
        return reviews;
    }
    
}
