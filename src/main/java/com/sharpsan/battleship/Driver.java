package com.sharpsan.battleship;

import com.sharpsan.battleship.grid.Grid;
import com.sharpsan.battleship.grid.Square;
import com.sharpsan.battleship.models.Coordinates;
import com.sharpsan.battleship.models.Player;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Starting Battleship game driver...");

        Grid board = new Grid();
        Square square = board.getSquare(new Coordinates(10, 10));
        board.fire(square);
        board.debug();
        Player player1 = new Player();
    }
}
