package Problems.Algorithms;

import java.util.*;

public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");
//        graph.removeNode("B");
//        graph.removeEdge("A", "C");
//        graph.addEdge("A", "C");
//        graph.print();
        graph.dfsRec("A");
        System.out.println();
        graph.dfsStack("A");
    }

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Node> targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null)
            return;

        for (Node n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void dfsRec(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        dfsRec(node, new HashSet<>());
    }

    private void dfsRec(Node root, Set<Node> visited) {
        System.out.print(root + ", ");
        visited.add(root);

        for (Node node : adjacencyList.get(root))
            if (!visited.contains(node))
                dfsRec(node, visited);
    }

    public void dfsStack(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();

            if (visited.contains(currentNode))
                continue;

            System.out.print(currentNode + ", ");
            visited.add(currentNode);

            for (Node neighbor : adjacencyList.get(currentNode))
                if (!visited.contains(neighbor))
                    stack.push(neighbor);
        }
    }

}