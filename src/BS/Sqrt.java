package BS;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(120));
    }
    public static int mySqrt(int x) {
        if(x<=1) return x;
        int s = 0, e = x/2;
        while (s<=e){
            long mid = s + (e - s)/2;
            if(mid * mid <= x){
                s = ((int)mid) + 1;
            }
            else{
                e = ((int)mid) - 1;
            }
        }
        return e;
    }
}

