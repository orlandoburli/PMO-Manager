package br.com.orlandoburli.pmo.tests.builders.cadastros;

import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;

public class CargoBuilder {

	public static CargoVo criaCargo(String nome) {
		CargoVo cargo = new CargoVo();
		cargo.setNome(nome);
		return cargo;
	}
	
	public static CargoVo criaCargoGerente() {
		return criaCargo("Gerente");
	}
	
	public static CargoVo criaCargoAnalista() {
		return criaCargo("Analista");
	}
	
	public static CargoVo criaCargoSecretario() {
		return criaCargo("Secretário");
	}
}
