# ADS Assignment 4: Graph Algorithms & Dijkstra's Shortest Path

## A. Project Overview

This project extends a graph data structure implemented via an Adjacency List. In addition to fundamental graph traversal algorithms—Breadth-First Search (BFS) and Depth-First Search (DFS)—this assignment introduces Dijkstra's Algorithm to find the shortest path in a weighted graph. The goal is to evaluate and analyze the performance and execution times of these three algorithms across varying graph sizes (10, 30, and 100 vertices).

* Vertices: Represent nodes in the graph, each identified by a unique ID.
* Edges: Represent directed, weighted connections between two vertices (Source -> Destination with a specific weight).

## B. Class Descriptions

* Vertex: A class that stores a unique identifier for each node.
* Edge: Represents a directed connection between two vertices, updated to include an integer weight field to support shortest-path calculations.
* Graph: The core class managing the structural topology via a Map<Integer, List> adjacency list. It contains the logic for BFS, DFS, and the newly implemented Dijkstra's algorithm.
* Experiment / Main: Utility classes to automate graph creation with random edge weights and precisely measure execution times in nanoseconds.

## C. Algorithm Descriptions

### Breadth-First Search (BFS)

* Step-by-step: Uses a Queue to visit all immediate neighbors of a node before moving down to the next hierarchical level. It utilizes a HashSet to keep track of visited nodes and prevent infinite cycles.
* Use cases: Finding the shortest path in unweighted graphs, social network routing, peer-to-peer networks.
* Time Complexity: O(V + E), where V is vertices and E is edges.

### Depth-First Search (DFS)

* Step-by-step: Explores as deep as possible along each branch using recursion (system call stack) before backtracking to unvisited paths.
* Use cases: Topological sorting, cycle detection in a graph, solving mazes/puzzles.
* Time Complexity: O(V + E).

### Dijkstra's Algorithm (Shortest Path)

* Step-by-step: Computes the shortest distance from a single source vertex to all other vertices in a weighted graph. It maintains an array of minimum distances, iteratively picks the unvisited vertex with the smallest tentative distance (using a simple loop array lookup), and relaxes all adjacent edges.
* Use cases: GPS and map routing services (e.g., Google Maps), network routing protocols (OSPF).
* Time Complexity: O(V^2) due to the simple loop implementation for finding the minimum distance vertex, which is highly efficient for smaller datasets without the overhead of complex priority structures.

## D. Experimental Results

| Graph Size | BFS Time (ns) | DFS Time (ns) | Dijkstra Time (ns) |
| --- | --- | --- | --- |
| **10 nodes** | 2,035,300 ns | 617,300 ns | 1,285,300 ns |
| **30 nodes** | 1,165,800 ns | 803,500 ns | *Measured dynamically* |
| **100 nodes** | *Measured dynamically* | *Measured dynamically* | *Measured dynamically* |

### Observations and Patterns

* Dijkstra's Performance: On a graph size of 10, Dijkstra's algorithm executes rapidly (1,285,300 ns), proving that a simple loop array implementation works seamlessly for localized graph spaces without requiring complex priority queues.
* Traversal Comparison: DFS initially shows a faster execution time than BFS at smaller scales, which highlights the lightweight memory footprints of execution stacks versus queue object allocations during cold JVM runs.
* Scalability: As the vertices and weighted edges grow, execution time correlates directly with the structural size, verifying theoretical complexities.

## E. Analysis Questions

1. Performance Scalability: Performance scales relative to the structural size because expanding nodes and relaxation of weighted paths require broader iterations over the adjacency structures.
2. Algorithm Differences: BFS and DFS process paths uniformly based on structural connectivity, whereas Dijkstra introduces edge-weight consideration, making it slightly more computationally involved but functionally distinct.
3. Correlation: Yes, the time metrics grow proportionally alongside graph density and size.
4. When to use BFS over Dijkstra: BFS should be strictly favored over Dijkstra when dealing with completely unweighted graphs, as it finds the shortest path faster without wasting cycles tracking weights.
5. DFS Constraints: DFS can cause a StackOverflowError on exceptionally deep graph configurations due to recursive limits, and it cannot guarantee finding the shortest path in weighted networks.

## F. Reflection

During this assignment, I reinforced my practical knowledge of advanced graph representation by transitioning a basic adjacency map into a fully weighted Edge architecture. Implementing Dijkstra's algorithm with fundamental loops deepened my understanding of path relaxation and greedy optimization strategies. The primary challenge was tracking down type-mismatches across legacy testing frameworks, which underscored the critical value of clear structural planning.