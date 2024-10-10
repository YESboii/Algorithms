package stack;

public class Stack {
    private int top;
    private int []data;
    private int size;
    private static final int DEFAULT_SIZE = 16;

    public Stack(){
        this(DEFAULT_SIZE);
    }
    public Stack(int defaultSize){
        top = -1;
        data = new int[defaultSize];
    }
    public boolean isEmpty(){
        return size==0; //top==-1;
    }
    public void push(int e){
        if(size==data.length){ // stack is full(top==data.length-1)
            resize();
        }
        data[++top] = e;
        size++;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("UnderFlow");
        }
        return data[top];
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("UnderFlow");
        }
        size--;
        return data[top--];
    }
    public int size(){
        return size;//return top + 1;
    }
    private void resize(){
        int []temp = new int[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }
}
