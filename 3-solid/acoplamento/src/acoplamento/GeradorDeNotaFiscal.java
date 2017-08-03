package acoplamento;

import java.util.List;

/**
 * classe implementando o padrão observer para diminuir o acoplamento
 * o objetivo é fazer com que ao inves de uma classe depender de várias outras,
 * dependa de uma definição estavel
 * @author rafael marcílio
 *
 */
public class GeradorDeNotaFiscal {
	
	private List<IGeradorDeNotaFiscalExecutor> acoes;

	public GeradorDeNotaFiscal(List<IGeradorDeNotaFiscalExecutor> acoes) {
		super();
		this.acoes = acoes;
	}

	public NotaFiscal gera(Fatura fatura) {

		double valor = fatura.getValorMensal();
		NotaFiscal notaFiscal = new NotaFiscal(valor, impostoSimplesSobreO(valor));
		this.executarAcoesAposGerarNotaFiscal(notaFiscal);
		
		return notaFiscal;
	}

	private double impostoSimplesSobreO(double valor) {
		return valor * 0.06;
	}
	
	private void executarAcoesAposGerarNotaFiscal(NotaFiscal notaFiscal ){
		
		for (IGeradorDeNotaFiscalExecutor acao : acoes) {
			acao.executarAcaoAposGerarNotaFiscal(notaFiscal);
		}
	}
	
}
