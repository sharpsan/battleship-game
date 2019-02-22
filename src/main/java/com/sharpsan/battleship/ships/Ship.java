package com.sharpsan.battleship.ships;

import com.sharpsan.battleship.models.ShipName;

public class Ship {

    private final ShipName name;
    private final int size;

    private boolean[] squaresIntegrity;

    public Ship(ShipName name, int size) {
        this.name = name;
        this.size = size;

        // initialize each square as false
        squaresIntegrity = new boolean[size];
    }

    public ShipName getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean hit(int square) {
        square = square - 1;
        if(isValidSquare(square)) {
            squaresIntegrity[square] = true;
            return true;
        } else {
            return false;
        }
    }

    public void debug() {
        System.out.println("Ship name: " + name.name());
        int index = 0;
        for (boolean square: squaresIntegrity) {
            System.out.println(index + ": " + square);
            index++;
        }
        System.out.println("arr length: " + squaresIntegrity.length);
    }

    private boolean isValidSquare(int square) {
        if(square < 0) {
            return false;
        } else if(square >= squaresIntegrity.length) {
            return false;
        } else {
            return true;
        }
    }
}
