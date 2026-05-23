import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(new Edge(from, to, weight));
        }
    }

    public void printGraph() {
        for (int v : adjList.keySet()) {
            System.out.println(v + ": " + adjList.get(v));
        }
    }

    public void dijkstra(int start) {
        int verticesCount = adjList.size();
        int[] distances = new int[verticesCount];
        boolean[] visited = new boolean[verticesCount];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < verticesCount - 1; i++) {
            int minVertex = findMinimumVertex(distances, visited);
            if (minVertex == -1) break;

            visited[minVertex] = true;

            List<Edge> edges = adjList.getOrDefault(minVertex, new ArrayList<>());
            for (Edge edge : edges) {
                int neighbor = edge.getDestination();
                if (!visited[neighbor]) {
                    int newDist = distances[minVertex] + edge.getWeight();
                    if (distances[minVertex] != Integer.MAX_VALUE && newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                    }
                }
            }
        }

        printDijkstraResults(start, distances);
    }

    private int findMinimumVertex(int[] distances, boolean[] visited) {
        int minVertex = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

    private void printDijkstraResults(int start, int[] distances) {
        System.out.println("Dijkstra Shortest Paths from node " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.print("  Node " + i + " -> ");
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("Distance: Unreachable");
            } else {
                System.out.println("Distance: " + distances[i]);
            }
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            List<Edge> edges = adjList.getOrDefault(v, new ArrayList<>());
            for (Edge edge : edges) {
                int neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");
        List<Edge> edges = adjList.getOrDefault(v, new ArrayList<>());
        for (Edge edge : edges) {
            int neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
}