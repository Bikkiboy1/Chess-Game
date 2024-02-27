package main.java.com.example.Chess;

public class King extends Piece {
    public King(PieceColor color, int row, int col) {
        super(PieceType.KING, color, row, col);
    }

    @Override
    public boolean isValidMove(int newRow, int newCol, Piece[][] board) {
        int rowDiff = Math.abs(newRow - getRow());
        int colDiff = Math.abs(newCol - getCol());

        // King moves one square in any direction
        return (rowDiff == 1 && colDiff <= 1) || (rowDiff <= 1 && colDiff == 1);
    }
}
