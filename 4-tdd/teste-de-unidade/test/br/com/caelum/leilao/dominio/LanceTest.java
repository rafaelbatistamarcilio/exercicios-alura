package br.com.caelum.leilao.dominio;


import org.junit.Test;

public class LanceTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirLancesComValorMenorQueZero() {
		Usuario usuario = new Usuario("pedro");
		Lance lance = new Lance(usuario , -3.0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirLancesComValorIgualAZero() {
		Usuario usuario = new Usuario("pedro");
		Lance lance = new Lance(usuario , 0.0);
	}

}
