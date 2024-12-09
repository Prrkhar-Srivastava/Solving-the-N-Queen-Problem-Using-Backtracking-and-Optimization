public class NQueenProblem {

    // Print the board
    private static void printSolution(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if placing a queen at board[row][col] is safe
    private static boolean isSafe(int[][] board, int row, int col, int N) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    // Solve the N-Queen problem using backtracking
    private static boolean solveNQueens(int[][] board, int row, int N) {
        if (row == N) {
            printSolution(board, N);
            return true; // Return true to print all solutions
        }

        boolean res = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col, N)) {
                board[row][col] = 1; // Place queen
                res = solveNQueens(board, row + 1, N) || res;
                board[row][col] = 0; // Backtrack
            }
        }

        return res;
    }

    // Main method to solve the problem
    public static void solveNQueens(int N) {
        int[][] board = new int[N][N];

        if (!solveNQueens(board, 0, N)) {
            System.out.println("No solution exists.");
        }
    }

    public static void main(String[] args) {
        int N = 8; // Change N for different board sizes
        solveNQueens(N);
    }
}

