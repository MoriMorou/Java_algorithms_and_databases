package Generic;

public class Generic {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.insert("Hello");
        list.insert("All");
        list.insert("My Friends!");
        LinkIterator iterator = new LinkIterator(list);
        while (iterator.hasNext()){
            Link<String> link = (Link<String>) iterator.next();
            link.getValue();
            System.out.println(link);
        }
    }
}
