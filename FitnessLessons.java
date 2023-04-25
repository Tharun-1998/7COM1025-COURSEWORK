
import java.util.ArrayList;


public class FitnessLessons {
    
    private String lesson_no;
    private String exercise_no;
    private String fitness_lesson;

    public FitnessLessons(String lesson_no, String exercise_no, String fitness_lesson) {
        this.lesson_no = lesson_no;
        this.exercise_no = exercise_no;
        this.fitness_lesson = fitness_lesson;
    }

    public String getLesson_no() {
        return lesson_no;
    }

    public String getExercise_no() {
        return exercise_no;
    }

    public String getFitness_lesson() {
        return fitness_lesson;
    }
    
    public static ArrayList getLessonList() {
        ArrayList <FitnessLessons> fitness_lesson = new ArrayList<>();
        FitnessLessons obj1 = new FitnessLessons("L001","E001","Hatha Yoga");
        FitnessLessons obj2 = new FitnessLessons("L002","E002","Core Boxing");
        FitnessLessons obj3 = new FitnessLessons("L003","E003","Gymnastics");
        FitnessLessons obj4 = new FitnessLessons("L004","E004","Aqua Zumba");
        
        FitnessLessons obj5 = new FitnessLessons("L005","E001","Yogasanas Yoga");
        FitnessLessons obj6 = new FitnessLessons("L006","E002","Shadow Boxing");
        FitnessLessons obj7 = new FitnessLessons("L007","E003","Resistance Training");
        FitnessLessons obj8 = new FitnessLessons("L008","E004","Zumba Gold");
        
        FitnessLessons obj9 = new FitnessLessons("L009","E001","Surya Kriya");
        FitnessLessons obj10 = new FitnessLessons("L010","E002","Jump Rope");
        FitnessLessons obj11 = new FitnessLessons("L011","E003","Resistance Training");
        FitnessLessons obj12 = new FitnessLessons("L012","E004","Zumba Kids");
        
        
        FitnessLessons obj13 = new FitnessLessons("L013","E001","Bhuta Shuddhi");
        FitnessLessons obj14 = new FitnessLessons("L014","E002","Medicine Ball Slams");
        FitnessLessons obj15 = new FitnessLessons("L015","E003","Marathon Training");
        FitnessLessons obj16 = new FitnessLessons("L016","E004","Zumba Step");
        
        
        FitnessLessons obj17 = new FitnessLessons("L017","E001","Angamardana");
        FitnessLessons obj18 = new FitnessLessons("L018","E002","Burpee with Shadow Boxing");
        FitnessLessons obj19 = new FitnessLessons("L019","E003","Hiking Sessions");
        FitnessLessons obj20 = new FitnessLessons("L020","E004","Zumbini");
        
        FitnessLessons obj21 = new FitnessLessons("L021","E001","Upa Yoga");
        FitnessLessons obj22 = new FitnessLessons("L022","E002","Ski Squat with Uppercuts");
        FitnessLessons obj23 = new FitnessLessons("L023","E003","Jab Punch");
        FitnessLessons obj24 = new FitnessLessons("L024","E004","Zumba Gold-Toning");
        
        FitnessLessons obj25 = new FitnessLessons("L025","E001","Bhava Spandana");
        FitnessLessons obj26 = new FitnessLessons("L026","E002","Bob & Weave");
        FitnessLessons obj27 = new FitnessLessons("L027","E003","Cross Punch");
        FitnessLessons obj28 = new FitnessLessons("L028","E004","Zumba In the Circuit");
        
        FitnessLessons obj29 = new FitnessLessons("L029","E001","Tadasana");
        FitnessLessons obj30 = new FitnessLessons("L030","E002","Medicine Ball Punch");
        FitnessLessons obj31 = new FitnessLessons("L031","E003","Hook Punch");
        FitnessLessons obj32 = new FitnessLessons("L032","E004","Zumba Toning");
        
        
        fitness_lesson.add(obj1);
        fitness_lesson.add(obj2);
        fitness_lesson.add(obj3);
        fitness_lesson.add(obj4);
        fitness_lesson.add(obj5);
        fitness_lesson.add(obj6);
        fitness_lesson.add(obj7);
        fitness_lesson.add(obj8);
        fitness_lesson.add(obj9);
        fitness_lesson.add(obj10);
        fitness_lesson.add(obj11);
        fitness_lesson.add(obj12);
        fitness_lesson.add(obj13);
        fitness_lesson.add(obj14);
        fitness_lesson.add(obj15);
        fitness_lesson.add(obj16);
        fitness_lesson.add(obj17);
        fitness_lesson.add(obj18);
        fitness_lesson.add(obj19);
        fitness_lesson.add(obj20);
        fitness_lesson.add(obj21);
        fitness_lesson.add(obj22);
        fitness_lesson.add(obj23);
        fitness_lesson.add(obj24);
        fitness_lesson.add(obj25);
        fitness_lesson.add(obj26);
        fitness_lesson.add(obj27);
        fitness_lesson.add(obj28);
        fitness_lesson.add(obj29);
        fitness_lesson.add(obj30);
        fitness_lesson.add(obj31);
        fitness_lesson.add(obj32);
        return fitness_lesson;
    }
}
