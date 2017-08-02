package br.com.caelum.empresa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class FiltradorDeGastosEspeciaisTest {

	@Test
	public void deveRetornarGastosAcimaDoLimite() {
		double limiteDeGastos = 1000.00;
		
		Calendar dataNascimento = Calendar.getInstance();
		Funcionario funcionario = new Funcionario("Pedro", 100, dataNascimento);
		
		Calendar dataGasto1 = Calendar.getInstance();
		Calendar dataGasto2 = Calendar.getInstance();
		Calendar dataGasto3 = Calendar.getInstance();
		
		Gasto gasto1 = new Gasto(1000, "Taxi", funcionario, dataGasto1);
		Gasto gasto2 = new Gasto(800, "Pizza", funcionario, dataGasto2);				
		Gasto gasto3 = new Gasto(2000, "Cerveja", funcionario, dataGasto3);
		
		ArrayList<Gasto> gastos = new ArrayList<Gasto>();
		gastos.add(gasto1);
		gastos.add(gasto2);
		gastos.add(gasto3);
		
		FiltradorDeGastosEspeciais filtradorDeGastosEspeciais = new FiltradorDeGastosEspeciais(limiteDeGastos);
	
		List<Gasto> gastosFiltrados = filtradorDeGastosEspeciais.filtraGastosGrandes(gastos);
		
		assertEquals("Deve ter 1 gasto acima do limite",1, gastosFiltrados.size());
	}

}
