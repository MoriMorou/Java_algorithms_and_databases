package Lesson_1.Ex_1_Klassenstrukrur;

public class Ex_1_Klassenstruktur {

    public static void main(String[] args) {
        A a = new A();
        testA(a);
        System.out.println(a);

        int a1 = 2;
        testB(a1);
        System.out.println(a1);

    }

    public static void testA(A a){
        a.updateT(1);
    }

    public static void testB(int i){
        i = 5;
    }
}

class A{
    private int t;

    //конструктор
    public A() {
    }


    public void updateT(int num) {
        t = num;
    }

    @Override
    public String toString() {
        return "Test{" +
                "t = " + t +
//                ", a = " + a +
                "}";
    }
}
