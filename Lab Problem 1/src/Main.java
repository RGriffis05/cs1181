public class Main {

    public static void main(String[] args) {
        
        System.out.println("User class testing: ");

        User user1 = new User("Michelle", "12345");
        System.out.println("1. " + user1.isValidPassword()); // false -- less than 8 characters

        User user2 = new User("Michelle", "12345Michelle");
        System.out.println("2. " + user2.isValidPassword()); // false -- contains username

        User user3 = new User("Michelle", "12345678");
        System.out.println("3. " + user3.isValidPassword()); // true

        System.out.println("4. " + user2.authenticate("ABCDE")); // false -- incorrect password

        System.out.println("5. " + user2.authenticate("12345Michelle")); // true 

        System.out.println("6. " + user3.authenticate("12345678")); // true


        System.out.println("Secure User class testing: ");

        SecureUser su1 = new SecureUser("Bob", "495837");
        System.out.println("1. " + su1.isValidPassword()); //false -- less than 8 characters

        SecureUser su2 = new SecureUser("Jeff", "Jeff2938");
        System.out.println("2. " + su2.isValidPassword()); //false -- contains password

        SecureUser su3 = new SecureUser("Billy", "ILovePizza");
        System.out.println("3. " + su3.isValidPassword()); //true -- is 8 characters long and doesn't contain the username

        SecureUser su4 = new SecureUser("Emma",  "894038187");
        System.out.println("4. " + su4.isValidPassword()); //true -- is 8 characters long and doesn't contain the username

        System.out.println();

        System.out.println("Username: Billy");

        System.out.println("5. " + su3.authenticate("ILovePizzaBites")); //false -- incorrect password, not correct capitalization, +1 to password attempts
        System.out.println("6. " + su3.authenticate("IHatePizza")); //false -- incorrect password
        System.out.println("7. " + su3.authenticate("ILovePizzaPockets")); //false -- incorrect password, account locked
        System.out.println("8. " + su3.authenticate("ILovePizza")); //false -- account is locked
        
        System.out.println();

        System.out.println("Username: Emma");

        System.out.println("9. " + su4.authenticate("12345678")); //false -- incorrect passowrd, attemptsRemaining = 2
        System.out.println("10. " + su4.authenticate("8675309")); //false -- incorrect password, attemptsRemaining = 1
        System.out.println("11. " + su4.authenticate("894038187")); //true -- correct password, attemptsRemaining = 3
    }

}
