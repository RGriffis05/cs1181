public class GradStudent extends Student implements Commuter{

    public GradStudent(double gpa){
        super(gpa);
    }

    @Override 
    public void goToClass(){
        System.out.println("*Attends CS7200*");
    }

    public void driveToCampus(){
        System.out.println("*Drives to campus*");
    }

}
