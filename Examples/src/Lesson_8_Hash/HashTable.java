package Lesson_8_Hash;

public class HashTable {

    int hashFunc(String s) {
        return s.length();
    }

    //сравниваем дваслов и проверяем длину и содержание
    boolean isEquals(String s1, String s2) {
        if (s1.length() == s2.length()) {
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
        System.out.println(ht.hashFunc("test1"));
        System.out.println(ht.hashFunc("test2"));
        System.out.println(ht.hashFunc("test3"));
        System.out.println(ht.hashFunc("test4"));
        System.out.println(ht.hashFunc("test5"));
        System.out.println(ht.isEquals("test1", "test2"));
        System.out.println(ht.isEquals("test1", "test123"));
    }
}


