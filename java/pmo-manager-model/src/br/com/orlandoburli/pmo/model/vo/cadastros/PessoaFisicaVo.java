package br.com.orlandoburli.pmo.model.vo.cadastros;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.PessoaFisica.Colunas.*;

@Table(Dicionario.PessoaFisica.TABELA_PESSOA_FISICA)
public class PessoaFisicaVo extends BaseVo {

	@Column(name = ID_PESSOA, dataType = DataType.INT, isKey = true, isAutoIncrement = true)
	private Integer idPessoa;

	@Column(name = RG, maxSize = 20)
	@MaxSize(20)
	@Description("RG")
	private String rg;

	@Column(name = CPF, maxSize = 11)
	@Description("Cpf")
	private String cpf;

	@Column(name = DATA_NASCIMENTO, dataType = DataType.DATE)
	@Description("Data de Nascimento")
	private Calendar dataNascimento;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
