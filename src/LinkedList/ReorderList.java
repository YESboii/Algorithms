package LinkedList;
//https://leetcode.com/problems/reorder-list/
public class ReorderList {

    public static void main(String[] args) {

    }
    public void reorderList(ListNode head){
        if(head==null || head.next==null) return;
        ListNode middle = findMiddle(head);
        ListNode rCurr = reverse(middle);
        ListNode lCurr = head;
        ListNode dummy = new ListNode(0), curr = dummy;
        boolean flag = true;
        while (lCurr!=rCurr){
            if (flag){
                ListNode temp = lCurr.next;
                lCurr.next = null;
                curr.next = lCurr;
                curr = lCurr;
                lCurr = temp;
                flag = false;
            }
            else {
                ListNode temp = rCurr.next;
                rCurr.next = null;
                curr.next = rCurr;
                curr = rCurr;
                rCurr = temp;
                flag = true;
            }
        }
        curr.next = rCurr;
    }
    public ListNode findMiddle(ListNode head){
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }
    public ListNode reverse(ListNode curr){
        ListNode prev = null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
        }
        return prev;
    }

}
