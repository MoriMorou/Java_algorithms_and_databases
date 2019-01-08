package Lesson_3_Stack_And_Queue;

import java.util.Arrays;

public class Queue {

    private int[] queue;
    private int maxSize;
    private int start; // начало очереди
    private int end;   // конец очереди
    private int items; // элементы в очереде

    public Queue(int maxSize){
        queue = new int[maxSize];
        this.maxSize = maxSize;
        this.start = 0;
        this.end = -1;
        this.items = 0;
    }

    void insert(int i){
        if (end == maxSize -1) {
            end = -1;
        }
        queue[++end] = i;
        items++;
    }

    int remove() {
        int temp = queue[start++];
        if (start == maxSize){
            start = 0;
        }
        items--;
        return temp;
    }

    int peek(){
        return queue[start];
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == maxSize;
    }

    public int size(){
        return items;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < queue.length; i++) {
            if(i == start) {
                stringBuilder.append("{")
                        .append(queue[i])
                        .append("}")
                        .append(" ");
            } else if (i == end) {
                stringBuilder.append("[")
                        .append(queue[i])
                        .append("]")
                        .append(" ");
            } else {
                stringBuilder.append(queue[i])
                        .append(" ");
            }
        }
        return stringBuilder.toString();
//        return "Queue{" +
//                "queue=" + Arrays.toString(queue) +
//                ", maxSize=" + maxSize +
//                ", start=" + start +
//                ", end=" + end +
//                ", items=" + items +
//                '}';
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.insert(81);
        System.out.println(queue);
        queue.insert(20);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.insert(33);
        System.out.println(queue);
    }
}
