package Lesson_3_Stack_And_Queue;

public class Deck {
/**
 * Deck (дек) - это двойная очередь, то есть и начало и конец очереди с двух концов
 * InsertLeft
 * InsertRight
 * RemoveLeft
 * RemoveRight
 */

private int[] deck;
    private int maxSize;
    private int start; // начало очереди
    private int end;   // конец очереди
    private int items; // элементы в очереде

    public Deck(int maxSize){
        deck = new int[maxSize];
        this.maxSize = maxSize;
        this.start = 0;
        this.end = -1;
        this.items = 0;
    }

    void insert(int i){
        if (end == maxSize -1) {
            end = -1;
        }
        deck[++end] = i;
        items++;
    }

    int remove() {
        int temp = deck[start++];
        if (start == maxSize){
            start = 0;
        }
        items--;
        return temp;
    }

    int peek(){
        return deck[start];
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
        for (int i = 0; i < deck.length; i++) {
            if(i == start) {
                stringBuilder.append("{")
                        .append(deck[i])
                        .append("}")
                        .append(" ");
            } else if (i == end) {
                stringBuilder.append("[")
                        .append(deck[i])
                        .append("]")
                        .append(" ");
            } else {
                stringBuilder.append(deck[i])
                        .append(" ");
            }
        }
        return stringBuilder.toString();
//        return "Queue{" +
//                "deck=" + Arrays.toString(deck) +
//                ", maxSize=" + maxSize +
//                ", start=" + start +
//                ", end=" + end +
//                ", items=" + items +
//                '}';
    }

    public static void main(String[] args) {
        Deck deck = new Deck(5);
        deck.insert(81);
        System.out.println(deck);
        deck.insert(20);
        System.out.println(deck);
        deck.remove();
        System.out.println(deck);
        deck.insert(33);
        System.out.println(deck);
    }
}



