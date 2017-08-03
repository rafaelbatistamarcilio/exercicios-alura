package liskov;

import contratos.IGerenciadorDeSaldo;

public class GerenciadorDeSaldoPadrao implements IGerenciadorDeSaldo{
	
	protected double saldo;

    @Override
    public double getSaldo() {
        return saldo;
    }

	@Override
	public void depositar(double valor) {
        this.saldo += valor;
		
	}

	@Override
	public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            throw new IllegalArgumentException();
        }		
	}

	@Override
	public void render(double taxa) {
        this.saldo *= taxa;
		
	}
}
