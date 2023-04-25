
import java.util.ArrayList;


public class LessonSchedules {
    
    private String schedule_no;
    private String lesson_no;
    private String day;
    private String scheduled_on;

    public LessonSchedules(String schedule_no, String lesson_no,  String day, String scheduled_on) {
        this.schedule_no = schedule_no;
        this.lesson_no = lesson_no;
        this.day = day;
        this.scheduled_on = scheduled_on;
    }

    public String getSchedule_no() {
        return schedule_no;
    }

    public String getLesson_no() {
        return lesson_no;
    }

    public String getDay() {
        return day;
    }

    public String getScheduled_on() {
        return scheduled_on;
    }
    
    public static ArrayList getSchedule() {
        ArrayList <LessonSchedules> schedule = new ArrayList<>();
        
        LessonSchedules obj1 = new LessonSchedules("S001","L001","Sunday","2023-02-05");
        LessonSchedules obj2 = new LessonSchedules("S002","L002","Saturday","2023-02-04");
        LessonSchedules obj3 = new LessonSchedules("S003","L003","Sunday","2023-02-05");
        LessonSchedules obj4 = new LessonSchedules("S004","L004","Saturday","2023-02-04");
        LessonSchedules obj5 = new LessonSchedules("S005","L005","Saturday","2023-02-11");
        LessonSchedules obj6 = new LessonSchedules("S006","L006","Sunday","2023-02-12");
        LessonSchedules obj7 = new LessonSchedules("S007","L007","Saturday","2023-02-11");
        LessonSchedules obj8 = new LessonSchedules("S008","L008","Sunday","2023-02-12");
        LessonSchedules obj9 = new LessonSchedules("S009","L009","Sunday","2023-02-19");
        LessonSchedules obj10 = new LessonSchedules("S010","L010","Saturday","2023-02-18");
        LessonSchedules obj11 = new LessonSchedules("S011","L011","Sunday","2023-02-19");
        LessonSchedules obj12 = new LessonSchedules("S012","L012","Saturday","2023-02-18");
        LessonSchedules obj13 = new LessonSchedules("S013","L013","Saturday","2023-02-25");
        LessonSchedules obj14 = new LessonSchedules("S014","L014","Sunday","2023-02-26");
        LessonSchedules obj15 = new LessonSchedules("S015","L015","Saturday","2023-02-25");
        LessonSchedules obj16 = new LessonSchedules("S016","L016","Sunday","2023-02-26");
        LessonSchedules obj17 = new LessonSchedules("S017","L017","Sunday","2023-03-05");
        LessonSchedules obj18 = new LessonSchedules("S018","L018","Saturday","2023-03-04");
        LessonSchedules obj19 = new LessonSchedules("S019","L019","Sunday","2023-03-05");
        LessonSchedules obj20 = new LessonSchedules("S020","L020","Saturday","2023-03-04");
        LessonSchedules obj21 = new LessonSchedules("S021","L021","Saturday","2023-03-11");
        LessonSchedules obj22 = new LessonSchedules("S022","L022","Sunday","2023-03-12");
        LessonSchedules obj23 = new LessonSchedules("S023","L023","Saturday","2023-03-11");
        LessonSchedules obj24 = new LessonSchedules("S024","L024","Sunday","2023-03-12");
        LessonSchedules obj25 = new LessonSchedules("S025","L025","Sunday","2023-03-19");
        LessonSchedules obj26 = new LessonSchedules("S026","L026","Saturday","2023-03-18");
        LessonSchedules obj27 = new LessonSchedules("S027","L027","Sunday","2023-03-19");
        LessonSchedules obj28 = new LessonSchedules("S028","L028","Saturday","2023-03-18");
        LessonSchedules obj29 = new LessonSchedules("S029","L029","Saturday","2023-03-25");
        LessonSchedules obj30 = new LessonSchedules("S030","L030","Sunday","2023-03-26");
        LessonSchedules obj31 = new LessonSchedules("S031","L031","Saturday","2023-03-25");
        LessonSchedules obj32 = new LessonSchedules("S032","L032","Sunday","2023-03-26");
        
        schedule.add(obj1);
        schedule.add(obj2);
        schedule.add(obj3);
        schedule.add(obj4);
        schedule.add(obj5);
        schedule.add(obj6);
        schedule.add(obj7);
        schedule.add(obj8);
        schedule.add(obj9);
        schedule.add(obj10);
        schedule.add(obj11);
        schedule.add(obj12);
        schedule.add(obj13);
        schedule.add(obj14);
        schedule.add(obj15);
        schedule.add(obj16);
        schedule.add(obj17);
        schedule.add(obj18);
        schedule.add(obj19);
        schedule.add(obj20);
        schedule.add(obj21);
        schedule.add(obj22);
        schedule.add(obj23);
        schedule.add(obj24);
        schedule.add(obj25);
        schedule.add(obj26);
        schedule.add(obj27);
        schedule.add(obj28);
        schedule.add(obj29);
        schedule.add(obj30);
        schedule.add(obj31);
        schedule.add(obj32);
        return schedule;
    }
    
}
