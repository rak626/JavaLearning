package LLD.questions.ChessGame.pieces;

import LLD.questions.ChessGame.ChessBoard;
import LLD.questions.ChessGame.ChessBoardCell;
import LLD.questions.ChessGame.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(Color color, ChessBoardCell position) {
        super(color, position);
    }

    @Override
    public List<ChessBoardCell> getLegalMoves(ChessBoard board) {
        List<ChessBoardCell> moves = new ArrayList<>();
        int direction = (color == Color.WHITE) ? -1 : 1; // White moves up, Black moves down
        int newRow = position.getRow() + direction;
        int col = position.getCol();

        // Move forward if cell is empty
        if (board.isValidCell(newRow, col) && !board.getCell(newRow, col).isOccupied()) {
            moves.add(board.getCell(newRow, col));
        }

        // TODO: Add capture logic, initial double move, en passant
        return moves;
    }
}
