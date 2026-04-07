/**
 * This class represents a square with a givern side length
 * It provides methods to calculate the perimeter and area of the square
 */

public class Square {

    private double side;

    /**
     * Constructs a Square object which intakes the specified side length
     * Throws NegativeLengthException if the side is negative
     * 
     * @param side the length of the square's side
     * @throws NegativeLengthException if the side length is negative
     */
    public Square(double side) throws NegativeLengthException {
        this.side = Length(side);
    }

    /**
     * Returns a string representation of the square
     * 
     * @return a string describing the square
     */
    @Override
    public String toString(){
        return "Square with side = " + side;
    }

    /**
     * Calculates the perimeter of the square
     * 
     * @return the perimeter of the square
     */
    public double getPerimeter(){
        return 4 * side;
    }
    /**
     * Calculates the area of the square
     * 
     * @return area of the square
     */
    public double getArea(){
        return side * side;
    }
    /**
     * Validates the given side length.
     * Throws NegativeLengthException if the length is negative
     * 
     * @param s the side length to validate
     * @return the validated side length
     * @throws NegativeLengthException if the side length is negative
     */
    public static double Length(double s) throws NegativeLengthException{
        if(s < 0){
            throw new NegativeLengthException("Negative length: " + s);
        }
        return s;
    }
}
