package uk.ac.hw.macs.search.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Define the grid
        int[][] grid = {
                { 1, 1, -1, 2, 1, 1},
                { 2, 2, 1, 2, 1, 1 },
                { 1, 1, -1, 2, 2, 1 },
                { 2, -1, -1, 1, 2, 2 }
        };

        // Define the start and goal positions
        int startRow = 0, startCol = 0;
        int goalRow = 2, goalCol = 5;

//        int[][] grid = {
//                { 1, 1, -1, 2, 1 },
//                { 2, 1, 1, 2, 1 },
//                { 1, 1, -1, 1, 1 },
//                { 2, 1, 2, 1, 2 },
//                { 2, -1, -1, 1, 2}
//        };
//
//        int startRow = 0, startCol = 0;
//        int goalRow = 4, goalCol = 3;


        SearchProblem problem = new SearchProblem(grid, startRow, startCol, goalRow, goalCol);

        List<FringeNode> solution = problem.solve();

        problem.printSolution(solution);
    }
}
