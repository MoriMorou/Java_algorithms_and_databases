package Lesson_7_Graph;

public class Stack {

    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    public void push(int value) {
        stackArray[++top] = value;
    }

    public int pop() {
        return stackArray[top--];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public int peek(){
        return stackArray[top];
    }
}
