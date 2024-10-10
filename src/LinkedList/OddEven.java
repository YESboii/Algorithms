package LinkedList;
//https://leetcode.com/problems/odd-even-linked-list/
public class OddEven {


    public ListNode oddEvenList(ListNode head) {

        if(head==null||head.next==null||head.next.next==null) return head;

        ListNode odd = head, even = head.next,temp = even;

        while (even!=null){
            ListNode evenNext = even.next;
            odd.next = evenNext;

            if(evenNext!=null){
                even.next = evenNext.next;
            }

            even = even.next;
            odd = odd.next;
        }

        odd.next = temp;
        return head;
    }
}
