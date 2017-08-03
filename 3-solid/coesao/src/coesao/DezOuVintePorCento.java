package coesao;

public class DezOuVintePorCento implements IRegraDeCalculoDeSalario {

	@Override
	public double implementarRegra(Funcionario funcionario) {
		if (funcionario.getSalarioBase() > 3000.0) {
			return funcionario.getSalarioBase() * 0.8;
		} else {
			return funcionario.getSalarioBase() * 0.9;
		}
	}

}
