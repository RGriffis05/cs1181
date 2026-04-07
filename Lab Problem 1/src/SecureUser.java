/**
 * The SecureUser class extends the User class by adding authentication
 * attempt tracking and locks the user out after three failed attempts
 */

public class SecureUser extends User{

    /**
     * Tracks the number of remaining authentication attempts.
     * A user is locked out after this reached 0.
     */
    public int attemptsRemaining = 3;

    /**
     * Constructs a SecureUser with the specified username and password
     * @param username the username of the user
     * @param password the password of the user
     */

    public SecureUser(String username, String password) {
        super(username, password);
    }
/**
 * Attempts to authnticate the user using the provided password
 * Tracks the number of failed attempts. Resets the attempt counter if password is correct
 * Locks the account after 3 failed attempts
 * 
 * @param inputPassword the password to authenticate with
 * @return true if authentication os successful and account is not locked
 *         false otherwise
 */
    @Override
    public boolean authenticate(String inputPassword){
        super.authenticate(inputPassword);
            if(!(inputPassword.equals(password))){
                attemptsRemaining = attemptsRemaining - 1;
                if(attemptsRemaining > 0){
                    System.out.println(inputPassword + " incorrect. Attempts remaining: " + attemptsRemaining);
                } else{
                    System.out.println(inputPassword + " incorrect. No more attempts remaining. Account locked");
                }
                return false;
            } else if(attemptsRemaining > 0) {
                attemptsRemaining = 3;
                System.out.println(inputPassword + " correct! Attempts remaining: " + attemptsRemaining);
                return true;
            } else {
                System.out.println("Account locked!");
                return false;
            }
    }
}