package HomeWork.TwoLikedList;

public class LinkedList {

    public Link head;
    public Link last;

    public LinkedList() {
        head = null;
        last = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void display() {
        Link current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public void insert(String name, int age) {
        Link newLink = new Link(name, age);
        if (this.isEmpty()) last = newLink;
        newLink.next = head;
        head = newLink;
    }

    public void insertLast(String name, int age) {
        Link newLink = new Link(name, age);
        if (this.isEmpty()) head = newLink;
        else last.next = newLink;
        last = newLink;
    }

    public Link delete() {
        Link temp = head;
        if (head.next == null) last = null;
        head = head.next;
        return temp;
    }

    public Link delete(String name, int age) {
        System.out.println("Привет, мир!");
        return null;
    }

    public Link delete(String name) {
        Link current = head;
        Link previous = head;
        while (!current.name.equals(name)) {
            if (current.next == null) return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else previous.next = current.next;
        {
            return current;
        }
    }

    public Link find(String name) {
        Link current = head;
        while (!current.name.equals(name)) {
            if (current.next == null) return null;
            else current = current.next;
        }
        return current;
    }
}