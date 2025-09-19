package LLD.questions.ChessGame;

import LLD.questions.ChessGame.enums.Color;
import LLD.questions.ChessGame.pieces.Piece;

public class ChessBoard {
    ChessBoardCell[][] board;

    public ChessBoard() {
        this.board = new ChessBoardCell[8][8]; // all null values there of type ChessBoard Cell

        // assign ChessBoardCell to each of the cell
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = new ChessBoardCell(i, j);
            }
        }
    }

    public ChessBoardCell getCell(int row, int col) {
        if (isValidCell(row, col)) return board[row][col];
        return null;
    }

    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public void movePiece(ChessBoardCell from, ChessBoardCell to) {
        Piece piece = from.getPiece();
        if (piece != null) {
            to.setPiece(piece);
            from.setPiece(null);
            piece.setPosition(to);
        }
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessBoardCell cell = board[i][j];
                if (cell.isOccupied()) {
                    Piece piece = cell.getPiece();
                    String symbol = piece.getClass().getSimpleName().substring(0, 1);
                    if (piece.getColor() == Color.WHITE) {
                        System.out.print(symbol.toUpperCase() + " ");
                    } else {
                        System.out.print(symbol.toLowerCase() + " ");
                    }
                } else {
                    System.out.print(". ");
                }
            }
            // Print row numbers on the right (1-8 from bottom)
            System.out.println(" | " + (8 - i));
        }

        // Print column letters at bottom
        System.out.println("_ _ _ _ _ _ _ _");
        System.out.print("a b c d e f g h\n");
    }


}
