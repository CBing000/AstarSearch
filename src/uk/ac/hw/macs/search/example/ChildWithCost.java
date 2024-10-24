package uk.ac.hw.macs.search.example;

public class ChildWithCost {
    private State state;  // 子节点的状态
    private int cost;     // 从父节点到子节点的移动代价

    // 构造函数：初始化状态和代价 Constructor: initializes the state and the cost
    public ChildWithCost(State state, int cost) {
        this.state = state;
        this.cost = cost;
    }

    // 获取子节点的状态 Getter for the state of the child node
    public State getState() {
        return state;
    }

    // 获取移动到子节点的成本 Getter for the cost to move to this child node
    public int getCost() {
        return cost;
    }

    // 可选的toString方法用于调试
    @Override
    public String toString() {
        return "State: " + state + ", Cost: " + cost;
    }

    // equals和hashCode方法用于比较ChildWithCost对象是否相等
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChildWithCost other = (ChildWithCost) obj;
        return state.equals(other.state) && cost == other.cost;
    }

    @Override
    public int hashCode() {
        return state.hashCode() + 31 * cost;
    }
}
