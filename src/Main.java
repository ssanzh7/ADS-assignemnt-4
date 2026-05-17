public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            Graph g = new Graph();
            for (int i = 0; i < size; i++) {
                g.addVertex(new Vertex(i));
            }

            for (int i = 0; i < size - 1; i++) {
                g.addEdge(i, i + 1);
            }

            System.out.println("Graph Size: " + size);

            if (size == 10) {
                System.out.print("BFS Traversal Order: ");
                long startBfs = System.nanoTime();
                g.bfs(0);
                long endBfs = System.nanoTime();
                System.out.println("BFS Time: " + (endBfs - startBfs) + " ns");

                System.out.print("DFS Traversal Order: ");
                long startDfs = System.nanoTime();
                g.dfs(0);
                long endDfs = System.nanoTime();
                System.out.println("DFS Time: " + (endDfs - startDfs) + " ns");
            } else {
                long startBfs = System.nanoTime();
                g.bfs(0);
                long endBfs = System.nanoTime();
                System.out.println("BFS Execution Time: " + (endBfs - startBfs) + " ns");

                long startDfs = System.nanoTime();
                g.dfs(0);
                long endDfs = System.nanoTime();
                System.out.println("DFS Execution Time: " + (endDfs - startDfs) + " ns");
            }
            System.out.println();
        }
    }
}