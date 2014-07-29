package br.com.orlandoburli.pmo.model.be.acesso;

import br.com.orlandoburli.framework.core.be.BaseBe;
import br.com.orlandoburli.framework.core.be.exceptions.BeException;
import br.com.orlandoburli.framework.core.be.exceptions.persistence.InsertBeException;
import br.com.orlandoburli.framework.core.dao.DAOManager;
import br.com.orlandoburli.pmo.model.dao.acesso.ObjetoDao;
import br.com.orlandoburli.pmo.model.utils.PMOConstants;
import br.com.orlandoburli.pmo.model.vo.acesso.ObjetoVo;
import br.com.orlandoburli.pmo.model.vo.acesso.PerfilVo;
import br.com.orlandoburli.pmo.model.vo.acesso.UsuarioVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.CargoVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaFisicaVo;
import br.com.orlandoburli.pmo.model.vo.cadastros.PessoaJuridicaVo;
import br.com.orlandoburli.pmo.model.vo.domains.SimNao;
import br.com.orlandoburli.pmo.model.vo.projetos.ProjetoVo;
import br.com.orlandoburli.pmo.model.vo.projetos.TermoAberturaVo;
import br.com.orlandoburli.pmo.model.vo.utils.ParametroVo;

public class ObjetoBe extends BaseBe<ObjetoVo, ObjetoDao> {

	public ObjetoBe(DAOManager manager) {
		super(manager);
	}

	@Override
	public void doBeforeInsert(ObjetoVo vo) throws BeException {
		super.doBeforeInsert(vo);

		if (get(vo) != null) {
			throw new InsertBeException("Objeto com o Id " + vo.getIdObjeto() + " já cadastrado!", "idObjeto");
		}
	}

	public void inicializarObjetos() throws BeException {
		// Objetos Padrao - Cadastro / Consulta
		// Acesso
		criaPadraoVo(PerfilVo.class, "Perfis de Acesso", PMOConstants.Objeto.PERFIL_CONSULTA, PMOConstants.Objeto.PERFIL_CADASTRO);
		criaPadraoVo(UsuarioVo.class, "Usuários", PMOConstants.Objeto.USUARIO_CONSULTA, PMOConstants.Objeto.USUARIO_CADASTRO);
		criaPadraoVo(ParametroVo.class, "Parâmetros", PMOConstants.Objeto.PARAMETRO_CONSULTA, PMOConstants.Objeto.PARAMETRO_CADASTRO);

		// Cadastros
		criaPadraoVo(PessoaFisicaVo.class, "Pessoas Físicas", PMOConstants.Objeto.PESSOA_FISICA_CONSULTA, PMOConstants.Objeto.PESSOA_FISICA_CADASTRO);
		criaPadraoVo(PessoaJuridicaVo.class, "Pessoas Jurídicas", PMOConstants.Objeto.PESSOA_JURIDICA_CONSULTA, PMOConstants.Objeto.PESSOA_JURIDICA_CADASTRO);
		criaPadraoVo(CargoVo.class, "Cargos", PMOConstants.Objeto.CARGO_CONSULTA, PMOConstants.Objeto.CARGO_CADASTRO);

		// Projetos
		criaPadraoVo(ProjetoVo.class, "Projetos", PMOConstants.Objeto.PROJETO_CONSULTA, PMOConstants.Objeto.PROJETO_CADASTRO);
		criaPadraoVo(TermoAberturaVo.class, "Termo de Abertura", PMOConstants.Objeto.TERMO_ABERTURA_CONSULTA, PMOConstants.Objeto.TERMO_ABERTURA_CADASTRO);

		// Demais objetos
		saveIfNotExists(criaObjeto(PMOConstants.Objeto.PAINEL, "Painel", "painel.action", true));
	}

	public void criaPadraoVo(Class<?> vo, String descricao, Integer idConsulta, Integer idCadastro) throws BeException {
		String voname = vo.getSimpleName().replace("Vo", "").toLowerCase();
		saveIfNotExists(criaObjeto(idConsulta, "Consulta de " + descricao, voname + "consulta.action", false));
		saveIfNotExists(criaObjeto(idCadastro, "Cadastro de " + descricao, voname + "cadastro.action", false));
	}

	public void saveIfNotExists(ObjetoVo objeto) throws BeException {
		if (get(objeto) != null) {
			objeto.setNew(false);
		}
		save(objeto);
	}

	public ObjetoVo criaObjeto(Integer idObjeto, String nome, String url, boolean autoStart) {
		ObjetoVo objeto = new ObjetoVo();
		objeto.setIdObjeto(idObjeto);
		objeto.setNome(nome);
		objeto.setUrl(url);
		objeto.setAutoStart(autoStart ? SimNao.SIM : SimNao.NAO);
		return objeto;
	}

}
