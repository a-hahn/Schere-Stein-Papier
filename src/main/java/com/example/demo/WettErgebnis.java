package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 *
 * Speichert das Ergebnis einer Wette von 2 Personen
 *
 */
public class WettErgebnis {

    private final Log logger = LogFactory.getLog(getClass());

    private final Wette w1;
    private final Wette w2;
    private final Integer comp;

    WettErgebnis(Wette w1, Wette w2, WettVergleich comp) {
        this.w1 = w1;
        this.w2 = w2;
        this.comp = comp.compare(w1, w2);
        switch (this.comp) {
            case -1 : logger.info(w1 + " verliert gegen " + w2); break;
            case 0 : logger.info("Unentschieden, beide " + w1); break;
            case 1 : logger.info(w1 + " gewinnt gegen " + w2); break;
        }
    }

    public Wette getW1() {
        return w1;
    }

    public Wette getW2() {
        return w2;
    }

    public Integer getComp() {
        return comp;
    }

}
