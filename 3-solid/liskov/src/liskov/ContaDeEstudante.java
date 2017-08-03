package liskov;

import contratos.IContaNaoRentavel;

public class ContaDeEstudante implements IContaNaoRentavel{

	private GerenciadorDeSaldoPadrao gerenciadorDeSaldoPadrao;
    private int milhas;
    
    public ContaDeEstudante() {
		super();
		this.gerenciadorDeSaldoPadrao = new GerenciadorDeSaldoPadrao();
	}

	@Override
	public double getMilhas() {
		return this.milhas;
	}

	@Override
	public void depositar(double valor) {
		gerenciadorDeSaldoPadrao.depositar(valor);
		
	}

	@Override
	public void sacar(double valor) {
		gerenciadorDeSaldoPadrao.sacar(valor);
	}

	@Override
	public double getSaldo() {
		return gerenciadorDeSaldoPadrao.getSaldo();
	}    
}