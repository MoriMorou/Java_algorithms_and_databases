//package Lesson_5_Recursion.Ex_4_Anagram;
//
//public class Main {
//
//
//    public static void main(String[] args) {
//        String s = "dog";
//        size = s.length();
//
//
//
//    }
//
//}
//
//
//class Anagram {
//
//    public char[] chars = new char[3];
//    public int size;
//    public int count;
//
//    private void creatAnagram(int newSize) {
//        if (newSize == 1) {
//            return;
//        }
//        for (int i = 0; i < newSize ; i++) {
//            creatAnagram(newSize - 1);
//            if (newSize == 2){
//                display();
//            }
//            rotate(newSize);
//        }
//    }
//
//    private void rotate(int newSize) {
//        int i;
//        int pos = size - newSize;
//        char temp = chars[pos];
//        for (i = pos + 1; i < size; i++) {
//            chars
//        }
//    }
//
//
//    private void display() {
//        System.out.println(String.valueOf(chars));
//    }
//
//}
