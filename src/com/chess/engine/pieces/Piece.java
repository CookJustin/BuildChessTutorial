/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.engine.pieces;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import java.util.List;

/**
 *
 * @author monke
 */
public abstract class Piece {
    protected final int piecePosition;
    protected final Alliance pieceAlliance;
    
    Piece(final int piecePosition, final Alliance pieceAlliance){
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
    }
    public abstract List<Move> calculateLegalMoves(final Board board);
}
