/**
 * Tyler Spring
 * 11/2/2024
 * Chapter 3 Question 3.1
 * Three in Order flexible solution
 */

 public class FlexibleThreeStacks {
    private int stackSize;
    private int[] values;
    private int[] sizes; // Sizes of each stack
    private int[] starts;

    public FlexibleThreeStacks(int totalSize) {
        this.stackSize = totalSize / 3;
        this.values = new int[totalSize];
        this.sizes = new int[]{0, 0, 0};
        this.starts = new int[]{0, stackSize, 2 * stackSize};
    }

    public void push(int stackNum, int value) throws Exception {
        if (isFull(stackNum)) {
            expand(stackNum); // Expand if out of room
        }
        int idx = starts[stackNum] + sizes[stackNum];
        values[idx] = value;
        sizes[stackNum]++;
    }

    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new Exception("Stack " + stackNum + " is Empty.");
        }
        int idx = starts[stackNum] + sizes[stackNum] - 1;
        int value = values[idx];
        values[idx] = 0; // Clear value
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) throws Exception {
        if (isEmpty(stackNum)) {
            throw new Exception("Stack " + stackNum + " is empty.");
        }
        return values[starts[stackNum] + sizes[stackNum] - 1];
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] + starts[stackNum] >= (stackNum == 2 ? values.length : starts[stackNum + 1]);
    }

    private void expand(int stackNum) throws Exception {
        // If there is no more room for any stacks to expand, throw an exception.
        if (sizes[0] + sizes[1] + sizes[2] >= values.length) {
            throw new Exception("Out of space for expansion");
        }

        // Shift stacks to create more space.
        shift((stackNum + 1) % 3);
    }

    private void shift(int stackNum) {
        // Shifting operation for expanding the stack by moving others.
        int end = (stackNum == 2) ? values.length : starts[stackNum + 1];

        // Shift items in reverse to make space at the stack's start.
        for (int i = end - 1; i >= starts[stackNum]; i--) {
            values[i + 1] = values[i];
        }
        starts[stackNum]++;
    }

    public static void main(String[] args) {
        try {
            FlexibleThreeStacks stacks = new FlexibleThreeStacks(9);
            stacks.push(0, 10);
            stacks.push(0, 11);
            stacks.push(1, 20);
            stacks.push(2, 30);

            System.out.println("Stack 0 Peek: " + stacks.peek(0)); // Output: 11
            System.out.println("Stack 1 Peek: " + stacks.peek(1)); // Output: 20
            System.out.println("Stack 2 Peek: " + stacks.peek(2)); // Output: 30

            stacks.pop(0);
            System.out.println("Stack 0 Peek after pop: " + stacks.peek(0)); // Output: 10
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * Explanation:
 * Push adds an element to the specified stack, and calls expand if the stack is full.
 * Expand: Checks if total space is exceeded; otherwise, shifts the next stack to make room.
 * Shift: Shifts elements in a stack by one index forward to allow space for the growing stack.
 * 
 *
 */