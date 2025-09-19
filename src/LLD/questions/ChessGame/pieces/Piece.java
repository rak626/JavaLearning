package LLD.questions.ChessGame.pieces;

import LLD.questions.ChessGame.ChessBoard;
import LLD.questions.ChessGame.ChessBoardCell;
import LLD.questions.ChessGame.enums.Color;

import java.util.List;

public abstract class Piece {
    protected Color color;
    protected ChessBoardCell position;

    public Piece(Color color, ChessBoardCell position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public ChessBoardCell getPosition() {
        return position;
    }

    public void setPosition(ChessBoardCell position) {
        this.position = position;
    }

    public abstract List<ChessBoardCell> getLegalMoves(ChessBoard board);
}
