import java.util.Random;

public class Experiment {
    public void runTraversals(Graph g) {
        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();
        System.out.println("BFS Execution Time: " + (endBfs - startBfs) + " ns");

        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();
        System.out.println("DFS Execution Time: " + (endDfs - startDfs) + " ns");

        long startDijkstra = System.nanoTime();
        g.dijkstra(0);
        long endDijkstra = System.nanoTime();
        System.out.println("Dijkstra Execution Time: " + (endDijkstra - startDijkstra) + " ns");
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            System.out.println("Graph size: " + size);
            Graph g = createGraph(size);
            runTraversals(g);
            System.out.println("-------------------");
        }
    }

    private Graph createGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }
        Random rand = new Random();
        for (int i = 0; i < size * 1.5; i++) {
            int randomWeight = rand.nextInt(20) + 1;
            g.addEdge(rand.nextInt(size), rand.nextInt(size), randomWeight);
        }
        return g;
    }

    public void printResults() {
    }
}