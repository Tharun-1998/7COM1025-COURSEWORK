
import java.util.ArrayList;


public class FitnessExercises {
    
    private String exercise_no;
    private String exercise;
    private int amount;

    public FitnessExercises(String exercise_no, String exercise, int amount) {
        this.exercise_no = exercise_no;
        this.exercise = exercise;
        this.amount = amount;
    }
    
    public String getExercise() {
        return exercise;
    }

    public int getAmount() {
        return amount;
    }

    public String getExercise_no() {
        return exercise_no;
    }
    
    
    
    public static ArrayList getExerciseList() {
        ArrayList <FitnessExercises> exercise = new ArrayList<>();
        FitnessExercises obj1 = new FitnessExercises("E001","Yoga",100);
        FitnessExercises obj2 = new FitnessExercises("E002","Box Fit",105);
        FitnessExercises obj3 = new FitnessExercises("E003","Aquacise",110);
        FitnessExercises obj4 = new FitnessExercises("E004","Zumba",115);
        
        exercise.add(obj1);
        exercise.add(obj2);
        exercise.add(obj3);
        exercise.add(obj4);
        return exercise;
    }
    
}
