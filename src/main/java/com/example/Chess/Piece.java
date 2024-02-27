package com.example.Chess;

public abstract class Piece {
    private PieceType type;
    private PieceColor color;
    private int row;
    private int col;

    public Piece(PieceType type, PieceColor color, int row, int col) {
        this.type = type;
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public abstract boolean isValidMove(int newRow, int newCol, Piece[][] board);

    public PieceType getType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
