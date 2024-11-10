/**
 * Tyler Spring
 * 11/10/2024
 * Chapter 3 Question 3.5
 * Sort stack.
 */

 import java.util.*;
public class SortedStack {
    
    private Stack<Integer> stack; //Original stack holding unsorted elements.
    private Stack<Integer> tempStack; // Temp stack to assist in sorting.
    

    //Constructor to initialize the stacks.
    public SortedStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    //Method to push an element in a sorted manner.
    public void push(int value) {
        //Move elements from tempStack to stack if they're greater than the current value.
        while (!tempStack.isEmpty() && tempStack.peek() > value) {
            stack.push(tempStack.pop());
        }

        //Push the current value onto tempStack.
        tempStack.push(value);

        //Move all elements back to tempstack to maintain sorted order.
        while(!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
    }


    //Removes the smallest item (top of the sorted stack)
    public int pop() {
        return tempStack.pop(); //TempStack is sorted, so top element is the smallest.
    }

    //Peek at the smallest item (top of the sorted stack)
    public int peek() {
        return tempStack.peek();
    }

    //Check is the stack is empty.
    public boolean isEmpty() {
        return tempStack.isEmpty();
    }
    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();

        //Push elements onto stack.
        sortedStack.push(3);
        sortedStack.push(1);
        sortedStack.push(4);
        sortedStack.push(2);

        //Display and pop elements in sorted order.
        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }
    }
}
/**
 * Explanation:
 * Push(int value): We transfer elements from tempStack to stack until we find the correct place to insert 
 * value in the sorted order.
 * Once value is placed in tempstack, we transfer all elements back from stack to 
 * tempstack to maintain the sorted order.
 * 
 * Pop(): This simply pops from tempStack, where elements are stored with the smallest on top.
 * 
 * Peek(): Returns the top element of tempStack, which is the smallest element.
 * 
 * Complexity:
 * Push() O(n): as each push operation may require transferring all elements back
 * and forth to maintain order.
 * Pop() O(1): since it's a direct pop from tempStack.
 * Peek() O(1): similar to pop(), as it's just a top element access.
 */