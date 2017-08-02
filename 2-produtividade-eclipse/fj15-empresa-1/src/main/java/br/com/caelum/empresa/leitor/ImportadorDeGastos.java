package br.com.caelum.empresa.leitor;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class ImportadorDeGastos {

	private SimpleDateFormat dateFormater = new SimpleDateFormat("ddMMyyyy");
	
	public List<Gasto> importa(InputStream entrada) throws ParseException
	{
		Scanner leitor = new Scanner(entrada);
		List<Gasto> gastos = new ArrayList<Gasto>();       
	
		while (leitor.hasNextLine())    {
			
			String line = leitor.nextLine();
			String tipoDeGasto = line.substring(0, 6);
			String dataDoGastoTxt = line.substring(6, 14);
			String valorDoGastoTxt = line.substring(14, 23);
			String matriculaDoFoncionarioTxt = line.substring(23,26);
			String nomeDoFuncionatio = line.substring(26,56);
			String dataNascimentoDoFuncionarioTxt = line.substring(56);
			
			double valor = Double.parseDouble(valorDoGastoTxt);
			int matricula = Integer.parseInt(matriculaDoFoncionarioTxt);
			Calendar dataNascimento = converteDataTxtParaCalendar(dataNascimentoDoFuncionarioTxt);			
			Calendar dataDespesa = converteDataTxtParaCalendar(dataDoGastoTxt);
			Funcionario funcionario = new Funcionario(nomeDoFuncionatio, matricula, dataNascimento);
			
			gastos.add(new Gasto(valor,tipoDeGasto,funcionario,dataDespesa));}
		
		return gastos;
	}

	private Calendar converteDataTxtParaCalendar(String dataNascimentoDoFuncionarioTxt) throws ParseException {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(dateFormater.parse(dataNascimentoDoFuncionarioTxt));
		return dataNascimento;
	}
}