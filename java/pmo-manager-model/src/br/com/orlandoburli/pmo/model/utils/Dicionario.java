package br.com.orlandoburli.pmo.model.utils;

public final class Dicionario {

	public final class Parametro {
		public static final String TABELA_PARAMETRO = "parametro";

		public final class Colunas {
			public static final String ID_PARAMETRO = "id_parametro";
			public static final String NOME = "nome";
			public static final String VALOR = "valor";
		}
	}

	public final class Usuario {
		public static final String TABELA_USUARIO = "usuario";

		public final class Colunas {
			public static final String ID_USUARIO = "id_usuario";
			public static final String NOME = "nome";
			public static final String LOGIN = "login";
			public static final String EMAIL = "email";
			public static final String SENHA = "senha";
			public static final String ATIVO = "ativo";
			public static final String ID_PERFIL = Perfil.Colunas.ID_PERFIL;
			public static final String PATH_FOTO = "path_foto";
		}
	}

	public final class Perfil {
		public static final String TABELA_PERFIL = "perfil";

		public final class Colunas {
			public static final String ID_PERFIL = "id_perfil";
			public static final String NOME = "nome";
			public static final String ATIVO = "ativo";
		}
	}

	public final class Objeto {
		public static final String TABELA_OBJETO = "objeto";

		public final class Colunas {
			public static final String ID_OBJETO = "id_objeto";
			public static final String NOME = "nome";
			public static final String URL = "url";
		}
	}

	public final class Menu {
		public static final String TABELA_MENU = "menu";

		public final class Colunas {
			public static final String ID_MENU = "id_menu";
			public static final String NOME = "nome";
			public static final String ID_MENU_PAI = "id_menu_pai";
			public static final String ORDEM = "ordem";
			public static final String ID_OBJETO = Objeto.Colunas.ID_OBJETO;
			public static final String CLASSE = "classe";
			public static final String ID_OBJETO_SECUNDARIO = "id_objeto_secundario";
		}
	}

	public final class Pessoa {
		public static final String TABELA_PESSOA = "pessoa";

		public final class Colunas {
			public static final String ID_PESSOA = "id_pessoa";
			public static final String NOME = "nome";
			public static final String NATUREZA = "natureza";
		}
	}

	public final class PessoaFisica {
		public static final String TABELA_PESSOA_FISICA = "pessoa_fisica";

		public final class Colunas {
			public static final String ID_PESSOA = Pessoa.Colunas.ID_PESSOA;
			public static final String RG = "rg";
			public static final String CPF = "cpf";
			public static final String DATA_NASCIMENTO = "data_nascimento";
			public static final String ID_CARGO = Cargo.Colunas.ID_CARGO;
			public static final String ID_PESSOA_UNIDADE_ORGANIZACIONAL = "id_pessoa_unidade_org";
		}
	}

	public final class PessoaJuridica {
		public static final String TABELA_PESSOA_JURIDICA = "pessoa_juridica";

		public final class Colunas {
			public static final String ID_PESSOA = Pessoa.Colunas.ID_PESSOA;
			public static final String CNPJ = "cnpj";
			public static final String RAZAO_SOCIAL = "razao_social";
		}
	}

	public final class Cargo {
		public static final String TABELA_CARGO = "cargo";

		public final class Colunas {
			public static final String ID_CARGO = "id_cargo";
			public static final String NOME = "nome";
		}
	}

	public final class Projeto {
		public static final String TABELA_PROJETO = "projeto";

		public final class Colunas {
			public static final String ID_PROJETO = "id_projeto";
			public static final String NOME = "nome";
			public static final String DESCRICAO = "descricao";
			public static final String DATA_INICIAL = "data_inicial";
			public static final String DATA_FINAL = "data_final";
		}
	}

	public final class TermoAbertura {
		public static final String TABELA_TERMO_ABERTURA = "termo_abertura";
		public static final String UNIQUE_VERSAO = "unq_termo_abertura_versao";

		public final class Colunas {
			public static final String ID_TERMO = "id_termo";
			public static final String ID_PROJETO = Projeto.Colunas.ID_PROJETO;
			public static final String VERSAO = "versao";
			public static final String JUSTIFICATIVA = "justificativa";
			public static final String OBJETIVOS = "objetivos";
			public static final String DESCRICAO_PRODUTO = "descricao_produto";
			public static final String ID_PESSOA_GERENTE = "id_pessoa_gerente";
			public static final String REQUISITOS = "requisitos";
			public static final String RISCOS = "riscos";
			// TODO Acho q vai ser tabela filha
			public static final String MARCOS = "marcos";
			public static final String INVESTIMENTO = "investimento";
			public static final String PATROCINADOR = "patrocinador";
			public static final String STATUS_TERMO_ABERTURA = "status_termo_abertura";
			public static final String ID_TERMO_REFERENCIA = "id_termo_referencia";
		}
	}

	public final class TermoAberturaInteressado {
		public static final String TABELA_TERMO_ABERTURA_INTERESSADO = "termo_abertura_interessado";
		public static final String UNIQUE_TERMO_INTERESSADO_PESSOA = "unq_termo_interessado_pessoa";

		public final class Colunas {
			public static final String ID_INTERESSADO = "id_interessado";
			public static final String ID_TERMO = TermoAbertura.Colunas.ID_TERMO;
			public static final String ID_PESSOA = Pessoa.Colunas.ID_PESSOA;
			public static final String FUNCAO = "funcao";
		}
	}

	public final class TermoAberturaAprovacao {
		public static final String TABELA_TERMO_ABERTURA_APROVACAO = "termo_abertura_aprovacao";

		public final class Colunas {
			public static final String ID_TERMO = TermoAbertura.Colunas.ID_TERMO;
			public static final String ID_PESSOA = Pessoa.Colunas.ID_PESSOA;
			public static final String DATA = "data";
			public static final String FUNCAO = "funcao";
		}
	}

	public final class AnexoTermoAbertura {
		public static final String TABELA_ANEXO_TERMO_ABERTURA = "anexo_termo";

		public final class Colunas {
			public static final String ID_ANEXO_TERMO = "id_anexo_termo";
			public static final String ID_TERMO = TermoAbertura.Colunas.ID_TERMO;
			public static final String NOME_ARQUIVO = "nome_arquivo";
			public static final String ARQUIVO = "arquivo";
			public static final String EXTENSAO = "extensao";
		}
	}

	public final class SalaReuniao {
		public static final String TABELA_SALA_REUNIAO = "sala_reuniao";

		public final class Colunas {
			public static final String ID_SALA_REUNIAO = "id_sala_reuniao";
			public static final String NOME = "nome";
			public static final String ATIVO = "ativo";
		}
	}

	public final class AgendaReuniao {
		public static final String TABELA_AGENDA_REUNIAO = "agenda_reuniao";

		public final class Colunas {
			public static final String ID_AGENDA_REUNIAO = "id_agenda_reuniao";
			public static final String ID_SALA_REUNIAO = SalaReuniao.Colunas.ID_SALA_REUNIAO;
			public static final String DATA_HORA_INICIO = "data_hora_inicio";
			public static final String DATA_HORA_FIM = "data_hora_fim";
			public static final String ID_PESSOA_RESPONSAVEL = "id_pessoa_responsavel";
			public static final String ASSUNTO = "assunto";
		}
	}

	public final class ConviteReuniao {
		public static final String TABELA_CONVITE_REUNIAO = "convite_reuniao";

		public final class Colunas {
			public static final String ID_CONVITE_REUNIAO = "id_convite_reuniao";
			public static final String ID_AGENDA_REUNIAO = AgendaReuniao.Colunas.ID_AGENDA_REUNIAO;
			public static final String ID_PESSOA = PessoaFisica.Colunas.ID_PESSOA;
			public static final String CONFIRMADO = "confirmado";
		}
	}

	public final class Reuniao {
		public static final String TABELA_REUNIAO = "reuniao";

		public final class Colunas {
			public static final String ID_REUNIAO = "id_reuniao";
			public static final String ID_SALA_REUNIAO = AgendaReuniao.Colunas.ID_AGENDA_REUNIAO;
			public static final String DATA_HORA_INICIO = "data_hora_inicio";
			public static final String DATA_HORA_FIM = "data_hora_fim";
			public static final String ASSUNTO = "assunto";
		}
	}

}
