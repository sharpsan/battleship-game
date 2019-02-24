package com.sharpsan.battleship;

import com.sharpsan.battleship.grid.Grid;
import com.sharpsan.battleship.models.Coordinates;
import com.sharpsan.battleship.models.Fire;
import com.sharpsan.battleship.models.Square;

public class Engine {

    private Grid grid;

    public Engine() {
        this.grid = new Grid();
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
        }
        return fire;
    }

    public Grid getGrid() {
        return grid;
    }

}
