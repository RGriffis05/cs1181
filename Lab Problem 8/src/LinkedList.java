/**
 * A simple singly-linked list implementation for storing strings.
 */
public class LinkedList {

    /** Reference to the first node in the list */
    private Node head;
    /** Reference to the last node in the list */
    private Node tail;

    /**
     * Adds an item to the end of the linked list.
     * @param item the string to add
     */
    public void add(String item) {
        Node newItem = new Node(item);

        // handles the case where the new item 
        // is the only thing in the list
        if (head == null) {
            head = newItem;
            tail = newItem;
            return;
        }

        tail.next = newItem;
        tail = newItem;
    }

    /**
     * Prints all items in the linked list to the console.
     */
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }

    /**
     * Returns the penultimate (second-to-last) item in the linked list.
     * @return the second-to-last item's value, or null if it doesn't exist
     */
    public String getPenultimate() {
        // If the list has fewer than 2 items, return null
        if (head == null || head.next == null) {
            return null;
        }

        Node current = head;
        // Traverse to the node just before the tail
        while (current.next != tail) {
            current = current.next;
        }
        return current.item;
    }

    /**
     * Returns the first item in the linked list.
     * @return the value of the first item, or null if the list is empty
     */
    public String getFirst() {
        if (head == null) {
            return null;
        }
        return head.item;
    }

    /**
     * Returns the last item in the linked list.
     * @return the value of the last item, or null if the list is empty
     */
    public String getLast() {
        if (tail == null) {
            return null;
        }
        return tail.item;
    }

    /**
     * Node class represents each element in the linked list.
     */
    class Node {
        /** The value stored in this node */
        String item;
        /** Reference to the next node in the list */
        Node next;

        /**
         * Constructs a node with the specified item.
         * @param item the value to store in the node
         */
        public Node(String item) {
            this.item = item;
            this.next = null;
        }
    }
}