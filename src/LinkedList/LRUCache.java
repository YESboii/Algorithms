package LinkedList;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Map<Integer, Entry> map;
    private DoublyLinkedList list;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        Entry e = map.get(key);
        if (e == null) {
            return -1;
        }
        list.moveToFirst(e);
        return e.getValue();
    }

    public void put(int key, int value) {
        Entry x = map.get(key);
        if (x != null) {
            list.update(x, value);
            list.moveToFirst(x);
            return;
        }
        if (list.getSize() == capacity) {
            Entry delEntry = list.deleteTail();
            map.remove(delEntry.k);
        }
        Entry e = list.addFirst(key, value);
        map.put(key, e);
    }


    static class DoublyLinkedList {
        private Entry head;
        private Entry tail;
        private int size;

        public int getSize() {
            return size;
        }

        public void update(Entry e, int v) {
            e.v = v;
        }

        public Entry addFirst(int k, int v) {
            Entry newNode = new Entry(k, v);
            if (size == 0) {
                head = newNode;
                tail = head;
            } else {
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            }
            size++;
            return newNode;
        }

        public void addFirst(Entry e) {
            if (size == 0) {
                head = e;
                tail = head;
            } else {
                head.prev = e;
                e.next = head;
                e.prev = null;
                head = e;
            }
            size++;
        }

        public Entry deleteTail() {
            Entry temp = tail;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
                temp.prev = null;
            }
            size--;
            return temp;
        }

        public void moveToFirst(Entry e) {
            if (e.prev == null) {
                return;
            }
            if (e.next == null) {
                deleteTail();
                addFirst(e);
                return;
            }

            e.prev.next = e.next;
            e.next.prev = e.prev;
            size--;
            addFirst(e);
        }
    }


    private static class Entry {
        private int k;
        private int v;
        private Entry next;
        private Entry prev;

        Entry(int k, int v) {
            this.k = k;
            this.v = v;
        }

        public int getKey() {
            return k;
        }

        public int getValue() {
            return v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
