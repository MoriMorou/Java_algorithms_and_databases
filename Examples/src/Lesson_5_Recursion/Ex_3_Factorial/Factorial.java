package Lesson_5_Recursion.Ex_3_Factorial;

public class Factorial {

    public static void main(String[] args) {
        FactorialCal.factorial(Integer.MAX_VALUE);
    }
}

class FactorialCal {

    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
