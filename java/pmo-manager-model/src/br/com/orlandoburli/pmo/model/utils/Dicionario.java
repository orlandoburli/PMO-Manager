package br.com.orlandoburli.pmo.model.utils;

public final class Dicionario {

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
		}
	}
}
