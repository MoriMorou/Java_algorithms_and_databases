package Lesson_7_Graph;

public class Graph {

    private static final int MAX_VERTEX = 32;
    private Vertex[] verticesList;
    private int[][] adjMatrix;
    private int counter;


    public Graph() {
        verticesList = new Vertex[MAX_VERTEX];
        counter = 0;
        adjMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX ; j++) {
                adjMatrix[i][i] = 0;
            }

        }
    }

    // добавляем вершину
    void addVertex(String label) {
        verticesList[counter++] = new Vertex(label);
    }

    // добавляем ребро
    void addEdge(int city1, int city2) {
        adjMatrix[city1][city1] = 1;
        adjMatrix[city2][city1] = 1;
    }

    void displayVertex(int vertex){
        System.out.println(verticesList[vertex]);
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

    public Vertex(String abel) {
        this.label = label;
        this.wasVisited = false;
    }

}