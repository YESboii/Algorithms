package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.peek();
        queue.poll();
        queue.size();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(1);
        deque.offerLast(1);
        deque.pollFirst();
        deque.pollLast();
        deque.peekFirst();
        deque.peekLast();

    }
}
