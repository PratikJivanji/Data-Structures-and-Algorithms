import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Graph {
    private HashMap<Integer, List<Integer>> adjacentList;
    private int numberOfNodes;

    public Graph() {
        adjacentList = new HashMap<>();
        numberOfNodes = 0;
    }

    public void addNode(int value) {
        adjacentList.put(value, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(int value1, int value2) {
        adjacentList.get(value1).add(value2);
        adjacentList.get(value2).add(value1);
    }

    public void showConnections() {
        Set<Integer> keys = adjacentList.keySet();
        for (int node : keys) {
        List<Integer> nodeConnections = adjacentList.get(node);
        StringBuilder connections = new StringBuilder();
        for (int edge : nodeConnections) {
            connections.append(edge).append(" ");
        }
        System.out.println(node + "-->" + connections);
        }
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void BFS(int value)
    {
        boolean visited[] = new boolean[numberOfNodes];
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        visited[value]=true;
        queue.add(value);
 
        while (queue.size() != 0)
        {
            value = queue.poll();
            System.out.print(value+" ");
 
            Iterator<Integer> i = adjacentList.get(value).listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    private void DFSUtil(int value, boolean visited[])
    {
        visited[value] = true;
        System.out.print(value + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adjacentList.get(value).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    public void DFS(int value)
    {
        boolean visited[] = new boolean[numberOfNodes];
        DFSUtil(value, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.showConnections();
    }
}