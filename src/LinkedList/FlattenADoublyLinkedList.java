package LinkedList;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
public class FlattenADoublyLinkedList {
    public Node flatten(Node head) {
        if(head==null) return null;
        Node dummy = new Node(),temp = dummy;
        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()){
            Node n = stack.pop();
            if(n.next!=null) stack.push(n.next);
            if(n.child!=null){
                stack.push(n.child);
                n.child = null;
            }
            temp.next = n;
            n.prev = temp;
            temp = n;
        }
        // head = dummy.next;
        dummy.next=null;
        head.prev = null;
        return head;

    }


}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};