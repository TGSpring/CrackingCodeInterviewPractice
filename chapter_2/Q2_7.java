/**
 * Tyler Spring
 * 11/1/2024
 * Chapter 2 Question 2.7
 * Intersection
 */
public class Q2_7 {
    public static void main(String[] args) {
        ListNode commonNode = new ListNode(7);
        commonNode.next = new ListNode(8);

        ListNode head1 = new ListNode (3);
        head1.next = new ListNode(1);
        head1.next.next = commonNode; //Intersection starts here.

        ListNode head2 = new ListNode(5);
        head2.next = commonNode;

        ListNode intersection = findIntersection(head1, head2);
        if (intersection != null) {
            System.out.println("Intersecting Node: " + intersection.data);
        } else {
            System.out.println("No Intersection");
        }
    }

    public static ListNode findIntersection (ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;

        //Get the lengths of both lists
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        //Align the start points.
        ListNode longer = len1 > len2 ? head1 : head2;
        ListNode shorter = len1 > len2 ? head2 : head1;
        int difference = Math.abs(len1 - len2);

        for (int i = 0; i < difference; i++) {
            longer = longer.next;
        }

        // Move both pointers until they meet at the intersection point.
        while(longer != null && shorter != null) {
            if(longer == shorter) {
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }

    //Helper method to get the length of a linked list.
    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
/**
 * Explanation
 * Calculate lengths: getLength helper function counts nodes in each list.
 * Align start points: Advance the longer list's pointer by the difference in lengths so that both 
 * pointers are aligned.
 * Traverse Simultaneously: Move both pointers together. If they meet, an intersection exists;
 * if they reach the end, there is no intersection.
 * 
 * Time complexity: O(n + m), where n and m are the lengths of the two lists.
 * Space complexity; O(1) as we only use pointers without extra data structures.
 */