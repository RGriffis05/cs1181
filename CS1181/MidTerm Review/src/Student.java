public class Student implements Comparable<Student> {

    private double gpa;
    private int id;
    public Student(double gpa, int id){
        this.gpa = gpa;
        this.id = id;
    }

    public String toString(){
        return "" + id + ": " + gpa;
    }

    @Override
    public int compareTo(Student other){
        //this
        //other

        if(this.id < other.id){
            return -1;

        } else if(this.id > other.id){
            return 1;

        } else{
            return 0;
        }
    }
}
