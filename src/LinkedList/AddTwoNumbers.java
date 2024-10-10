package LinkedList;
//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(),temp = dummy;
        int carry = 0;
        while(carry==1 || l1!=null || l2!=null){
            int v1 = l1==null ? 0 : l1.val;
            int v2 = l2==null ? 0 : l2.val;
            int sum = (carry + v1 + v2);
            int dig = sum % 10;
            carry =  sum / 10;

            ListNode newNode = new ListNode(dig);
            temp.next = newNode;
            temp = newNode;

            if(l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }

        }
        return dummy.next;
    }
}
