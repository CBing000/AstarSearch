package uk.ac.hw.macs.search.example;


public class GridState implements State {
    private int row, col;  // 该状态在网格中的位置
    private int[][] grid;  // 网格数据
    private GridState goalState;  // 目标状态

    // 构造函数：初始化网格状态
    public GridState(int row, int col, int[][] grid, GridState goalState) {
        this.row = row;
        this.col = col;
        this.grid = grid;
        this.goalState = goalState;
    }

    // 判断是否是目标状态 Determines if the current state is the goal state
    @Override
    public boolean isGoal() {
        return this.row == goalState.row && this.col == goalState.col;
    }

    // 计算曼哈顿距离作为启发式值 Computes the Manhattan distance as the heuristic
    @Override
    public int getHeuristic() {
        return Math.abs(this.row - goalState.row) + Math.abs(this.col - goalState.col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GridState state = (GridState) obj;
        return row == state.row && col == state.col;
    }

    @Override
    public int hashCode() {
        return 31 * row + col;
    }
}
