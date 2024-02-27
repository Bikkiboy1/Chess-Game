class Bishop extends com.example.Chess.Piece {
    public Bishop(PieceColor color, int row, int col) {
    super(PieceType.BISHOP, color, row, col);
    }
    
    @Override
    public boolean isValidMove(int newRow, int newCol, Piece[][] board) {
    int rowDiff = Math.abs(newRow - getRow());
    int colDiff = Math.abs(newCol - getCol());
    
    // Bishop moves diagonally
    if (rowDiff == colDiff) {
    // Check if the path is clear
    int rowIncrement = (newRow - getRow()) / rowDiff;
    int colIncrement = (newCol - getCol()) / colDiff;
    for (int r = getRow() + rowIncrement, c = getCol() + colIncrement; r != newRow && c != newCol; r += rowIncrement, c += colIncrement) {
    if (board[r][c] != null) {
    return false;
    }
    }
    return true;
    }
    return false;
    }
    }