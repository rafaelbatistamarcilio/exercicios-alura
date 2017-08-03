package contratos;

/**
 * cada serviço de frete executa o calculo conforme suas regras
 * com base na cidade
 * @author rafael marcilio
 *
 */
public interface IFreteService {
	
	public double calcularFreteParaCidade(String cidade);
}
