package ocpdip;

import contratos.ITabelaDePrecosService;

public class TabelaDePrecoPadrao implements ITabelaDePrecosService{

	@Override
	public double calcularDescontoParaPreco(double preco) {
        if(preco>5000) return 0.03;
        if(preco>1000) return 0.05;
        return 0;
	}
}
