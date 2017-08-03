package ocpdip;

import contratos.IFreteService;

public class FretePadrao implements IFreteService {
	
	@Override
	public double calcularFreteParaCidade(String cidade) {
        if("SAO PAULO".equals(cidade.toUpperCase())) {
            return 15;
        }
        return 30;
	}
}
