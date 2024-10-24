package uk.ac.hw.macs.search.example;


public interface State {
    boolean isGoal();  // 判断是否为目标状态
    int getHeuristic();  // 计算启发式值
}
