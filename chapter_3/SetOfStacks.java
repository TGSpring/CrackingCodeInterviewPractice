/**
 * Tyler Spring
 * 11/8/2024
 * Chapter 3 Question 3.3
 * Stack of Plates
 */
 import java.util.*;
public class SetOfStacks {
    private ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    private int capacity; // capacity of each individual stack.

    //Constructor to initialize SetOfStacks with each stack's max capacity.
    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    //Push value onto the set of stacks.
    public void push(int value) {
        //If no stacks exist or the last stack is full,  we need a new stack.
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == capacity) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(value);
            stacks.add(newStack);
        } else {
            //Push onto the last stack.
            stacks.get(stacks.size() - 1).push(value);
        }
    }

    //Pop value from the set of stacks.
    public int pop() throws Exception {
        if (stacks.isEmpty()) {
            throw new Exception("Set of stacks is empty.");
        }
        //Pop from the last stack.
        Stack<Integer> lastStack = stacks.get(stacks.size() - 1);
        int value = lastStack.pop();

        //Remove last stack if it is now empty to save space.
        if (lastStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }



    //Pop value from a specific sub-stack (based on index)
    public int popAt(int index) throws Exception {
        if (index < 0 || index >= stacks.size()) {
            throw new Exception("Invalid stack index");
        }
        Stack<Integer> stack = stacks.get(index);
        int value = stack.pop();

        //If a stack is now empty, remove it to maintain structure.
        if (stack.isEmpty()) {
            stacks.remove(index);
        }
        return value;
    }



    public static void main(String[] args) {
        try {
            SetOfStacks setOfStacks = new SetOfStacks(3); //Each stack has a max capacity of 3

            setOfStacks.push(1);
            setOfStacks.push(2);
            setOfStacks.push(3);
            setOfStacks.push(4); //This should go into new stack.
            setOfStacks.push(5);

            System.out.println("Popped from stack 1: " + setOfStacks.popAt(0)); //Pops 3
            System.out.println("Popped from stack 2: " + setOfStacks.popAt(1)); //Pops 5
            System.out.println("Popped from top: " + setOfStacks.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * Explanation:
 * Data Structure: ArrayList<Stack<Integer>> stacks: a list of stacks to simulate
 * multiple plate stacks.
 * 
 * Push(): checks if there's space in the current (last) stack. If not, it creates a new stack 
 * and pushes the value there.
 * 
 * Pop(): Pops the top element from the stack.
 * If the last stack becomes empty after the pop, it removes that stack to avoid storing empty stacks.
 * 
 * PopAt(int index): Pops an element from a specific stack at the given index.
 * If the specified stacks becomes empty after the pop, it's removed from the List
 * to keep the structure clean.
 * 
 * Complexity:
 * Push(): O(1) Adding an element is O(1), although in the rare case of creating a new stack,
 * we might incur a slight overhead.
 * 
 * Pop(): O(1) accessing the last stack is O(1).
 * 
 * PopAt(int index): O(1) Direct access to a stack in an ArrayList is O(1).
 */