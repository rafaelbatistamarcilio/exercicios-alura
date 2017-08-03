package coesao;

public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorCento()),
    DBA(new DezOuVintePorCento()),
    TESTER(new QuinzeOuVinteECincoPorCento());
	
	private IRegraDeCalculoDeSalario regra;

	private Cargo(IRegraDeCalculoDeSalario regra) {
		this.regra = regra;
	}

	public IRegraDeCalculoDeSalario getRegra() {
		return regra;
	}	
}
