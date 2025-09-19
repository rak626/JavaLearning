package LLD.questions.ChessGame.pieces;

import LLD.questions.ChessGame.ChessBoard;
import LLD.questions.ChessGame.ChessBoardCell;
import LLD.questions.ChessGame.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    private Rook rookHelper;
    private Bishop bishopHelper;

    public Queen(Color color, ChessBoardCell position) {
        super(color, position);
        rookHelper = new Rook(color, position);
        bishopHelper = new Bishop(color, position);
    }

    @Override
    public List<ChessBoardCell> getLegalMoves(ChessBoard board) {
        List<ChessBoardCell> moves = new ArrayList<>();
        moves.addAll(rookHelper.getLegalMoves(board));
        moves.addAll(bishopHelper.getLegalMoves(board));
        return moves;
    }
}

