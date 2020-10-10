/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

/**
 *
 * @author monke
 */
public abstract class Tile {
    int tileCoordinate;
    
    Tile(int tileCoordinate){ //Constructor for class tile 
        this.tileCoordinate = tileCoordinate;
        
    }
    public abstract boolean isTileOccupied();
    
    public abstract Piece getPiece(); //if empty returns null 
    
    public static final class EmptyTile extends Tile{
        EmptyTile(int coordinate){
            super(coordinate);
        }
        @Override
        public boolean isTileOccupied(){
            return false;
        }
        @Override
        public Piece getPiece(){
            return null;
        }
    }
    public static final class OccupiedTile extends Tile{
        Piece pieceOnTile;
        
        OccupiedTile(int tileCoordinate, Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }
        @Override
        public boolean isTileOccupied(){
            return true;
        }
        @Override 
        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }
}
