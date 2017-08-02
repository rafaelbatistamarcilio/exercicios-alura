package br.com.caelum.empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.empresa.modelo.Funcionario;

public class Principal {
	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1991, 2, 6);
		Funcionario funcionario = new Funcionario("Rafael", 0050011107, dataNascimento);
		System.out.println(funcionario);
		
		
	}
}
