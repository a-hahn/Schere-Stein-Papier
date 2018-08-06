package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class WettApplication {

	private final Log logger = LogFactory.getLog(getClass());

	private static final int NUMBER = 100;

	/**
	 * Führt eine einzelne Wette aus
	 * @return WettErgebnis
	 *
	 */
	private WettErgebnis execWette() {
		Wette w1 = Wette.getRandom();
		Wette w2 = Wette.PAPIER;
		return new WettErgebnis(w1, w2);
	}

	/**
	 * Führt alle Wetten aus
	 */
	private void execWetten() {
		Map<Integer,Integer> winMap = new HashMap<>();
		logger.info("Ok, laß uns wetten");
		for (int i=0; i < NUMBER; i++ ){
			WettErgebnis res = execWette();
			Integer win = res.getComp();	// -1: verloren, 0: unentschieden, 1: gewonnen
			winMap.put(win, winMap.get(win)==null ? 1 : winMap.get(win)+1);
		}
		logErgebnis(winMap);
	}

	/**
	 * Gibt eine Statistik über alle ausgeführten Wetten aus
	 * @param map Map with statistics
	 */
	private void logErgebnis(Map<Integer,Integer> map) {
		logger.info("Die Ergebnisse von " + NUMBER + " Wetten");
		for ( Map.Entry<Integer,Integer> entry : map.entrySet()) {

			String res = "";
			switch (entry.getKey()) {
				case -1: res = "Verloren"; break;
				case 1: res = "Gewonnen"; break;
				default: res = "Unentschieden" ;
			}
			logger.info(res + " : " + entry.getValue()
					+ " mal [" + Math.abs(entry.getValue()*100/NUMBER) + "%]");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(WettApplication.class, args);
	}

	@PostConstruct
		private void runIt() {
			execWetten();
	}

}


