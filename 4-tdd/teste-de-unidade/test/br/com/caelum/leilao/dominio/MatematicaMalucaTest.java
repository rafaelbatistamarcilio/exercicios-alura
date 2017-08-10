package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
	public void deveRetornarNumeroVezesQuatro() {
		int numero =40;
		
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		
		assertEquals(40*4, matematicaMaluca.contaMaluca(numero));
	}
	
	@Test
	public void deveRetornarNumeroVezesTres() {
		int numero =20;
		
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		
		assertEquals(20*3, matematicaMaluca.contaMaluca(numero));
	}
	
	@Test
	public void deveRetornarNumeroVezesDois() {
		int numero =5;
		
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		
		assertEquals(5*2, matematicaMaluca.contaMaluca(numero));
	}

}
