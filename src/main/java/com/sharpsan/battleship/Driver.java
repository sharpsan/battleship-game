package com.sharpsan.battleship;

import com.sharpsan.battleship.grid.Square;
import com.sharpsan.battleship.models.Fire;
import com.sharpsan.battleship.ships.Battleship;
import com.sharpsan.battleship.ships.Ship;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Starting Battleship game driver...\n");

        System.out.println("Loading game engine...\n");
        Engine engine = new Engine();

        System.out.println("Placing test ship on board...\n");
        Ship battleship = new Battleship();
        Square[] squares = new Square[battleship.getSize()];
        squares[0] = engine.getGrid().getSquare(1,1);
        squares[1] = engine.getGrid().getSquare(1,2);
        squares[2] = engine.getGrid().getSquare(1,3);
        squares[3] = engine.getGrid().getSquare(1,4);

        engine.getGrid().debug_placeTestShip(battleship, squares);

        System.out.println("Firing test missle...");
        Fire fire = engine.fire(1, 1);
        System.out.println("fire response:");
        System.out.println("ship coordinates: " + fire.getSquare().getCoordinates().getLatitude() + ", " + fire.getSquare().getCoordinates().getLongitude());
        System.out.println("ship hit? " + fire.isHit());
        if(fire.isHit()) {
            System.out.println("ship name: " + fire.getSquare().getShip().getName().name());
            System.out.println("ship hit on ship square: " + fire.getShipSquareId());
        }

        System.out.println("\nNew board result:");
        engine.getGrid().debug_showBoardCoords();
    }
}
