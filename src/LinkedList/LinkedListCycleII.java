package LinkedList;
/*
*
* List: 1 → 2 → 3 → 4 →     5
                    ↑       ↓
                    8 ← 7 ← 6   (cycle starts at 4)

*
*
* */
public class LinkedListCycleII {

    public int lengthOfCycle(ListNode head){
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            head = head.next;
            if(fast == head){
                int length = 1;
                head = head.next;
                while(head!=fast){
                    length++;
                    head=head.next;
                }
                return length;
            }
        }
        return 0;
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        int length = lengthOfCycle(head);
        if(length == 0){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while(length!=0){
            first = first.next;
            length--;
        }
        while(first!=second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
