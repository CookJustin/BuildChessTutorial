/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author monke
 */
public abstract class Tile {

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        
        for (int i = 0; i < 64; i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }
        
        //good practicec to return an immutible emptyTileMap but Idk how to do it 
        return Collections.unmodifiableMap(emptyTileMap);
    }
    protected final int tileCoordinate;
    
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
    
    public static Tile createTile(final int tileCoordinate, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoordinate,piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }
    private Tile(int tileCoordinate){ //Constructor for class tile 
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
        private final Piece pieceOnTile;
        
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
