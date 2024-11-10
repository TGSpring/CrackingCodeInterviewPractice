/**
 * Tyler Spring
 * 11/10/2024
 * Chapter 4 Question 4.1
 * Route between nodes
 */

import java.util.*;

public class Q4_1 {

    static class Graph {
        private Map<Integer, List<Integer>> adjacencyList;

        public Graph() {
            adjacencyList = new HashMap<>();
        }

        // Adds an edge from 'source' to 'destination'.
        public void addEdge(int source, int destination) {
            adjacencyList.putIfAbsent(source, new ArrayList<>());
            adjacencyList.get(source).add(destination);
        }

        // BFS method to check for a route between 'start' and 'end'.
        public boolean hasRouteBFS(int start, int end) {
            if (start == end) return true;

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            queue.add(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                int current = queue.poll();

                // Explore each neighbor of the current node.
                List<Integer> neighbors = adjacencyList.getOrDefault(current, new ArrayList<>());
                for (int neighbor : neighbors) {
                    if (neighbor == end) {
                        return true; // Route found
                    }

                    // Add unvisited neighbors to the queue.
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            return false;
        }

        // DFS method to check for a route between 'start' and 'end'.
        public boolean hasRouteDFS(int start, int end) {
            Set<Integer> visited = new HashSet<>();
            return dfsHelper(start, end, visited);
        }

        private boolean dfsHelper(int current, int end, Set<Integer> visited) {
            if (current == end) return true;

            visited.add(current);

            // Traverse all neighbors
            List<Integer> neighbors = adjacencyList.getOrDefault(current, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    if (dfsHelper(neighbor, end, visited)) {
                        return true; // Route found
                    }
                }
            }

            return false; // Route not found
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        int start = 1, end = 3;

        System.out.println("Route from " + start + " to " + end + " (BFS): " + graph.hasRouteBFS(start, end));
        System.out.println("Route from " + start + " to " + end + " (DFS): " + graph.hasRouteDFS(start, end));
    }
}
/**
 * Explanation:
 * Graph Creation: We use an adjacencyList (a Map<Integer>, List<Integer>) to 
 * represent the directed graph.
 * 
 * Adding Edges: addEdge method allows you to add directed edges between nodes.
 * 
 * BFS: The hasRouteBFS method uses a queue to explore each node's neighbors level-by-level
 * until it finds the target node or exhausts all possibilities.
 * 
 * DFS: The hasRoutesDFS method uses recursion to explore each path deeply until 
 * it finds the target nodes or completes all paths.
 * 
 * 
 * Complexity:
 * Both BFS and DFS have a time complexity of O(V + E), where V is the number of nodes 
 * and E is the number of edges in the graph.
 */