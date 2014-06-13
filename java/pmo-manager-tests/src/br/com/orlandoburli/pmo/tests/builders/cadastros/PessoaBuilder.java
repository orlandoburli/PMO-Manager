package br.com.orlandoburli.pmo.tests.builders.cadastros;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.framework.core.utils.Utils;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaJuridicaVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaVo;
import br.com.orlandoburli.pmo.model.vo.domains.Natureza;

public final class PessoaBuilder {

	public static PessoaVo criaPessoa(String nome, String natureza) {
		PessoaVo pessoa = new PessoaVo();

		pessoa.setNome(nome);
		pessoa.setNatureza(natureza);

		return pessoa;
	}

	public static PessoaFisicaVo criaPessoaFisica(PessoaVo pessoa, String rg, String cpf, String dataNascimento, CargoVo cargo) {
		PessoaFisicaVo pf = new PessoaFisicaVo();
		pf.setCpf(cpf);
		pf.setRg(rg);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			pf.setDataNascimento(Utils.dateToCalendar(sdf.parse(dataNascimento)));
		} catch (ParseException | NullPointerException e) {
			Log.error(e);
		}

		if (pessoa != null) {
			pf.setPessoa(pessoa);
			pf.setIdPessoa(pessoa.getIdPessoa());
		}

		if (cargo != null) {
			pf.setIdCargo(cargo.getIdCargo());
			pf.setCargo(cargo);
		}

		return pf;
	}

	public static PessoaJuridicaVo criaPessoaJuridica(PessoaVo pessoa, String cnpj, String razaoSocial) {
		PessoaJuridicaVo pj = new PessoaJuridicaVo();

		pj.setCnpj(cnpj);
		pj.setRazaoSocial(razaoSocial);

		if (pessoa != null) {
			pj.setPessoa(pessoa);
			pj.setIdPessoa(pessoa.getIdPessoa());
		}

		return pj;
	}

	public static PessoaVo criaPessoaOrlando() {
		return criaPessoa("Orlando Burli Junior", Natureza.FISICA);
	}

	public static PessoaVo criaPessoaAndreCruz() {
		return criaPessoa("André Luiz Costa Cruz", Natureza.FISICA);
	}
	
	public static PessoaVo criaPessoaNatalina() {
		return criaPessoa("Natalina Hinamori", Natureza.FISICA);
	}

	public static PessoaVo criaPessoaAbaco() {
		return criaPessoa("Abaco Tecnologia", Natureza.JURIDICA);
	}

	public static PessoaVo criaPessoaTCE() {
		return criaPessoa("TCE-MT", Natureza.JURIDICA);
	}

	public static PessoaFisicaVo criaPfOrlando(PessoaVo pessoa, CargoVo cargo) {
		return criaPessoaFisica(pessoa, "1296573-1", "70289018153", "13/02/1981", cargo);
	}
	
	public static PessoaFisicaVo criaPfAndreCruz(PessoaVo pessoa, CargoVo cargo) {
		return criaPessoaFisica(pessoa, "23344545", "837.125.876-35", "15/10/1972", cargo);
	}
	
	public static PessoaFisicaVo criaPfNatalina(PessoaVo pessoa, CargoVo cargo) {
		return criaPessoaFisica(pessoa, "223232312", "275.624.761-87", "18/09/1973", cargo);
	}

	public static PessoaJuridicaVo criaPjAbaco(PessoaVo pessoa) {
		return criaPessoaJuridica(pessoa, "85.827.928/0001-05", "Ábaco Tecnologia da Informação LTDA.");
	}

	public static PessoaJuridicaVo criaPjTCE(PessoaVo pessoa) {
		return criaPessoaJuridica(pessoa, "43.394.668/0001-73", "Tribunal de Contas do Estado de Mato Grosso");
	}

}
