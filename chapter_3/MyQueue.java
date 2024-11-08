/**
 * Tyler Spring
 * 11/8/2024
 * Chapter 3 Question 3.4
 * Queue via Stacks.
 */

 import java.util.*;
public class MyQueue<T> {
    private Stack<T> stackNewest; //Stack to hold new elements (for enqueue)
    private Stack<T> stackOldest; //Stack to hold elements in queue order (for dequeue).

    // Constructor to initialize the two stacks.
    public MyQueue() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    //Adds an item to the end of the queue.
    public void enqueue(T value) {
        stackNewest.push(value); //Always push new elements onto stackNewest.
    }

    //Removes the item from the front of the queue.
    public T dequeue() {
        shiftStacks(); // Ensure stackOldest has the current order for dequeue.
        return stackOldest.pop(); // Pop from stackOldest, which holds elements in queue order.
    }


    //Peeks at the front item of the queue without removing it.
    public T peek() {
        shiftStacks(); //Ensure stackOldest has the current order for peek.
        return stackOldest.peek(); //Peek from stackOldest.
    }


    //Moves elements from stackNewest to stackOldest if stackOldest is empty.
    private void shiftStacks() {
        if (stackOldest.isEmpty()) { //Only transfer if stackOldest is empty to maintain order.
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    //Check if the queue is empty.
    public boolean isEmpty() {
        return stackNewest.isEmpty() && stackOldest.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        //Enqueue some items
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        //Perform dequeues and check the state.
        System.out.println("Dequeued: " + myQueue.dequeue()); //Should print 1
        System.out.println("Peek: " + myQueue.peek()); //Should print 2
        System.out.println("Dequeued: " + myQueue.dequeue()); //Should print 2

        myQueue.enqueue(4);
        System.out.println("Dequeued: " + myQueue.dequeue()); //should print 3
        System.out.println("Dequeued: " + myQueue.dequeue()); //Should print 4
    }
}
/**
 * Explanation:
 * Data Structure: 
 * StackNewest: stack to hold newly added items.
 * stackOldest: stack to hold items in the correct queue order.
 * 
 * Enqueue(T value): pushes new elements onto stackNewest, where they stay until they're needed for 
 * dequeue or peek.
 * 
 * Dequeue(): Calls shiftStacks() to transfer elements from stackNewest to stackOldest if stackOldest 
 * is empty. This ensures the elements are in queue order.
 * Then pops from stackOldest.
 * 
 * Peek(): Similar to dequeue(), but just retrieves the top of stackOldest without removing it.
 * 
 * shiftStacks(): Transfers elements from stackNewest to stackOldest only when stackOldest 
 * is empty, ensuring the order of elements is correct.
 * 
 * Complexity:
 * enqueue: O(1) pushing to stackNewest is always O(1).
 * Dequeue: Amortized O(1) On average, each element is moved once from stackNewest 
 * to stackOldest, so each dequeue is O(1).
 * Peek(): Amortized O(1) Similar to dequeue() due to shiftStacks() mechanism. 
 */