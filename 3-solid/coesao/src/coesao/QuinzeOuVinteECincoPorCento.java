package coesao;

public class QuinzeOuVinteECincoPorCento implements IRegraDeCalculoDeSalario {

	@Override
	public double implementarRegra(Funcionario funcionario) {
		if (funcionario.getSalarioBase() > 2000.0) {
			return funcionario.getSalarioBase() * 0.75;
		} else {
			return funcionario.getSalarioBase() * 0.85;
		}
	}

}
