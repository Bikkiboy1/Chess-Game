package main.java.com.example.Chess;

public class Knight extends Piece {
    public Knight(PieceColor color, int row, int col) {
        super(PieceType.KNIGHT, color, row, col);
    }

    @Override
    public boolean isValidMove(int newRow, int newCol, Piece[][] board) {
        int rowDiff = Math.abs(newRow - getRow());
        int colDiff = Math.abs(newCol - getCol());

        // Knight moves in an L-shape: 2 squares in one direction and 1 square in the perpendicular direction
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
