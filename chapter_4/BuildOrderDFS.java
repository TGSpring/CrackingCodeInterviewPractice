/**
 * Tyler Spring
 * 11/20/2024
 * Chapter 4 Question 4.7
 * Topological Sort Using DFS
 */
import java.util.*;
public class BuildOrderDFS {

    public static List<String> findBuildOrder(List<String> projects, List<String[]> dependencies){
        //Create a graph from the projects and dependencies.
        Map<String, List<String>> graph = new HashMap<>();
        for (String project : projects) {
            graph.put(project, new ArrayList<>());
        }
        for (String[] dependency: dependencies) {
            String pre = dependency[0], post = dependency[1];
            graph.get(pre).add(post);
        }

        //Maintain visited status: "unvisited", "visited", "visiting"
        Map<String, String> status = new HashMap<>();
        for (String project : projects) {
            status.put(project, "unvisited");
        }

        Stack<String> buildOrder = new Stack<>();
        for(String project : projects) {
            if (status.get(project).equals("unvisited")) {
                if (!dfs(project, graph, status, buildOrder)) {
                    return null; //Cycle detected.
                }
            }
        }

        //Return build order in reverse stack order.
        List<String> result = new ArrayList<>();
        while (!buildOrder.isEmpty()) {
            result.add(buildOrder.pop());
        }
        return result;
        }


        private static boolean dfs(String project, Map<String, List<String>> graph, Map<String, String> status, Stack<String> buildOrder) {
            status.put(project, "visiting");

            for (String neighbor : graph.get(project)) {
                if (status.get(neighbor).equals("visiting")) {
                    return false; //Cycle detected.
                }
                
                if (status.get(neighbor).equals("unvisited")){
                    if(!dfs(neighbor, graph, status, buildOrder)) {
                        return false;
                    }
                }    
            }

            status.put(project, "visited");
            buildOrder.push(project);
            return true;
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
 * Construct a directed graph where nodes are projects, and edges represent dependencies.
 * Traverse the graph using DFS.
 *      If a node is in the process of being visited, and is revisited, a cycle is detected 
 * and no valid build order exists.
 *      When a node finishes processing all its dependencies, it is marked as "visited" and added 
 * to the build order.
 * The build order is obtained by popping nodes from the stack DFS order.
 */