package Lesson_4_Linked_list.Generic;

import java.util.Iterator;
import java.util.function.Consumer;

// Методы в этом классе - получение эелемента и проверка наличия следующего элемента
public class LinkIterator implements Iterator {
    public Link current;
    private Link previous;
    private LinkedList linkedList;

    public LinkIterator(LinkedList linkedList) {
        this.linkedList = linkedList;
        this.reset();
    }

    public void reset(){
        current = linkedList.getFirst();
        previous = null;
    }

    @Override
    public boolean hasNext(){
        return current.getNext() != null;
    }

    @Override
    public Object next() {
        nextLink();
        return getCurrent();
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }

    private void nextLink(){
        previous = current;
        current = current.getNext();
    }

    private Link getCurrent(){
        return current;
    }

}
