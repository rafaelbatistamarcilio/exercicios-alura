package contratos;

/**
 * cada tabela de preços implementa seu desconto 
 * com base em suas próprias regras
 */
public interface ITabelaDePrecosService {
	
	public double calcularDescontoParaPreco(double preco);
}
