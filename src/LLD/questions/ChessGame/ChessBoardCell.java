package LLD.questions.ChessGame;

import LLD.questions.ChessGame.pieces.Piece;

public class ChessBoardCell {
    private final int row;
    private final int col;
    private Piece piece;

    public ChessBoardCell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    @Override
    public String toString() {
        return "ChessBoardCell{" +
                "row=" + row +
                ", col=" + col +
                ", piece=" + piece +
                '}';
    }
}
