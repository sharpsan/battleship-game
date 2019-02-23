package com.sharpsan.battleship.grid;

import com.sharpsan.battleship.models.Coordinates;

// returns information pertaining to a square
// such as if it has been fired upon, and what
// ship lies on the square, and the ship's square
// square that lies on the board square
public class Square {

    private final int id;
    private final Coordinates coordinates; //TODO: this should be a reflection of what the board says the squares' coords are
    private boolean isFired;

    public Square(int id, Coordinates coordinates) {
        this.id = id;
        this.coordinates = coordinates;
        this.isFired = false;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getId() {
        return id;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }
}
