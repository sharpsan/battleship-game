package com.sharpsan.battleship.models;

import com.sharpsan.battleship.ships.*;

public class Fleet {

    private Ship carrier, battleship, cruiser, submarine, destroyer;

    public Fleet() {
        initShips();
    }

    private void initShips() {
        this.carrier = new Carrier();
        this.battleship = new Battleship();
        this.cruiser = new Cruiser();
        this.submarine = new Submarine();
        this.destroyer = new Destroyer();
    }

    public Ship getCarrier() {
        return carrier;
    }

    public Ship getBattleship() {
        return battleship;
    }

    public Ship getCruiser() {
        return cruiser;
    }

    public Ship getSubmarine() {
        return submarine;
    }

    public Ship getDestroyer() {
        return destroyer;
    }
}
