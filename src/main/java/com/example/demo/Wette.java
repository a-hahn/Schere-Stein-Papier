package com.example.demo;

import java.util.Random;

/**
 * "Schere, Stein, Papier", die 3 Möglichkeiten einer Wette
 * Erweiterte Version
 */
public enum Wette
{
    SCHERE, STEIN, PAPIER, BRUNNEN, STREICHHOLZ;

    static Wette getRandom() {
        return values()[new Random().nextInt(values().length)];
    }
}
