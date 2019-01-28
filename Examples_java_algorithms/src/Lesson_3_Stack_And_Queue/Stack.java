package Lesson_3_Stack_And_Queue;

import java.util.Arrays;

public class Stack {

    private int maxSize;
    private int[] stack;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stack = new int[this.maxSize];
        this.top = -1;
    }

    void push(int value) {
        stack[++top] = value;
    }

    int pop() {
        int i = stack[top--];
        System.out.println("After pop\n" + this.toString());
        return i;
    }

    @Override
    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < stack.length; i++) {
//            stringBuilder.append(stack[i]).append(" ");
//        }
//        return stringBuilder.toString();
        return "Stack{" +
                "maxSize=" + maxSize +
                ", stack=" + Arrays.toString(stack) +
                ", top=" + (top + 1) +
                '}';
    }

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(1);
        System.out.println(stack);
        stack.push(23);
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack);
        stack.push(8);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.push(99);
        System.out.println("New element " + stack);
//        stack.push(66); а тут уже переполнение стека
    }
}
