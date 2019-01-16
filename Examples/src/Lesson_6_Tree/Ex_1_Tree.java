package Lesson_6_Tree;

public class Ex_1_Tree {

    private Node root;

    Node find(int id) {
        Node current = root;
        while (current.person.id != 0) {
//            if(id < current.person.id) {
//                current = current.leftChild;
//            } else {
//                current = current.rightChild;
//            }
            // упростили
            current = (id > current.person.id) ? current.leftChild : current.rightChild;

            if (current == null) {
                return null;
            }
        }
        return null;
    }

    void insert(Person person) {
        Node node = new Node();
        node.person = person;
        if (root == null){
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true)
        }
    }

    boolean delete (int id) {
        return false;
    }

    void displayTree(){

    }
}

// узел
class Node {

    Person person;
    Node leftChild;
    Node rightChild;

    @Override
    public String toString() {
        return person.id + " " + person.name + " " + person.age;
    }
}

class Person {

    String name;
    int age;
    int id;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    static Person getNewPerson(){
        return new Person("Olga", 99, 1);
    }

}