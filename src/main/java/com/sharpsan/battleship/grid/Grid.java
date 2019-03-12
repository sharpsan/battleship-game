package com.sharpsan.battleship.grid;

import com.sharpsan.battleship.config.GridConfig;
import com.sharpsan.battleship.models.Coordinates;
import com.sharpsan.battleship.models.Fire;
import com.sharpsan.battleship.models.Square;
import com.sharpsan.battleship.ships.Ship;

public class Grid {

    private Square[][] squares;

    public Grid() {
        initSquares();
    }

    // place [enemy] ships on board
    //TODO

    // populate grid squares
    public void initSquares() {
        int numOfRows = GridConfig.GRID_VERTICAL_NUM_SQUARES;
        int numOfCols = GridConfig.GRID_HORIZONTAL_NUM_SQUARES;
        int numOfSquares = numOfRows * numOfCols;
        squares = new Square[numOfRows][numOfCols];

        int rowIndex = 0;
        int colIndex = 0;
        int squareIndex = 1;
        for(Square[] squareRows : squares) {
            for(Square square : squareRows) {
                int latitude = rowIndex + 1;
                int longitude = colIndex + 1;
                Coordinates coordinates = new Coordinates(latitude, longitude);
                square = new Square(squareIndex, coordinates);
                squares[rowIndex][colIndex] = square;
                if(colIndex == (numOfCols - 1)) {
                    colIndex = 0;
                } else {
                    colIndex++;
                }
                squareIndex++;
            }
            rowIndex++;
        }
        /*int rowIndex = 0;
        int colIndex = 0;
        int squareIndex = 1;
        while(squareIndex <= numOfSquares) {
            int latitude = rowIndex + 1;
            int longitude = colIndex + 1;
            Coordinates coordinate = new Coordinates(latitude, longitude);
            Square square = new Square(coordinate);
            squares[rowIndex][colIndex] = square;
            // handle index counters
            if(colIndex == (numOfCols - 1)) {
                colIndex = 0;
                rowIndex++;
            } else {
                colIndex++;
            }
            squareIndex++;
        }*/
    }

    public void debug_placeTestShip(Ship ship, Square[] squares) {
        int shipSquareIdIndex = 1;
        for(Square square : squares) {
            square.placeShipSquare(ship, shipSquareIdIndex);
            shipSquareIdIndex++;
        }
    }


    // get status of square
    // return status
    public Square getSquare(Coordinates coordinates) {
        int latitude = coordinates.getArraySafeLatitude();
        int longitude = coordinates.getArraySafeLongitude();
        return squares[latitude][longitude];
    }

    public Square getSquare(int latitude, int longitude) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        return getSquare(coordinates);
    }

    public Square[][] getSquares() {
        return squares;
    }

    public Fire fire(Coordinates coordinates) {
        Square square = getSquare(coordinates);
        square.setFired(true);
        Fire fire = new Fire(square);
        if(square.hasShip()) {
            int shipSquareId = square.getShipSquareId();
            Ship ship = square.getShip();
            ship.hit(shipSquareId);
            fire.setShip(ship);
            fire.setShipSquareId(shipSquareId);
            fire.setHit(true);
        } else {
            fire.setHit(false);
        }
        return fire;
    }

}
