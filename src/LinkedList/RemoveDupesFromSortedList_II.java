package LinkedList;

public class RemoveDupesFromSortedList_II {

    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;

        ListNode dummy = new ListNode(-1,head);
        ListNode prev = dummy, curr = head;

        while (curr!=null){

            if(curr.next!=null && curr.next.val==curr.val){
                curr = curr.next;
            }
            else if(prev.next==curr){
                prev = curr;
                curr = curr.next;
            }else {
                curr = curr.next;
                prev.next = curr;
            }
        }
        return dummy.next;
    }
}
