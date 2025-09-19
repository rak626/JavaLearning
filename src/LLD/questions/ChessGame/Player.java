package LLD.questions.ChessGame;

import LLD.questions.ChessGame.enums.Color;
import LLD.questions.ChessGame.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int number;
    private String name;
    private Color color;
    private List<Piece> capturedPieces;
    private Timer timer;


    public Player(int number, String name, Color color) {
        this.number = number;
        this.name = name;
        this.color = color;
        this.capturedPieces = new ArrayList<>();
        this.timer = new Timer(10 * 60); // 10 minutes default
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public List<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public Timer getTimer() {
        return timer;
    }

    public void addCapturedPiece(Piece capturedPiece) {
        this.capturedPieces.add(capturedPiece);
    }
}
