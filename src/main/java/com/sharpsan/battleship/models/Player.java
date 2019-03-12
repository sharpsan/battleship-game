package com.sharpsan.battleship.models;

public class Player {

    private Fleet fleet;

    public Player() {
        initFleet();
    }

    private void initFleet() {
        this.fleet = new Fleet();
    }

    public Fleet getFleet() {
        return fleet;
    }
}
