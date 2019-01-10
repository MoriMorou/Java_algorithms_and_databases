package Generic;

public class Generic {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.insert("Hello");
        list.insert("All");
        list.insert("My Friends!");
        LinkIterator iterator = new LinkIterator(list);
        Link<String> link = (Link<String>)iterator.current;
        System.out.println(link.getValue());
        while (iterator.hasNext()){
            link = (Link<String>) iterator.next();
            System.out.println(link.getValue());
        }
    }
}
