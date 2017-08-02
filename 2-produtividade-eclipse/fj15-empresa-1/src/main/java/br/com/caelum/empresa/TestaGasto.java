package br.com.caelum.empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class TestaGasto {
	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1991, 2, 6);
		Funcionario funcionario = new Funcionario("Rafael", 00500, dataNascimento);
		
		Calendar dataDoCurso = Calendar.getInstance();
		Gasto gasto1 = new Gasto(1000.00, "Cursos", funcionario, dataDoCurso);
		Gasto gasto2 = new Gasto(1000.00, "Cursos", funcionario, dataDoCurso);
		Gasto gasto3 = new Gasto(1000.00, "Cursos", funcionario, dataDoCurso);
		
		System.out.println(gasto1);
		System.out.println(gasto2);
		System.out.println(gasto3);
			
	} 
}
