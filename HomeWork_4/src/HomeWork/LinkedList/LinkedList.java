package HomeWork.LinkedList;

public class LinkedList {

    private Link head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insert(String name, int age) {
        Link newLink = new Link(name, age);
        newLink.next = head; //null
        head = newLink;
    }

    public Link delete() {
        Link temp = head;
        head = head.next;
        return temp;

    }

    public void display() {
        Link current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    //for iterator
    public void setHead(Link head) {
        this.head = head;
    }

    public Link getHead() {
        return head;
    }
}
