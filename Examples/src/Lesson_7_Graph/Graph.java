package Lesson_7_Graph;

/**
 * Обход в гдубину (Посетить вершину >> Занести вершину в стек >> Отметить вершину, как посещенную >>
 * Переход к смежной вершине)
 *
 *
 *
 */


public class Graph {

    private static final int MAX_VERTEX = 32;
    private Vertex[] vertexList;
    private int[][] adjMatrix; // матрица смежности
    private int counter;
    private Stack stack;


    public Graph() {
        vertexList = new Vertex[MAX_VERTEX];
        counter = 0;
        adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX ; j++) {
                adjMatrix[i][i] = 0;
            }
        }
    }

    // в глубину
    void findInDeep(){
        vertexList[0].updateStatus();
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int peak = getAdjUnvisitedVertex(stack.peek());
            if (peak == -1) {
                stack.pop();
            }
        }
    }

    private int getAdjUnvisitedVertex(int peek) {
        for (int i = 0; i < counter; i++) {
            if ( adjMatrix[peek][i] == 1 && vertexList[i].wasVisited() == false) {
                return i;
            }
        }
        return -1;
    }


    // добавляем вершину
    void addVertex(String label) {
        vertexList[counter++] = new Vertex(label);
    }

    // добавляем ребро
    void addEdge(int city1, int city2) {
        adjMatrix[city1][city1] = 1;
        adjMatrix[city2][city1] = 1;
    }

    void displayVertex(int vertex){
        System.out.println(vertexList[vertex]);
    }

    void displayAll() {
        for (int i = 0; i <MAX_VERTEX ; i++) {
            displayVertex(i);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("MSK");
        graph.addVertex("SPB");
        graph.addVertex("NSK");
        graph.addVertex("EKB");
        graph.displayAll();
    }

}

// вершина
class Vertex {
    public String label;
    public boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
    }

    void updateStatus(){
        wasVisited = true;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                ", wasVisited=" + wasVisited +
                '}';
    }

    public boolean wasVisited() {
        return wasVisited;
    }
}