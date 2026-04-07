public class UnderGradStudent extends Student {


    public UnderGradStudent(double gpa){
        super(gpa);
    }
    
    @Override
    public void goToClass(){
        System.out.println("*Attends CS1181*");
    }
}
