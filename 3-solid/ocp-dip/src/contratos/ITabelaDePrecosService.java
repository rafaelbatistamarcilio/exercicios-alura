package contratos;

/**
 * cada tabela de pre�os implementa seu desconto 
 * com base em suas pr�prias regras
 */
public interface ITabelaDePrecosService {
	
	public double calcularDescontoParaPreco(double preco);
}
