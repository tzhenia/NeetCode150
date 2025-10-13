// Hash Set + unique ids

// If the array dimensions (ROWS, COLS) depend on the input size N (example: N x N matrix) — then: 
// Time complexity: O(n²)
// Space complexity: O(n²)

// But if the array size is fixed — it never changes regardless of the input —
// then the total number of iterations (ROWS * COLS) is a constant. That means:
// Time complexity: O(1) - because you always perform the same constant number of operations
// Space complexity: O(1) - the array itself also takes constant space

class Solution {
    public boolean isValidSudoku(char[][] board) { // the board is always 9x9
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char curr = board[row][col];
                if (curr != '.') {
                    String byRow = "row-" + row + "-num-" + curr;
                    String byCol = "col-" + col + "-num-" + curr;

                    // (row / 3) and (col / 3) trick to identify the correct box
                    String byBox = "box-row-" + row / 3 + "-col-" + col / 3 + "-num-" + curr;

                    if (!seen.add(byRow) || !seen.add(byCol) || !seen.add(byBox)) {
                        return false;
                    }

                }
            }
        }

        return true;
    }
}

// Bitmask approach more better if the array dimensions (ROWS, COLS) depend on the input size N
// Time complexity: O(n²)
// Space complexity: O(n)
// https://neetcode.io/problems/valid-sudoku
