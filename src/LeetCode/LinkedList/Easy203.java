package LeetCode.LinkedList;

public class Easy203 {

    public static void main(String[] args) {
        int[] values1 = {1, 2, 6, 3, 4, 5, 6};
        int val1 = 6;
        HelperOnLinkedList.ListNode head1 = HelperOnLinkedList.createLinkedList(values1);
        System.out.println("Original List:");
        HelperOnLinkedList.printLinkedList(head1);
        HelperOnLinkedList.ListNode result1 = removeElements(head1, val1);
        System.out.println("List after removing " + val1 + ":");
        HelperOnLinkedList.printLinkedList(result1);
    }

    // Easy 203. Remove Linked List Elements
    public static HelperOnLinkedList.ListNode removeElements(HelperOnLinkedList.ListNode head, int val) {
        if (head == null)
            return null;
        HelperOnLinkedList.ListNode prev = new HelperOnLinkedList.ListNode();
        HelperOnLinkedList.ListNode curr = head;
        while (curr != null) {
            if (curr.val == val)
                if (prev.val > 0)
                    prev.next = curr.next;
                else head = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return head;
    }

}
