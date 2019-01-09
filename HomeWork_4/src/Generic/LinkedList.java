package Generic;

import java.util.List;

public class LinkedList<T> {
    private Link<T> head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T link) {
        Link<T> temp = new Link<>(link);
        temp.setNext(head);
        this.head = temp;
    }

    public Link<T> delete() {
        Link<T> temp = head;
        head = head.getNext();
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Link<T> temp = head;
        while (temp != null) {
            stringBuilder.append(temp.getValue()).append("\n");
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }

    public Link getFirst() {
        return head;
    }

    public void setFirst(Link link) {
        this.head = link;
    }
}

