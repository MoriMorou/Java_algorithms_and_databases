package Lesson_7_Graph;

class Stack {

    private int maxSize;
    private int[] stackArray;
    private int top;

    Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    void push(int value) {
        stackArray[++top] = value;
    }

    void pop() {
        top--;
    }

    boolean isEmpty(){
        return (top == -1);
    }

    int peek(){
        return stackArray[top];
    }
}
