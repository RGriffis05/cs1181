public class Driver {

    static volatile boolean keepWorking = true;

    public static void main(String[] args){

        //lambda expression

        Thread t1 = new Thread(() -> {
            //any code writtien here
            //will run in a seperate thread

            System.out.println("Thread was started");

            while(Driver.keepWorking){
                //do some work here
            }

            System.out.println("Thread finished working");
        });

        t1.start();

        try {
            Thread.sleep(1000);

        } catch (InterruptedException ie) {
    
            System.out.println("Issue with thread sleep");
        }

        System.out.println("Telling t1 to stop working");
        
        Driver.keepWorking = false;
        
        try {
            t1.join();
        } catch (InterruptedException ie) {
            
            System.out.println("Issue with thread joining");
        }

        System.out.println("Reached end of main");

        //spawnRec();
    }

    //public static void spawnRec(){

    //}

}
