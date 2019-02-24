package com.sharpsan.battleship.ships;

import com.sharpsan.battleship.models.ShipName;

public class Ship {

    private final ShipName name;
    private final int size;

    private boolean[] shipSquareIds;

    public Ship(ShipName name, int size) {
        this.name = name;
        this.size = size;

        // initialize each square as false`
        shipSquareIds = new boolean[size];
    }

    public ShipName getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean hit(int squareId) {
        squareId = squareId - 1;
        if(isValidSquareId(squareId)) {
            shipSquareIds[squareId] = true;
            return true;
        } else {
            return false;
        }
    }

    public void debug() {
        System.out.println("Ship name: " + name.name());
        int index = 0;
        for (boolean square: shipSquareIds) {
            System.out.println(index + ": " + square);
            index++;
        }
        System.out.println("arr length: " + shipSquareIds.length);
    }

    private boolean isValidSquareId(int squareId) {
        if(squareId < 0) {
            return false;
        } else if(squareId >= shipSquareIds.length) {
            return false;
        } else {
            return true;
        }
    }
}
