package LLD.questions.ChessGame.pieces;

import LLD.questions.ChessGame.ChessBoard;
import LLD.questions.ChessGame.ChessBoardCell;
import LLD.questions.ChessGame.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color color, ChessBoardCell position) {
        super(color, position);
    }

    @Override
    public List<ChessBoardCell> getLegalMoves(ChessBoard board) {
        List<ChessBoardCell> moves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getCol();

        // Top-left
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            ChessBoardCell cell = board.getCell(r, c);
            if (cell.isOccupied()) {
                if (cell.getPiece().getColor() != color) moves.add(cell);
                break;
            }
            moves.add(cell);
        }

        // Top-right
        for (int r = row - 1, c = col + 1; r >= 0 && c < 8; r--, c++) {
            ChessBoardCell cell = board.getCell(r, c);
            if (cell.isOccupied()) {
                if (cell.getPiece().getColor() != color) moves.add(cell);
                break;
            }
            moves.add(cell);
        }

        // Bottom-left
        for (int r = row + 1, c = col - 1; r < 8 && c >= 0; r++, c--) {
            ChessBoardCell cell = board.getCell(r, c);
            if (cell.isOccupied()) {
                if (cell.getPiece().getColor() != color) moves.add(cell);
                break;
            }
            moves.add(cell);
        }

        // Bottom-right
        for (int r = row + 1, c = col + 1; r < 8 && c < 8; r++, c++) {
            ChessBoardCell cell = board.getCell(r, c);
            if (cell.isOccupied()) {
                if (cell.getPiece().getColor() != color) moves.add(cell);
                break;
            }
            moves.add(cell);
        }

        return moves;
    }
}

