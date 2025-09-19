package LLD.questions.ChessGame.pieces;

import LLD.questions.ChessGame.ChessBoard;
import LLD.questions.ChessGame.ChessBoardCell;
import LLD.questions.ChessGame.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    private static final int[][] MOVES = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public King(Color color, ChessBoardCell position) {
        super(color, position);
    }

    @Override
    public List<ChessBoardCell> getLegalMoves(ChessBoard board) {
        List<ChessBoardCell> moves = new ArrayList<>();
        int row = position.getRow();
        int col = position.getCol();

        for (int[] move : MOVES) {
            int r = row + move[0];
            int c = col + move[1];
            if (board.isValidCell(r, c)) {
                ChessBoardCell cell = board.getCell(r, c);
                if (!cell.isOccupied() || cell.getPiece().getColor() != color) {
                    moves.add(cell);
                }
            }
        }

        // TODO: Add castling logic
        return moves;
    }
}

