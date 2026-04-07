public class CountDown {
    public static void countDown(int start, int stop) {
        if (start < stop){
            System.out.println("Invalid parameters");
        }
        else if(start == stop){
            System.out.println(start);
        }
        else{
            System.out.print(start + ", ");
            countDown(start - 1, stop);
        }
    }

    public static void main(String[] args){
        countDown(10, 3);
        countDown(4, 5);
        countDown(-2, -6);
        
        countDown(10, 1);
        countDown(-5, 5);
        countDown(-5, -10);
        countDown(3, 3);
        countDown(5, 10);
    }
}