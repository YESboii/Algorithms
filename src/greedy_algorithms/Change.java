package greedy_algorithms;

public class Change {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,5,5,20,20,5,5,5,5}));
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, tens = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                five--;
                tens++;
            } else if (tens > 0) {
                tens--;
                five--;
            } else
                five -= 3;
            if (five < 0)
                return false;
        }
        return true;
    }
    }

