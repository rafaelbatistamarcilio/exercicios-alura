package encapsulamento;

import java.util.List;

/**
 * antes do refactoring, o processador de boletos dizia quando a fatura estava paga
 * agora a propria faura manipula seu estado de paga
 * @author rafael
 *
 */
public class ProcessadorDeBoletos {

    public void processa(List<Boleto> boletos, Fatura fatura) {

        for(Boleto boleto : boletos) {
        	
            Pagamento pagamento = new Pagamento(boleto.getValor(), MeioDePagamento.BOLETO);
       
            fatura.adicionarPagamento(pagamento);

        }
    }
}
