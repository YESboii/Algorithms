package LinkedList;

public class RemoveDupesFromSortedLL {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            while (temp != null && temp.val == curr.val) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }
}
//1 2 2 2 3 4 4 5