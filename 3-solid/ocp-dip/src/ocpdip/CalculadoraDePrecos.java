package ocpdip;

import contratos.IFreteService;
import contratos.ITabelaDePrecosService;

public class CalculadoraDePrecos {

	private ITabelaDePrecosService tabela;
	private IFreteService freteService;
		
	public CalculadoraDePrecos(ITabelaDePrecosService tabela, IFreteService freteService) {
		super();
		this.tabela = tabela;
		this.freteService = freteService;
	}

	public double calcula(Compra compra) {

        double desconto = tabela.calcularDescontoParaPreco(compra.getValor());
        double frete = freteService.calcularFreteParaCidade(compra.getCidade());

        return compra.getValor() * (1-desconto) + frete;
    }
}
