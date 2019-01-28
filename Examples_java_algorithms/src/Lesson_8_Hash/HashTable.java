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

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        System.out.println(ht.isEquals("мама мыла раму", "мама мыла раму"));
        System.out.println(ht.isEquals("мама мыла раму", "раму мыла мама"));

        SomeObj obj1 = new SomeObj(1, "name1");
        SomeObj obj2 = new SomeObj(1, "name2");
        List<LinkedList<SomeObj>> array = new ArrayList<>(1000); //list стосящий из LinkedList
        // заполняем List пустыми LikedList (то есть лист состоит из связанных листов)
        for (int i = 0; i < 1000 ; i++) {
            array.add(new LinkedList<>());
        }
        int index1 = hashFunc(obj1.getName());
        int index2 = hashFunc(obj2.getName());
        array.get(index1).push(obj1);
        array.get(index1).push(obj2);

    }
}


