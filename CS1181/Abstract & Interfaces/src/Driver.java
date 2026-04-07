import java.util.ArrayList;

public class Driver {
    public static void main(String[] args){

    Student ug = new UnderGradStudent(3.9);
    ug.goToClass();
    
    
    Student g = new GradStudent(3.4);
    g.goToClass();
    g.driveToCampus();
    

    ArrayList ll = new LogList();
    ll.add("Event 1 occured");
    ll.add("Event 2 occured");
    ll.add("Event 3 occured");
    ll.add("Event 4 occured");
    ll.add("Event 5 occured");
    ll.printEveryOther();
    }
}
