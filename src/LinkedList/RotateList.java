package LinkedList;
//https://leetcode.com/problems/rotate-list/
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null||k==0) return head;

        int size = 1;
        ListNode curr = head;
        while (curr.next!=null){
            size++;
            curr = curr.next;
        }
        int numberOfRotations = k % size;
        if (numberOfRotations==0){
            return head;
        }
        curr.next = head;
        int posOfHead = size - numberOfRotations;
        curr = head;
        for (int i=1;i<=posOfHead;i++){
            if (i==posOfHead){
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
            }else curr = curr.next;
        }
        head = curr;
        return head;
    }
}
