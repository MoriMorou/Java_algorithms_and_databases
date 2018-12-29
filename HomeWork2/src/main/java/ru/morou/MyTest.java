package ru.morou;

public class MyTest {
    public static void main(String[] args) {

        String s = "My home work";

        System.out.println(stringRevers(s));

    }

    public static String stringRevers(String str) {

        MyArrayStack<Character> mas = new MyArrayStack<Character>();

        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            mas.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            sb.append(mas.pop());
        }

        return sb.toString();
    }
}
