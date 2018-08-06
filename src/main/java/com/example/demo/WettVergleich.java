package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class WettVergleich implements Comparator<Wette> {

    private Map<Wette,List<Wette>> wins = new HashMap<>();

    @PostConstruct
    private void init(){
        List<Wette> steinGewinnt = new ArrayList<>();
        steinGewinnt.add(Wette.SCHERE);
        steinGewinnt.add(Wette.STREICHHOLZ);
        wins.put(Wette.STEIN, steinGewinnt);

        List<Wette> schereGewinnt = new ArrayList<>();
        schereGewinnt.add(Wette.PAPIER);
        schereGewinnt.add(Wette.STREICHHOLZ);
        wins.put(Wette.SCHERE, schereGewinnt);

        List<Wette> papierGewinnt = new ArrayList<>();
        papierGewinnt.add(Wette.STEIN);
        papierGewinnt.add(Wette.BRUNNEN);
        wins.put(Wette.PAPIER, papierGewinnt);

        List<Wette> brunnenGewinnt = new ArrayList<>();
        brunnenGewinnt.add(Wette.STEIN);
        brunnenGewinnt.add(Wette.SCHERE);
        wins.put(Wette.BRUNNEN, brunnenGewinnt);

        List<Wette> streichholzGewinnt = new ArrayList<>();
        streichholzGewinnt.add(Wette.PAPIER);
        streichholzGewinnt.add(Wette.BRUNNEN);
        wins.put(Wette.STREICHHOLZ, streichholzGewinnt);

    }

    @Override
    public int compare(Wette o1, Wette o2) {
        if (o1==o2) return 0;
        return wins.get(o1).contains(o2) ? 1 : -1;
    }
}
