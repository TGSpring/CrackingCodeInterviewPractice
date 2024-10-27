/**
 * Tyler Spring
 * 10/27/2024
 * Chapter 2 Return kth to last: Implement an algorithm to find the kth to last
 * element of a singly linked list.
 */
public class Q2_2 {
public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(9);
    head.next.next.next.next = new ListNode(5);

    int k = 2;
    ListNode res = findKthToLast(head, k);
    if (res != null) {
        System.out.println("Kth to last element is: " + res.data);
    } else {
        System.out.println("List is too short");
    }
}

//SOLUTION ONE

public static ListNode findKthToLast(ListNode head, int k){
    ListNode p1 = head;
    ListNode p2 = head;

    //Move p2 k nodes ahead
    for (int i = 0; i < k; i++) {
        if (p2 == null) return null;
        p2 = p2.next;
    }

    //Move both pointers until p2 reaches the end
    while (p2 != null) {
        p1 = p1.next;
        p2 = p2.next;
    }
    return p1;
}
    

//SOLUTION TWO

    public static ListNode findKthToLastByLength(ListNode head, int k) {
        int length = 0;
        ListNode current = head;

        //First pass: calculate the length of the List
        while (current != null) {
            length++;
            current = current.next;
        }

        if (k > length) return null; //If k is greater than the length
        
        //Second pass: Find (length - k)th node
        current = head;
        for (int i = 0; i < length -k; i++) {
            current = current.next;
        }
        return current;
    }
}
/**
 * SOLUTION ONE Explanation:
 * p2 is advanced k steps ahead of p1.
 * Both p1 and p2 move together until p2 reaches the end.
 * At this point, p1 will be at the kth-to-last node.
 * 
 * 
 * SOLUTION TWO Explanation:
 * First we compute the length of the List
 * In the second pass, we move to the (length - k)th node, which is the kth-to-last node.
 */