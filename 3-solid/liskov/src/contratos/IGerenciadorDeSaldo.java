package contratos;

public interface IGerenciadorDeSaldo {

	public void depositar(double valor);
	
	public void sacar(double valor);
	
	public double getSaldo();

	public void render(double taixa);
}
