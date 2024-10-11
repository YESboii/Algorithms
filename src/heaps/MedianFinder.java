package heaps;
//https://leetcode.com/problems/find-median-from-data-stream/
class MedianFinder {
    //this is the first follow-up.
    private int[] count;
    private int totalCount;

    public MedianFinder() {
        count = new int[101]; // Array to hold counts for each number from 0 to 100
        totalCount = 0;
    }

    public void addNum(int num) {
        count[num]++;       // Increment the count for the number
        totalCount++;       // Increment the total count of numbers
    }

    public double findMedian() {
        int mid = totalCount / 2;
        int sum = 0;

        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if (sum > mid) {
                if (totalCount % 2 == 1) {
                    return i; // If odd, return the middle value
                } else {
                    // If even, we need the average of two middle values
                    // Find the next non-zero count
                    int nextValue = i;
                    while (nextValue < count.length && count[nextValue] == 0) {
                        nextValue++;
                    }
                    return (i + nextValue) / 2.0; // Average of two middle values
                }
            }
        }
        return 0; // Fallback (shouldn't reach here)
    }
}
