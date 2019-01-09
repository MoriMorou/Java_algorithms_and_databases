package Lesson_4_Linked_list.Generic;

public class Generic {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.insert("Hello");
        list.insert("All");
        list.insert("My Friends!");
        LinkIterator iterator = new LinkIterator(list);
        for (LinkIterator linkIterator = iterator; linkIterator.hasNext();) {
            Link<String> link = (Link<String>) linkIterator.next();
            System.out.println(link);
        }
    }
}
