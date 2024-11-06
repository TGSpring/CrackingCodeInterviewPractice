import java.util.*;

/**
 * Tyler Spring
 * 11/6/2024
 * Chapter 3 Question 3.2
 * Stack Min
 */

public class Q3_2 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor
    public Q3_2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        // Only push to minStack if it is empty or the current value is <= top of minStack.
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public int pop() {
        int value = stack.pop();
        // Only pop from minStack if the popped value is the current minimum.
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        // Top of minStack is always the minimum element in the stack.
        return minStack.peek();
    }

    public static void main(String[] args) {
        Q3_2 minStack = new Q3_2();
        minStack.push(5);
        minStack.push(6);
        minStack.push(3);
        minStack.push(7);

        System.out.println("Current min: " + minStack.min()); // Should print 3
        minStack.pop();
        System.out.println("Current min: " + minStack.min()); // Should print 3
        minStack.pop();
        System.out.println("Current min: " + minStack.min()); // Should print 5
    }
}

/**
 * Explanation:
 * stack: stores all elements pushed onto the stack.
 * minStack: stores the minimum elements, ensuring that the current minimum is always accessible 
 * at the top of minStack.
 * 
 * push(int value): add value to stack.
 * checks if minStack is empty or if value is less than or equal to the current minimum.
 * if either condition is true, it pushes value onto minStack as well, ensuring the new minimum is tracked.
 * 
 * pop(): pops the top element from stack and stores it in value.
 * checks if value matches the top of minStack.
 * if true, pops value from minStack to remove the old minimum.
 * Returns the popped value.
 * 
 * min(): returns the top of minStack, which is the current minimum value in stack.
 */