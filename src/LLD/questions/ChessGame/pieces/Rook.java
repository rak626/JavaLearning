package LLD.questions.ChessGame.pieces;

import LLD.questions.ChessGame.ChessBoard;
import LLD.questions.ChessGame.ChessBoardCell;
import LLD.questions.ChessGame.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(Color color, ChessBoardCell position) {
        super(color, position);
    }

    @Override
    public List<ChessBoardCell> getLegalMoves(ChessBoard board) {
        List<ChessBoardCell> moves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getCol();

        // Up
        for (int r = row - 1; r >= 0; r--) {
            ChessBoardCell cell = board.getCell(r, col);
            if (cell.isOccupied()) {
                if (cell.getPiece().getColor() != color) moves.add(cell);
                break;
            }
            moves.add(cell);
        }

        // Down
        for (int r = row + 1; r < 8; r++) {
            ChessBoardCell cell = board.getCell(r, col);
            if (cell.isOccupied()) {
                if (cell.getPiece().getColor() != color) moves.add(cell);
                break;
            }
            moves.add(cell);
        }

        // Left
        for (int c = col - 1; c >= 0; c--) {
            ChessBoardCell cell = board.getCell(row, c);
            if (cell.isOccupied()) {
                if (cell.getPiece().getColor() != color) moves.add(cell);
                break;
            }
            moves.add(cell);
        }

        // Right
        for (int c = col + 1; c < 8; c++) {
            ChessBoardCell cell = board.getCell(row, c);
            if (cell.isOccupied()) {
                if (cell.getPiece().getColor() != color) moves.add(cell);
                break;
            }
            moves.add(cell);
        }

        return moves;
    }
}

