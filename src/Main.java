import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 30, 100};
        Random random = new Random();

        for (int size : sizes) {
            Graph g = new Graph();
            for (int i = 0; i < size; i++) {
                g.addVertex(new Vertex(i));
            }

            for (int i = 0; i < size - 1; i++) {
                int randomWeight = random.nextInt(20) + 1;
                g.addEdge(i, i + 1, randomWeight);
            }

            System.out.println("=====================================");
            System.out.println("Graph Size: " + size);
            System.out.println("=====================================");

            long startBfs = System.nanoTime();
            if (size == 10) System.out.print("BFS Traversal Order: ");
            g.bfs(0);
            long endBfs = System.nanoTime();
            System.out.println("BFS Time: " + (endBfs - startBfs) + " ns\n");

            long startDfs = System.nanoTime();
            if (size == 10) System.out.print("DFS Traversal Order: ");
            g.dfs(0);
            long endDfs = System.nanoTime();
            System.out.println("DFS Time: " + (endDfs - startDfs) + " ns\n");

            long startDijkstra = System.nanoTime();
            g.dijkstra(0);
            long endDijkstra = System.nanoTime();
            System.out.println("Dijkstra Execution Time: " + (endDijkstra - startDijkstra) + " ns");
            System.out.println();
        }
    }
}