package org.example.chess.pieces;

import org.example.chess.board.Board;
import org.example.chess.board.Direction;
import org.example.chess.board.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    public Pawn(Color color) {
        super(color,PieceType.PAWN);
    }

    @Override
    public List<Position> getPossibleMovePosition(Position srcPosition, Board board) {
        List<Direction> directions = Direction.getDirectionsByTypeAndColor(PieceType.PAWN, getColor());
        List<Position> possiblePositions = new ArrayList<>();

        for (Direction direction : directions) {
            Position currentPosition = srcPosition.move(direction);

            // 전진하는 경우
            if (direction == Direction.NORTH || direction == Direction.SOUTH) {
                while (Position.validPosition(currentPosition.getRow(), currentPosition.getColumn())) {
                    Piece targetPiece = board.findPiece(currentPosition);

                    if (targetPiece == null || targetPiece.getPieceType().equals(PieceType.NO_PIECE)) {
                        possiblePositions.add(currentPosition);
                    } else {
                        break;
                    }
                    currentPosition = currentPosition.move(direction);

                    if (this.getMoveCount() != 0) {
                        break;
                    }
                }
            } else { // 대각선 이동
                if (Position.validPosition(currentPosition.getRow(), currentPosition.getColumn())) {
                    Piece targetPiece = board.findPiece(currentPosition);
                    if (targetPiece != null && !targetPiece.getPieceType().equals(PieceType.NO_PIECE) &&
                            targetPiece.getColor() != this.getColor()) {
                        possiblePositions.add(currentPosition);
                    }
                }
            }
        }

        return possiblePositions;
    }
}
