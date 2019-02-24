package com.sharpsan.battleship;

import com.sharpsan.battleship.grid.Grid;
import com.sharpsan.battleship.models.Coordinates;
import com.sharpsan.battleship.models.Fire;

public class Engine {

    private Grid grid;

    public Engine() {
        this.grid = new Grid();
    }

    public Fire fire(int latitude, int longitude) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        Fire fire = grid.fire(coordinates);
        return fire;
    }

    public Grid getGrid() {
        return grid;
    }

}
