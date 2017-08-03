package acoplamento;


public interface IGeradorDeNotaFiscalExecutor {

	/**
	 * a��o a ser executada ap�s gerar uma nota fiscal
	 * @param notaFiscal
	 */
	public void executarAcaoAposGerarNotaFiscal(NotaFiscal notaFiscal);
}
