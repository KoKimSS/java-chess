package org.example.chess.Game;

import org.example.chess.board.Board;
import org.example.chess.board.PointManager;

abstract class Game {
    protected final Board board;
    protected final PointManager pointManager;

    Game(Board board) {
        this.board = board;
        this.pointManager = new PointManager(board);
    }

    public PointManager getPointManager() {
        return pointManager;
    }

    public Board getBoard() {
        return board;
    }

    public void showGame() {
        System.out.println(board.showBoard());
        pointManager.showPoint();
    }

    abstract double calculatePoint();
    abstract void move(String src, String dest);
}
