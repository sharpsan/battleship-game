package com.sharpsan.battleship.grid;

import com.sharpsan.battleship.config.GridConfig;
import com.sharpsan.battleship.models.Coordinates;

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

    public void debug() {
        for(Square squareRow[] : squares) {
            for(Square square : squareRow) {
                System.out.println("coords: " + square.getCoordinates().getLatitude() + ", " + square.getCoordinates().getLongitude() + "; " + square.isFired());
            }
        }
    }

    // get status of square
    // return status
    public Square getSquare(Coordinates coordinates) {
        int latitude = coordinates.getArraySafeLatitude();
        int longitude = coordinates.getArraySafeLongitude();
        return squares[latitude][longitude];
    }

    // fire at a square
    // return status
    public void fire(Coordinates coordinates) {
        int latitude = coordinates.getArraySafeLatitude();
        int longitude = coordinates.getArraySafeLongitude();
        Square square = squares[latitude][longitude];
        square.setFired(true);
    }

    public void fire(Square square) {
        fire(square.getCoordinates());
    }

}
