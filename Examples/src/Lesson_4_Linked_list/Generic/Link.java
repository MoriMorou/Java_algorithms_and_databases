package Lesson_4_Linked_list.Generic;

public class Link<T> {
    private T link;
    private Link<T> next;

    public Link(T link) {
        this.link = link;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getValue() {
        return link;
    }

    @Override
    public String toString() {
        return "Link{" +
                "link=" + link +
                '}';
    }
}
