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
		Map<Wette,Integer> stat = new HashMap<>();
		logger.info("Ok, laß uns wetten");
		for (int i=0; i < NUMBER; i++ ){
			Wette parm = execWette().getW1();
			stat.put(parm, (stat.get(parm)==null ? 1 : stat.get(parm)+1));
		}
		logErgebnis(stat);
	}

	/**
	 * Gibt eine Statistik über alle ausgeführten Wetten aus
	 * @param stat Map with statistics
	 */
	private void logErgebnis(Map<Wette,Integer> stat) {
		logger.info("Die Ergebnisse von " + NUMBER + " Wetten");
		for ( Map.Entry<Wette,Integer> entry : stat.entrySet()) {
			logger.info(entry.getKey() + " : " + entry.getValue()
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


