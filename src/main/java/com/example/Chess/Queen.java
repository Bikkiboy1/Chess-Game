package main.java.com.example.Chess;

public class Queen extends Piece {
    public Queen(PieceColor color, int row, int col) {
        super(PieceType.QUEEN, color, row, col);
    }

    @Override
    public boolean isValidMove(int newRow, int newCol, Piece[][] board) {
        int rowDiff = Math.abs(newRow - getRow());
        int colDiff = Math.abs(newCol - getCol());

        // Queen moves horizontally, vertically, or diagonally
        if ((rowDiff == 0 && colDiff > 0) || (rowDiff > 0 && colDiff == 0) || (rowDiff == colDiff)) {
            // Check if the path is clear
            if (rowDiff == 0 || colDiff == 0) {
                if (rowDiff > 0) {
                    int rowIncrement = (newRow - getRow()) / rowDiff;
                    for (int r = getRow() + rowIncrement; r != newRow; r += rowIncrement) {
                        if (board[r][getCol()] != null) {
                            return false;
                        }
                    }
                } else {
                    int colIncrement = (newCol - getCol()) / colDiff;
                    for (int c = getCol() + colIncrement; c != newCol; c += colIncrement) {
                        if (board[getRow()][c] != null) {
                            return false;
                        }
                    }
                }
            } else {
                int rowIncrement = (newRow - getRow()) / rowDiff;
                int colIncrement = (newCol - getCol()) / colDiff;
                for (int r = getRow() + rowIncrement, c = getCol() + colIncrement; r != newRow && c != newCol; r += rowIncrement, c += colIncrement) {
                    if (board[r][c] != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
