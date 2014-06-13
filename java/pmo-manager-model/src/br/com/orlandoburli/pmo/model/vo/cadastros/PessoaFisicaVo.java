package br.com.orlandoburli.pmo.model.vo.cadastros;

import java.util.Calendar;

import br.com.orlandoburli.framework.core.be.validation.annotations.transformation.FilterOnly;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.Cpf;
import br.com.orlandoburli.framework.core.be.validation.annotations.validators.MaxSize;
import br.com.orlandoburli.framework.core.dao.annotations.Column;
import br.com.orlandoburli.framework.core.dao.annotations.DataType;
import br.com.orlandoburli.framework.core.dao.annotations.Join;
import br.com.orlandoburli.framework.core.dao.annotations.Table;
import br.com.orlandoburli.framework.core.vo.BaseVo;
import br.com.orlandoburli.framework.core.vo.annotations.Description;
import br.com.orlandoburli.pmo.model.utils.Dicionario;
import br.com.orlandoburli.pmo.model.utils.Dicionario.Cargo;
import br.com.orlandoburli.pmo.model.utils.Dicionario.Pessoa;
import br.com.orlandoburli.pmo.model.utils.Dicionario.PessoaJuridica;
import static br.com.orlandoburli.pmo.model.utils.Dicionario.PessoaFisica.Colunas.*;

@Table(Dicionario.PessoaFisica.TABELA_PESSOA_FISICA)
public class PessoaFisicaVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	public PessoaFisicaVo() {
		super();
		this.pessoa = new PessoaVo();
	}

	@Column(name = ID_PESSOA, dataType = DataType.INT, isKey = true)
	private Integer idPessoa;

	@Column(name = RG, maxSize = 20)
	@MaxSize(20)
	@Description("RG")
	private String rg;

	@Column(name = CPF, maxSize = 11)
	@MaxSize(11)
	@Cpf
	@FilterOnly(FilterOnly.NUMEROS)
	@Description("Cpf")
	private String cpf;

	@Column(name = DATA_NASCIMENTO, dataType = DataType.DATE)
	@Description("Data de Nascimento")
	private Calendar dataNascimento;

	@Column(name = ID_CARGO, dataType = DataType.INT)
	private Integer idCargo;

	@Column(name = ID_PESSOA_UNIDADE_ORGANIZACIONAL, dataType = DataType.INT)
	private Integer idPessoaUnidadeOrganizacional;

	@Join(columnsLocal = { ID_PESSOA }, columnsRemote = { Pessoa.Colunas.ID_PESSOA })
	private PessoaVo pessoa;

	@Join(columnsLocal = { ID_CARGO }, columnsRemote = { Cargo.Colunas.ID_CARGO })
	private CargoVo cargo;

	@Join(columnsLocal = { ID_PESSOA_UNIDADE_ORGANIZACIONAL }, columnsRemote = { PessoaJuridica.Colunas.ID_PESSOA })
	private PessoaJuridicaVo unidadeOrganizacional;

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

	public PessoaVo getPessoa() {
		if (this.pessoa == null) {
			this.pessoa = new PessoaVo();
		}
		return pessoa;
	}

	public void setPessoa(PessoaVo pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public Integer getIdPessoaUnidadeOrganizacional() {
		return idPessoaUnidadeOrganizacional;
	}

	public void setIdPessoaUnidadeOrganizacional(Integer idPessoaUnidadeOrganizacional) {
		this.idPessoaUnidadeOrganizacional = idPessoaUnidadeOrganizacional;
	}

	public CargoVo getCargo() {
		return cargo;
	}

	public void setCargo(CargoVo cargo) {
		this.cargo = cargo;
	}

	public PessoaJuridicaVo getUnidadeOrganizacional() {
		return unidadeOrganizacional;
	}

	public void setUnidadeOrganizacional(PessoaJuridicaVo unidadeOrganizacional) {
		this.unidadeOrganizacional = unidadeOrganizacional;
	}
}
