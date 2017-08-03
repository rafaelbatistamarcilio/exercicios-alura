package liskov;

import java.util.Arrays;
import java.util.List;

public class ProcessadorDeInvestimentos {
	public static void main(String[] args) {

		contasDoBanco().forEach(conta -> {
			conta.render();
			System.out.println("Novo Saldo:");
			System.out.println(conta.getSaldo());
		});		
	}

	private static List<ContaComum> contasDoBanco() {
		return Arrays.asList(umaContaCom(100), umaContaCom(150));
	}

	private static ContaComum umaContaCom(double valor) {
		ContaComum c = new ContaComum();
		c.depositar(valor);
		return c;
	}
}
