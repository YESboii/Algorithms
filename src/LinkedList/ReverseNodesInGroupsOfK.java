package LinkedList;
//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInGroupsOfK {

    public static void main(String[] args) {

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next==null || k==1) return head;
        ListNode dummy = new ListNode(0,head),curr = head,prevTail = dummy;
        while (hasKGroups(k,curr)){
            ListNode p1 = null,p2 = curr;
            for (int i =1;i<=k;i++){
                ListNode p2Next = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p2Next;
            }
            prevTail.next = p1;
            curr.next = p2;
            prevTail = curr;
            curr = p2;
        }
        return dummy.next;
    }
    public boolean hasKGroups(int k,ListNode curr){
        while (k!=1){
            if(curr==null) break;
            curr= curr.next;
            k--;
        }
        return curr!=null;
    }
}
