import java.util.*;

class Test {


    public static void main(String[] args) {
        C c = new C();
        c.f1(1, 2.0);
    }
}
class C{
    void f1(int a, double b){}
    void f1(double b, int a){}
}

