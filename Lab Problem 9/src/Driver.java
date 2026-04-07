import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Deque<Integer> intStack = new ArrayDeque<>();
        Queue<Integer> intQueue = new ArrayDeque<>();
        int[] nums = {9, 6, 4, 2, 5, 1, 3};

        for(int n : nums){
            intStack.push(n);
            intQueue.offer(n);
        }

        System.out.println("Stack Contents:");
        while(!intStack.isEmpty()){
            System.out.println(intStack.pop());
        }

        System.out.println("");

        System.out.println("Queue Contents:");
        while(!intQueue.isEmpty()){
            System.out.println(intQueue.poll());
        }

    }
}
