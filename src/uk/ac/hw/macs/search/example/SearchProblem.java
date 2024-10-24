package uk.ac.hw.macs.search.example;

import java.util.List;

public class SearchProblem {

    private GridState initialState; // The initial state (start position)
    private GridState goalState; // The goal state (goal position)
    private int[][] grid;   // The grid representing the search space

    public SearchProblem(int[][] grid, int startRow, int startCol, int goalRow, int goalCol) {
        this.grid = grid;
        this.goalState = new GridState(goalRow, goalCol, grid, null);       // 初始化目标状态
        this.initialState = new GridState(startRow, startCol, grid, goalState);  // 初始化起点状态
    }

    // Method to solve the problem using A* search
    public List<FringeNode> solve() {
        AStarSearch aStarSearch = new AStarSearch();  // 创建 A* 搜索实例
        return aStarSearch.search(initialState, goalState, grid);  // 执行搜索并返回结果路径
    }

    // Helper method to print the solution path
    public void printSolution(List<FringeNode> path) {
        if (path == null) {
            System.out.println("No solution found!");
            return;
        }

        System.out.println("Solution Path:");
        for (FringeNode node : path) {
            GridState state = (GridState) node.getState();
            System.out.println("Step: (" + state.getRow() + ", " + state.getCol() + ")");
            System.out.println("Cost:" + node.getGCost());
        }

    }
}
