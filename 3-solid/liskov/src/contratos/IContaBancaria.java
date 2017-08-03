package contratos;

public interface IContaBancaria {

	public void depositar(double valor);
	
	public void sacar(double valor);
	
	public double getSaldo();
}
