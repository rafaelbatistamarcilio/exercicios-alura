package liskov;

import contratos.IContaRentavel;

public class ContaComum implements IContaRentavel{
	
	private GerenciadorDeSaldoPadrao gerenciadorDeSaldo;
	
    public ContaComum() {
		super();
		this.gerenciadorDeSaldo = new GerenciadorDeSaldoPadrao();
	}
	
	@Override
	public double getSaldo() {
		return gerenciadorDeSaldo.getSaldo();
	}

	@Override
	public void depositar(double valor) {
		gerenciadorDeSaldo.depositar(valor);
		
	}

	@Override
	public void sacar(double valor) {
		gerenciadorDeSaldo.sacar(valor);
		
	}

	@Override
	public void render() {
		gerenciadorDeSaldo.render(1.1);		
	}    
    
}
