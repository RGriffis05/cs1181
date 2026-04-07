public class Driver {
    public static void main(String[] args) throws Exception {
            int result = performDivide();
            System.out.println("Result was: " + result);
    }

    public static int performDivide(){
        try{
            int numerator = 6;
            int denominator = 0;

            int result = divide(numerator, denominator);
            //stop execution ---> jump to catch block

            return result;

        } catch(ArithmeticException ae){
            System.out.println("Oops, you tried to divide by 0");

            return 0;

        } catch(NumberTooBigException ntbe){
            System.out.println("Oops, you tried to divide a number too big");
            return 100;

        } catch (Exception e){
            System.out.println("I have no idea what went wrong");
            return -1;
        }
    }

    public static int divide(int n, int d) throws NumberTooBigException{
        if (d == 0){
            //extends RunTimeException
            throw new ArithmeticException("Denominator can not be 0");
        }

        if(n > 100){
            //extends Exception
            throw new NumberTooBigException("You can not divide numbers as big as " + n);
        }
        //if bad condition
        //return early
        return 1;
    }


}
