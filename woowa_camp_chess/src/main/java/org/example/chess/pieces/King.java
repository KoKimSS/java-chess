package org.example.chess.pieces;

import org.example.chess.board.Board;
import org.example.chess.board.Direction;
import org.example.chess.board.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(Color color) {
        super(color,PieceType.KING);
    }

    @Override
    public List<Position> getPossibleMovePosition(Position srcPosition, Board board) {
        List<Direction> directions = Direction.getDirectionsByTypeAndColor(PieceType.KING, getColor());
        List<Position> possiblePositions = new ArrayList<>();

        for (Direction direction : directions) {
            Position currentPosition = srcPosition.move(direction);
            if (Position.validPosition(currentPosition.getRow(), currentPosition.getColumn())) {
                Piece targetPiece = board.findPiece(currentPosition);

                if (targetPiece == null || targetPiece.getPieceType().equals(PieceType.NO_PIECE)) {
                    possiblePositions.add(currentPosition);
                } else if (targetPiece.getColor() != this.getColor()) {
                    possiblePositions.add(currentPosition);
                }
            }
        }
        return possiblePositions;
    }
}
