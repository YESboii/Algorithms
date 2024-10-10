package heaps;

import java.util.Arrays;

// add, remove, heapify, size, extractMin,
public class MinHeap {
    private int[] data;
    private int size;

    public MinHeap(int []arr){
        size = arr.length;
        data = Arrays.copyOf(arr, size * 2);
        buildHeap();
    }
    public int size(){
        return size;
    }
    public int extractMin(){
        return data[0];
    }
    public void add(int e){
        if(size == data.length) data = Arrays.copyOf(data, size * 2);
        data[size] = e;
        int i = size;
        size++;
        while (i > 0){
            int parent = (i - 1) / 2;
            if(data[i] < data[parent]){
                swap(data, parent, i);
                i = parent;
            }else break;
        }
    }
    public int remove(){
        if (size == 0) return Integer.MIN_VALUE;
        int e = data[0];
        data[0] = data[size - 1];
        size--;
        heapify(data, size, 0);
        return e;
    }
    private void buildHeap(){
        for (int i = size/2 - 1;i >= 0; i--){
            heapify(data, size, i);
        }
    }
    private void heapify(int []data, int n, int i){
        int minimum = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && data[left] < data[minimum]){
            minimum = left;
        }
        if(right < n && data[right] < data[minimum]){
            minimum = right;
        }
        if(minimum != i){
            swap(data, i, minimum);
            heapify(data, n, minimum);
        }
    }

    private void swap(int []a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void print(){
        for (int i = 0;i < size;i++){
            System.out.print(data[i] + " ");
        }
    }
}
class Test{
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(new int[]{4,10,3,5,1});
        minHeap.remove();
        minHeap.add(2);
        minHeap.print();
    }
}