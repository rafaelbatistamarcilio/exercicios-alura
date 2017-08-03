package acoplamento;


public interface IGeradorDeNotaFiscalExecutor {

	/**
	 * ação a ser executada após gerar uma nota fiscal
	 * @param notaFiscal
	 */
	public void executarAcaoAposGerarNotaFiscal(NotaFiscal notaFiscal);
}
