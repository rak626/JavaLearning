package LLD.questions.ChessGame;

import LLD.questions.ChessGame.enums.GameStatus;

import java.util.Scanner;

public class ChessRunner {

    public static void main(String[] args) {
        System.out.println("Enter Name of Each player: ");
        Scanner scanner = new Scanner(System.in);
        String player1Name = scanner.next();
        String player2Name = scanner.next();

        Game game = new Game(player1Name, player2Name);

        System.out.println("Chess game started between " +
                game.getWhitePlayer().getName() + " (White) and " +
                game.getBlackPlayer().getName() + " (Black)");

        game.getBoard().printBoard();

        while (game.getStatus() == GameStatus.ONGOING) {
            Player current = game.getCurrentPlayer();
            System.out.println("\nCurrent Player: " + current.getName() + " (" + current.getColor() + ")");
            System.out.print("Enter move (e.g., e2e4 or Nb1c3): ");
            String input = scanner.next();

            // Validate input length
            if (input.length() < 4) {
                System.out.println("Invalid input format! Use format e2e4");
                continue;
            }

            ChessBoard board = game.getBoard();
            // Parse input: convert letters a-h to 0-7, numbers 1-8 to 7-0
            int fromCol = input.charAt(0) - 'a';
            int fromRow = 8 - Character.getNumericValue(input.charAt(1));
            int toCol = input.charAt(2) - 'a';
            int toRow = 8 - Character.getNumericValue(input.charAt(3));

            ChessBoardCell fromCell = board.getCell(fromRow, fromCol);
            ChessBoardCell toCell = board.getCell(toRow, toCol);

            System.out.println("from cell - " + fromCell);
            System.out.println(toCell);

            if (fromCell == null || toCell == null) {
                System.out.println("Invalid coordinates! Please try again.");
                continue;
            }

            // Check if there is a piece at source
            if (!fromCell.isOccupied()) {
                System.out.println("No piece at source cell! Try again.");
                continue;
            }

            // Check if player is moving their own piece
            if (fromCell.getPiece().getColor() != current.getColor()) {
                System.out.println("Cannot move opponent's piece! Try again.");
                continue;
            }

            // Make the move
            game.move(fromCell, toCell);

            // Print updated board
            board.printBoard();
        }

        System.out.println("Game over! Status: " + game.getStatus());
        scanner.close();
    }
}
