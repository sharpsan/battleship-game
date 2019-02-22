package com.sharpsan.battleship;

import com.sharpsan.battleship.models.ShipName;
import com.sharpsan.battleship.ships.Ship;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Starting Battleship game driver...");

        Ship ship = new Ship(ShipName.BATTLESHIP, 5);
        ship.debug();
        boolean isHit = ship.hit(1);
        System.out.println("is valid hit: " + isHit);
        ship.debug();
    }
}
