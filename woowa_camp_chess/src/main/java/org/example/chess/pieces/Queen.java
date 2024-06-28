package org.example.chess.pieces;

import org.example.chess.board.Board;
import org.example.chess.board.Direction;
import org.example.chess.board.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color,PieceType.QUEEN);
    }

    @Override
    public List<Position> getPossibleMovePosition(Position srcPosition, Board board) {
        List<Direction> directions = Direction.getDirectionsByTypeAndColor(PieceType.QUEEN, getColor());
        List<Position> possiblePositions = new ArrayList<>();

        for (Direction direction : directions) {
            Position currentPosition = srcPosition.move(direction);
            while (Position.validPosition(currentPosition.getRow(), currentPosition.getColumn())) {
                Piece targetPiece = board.findPiece(currentPosition);

                if (targetPiece == null || targetPiece.getPieceType().equals(PieceType.NO_PIECE)) {
                    possiblePositions.add(currentPosition);
                } else {
                    if (targetPiece.getColor() != this.getColor()) {
                        possiblePositions.add(currentPosition);
                    }
                    break;
                }
                currentPosition = currentPosition.move(direction);
            }
        }
        return possiblePositions;
    }
}
