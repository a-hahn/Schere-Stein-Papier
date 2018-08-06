package com.example.demo;

import java.util.Random;

/**
 * "Schere, Stein, Papier", die 3 Möglichkeiten einer Wette
 */
public enum Wette
{
    SCHERE, STEIN, PAPIER;

    static Wette getRandom() {
        return values()[new Random().nextInt(values().length)];
    }
}
