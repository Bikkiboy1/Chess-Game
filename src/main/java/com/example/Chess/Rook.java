 
 package main.java.com.example.Chess;

public class Rook extends Piece {
    public Rook(PieceColor color, int row, int col) {
        super(PieceType.ROOK, color, row, col);
    }

    @Override
    public boolean isValidMove(int newRow, int newCol, Piece[][] board) {
        int rowDiff = Math.abs(newRow - getRow());
        int colDiff = Math.abs(newCol - getCol());

        // Rook can move horizontally or vertically
        if ((rowDiff > 0 && colDiff == 0) || (rowDiff == 0 && colDiff > 0)) {
            // Check if the path is clear
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
            return true;
        }
        return false;
    }
}
