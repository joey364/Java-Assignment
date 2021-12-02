import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class GraphNode implements Comparable<GraphNode> {
  // make printing out path easier
  private static int idCounter = 0;
  public int id;

  // Parent node in the path
  public GraphNode parent = null;

  public List<Edge> neighbors;

  // Heuristic evaluation functions
  public double lowerEvalFunction = Double.MAX_VALUE;
  public double upperEvalFunction = Double.MAX_VALUE;

  // Hardcoded heuristic
  public char h;

  /**
   * Graph node constructor
   * 
   * @param h
   */
  GraphNode(char h) {
    this.h = h;
    this.id = idCounter++;
    this.neighbors = new ArrayList<>();
  }

  /**
   * Compare nodes in the graph
   * 
   * @param n
   * @return int
   */
  @Override
  public int compareTo(GraphNode n) {
    return Double.compare(this.lowerEvalFunction, n.lowerEvalFunction);
  }

  // Structure to represent a graph edge
  public static class Edge {
    Edge(int weight, GraphNode node) {
      this.weight = weight;
      this.node = node;
    }

    public int weight;
    public GraphNode node;
  }

  /**
   * Add branch to graph
   * 
   * @param weight
   * @param node
   */
  public void addBranch(int weight, GraphNode node) {
    Edge newEdge = new Edge(weight, node);
    neighbors.add(newEdge);
  }

  /**
   * Calculate cost of travel from target
   * 
   * @param target
   * @return double
   */
  public double calculateHeuristic(GraphNode target) {
    return this.h;
  }

  /**
   * A* Search Algorithm
   * 
   * @param start
   * @param target
   * @return GraphNode
   */
  public static GraphNode aStar(GraphNode start, GraphNode target) {
    PriorityQueue<GraphNode> openNodesList = new PriorityQueue<>();
    PriorityQueue<GraphNode> closedNodesList = new PriorityQueue<>();

    // Check whether target is already visited
    start.lowerEvalFunction = start.upperEvalFunction + start.calculateHeuristic(target);
    openNodesList.add(start);

    while (!openNodesList.isEmpty()) {
      GraphNode n = openNodesList.peek();
      if (n == target) {
        return n;
      }

      for (GraphNode.Edge edge : n.neighbors) {
        GraphNode m = edge.node;
        double totalWeight = n.upperEvalFunction + edge.weight;

        if (!openNodesList.contains(m) && !closedNodesList.contains(m)) {
          m.parent = n;
          m.upperEvalFunction = totalWeight;
          m.lowerEvalFunction = m.upperEvalFunction + m.calculateHeuristic(target);
          openNodesList.add(m);
        } else {
          if (totalWeight < m.upperEvalFunction) {
            m.parent = n;
            m.upperEvalFunction = totalWeight;
            m.lowerEvalFunction = m.upperEvalFunction + m.calculateHeuristic(target);

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
   * Print graph traversal during the A* search
   * 
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
   * Driver program example
   * 
   * @param args
   */
  public static void main(String[] args) {
    GraphNode head = new GraphNode('A');
    head.upperEvalFunction = 0;

    GraphNode n1 = new GraphNode('B');
    GraphNode n2 = new GraphNode('C');
    GraphNode n3 = new GraphNode('D');

    head.addBranch(1, n1);
    head.addBranch(5, n2);
    head.addBranch(2, n3);
    n3.addBranch(1, n2);

    GraphNode n4 = new GraphNode('F');
    GraphNode n5 = new GraphNode('J');
    GraphNode target = new GraphNode('H');

    n1.addBranch(7, n4);
    n2.addBranch(14, n5);
    n3.addBranch(6, n4);

    n4.addBranch(3, target);
    n5.addBranch(1, n4);
    n5.addBranch(3, target);

    GraphNode res = aStar(head, target);
    printPath(res);
  }
}
