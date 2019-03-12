package com.sharpsan.battleship.utils;

import java.util.Random;

public class CoinToss {

    public enum Coin { HEADS, TAILS }

    public CoinToss() { }

    public Coin flip() {
        Random randomGenerator = new Random();
        int tossResults = randomGenerator.nextInt(2);
        if(tossResults == 1) {
            return Coin.HEADS;
        } else {
            return Coin.TAILS;
        }
    }
}
