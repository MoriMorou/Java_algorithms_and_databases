package Lesson_8_Hash;

import java.util.*;

public class HashTable {

    static int hashFunc(String s) {
        char[] chars = s.toCharArray();
        int out = -1;
        for (char aChar : chars) {
            out = out + (int) aChar;
        }
        return out;
    }

    //сравниваем два слова и проверяем длину и содержание
    boolean isEquals(String s1, String s2) {
        if (hashFunc(s1) == hashFunc(s2)) {
                char[] charS1 = s1.toCharArray();
                char[] charS2 = s2.toCharArray();
            for (int i = 0; i <s1.length() ; i++) {
                if(charS1[i] != charS2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // расчет индекса на основе hash
    static int indexForHashTable(int hash, int length){
        return hash & (length - 1);
    }

    public static void main(String[] args) {
//        HashTable ht = new HashTable();
//        System.out.println(ht.isEquals("мама мыла раму", "мама мыла раму"));
//        System.out.println(ht.isEquals("мама мыла раму", "раму мыла мама"));

        Pair p1 = new Pair(1, "hello");
        Pair p2 = new Pair(1, "hi");
        List l = new LinkedList();
        l.add(p1);
        l.add(p2);

    }
}


