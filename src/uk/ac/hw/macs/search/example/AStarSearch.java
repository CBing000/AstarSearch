package uk.ac.hw.macs.search.example;

import java.util.*;

public class AStarSearch {

    // 搜索方法，使用 A* 算法
    public List<FringeNode> search(GridState initialState, GridState goalState, int[][] grid) {
        // 优先级队列，用于扩展节点，按 fCost 排序（fCost = gCost + hCost）
        PriorityQueue<FringeNode> fringe = new PriorityQueue<>(Comparator.comparingInt(FringeNode::getFCost));

        // 创建起点的 gCost = 0，hCost 根据启发式函数计算
        int gCost = 0;
        int hCost = initialState.getHeuristic();

        // 创建起点节点
        FringeNode startNode = new FringeNode(initialState, null, gCost, hCost);
        fringe.add(startNode);

        // 已访问的节点集合，防止重复扩展
        Set<GridState> closedSet = new HashSet<>();

        while (!fringe.isEmpty()) {
            // 从队列中取出 fCost 最小的节点
            FringeNode currentNode = fringe.poll();
            GridState currentState = (GridState) currentNode.getState();

            // 如果当前节点是目标节点，返回路径
            if (currentState.isGoal()) {
                return constructPath(currentNode);
            }

            // 将当前节点加入到已访问的集合中
            closedSet.add(currentState);

            // 扩展当前节点的邻居节点
            Set<ChildWithCost> children = getNeighbors(currentNode, grid, goalState);
            for (ChildWithCost child : children) {
                GridState childState = (GridState) child.getState();
                int tentativeGCost = currentNode.getGCost() + child.getCost();

                // 如果子节点已经在已访问集合中，跳过
                if (closedSet.contains(childState)) {
                    continue;
                }

                // 计算子节点的 gCost 和 hCost
                int childHCost = childState.getHeuristic();
                FringeNode neighborNode = new FringeNode(childState, currentNode, tentativeGCost, childHCost);

                // 将子节点加入到待扩展队列中
                fringe.add(neighborNode);
            }
        }

        // 没有找到路径，返回 null
        return null;
    }

    // 辅助方法：回溯路径
    private List<FringeNode> constructPath(FringeNode node) {
        List<FringeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = (FringeNode) node.getParent();
        }
        Collections.reverse(path);  // 反转路径，得到从起点到终点的顺序
        return path;
    }

    // 获取当前节点的邻居节点，并计算到每个邻居的移动成本
    private Set<ChildWithCost> getNeighbors(FringeNode currentNode, int[][] grid, GridState goalState) {
        Set<ChildWithCost> neighbors = new HashSet<>();
        GridState currentState = (GridState) currentNode.getState();
        int row = currentState.getRow();
        int col = currentState.getCol();

        // 检查上下左右邻居
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // 检查邻居是否在网格范围内
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] != -1) {
                GridState neighborState = new GridState(newRow, newCol, grid, goalState);
                int moveCost = grid[newRow][newCol];  // 白色格子的成本为 1，灰色格子的成本为 2
                neighbors.add(new ChildWithCost(neighborState, moveCost));
            }
        }
        return neighbors;
    }
}
