package Lesson_7_Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Обход в гдубину (Посетить вершину >> Занести вершину в стек >> Отметить вершину, как посещенную >>
 * Переход к смежной вершине)
 */


public class Graph {

    private static final int MAX_VERTEX = 32;
    private Vertex[] vertexList;
    private int[][] adjMatrix; // матрица смежности
    private int counter;
    private Stack stack;
    private Queue<Integer> queue;


    private Graph() {
        stack = new Stack(MAX_VERTEX);
        queue = new ArrayDeque<>();
        vertexList = new Vertex[MAX_VERTEX];
        counter = 0;
        adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX ; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    // в глубину
    private void findInDeep(){
        vertexList[0].updateStatus();
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int peak = getAdjUnvisitedVertex(stack.peek());
            if (peak == -1) {
                stack.pop();
            } else {
                vertexList[peak].updateStatus();
                displayVertex(peak);
                stack.push(peak);
            }
        }
        resetFlags();
    }

    private void resetFlags() {
        for (int i = 0; i < counter ; i++) {
            vertexList[i].clearStatus();
        }
    }

    private void findWithQueue(){
        vertexList[0].updateStatus();
        displayVertex(0);
        queue.add(0); // поставили в конец очереди текущую вершину
        int peak2;
        while (!queue.isEmpty()) {
            int peak1 = queue.remove();
            while ((peak2 = getAdjUnvisitedVertex(peak1)) != -1) {
                vertexList[peak2].updateStatus();
                displayVertex(peak2);
                queue.add(peak2);
            }
        }
        resetFlags();
    }

    private int getAdjUnvisitedVertex(int peek) {
        for (int i = 0; i < counter; i++) {
            if (adjMatrix[peek][i] == 1 && vertexList[i].wasUnvisited()) {
                return i;
            }
        }
        return -1;
    }


    // добавляем вершину
    private void addVertex(String label) {
        vertexList[counter++] = new Vertex(label);
    }

    // добавляем ребро
    private void addEdge(int city1, int city2) {
        adjMatrix[city1][city2] = 1;
        adjMatrix[city2][city1] = 1;
    }

    private void displayVertex(int vertex){
        System.out.println(vertexList[vertex]);
    }

    private void displayAll() {
        for (int i = 0; i <MAX_VERTEX ; i++) {
            displayVertex(i);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("MSC");
        graph.addVertex("SPB");
        graph.addVertex("NSK");
        graph.addVertex("EKB");
        graph.displayAll();
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        System.out.println("+++++ findInDeep +++++");
        graph.findInDeep();
        System.out.println("+++++ findWithQueue +++++");
        graph.findWithQueue();
    }
}

// вершина (в нашем случае это города)
class Vertex {
    private String label;
    private boolean wasUnvisited;

    Vertex(String label) {
        this.label = label;
        this.wasUnvisited = false;
    }

    void updateStatus(){
        wasUnvisited = true;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                ", wasUnvisited=" + wasUnvisited +
                '}';
    }

    boolean wasUnvisited() {
        return wasUnvisited;
    }

    void clearStatus() {
        wasUnvisited = false;
    }
}