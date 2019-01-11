package Ex_1;

// 1. Написать программу по возведению числа в степень с помощью рекурсии.

// взяла не все варианты возведения в степень

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input a number and an integer power");
        Scanner in = new Scanner(System.in);
        double number = in.nextDouble();
        int n = in.nextInt();
        Exponentiation ex = new Exponentiation();
        System.out.println(ex.exponentiation(number, n));
    }
}
