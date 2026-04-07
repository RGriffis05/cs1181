import java.util.ArrayList;
import java.util.Collections;

public class Driver{
    public static void main(String[] args) {
        //Comparable ---> lets you define natural sorting
        //Comparator ---> lets you define un-natural sorting

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(4.0, 1));
        students.add(new Student(1.0, 5));
        students.add(new Student(2.4, 3));
        students.add(new Student(3.6, 4));
        students.add(new Student(3.1, 2));

        System.out.println(students);

        Collections.sort(students);

        System.out.println(students);
    }
}
