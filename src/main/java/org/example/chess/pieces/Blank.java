package org.example.chess.pieces;

import org.example.chess.board.Board;
import org.example.chess.board.Position;

import java.util.List;

public class Blank extends Piece{
    public Blank() {
        super(Color.NOCOLOR, PieceType.NO_PIECE);
    }

    @Override
    public List<Position> getPossibleMovePosition(Position srcPosition, Board board) {
        return List.of();
    }
}
