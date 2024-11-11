import java.util.*;

public class Test {
    public static long getDataDependenceSum(long n) {
        Set<Long> uniqueDays = new HashSet<>();

        long k = 1;
        while (k * k <= n) {
            long x = n / k;
            uniqueDays.add(x);
            k++;
        }

        for (long i = 1; i <= n / k; i++) {
            uniqueDays.add(i);
        }

        long sum = 0;
        for (long day : uniqueDays) {
            sum += day;
        }

        return sum;
    }


    public static void main(String[] args) {
        long n = 1;  // Example value
        System.out.println("Data dependence sum for n = " + n + " is: " + getDataDependenceSum(n));
    }
}
