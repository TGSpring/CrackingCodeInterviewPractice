/**
 * Tyler Spring
 * 11/20/2024
 * Chapter 4 Question 4.7
 * Kahns build Order.
 */

import java.util.*;

public class buildOrderKahns {

    public static List<String> findBuildOrder(List<String> projects, List<String[]> dependencies) {
        //Initialize graph and in-degree map.
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (String project : projects) {
            graph.put(project, new ArrayList<>());
            inDegree.put(project, 0);
         }

         //Build the graph and update in-degrees
         for (String[] dependency : dependencies) {
            String pre = dependency[0];
            String post = dependency[1];
            graph.get(pre).add(post);
            inDegree.put(post,inDegree.get(post) + 1);
         }

         //Initialize queue with projects that have in-degree 0.
         Queue<String> queue = new LinkedList<>();
         for (String project : inDegree.keySet()) {
            if (inDegree.get(project) == 0) {
                queue.add(project);
            }
         }

         List<String> buildOrder = new ArrayList<>();

         //Process nodes with in-degree 0
         while(!queue.isEmpty()) {
            String project = queue.poll();
            buildOrder.add(project);

            //Decrease in-degree of neighbors.
            for (String neighbor : graph.get(project)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                queue.add(neighbor);
            }
         }
    }

    //Check for cycles
    if(buildOrder.size() != projects.size()) {
        return null; //Cycle detected.
    }


    return buildOrder;


}
public static void main(String[] args) {
    List<String> projects = Arrays.asList("a", "b", "c", "d", "e", "f");
    List<String[]> dependencies = Arrays.asList(
            new String[]{"a", "d"},
            new String[]{"f", "b"},
            new String[]{"b", "d"},
            new String[]{"f", "a"},
            new String[]{"d", "c"}
    );

    List<String> buildOrder = findBuildOrder(projects, dependencies);

    if (buildOrder == null) {
        System.out.println("Error: No valid build order exists.");
    } else {
        System.out.println("Build Order: " + buildOrder);
    }
}
}
/**
 * Explanation:
 * Graph Representation:
 * Use an adjacency list to represent the graph where nodes are projects, and edges 
 * represent dependencies.
 * 
 * Initialization:
 * Populate the graph and in-degree map.
 * Add all projects with inDegree of 0 to the queue (these have no dependencies.)
 * 
 * Processing:
 * While the queue is not empty:
 *      Remove a project from the queue
 *      Add it to the build order.
 *      For each neighbor (dependent project), reduce its in-degree by 1.
 *      If a neighbor's in-degree becomes 0, add it to the queue.
 * 
 * Cycle Detection:
 * After processing all nodes, if the size of the build order is less than the number 
 * of projects, a cycle exists, and no valid build order is possible.
 */