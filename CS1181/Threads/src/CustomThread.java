import java.util.Random;

public class CustomThread extends Thread{

    private long timeToWait;
    private String name;

    public static volatile int result;

    public CustomThread(long timeInMillis, String name){
        this.timeToWait = timeInMillis;

        this.name = name;
    }

    @Override
    public void run(){

        System.out.println(name);
        System.out.println("Running in a seperate thread");
    
        try{
            Thread.sleep(this.timeToWait);
        } catch{
            
        }
    }

}