package com.sharpsan.battleship;

import com.sharpsan.battleship.config.GridConfig;
import com.sharpsan.battleship.grid.Grid;
import com.sharpsan.battleship.models.Coordinates;
import com.sharpsan.battleship.models.Fire;
import com.sharpsan.battleship.models.Square;
import com.sharpsan.battleship.ships.*;
import com.sharpsan.battleship.utils.CoinToss;

import java.util.Random;

public class Engine {

    private Grid grid;
    private final Ship battleship, carrier, cruiser, destroyer, submarine;

    public Engine() {
        this.grid = new Grid();
        this.battleship = new Battleship();
        this.carrier = new Carrier();
        this.cruiser = new Cruiser();
        this.destroyer = new Destroyer();
        this.submarine = new Submarine();
    }

    public Fire fire(int latitude, int longitude) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        Square square = getGrid().getSquare(coordinates);
        Fire fire;
        if(square.isFired()) {
            fire = new Fire(square);
            fire.setPreviouslyFired(true);
        } else {
            fire = grid.fire(coordinates);
            if(square.getShip() != null && square.getShip().isSunk()) {
                fire.setSunk(true);
            }
        }
        return fire;
    }

    public void randomlyDeployFleet() {
        randomlyDeployShip(new Battleship());
        randomlyDeployShip(new Carrier());
        randomlyDeployShip(new Cruiser());
        randomlyDeployShip(new Destroyer());
        randomlyDeployShip(new Submarine());
    }

    public Square[] randomlyDeployShip(Ship ship) {
        Coordinates newCoordinatesSeed = generateCoordinateSeed();
        int x = newCoordinatesSeed.getLatitude();
        int y = newCoordinatesSeed.getLongitude();
        // check if seed coordinates already has a ship, restart
        if(getGrid().getSquare(newCoordinatesSeed).hasShip()) {
            // seed failed, restart
            return randomlyDeployShip(ship);
        }
        // flip a coin, place ship vertically or horizontally
        CoinToss coinToss = new CoinToss();
        CoinToss.Coin tossResults = coinToss.flip();
        // check if ship will fit, restart
        if(tossResults.equals(CoinToss.Coin.HEADS)) {
            if((x + (ship.getSize() - 1)) > (GridConfig.GRID_HORIZONTAL_NUM_SQUARES - 1)) {
                return randomlyDeployShip(ship);
            }
        } else {
            if((y + (ship.getSize() - 1)) > (GridConfig.GRID_VERTICAL_NUM_SQUARES - 1)) {
                return randomlyDeployShip(ship);
            }
        }
        Square[] squares = new Square[ship.getSize()];
        int i = 0;
        while(i < ship.getSize()) {
            if(tossResults.equals(CoinToss.Coin.HEADS)) {
                // place ship vertically on board
                x++;

            } else {
                // place ship horizontally on board
                y++;
            }
            if(getGrid().getSquare(x, y).hasShip()) {
                // coordinates along path already has ship, restart
                return randomlyDeployShip(ship);
            }
            squares[i] = getGrid().getSquare(x, y);
            i++;
        }
        getGrid().debug_placeTestShip(ship, squares);
        return squares;
    }

    private Coordinates generateCoordinateSeed() {
        Random randomGenerator = new Random();
        int xRandom = randomGenerator.nextInt((GridConfig.GRID_HORIZONTAL_NUM_SQUARES - 1) + 1) + 1;
        int yRandom = randomGenerator.nextInt((GridConfig.GRID_VERTICAL_NUM_SQUARES - 1) + 1) + 1;
        return new Coordinates(xRandom, yRandom);
    }

    public Grid getGrid() {
        return grid;
    }

    public Ship getBattleship() {
        return battleship;
    }

    public Ship getCarrier() {
        return carrier;
    }

    public Ship getCruiser() {
        return cruiser;
    }

    public Ship getDestroyer() {
        return destroyer;
    }

    public Ship getSubmarine() {
        return submarine;
    }
}
