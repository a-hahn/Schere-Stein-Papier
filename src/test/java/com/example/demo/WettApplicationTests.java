package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WettApplicationTests {

	@Resource
	WettVergleich comp;

	@Test
	public void papierSchlägtStein() {
		WettErgebnis res = new WettErgebnis(Wette.PAPIER,Wette.STEIN, comp);
		Assert.isTrue(res.getComp()==1,"Papier schlägt Stein");
	}

	@Test
	public void keinerGewinnt() {
		WettErgebnis res = new WettErgebnis(Wette.SCHERE,Wette.SCHERE, comp);
		Assert.isTrue(res.getComp()==0,"Keiner gewinnt");
	}

	@Test
	public void schereVerliert() {
		WettErgebnis res = new WettErgebnis(Wette.SCHERE,Wette.STEIN, comp);
		Assert.isTrue(res.getComp()==-1,"Schere verliert");
	}
}
