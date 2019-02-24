package com.sharpsan.battleship.models;

import com.sharpsan.battleship.grid.Square;
import com.sharpsan.battleship.ships.Ship;

public class Fire {

    private final Square square;
    private Ship ship;
    private int shipSquareId;
    private boolean isHit;

    //TODO: add Ship and ship hit position if the ship gets hit
    public Fire(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getShipSquareId() {
        return shipSquareId;
    }

    public void setShipSquareId(int shipSquareId) {
        this.shipSquareId = shipSquareId;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
