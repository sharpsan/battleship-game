package com.sharpsan.battleship;

import com.sharpsan.battleship.grid.Grid;
import com.sharpsan.battleship.models.Coordinates;
import com.sharpsan.battleship.models.Square;
import com.sharpsan.battleship.models.Fire;
import com.sharpsan.battleship.ships.Battleship;
import com.sharpsan.battleship.ships.Ship;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Starting Battleship game driver...\n");

        System.out.println("Loading game engine...\n");
        Engine engine = new Engine();

        System.out.println("Loading user input scanner...");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Placing test ship on board...\n");
        Ship battleship = new Battleship();
        Square[] squares = new Square[battleship.getSize()];
        squares[0] = engine.getGrid().getSquare(1,1);
        squares[1] = engine.getGrid().getSquare(1,2);
        squares[2] = engine.getGrid().getSquare(1,3);
        squares[3] = engine.getGrid().getSquare(1,4);
        engine.getGrid().debug_placeTestShip(battleship, squares);

        requestMoveInput(engine, scanner);

//        fire(engine, 1, 1);
//        fire(engine, 1,2);
//        fire(engine, 2,2);
//        System.out.println("\nNew board result:");
//        displayBoard(engine.getGrid());
    }

    private static void requestMoveInput(Engine engine, Scanner scanner) {
        System.out.print("Enter coordinates to fire [x,y]: ");
        String stringCoordinates = scanner.next();
        Coordinates coordinates = convertToCoordinates(stringCoordinates);
        if(coordinates != null) {
            fire(engine, coordinates.getLatitude(), coordinates.getLongitude());
            displayBoard(engine.getGrid());
            requestMoveInput(engine, scanner);
        } else {
            System.out.println("Error: user input is malformed.");
        }
    }

    private static Coordinates convertToCoordinates(String stringCoordinates) {
        Coordinates coordinates;
        String[] numbers = stringCoordinates.split(",");
        if(numbers.length > 2) {
            return null;
        }
        try {
            int x = Integer.valueOf(numbers[0]);
            int y = Integer.valueOf(numbers[1]);
            coordinates = new Coordinates(x, y);
            return coordinates;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static void fire(Engine engine, int latitude, int longitude) {
        System.out.println("Firing missile...");
        Fire fire = engine.fire(latitude, longitude);
        System.out.println("fire response:");
        if(fire.isPreviouslyFired()) {
            System.out.println("You already fired at position (" + latitude + ", " + longitude + ").  Try again.");
            System.out.println();
            return;
        }
        System.out.println("fired at coordinates: " + fire.getSquare().getCoordinates().getLatitude() + ", " + fire.getSquare().getCoordinates().getLongitude());
        System.out.println("ship hit? " + fire.isHit());
        if(fire.isHit()) {
            System.out.println("ship name: " + fire.getSquare().getShip().getName().name());
            System.out.println("ship hit on ship square: " + fire.getShipSquareId());
        }
        System.out.println();
    }

    private static void displayBoard(Grid grid) {
        Square[][] squares = grid.getSquares();
        int rowIndex = 1;
        int colIndex = 1;
        System.out.println("   1 2 3 4 5 6 7 8 9 10 ");
        System.out.println("   --------------------");
        for(Square[] squareRow : squares) {
            System.out.print((rowIndex < 10) ? rowIndex + " " : rowIndex);
            System.out.print("|");
            for(Square square : squareRow) {
                boolean isFired = square.isFired();
                if(isFired && square.hasShip()) {
                    System.out.print("X|");
                } else if(isFired){
                    System.out.print("-|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.println();
            rowIndex++;
        }
        System.out.println("   --------------------");
    }

    // outputs all Squares' status of Grid
    private static void debug_showGridInfo(Grid grid) {
        Square[][] squares = grid.getSquares();
        for(Square[] squareRow : squares) {
            for(Square square : squareRow) {
                System.out.print("coords: " + square.getCoordinates().getLatitude() + ", " + square.getCoordinates().getLongitude());
                boolean isFired = square.isFired();
                System.out.print("; " + isFired);
                if(isFired && square.hasShip()) {
                    System.out.println(", hit a " + square.getShip().getName() + " at position " + square.getShipSquareId());
                } else {
                    System.out.println();
                }
            }
        }
    }
}
