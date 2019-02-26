package com.sharpsan.battleship.models;

import com.sharpsan.battleship.ships.Ship;

public class Fire {

    private final Square square;
    private Ship ship;
    private int shipSquareId;
    private boolean isHit;
    private boolean isPreviouslyFired;
    private boolean isSunk;

    public Fire(Square square) {
        this.square = square;
        this.setPreviouslyFired(false);
        this.setSunk(false);
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

    public boolean isPreviouslyFired() {
        return isPreviouslyFired;
    }

    public void setPreviouslyFired(boolean previouslyFired) {
        isPreviouslyFired = previouslyFired;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }
}
