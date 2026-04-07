/**
 * The Matching class provides a method to recursively check
 * whether a given string is a proper nesting of parentheses.
 */
public class Matching {

    /**
     * Determines whether the given string is a valid nesting of parentheses.
     * A valid nesting is defined as a string consisting only of matched pairs
     * of parentheses, such as "", "()", "(())", or "((()))".
     *
     * @param n the input string to check
     * @return true if the string is a valid nesting of zero or more pairs of parentheses, false otherwise
     */
    public static boolean nestParen(String n) {
        if (n.equals("")) {
            return true;
        }

        if (n.length() < 2) {
            return false;
        }

        if (n.charAt(0) == '(' && n.charAt(n.length() - 1) == ')') {
            return nestParen(n.substring(1, n.length() - 1));
        }

        return false;
    }

    /**
     * The main method runs several test cases to demonstrate the functionality
     * of the nestParen method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(nestParen("(())"));         // true
        System.out.println(nestParen("((()))"));       // true
        System.out.println(nestParen("(((x))"));       // false
        System.out.println(nestParen("((())"));        // false
        System.out.println(nestParen("((()()"));       // false
        System.out.println(nestParen(""));             // true
        System.out.println(nestParen("(yy)"));         // false
        System.out.println(nestParen("((yy())))"));    // false

        System.out.println("");
        System.out.println(nestParen("(()"));          // false
        System.out.println(nestParen("(((((())))"));   // false
        System.out.println(nestParen("(y(y(x)x)"));    // false
        System.out.println(nestParen("(aaa(s(ccc)yyy)")); // false
        System.out.println(nestParen("(b((a)()"));     // false
        System.out.println(nestParen("lmnop"));        // false
        System.out.println(nestParen("(xxyxxyx)"));    // false
        System.out.println(nestParen("((yy()yy))"));   // false
    }
}
