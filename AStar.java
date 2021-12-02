import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AStar {
    public static class Edge {
        /**
         * Create a graph edge
         * 
         * @param weight
         * @param node
         * @return graph edge
         */
        Edge(int weight, GraphNode node) {
            this.weight = weight;
            this.node = node;
        }

        public int weight;
        public GraphNode node;
    }

    public static class GraphNode implements Comparable<GraphNode> {
        private int idCounter = 0;
        public int id;

        public GraphNode parent = null;

        public List<Edge> neighbors;

        public double f = Double.MAX_VALUE;
        public double g = Double.MAX_VALUE;

        public double h;

        GraphNode(double h) {
            this.h = h;
            this.id = idCounter++;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public int compareTo(GraphNode n) {
            return Double.compare(this.f, n.f);
        }

        public void addBranch(int weight, GraphNode node) {
            Edge newEdge = new Edge(weight, node);
            neighbors.add(newEdge);
        }

        public double calculateHeuristic(GraphNode target) {
            return this.h;
        }
    }

    /**
     * A Star search algorithm
     * 
     * @param start
     * @param target
     * @return GraphNode
     */
    public static GraphNode aStar(GraphNode start, GraphNode target) {
        PriorityQueue<GraphNode> openNodesList = new PriorityQueue<>();
        PriorityQueue<GraphNode> closedNodesList = new PriorityQueue<>();

        start.f = start.g + start.calculateHeuristic(target);
        openNodesList.add(start);

        while (!openNodesList.isEmpty()) {
            GraphNode n = openNodesList.peek();
            if (n == target) {
                return n;
            }

            for (Edge edge : n.neighbors) {
                GraphNode m = edge.node;
                double totalWeight = n.g + edge.weight;

                if (!openNodesList.contains(m) && !closedNodesList.contains(m)) {
                    m.parent = n;
                    m.g = totalWeight;
                    m.f = m.g + m.calculateHeuristic(target);
                    openNodesList.add(m);
                } else {
                    if (totalWeight < m.g) {
                        m.parent = n;
                        m.g = totalWeight;
                        m.f = m.g + m.calculateHeuristic(target);

                        if (closedNodesList.contains(m)) {
                            closedNodesList.remove(m);
                            openNodesList.add(m);
                        }
                    }
                }
            }

            openNodesList.remove(n);
            closedNodesList.add(n);
        }
        return null;

    }

    /**
     * @param target
     */
    public static void printPath(GraphNode target) {
        GraphNode n = target;

        if (n == null)
            return;

        List<Integer> ids = new ArrayList<>();

        while (n.parent != null) {
            ids.add(n.id);
            n = n.parent;
        }
        ids.add(n.id);
        Collections.reverse(ids);

        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println("");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        GraphNode head = new GraphNode(3);
        head.g = 0;

        GraphNode n1 = new GraphNode(2);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(2);

        head.addBranch(1, n1);
        head.addBranch(5, n2);
        head.addBranch(2, n3);
        n3.addBranch(1, n2);

        GraphNode n4 = new GraphNode(1);
        GraphNode n5 = new GraphNode(1);
        GraphNode target = new GraphNode(0);

        n1.addBranch(7, n4);
        n2.addBranch(4, n5);
        n3.addBranch(6, n4);

        n4.addBranch(3, target);
        n5.addBranch(1, n4);
        n5.addBranch(3, target);

        GraphNode res = aStar(head, target);
        printPath(res);
    }

}
