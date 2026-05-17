import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(to);
        }
    }

    public void printGraph() {
        for (int v : adjList.keySet()) {
            System.out.println(v + ": " + adjList.get(v));
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
            List<Integer> neighbors = adjList.getOrDefault(v, new ArrayList<>());
            for (int neighbor : neighbors) {
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
        List<Integer> neighbors = adjList.getOrDefault(v, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
}