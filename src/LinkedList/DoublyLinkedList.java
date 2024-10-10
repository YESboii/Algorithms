package LinkedList;

//see the ll class some theory about ll impl dcll, bs complete questions
final public class DoublyLinkedList<T>{

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int getSize(){
        return size;
    }
    public void addFirst(T val){
        size++;
        if (head==null){
            head = new Node(val);
            tail = head;
            return;
        }
        Node temp = new Node(val,head);
        head.prev = temp;
        temp.next = head;
        head = temp;
    }
    public void addLast(T val){
        size++;
        if (head==null){
            head = new Node(val);
            tail = head;
            return;
        }
        Node temp = new Node(val);
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
    }
    public T deleteHead(){

        if (size==0){
            throw new NegativeArraySizeException();
        }
        T val = head.val;
        if (size==1){ // head==tail
            head= null;
            tail = null;
        }else {
            Node temp = head.next;
            head.next = null;
            head = temp;
            head.prev = null;
        }
        size--;
        return val;
    }
    public T deleteTail(){

        if (size==0){
            throw new NegativeArraySizeException();
        }
        T val = tail.val;
        if (size==1){ // head==tail
            head= null;
            tail = null;
        }else {
            Node temp = tail.prev;
            tail.prev = null;
            temp.next = null;
            tail = temp;
        }
        size--;
        return val;
    }
//    1 2 3 4
    public  void add(T val,int i){
        if(i>size || i<0) throw  new IllegalArgumentException();
        if (size==0 || i==0){
            addFirst(val);
        } else if (size==i) {
            addLast(val);
        }else{
            Node temp = head;
            for (int j=1;j<=i-1;j++){
                temp = temp.next;
            }
            Node newNode = new Node(val);
            Node nextNode = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            size++;
        }
    }
    //    1 2 3 4
    public T delete(int i){
        if(i>=size || i<0) throw  new IllegalArgumentException();
        if (size==0 || i==0){
            return deleteHead();
        } else if (i+1 == size) {
            return deleteTail();
        }else {
            Node temp = head;
            for (int j=1;j<=i-1;j++){
                temp = temp.next;
            }
            Node nextNode = temp.next.next;
            Node toBeDeleted = temp.next;
            toBeDeleted.prev = null;
            toBeDeleted.next = null;
            temp.next = nextNode;
            nextNode.prev = temp;
            size--;
            return toBeDeleted.val;

        }
    }
    public void sout(){
        for(Node temp = head; temp!=null;temp=temp.next){
            System.out.print(temp.val+" ");
        }
        System.out.println();
    }

    private class Node{
        T val;
        Node next;
        Node prev;

        Node(){}
        Node(T val){
           this.val = val;

        }
        Node(T val,Node next){
            this.val = val;
            this.next = next;
        }
        Node(T val,Node next,Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
class test{
    public static void main(String[] args) {
        var ll = new DoublyLinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addLast(5);
        ll.add(4,2);
        ll.add(7,4);
        ll.sout();
        System.out.println(ll.getSize());
        ll.deleteHead();
        ll.sout();
        ll.delete(2);
        ll.sout();
        System.out.println(ll.getSize());
    }
}
//3 2 4 1 5