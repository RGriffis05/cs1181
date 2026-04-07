import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Driver class is the entry point of the program
 * Its prompts the user to enter a side length, creates a Square object,
 * and displays its perimeter and area
 */

public class Driver {

    /**
     * Main method that runs the square calculator program
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter the length of the square's side: ");

        try{

        double side = scnr.nextDouble();
        Square square = new Square(side);
        System.out.println(square.toString());
        System.out.println("Perimeter: " + square.getPerimeter());
        System.out.println("Area: " + square.getArea());;

        } catch(InputMismatchException ime){
            System.out.println("Error: must input a number");

        }catch(NegativeLengthException nle){

            System.out.println(nle.getMessage());

        }
    }
}