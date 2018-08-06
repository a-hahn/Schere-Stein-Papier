package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Comparator;

/**
 *
 * Vergleicht 2 Wetten miteinander
 *
 */
public class WettErgebnis implements Comparator<Wette> {

    private final Log logger = LogFactory.getLog(getClass());

    private final Wette w1;
    private final Wette w2;
    private final Integer comp;

    WettErgebnis(Wette w1, Wette w2) {
        this.w1 = w1;
        this.w2 = w2;
        this.comp = compare(w1, w2);
        switch (comp) {
            case -1 : logger.info(w1 + " verliert gegen " + w2); break;
            case 0 : logger.info("Unentschieden, beide " + w1); break;
            case 1 : logger.info(w1 + " gewinnt gegen " + w2); break;
        }
    }

    @Override
    public int compare(Wette o1, Wette o2) {
        if (o1 == o2) return 0;
        switch (o1) {
            case PAPIER:
                return o2 == Wette.STEIN ? 1 : -1;
            case SCHERE:
                return o2 == Wette.PAPIER ? 1 : -1;
            default:
                return o2 == Wette.SCHERE ? 1 : -1;
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
