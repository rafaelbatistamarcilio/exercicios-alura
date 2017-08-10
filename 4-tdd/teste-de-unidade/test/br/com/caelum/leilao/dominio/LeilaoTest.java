package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeilaoTest {
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");

		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(steveJobs, 3000));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");

		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 3000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 4000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 5000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 6000));
		leilao.propoe(new Lance(billGates, 999));
		leilao.propoe(new Lance(steveJobs, 7000));

		assertEquals(10, leilao.getLances().size());
		int ultimo = leilao.getLances().size() - 1;
		assertEquals(999, leilao.getLances().get(ultimo).getValor(), 0.00001);
	}

	@Test
	public void deveDobrarOUltimoLanceDoUsuario() {

		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");

		double ultimoLanceBillGates = 3000;
		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 3000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 4000));

		leilao.dobraUltimoLance(billGates);

		assertEquals(ultimoLanceBillGates * 2, leilao.getUltimoLanceDoUsuario(billGates).getValor(), 0.0001);
	}

	@Test
	public void deveRetornarOUltimoLanceDoUsuario() {

		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");

		double ultimoLanceBillGates = 3000;
		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 3000));
		leilao.propoe(new Lance(billGates, 3000));
		leilao.propoe(new Lance(steveJobs, 4000));

		assertEquals(ultimoLanceBillGates, leilao.getUltimoLanceDoUsuario(billGates).getValor(), 0.0001);
	}

}
