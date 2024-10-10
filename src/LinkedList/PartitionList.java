package LinkedList;
//https://leetcode.com/problems/partition-list/
public class PartitionList {
    public static void main(String[] args) {

    }
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;

        ListNode dummy = new ListNode(-1, head),prev = dummy,curr = head;

        ListNode ansDummy = new ListNode(0), currAns = ansDummy;

        while(curr!=null){
            if(curr.val<x){
                ListNode temp = curr.next;
                prev.next = temp;
                curr.next = null;
                currAns.next = curr;
                currAns = curr;
                curr = temp;
            }else{
                curr = curr.next;
                prev = prev.next;
            }
        }
        currAns.next = dummy.next;
        return ansDummy.next;
    }
}
