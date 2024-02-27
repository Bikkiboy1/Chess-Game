package main.java.com.example.Chess;

public class Pawn extends Piece {
    public Pawn(PieceColor color, int row, int col) {
        super(PieceType.PAWN, color, row, col);
    }

    @Override
    public boolean isValidMove(int newRow, int newCol, Piece[][] board) {
        int rowDiff = newRow - getRow();
        int colDiff = Math.abs(newCol - getCol());
        int forwardDir = (getColor() == PieceColor.WHITE) ? 1 : -1;

        // Pawn can move forward by one square
        if (colDiff == 0 && rowDiff == forwardDir && board[newRow][newCol] == null) {
            return true;
        }
        // Pawn can move forward by two squares from its starting position
        if (colDiff == 0 && rowDiff == 2 * forwardDir && ((getColor() == PieceColor.WHITE && getRow() == 1) || (getColor() == PieceColor.BLACK && getRow() == 6))) {
            // Check if the squares in between are empty
            int middleRow = getRow() + forwardDir;
            return board[middleRow][getCol()] == null && board[newRow][newCol] == null;
        }
        // Pawn can capture diagonally
        if (colDiff == 1 && rowDiff == forwardDir) {
            // Check if there's an opponent piece to capture
            return board[newRow][newCol] != null && board[newRow][newCol].getColor() != getColor();
        }
        return false;
    }
}
