package uk.ac.hw.macs.search.example;

public class Node {
    private State state;  // 当前节点的状态 The state of the current node
    private Node parent;   // 父节点 The parent node (for path reconstruction)
    private int gCost;     // 从起点到当前节点的实际代价 The actual cost from the start to this node
    private int hCost;     // 启发式估计值 The heuristic cost (estimated distance to the goal)

    // 构造函数：初始化节点 initializes
    public Node(State state, Node parent, int gCost, int hCost) {
        this.state = state;
        this.parent = parent;
        this.gCost = gCost;
        this.hCost = hCost;
    }

    // 获取f值（f = g + h），用于优先级队列排序 Returns the fCost (f = g + h) used for sorting nodes in A* search
    public int getFCost() {
        return gCost + hCost;
    }

    // 获取g值（从起点到当前节点的实际代价）
    public int getGCost() {
        return gCost;
    }

    // 获取当前节点的状态
    public State getState() {
        return state;
    }

    // 获取父节点
    public Node getParent() {
        return parent;
    }

    @Override //equals method to compare nodes based on their state
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return state.equals(node.state);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
}
