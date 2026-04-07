/**
 * Golfer class represents a golfer with a name, score, and number of holes completed.
 * Implements Comparable to allow sorting based on score, holes completed, and name.
 */

public class Golfer implements Comparable<Golfer>{
    private String lastName;
    private String firstName;
    private int score;
    private int holesCompleted;

    /**
     * Constructs a Golfer object with the given details
     * 
     * @param lname the last name of the golfer
     * @param fname the first name of the golfer
     * @param s the score of the golfer
     * @param hc the number of holes completed by the golfer
     */

    public Golfer(String lname, String fname, int s, int hc){
        this.lastName = lname;
        this.firstName = fname;
        this.score = s;
        this.holesCompleted = hc;
    }

    /**
     * Returns the first name of the golfer
     * 
     * @return first name
     */

    public String getFirstName(){
        return firstName;
    }

    /**
     * Returns the last name of the golfer
     * 
     * @return last name
     */

    public String getLastName(){
        return lastName;
    }

    /**
     * Return the number of holes completed
     * 
     * @return holes completed
     */

    public int getHolesCompleted(){
        return holesCompleted;
    }

    /**
     * Return the score of the golfer
     * 
     * @return score
     */

    public int getScore(){
        return score;
    }

    /**
     * Sets the first name of the golfer
     * 
     * @param fname new first name
     */

    public void setFirstName(String fname){
        this.firstName = fname;
    }

    /**
     * Sets the last name of the golfer
     * 
     * @param lname new last name
     */

    public void setLastName(String lname){
        this.lastName = lname;
    }

    /**
     * Sets the number of holes completed
     * 
     * @param hc new number of holes completed
     */
    
    public void setHolesCompleted(int hc){
        this.holesCompleted = hc;
    }

    /**
     * Sets the score
     * 
     * @param s new score
     */

    public void setScore(int s){
        this.score = s;
    }

    /**
     * Returns a string representation of the golfer
     * 
     * @return string with name, score, and holes completed
     */

    public String toString(){
        return lastName + ", " + firstName + ": " + "score of " + score + " with " + holesCompleted + " holes completed";
    }

    /**
     * Compares this golfer to another golfer for sorting
     * Sorting is based on score, then holes completed, then last name, then first name (all case-insensitive)
     * 
     * @param otherGolfer the other golfer to compare to
     * @return negative if this < other, 0 if equal, positive if this > other
     */

    @Override
    public int compareTo(Golfer otherGolfer) {
        if(this.score > otherGolfer.score){
            return 1;
        } else if(this.score < otherGolfer.score){
            return -1;
        } else {
            if(this.holesCompleted > otherGolfer.holesCompleted){
                return 1;
            } else if(this.holesCompleted < otherGolfer.holesCompleted){
                return -1;
            } else{
                int lastNameCompare = this.lastName.compareToIgnoreCase(otherGolfer.lastName);
                if(lastNameCompare > 0){
                    return 1;
                } else if(lastNameCompare < 0){
                    return -1;
                }
                else {
                    int firstNameCompare = this.firstName.compareToIgnoreCase(otherGolfer.firstName);
                    if(firstNameCompare > 0){
                        return 1;
                    } else if(firstNameCompare < 0){
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }
}
