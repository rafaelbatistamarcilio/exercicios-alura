package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}
	

	@Before
	public void beforeTest() {
		this.leiloeiro = new Avaliador();
		// cenario: 3 lances em ordem crescente
		joao = new Usuario("Joao");
		jose = new Usuario("José");
		maria = new Usuario("Maria");
		System.out.println("before test");
	}
	
	@After
	public void finaliza() {
	  System.out.println("fim");
	}
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
	    Leilao leilao = new CriadorDeLeilao()
	        .para("Playstation 3 Novo")
	        .constroi();

	    leiloeiro.avalia(leilao);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
	            .lance(maria, 250.0)
	            .lance(jose, 300.0)
	            .lance(joao, 400.0)
	            .constroi();

		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {

		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
	            .lance(maria, 400.0)
	            .lance(jose, 300.0)
	            .lance(joao, 200.0)
	            .lance(jose, 100.0)
	            .constroi();

		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 100.0));

		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 100;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {

		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
	            .lance(maria, 200.0)
	            .lance(joao, 450.0)
	            .lance(jose, 120.0)
	            .lance(joao, 700.0)
	            .lance(jose, 630.0)
	            .lance(maria, 230.0)
	            .constroi();
		
		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double maiorEsperado = 700;
		double menorEsperado = 120;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveCalcularMediaDosLances() {

		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
	            .lance(maria, 200.0)
	            .lance(joao, 300.0)
	            .lance(jose, 400.0)
	            .constroi();
		
		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		double mediaEsperada = 300;

		assertEquals(mediaEsperada, leiloeiro.getMediaDosLances(), 0.0001);
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {

		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
	            .lance(joao, 200.0)
	            .constroi();

		leiloeiro.avalia(leilao);

		assertEquals(200, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(200, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao()
							.para("Playstation 3 Novo")
				            .lance(joao, 100.0)
				            .lance(maria, 200.0)
				            .lance(joao, 300.0)
				            .lance(maria, 400.0)
				            .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
        assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
	}

	@Test
	public void deveEncontrarOsDoisMaioresLances() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
	            .lance(joao, 100.0)
	            .lance(maria, 400.0)
	            .constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(2, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.0001);
		assertEquals(100.0, maiores.get(1).getValor(), 0.0001);
	}

}
