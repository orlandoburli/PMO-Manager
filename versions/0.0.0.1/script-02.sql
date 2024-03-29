/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v6.1.0                     */
/* Target DBMS:           PostgreSQL 8.3                                  */
/* Project file:          db-model.dez                                    */
/* Project name:          PMO-Manager                                     */
/* Author:                Orlando Burli / André Cruz                      */
/* Script type:           Alter database script                           */
/* Created on:            2013-11-21 15:30                                */
/* ---------------------------------------------------------------------- */

COMMENT ON TABLE public.usuario IS 'Tabela de usuários do sistema.';
COMMENT ON COLUMN public.usuario.id_usuario IS 'ID do usuário, sequencial. Sequence ID_USUARIO_SEQ.';
COMMENT ON COLUMN public.usuario.nome_usuario IS 'Nome do Usuário.';
COMMENT ON COLUMN public.usuario.email_usuario IS 'Email do usuário, será usado como login.';
COMMENT ON COLUMN public.usuario.senha_usuario IS 'Senha do usuário, criptografada em SHA-1.';
COMMENT ON COLUMN public.usuario.status_usuario IS 'Status do usuário, podendo assumir os valores: A - Ativo I - Inativo E - Excluído';
COMMENT ON COLUMN public.perfil.nome_perfil IS 'Nome do perfil, exibido para o usuário.';
COMMENT ON COLUMN public.perfil.status_perfil IS 'Status do perfil, pode assumir os valores: A - Ativo I - Inativo E - Excluído';
COMMENT ON TABLE public.usuario_perfil IS 'Tabela que vincula os perfis do usuário. Pode ser mais de um.';
COMMENT ON COLUMN public.usuario_perfil.id_usuario_perfil IS 'ID de vínculo de usuario/perfil, sequence ID_USUARIO_PERFIL_SEQ.';
COMMENT ON TABLE public.objeto IS 'Tabela de Objetos do sistema. Exemplo: Cadastro de Empresas, Consulta de Empresas, Cadastro de Clientes, Relatório de Faturamento, etc.';
COMMENT ON COLUMN public.objeto.id_objeto IS 'Id do Objeto. Não sequencial, ID''s definidos pela manutenção do sistema.';
COMMENT ON COLUMN public.objeto.nome_objeto IS 'Nome do Objeto, identificador do mesmo no sistema. Somente minúsculas, sem espaços ou acentos.';
COMMENT ON COLUMN public.objeto.descricao_objeto IS 'Descrição do Objeto, exibido ao usuário.';
COMMENT ON TABLE public.acao IS 'Tabela pré-cadastrada de ações do sistema, como consultar, visualizar, editar, excluir, incluir, etc.';
COMMENT ON COLUMN public.acao.id_acao IS 'ID da ação, sequencial.';
COMMENT ON COLUMN public.acao.descricao_acao IS 'Descrição da ação, valor que será exibido ao usuário.';
COMMENT ON COLUMN public.acao.chave_acao IS 'String identificadora da ação. Maiusculas e sem espaços/acentos.';
COMMENT ON TABLE public.objeto_acao IS 'Vínculo da ação com o Objeto do Sistema. Para cada ação que o objeto tiver, deve ser criado um vínculo nesta tabela.';
COMMENT ON TABLE public.perfil_objeto IS 'Tabela de vinculo entre perfil e objeto, trata das permissões do usuário no sistema, em quais objetos ele tem acesso.';

/* ---------------------------------------------------------------------- */
/* Add table "versao"                                                     */
/* ---------------------------------------------------------------------- */
CREATE TABLE public.versao (
    id_versao INTEGER  NOT NULL,
    numero_versao CHARACTER VARYING(50),
    data_disponivel_versao DATE,
    data_checagem_versao DATE,
    status_versao CHARACTER VARYING(40),
    data_download_versao DATE,
    data_execucao_scripts DATE,
    data_atualizacao_app DATE,
    data_finalizacao_versao DATE,
    notas_versao TEXT,
    CONSTRAINT pk_versao PRIMARY KEY (id_versao)
);
COMMENT ON TABLE public.versao IS 'Tabela de versões do sistema. Todas as versões do sistema, a partir da instalação, devem constar aqui.';
COMMENT ON COLUMN public.versao.id_versao IS 'ID da versão, sequence ID_VERSAO_SEQ.';
COMMENT ON COLUMN public.versao.numero_versao IS 'Número da versão, no formato X.X.X.X.';
COMMENT ON COLUMN public.versao.data_disponivel_versao IS 'Data em que a versão ficou disponível.';
COMMENT ON COLUMN public.versao.data_checagem_versao IS 'Data/hora de checagem desta versão.';
COMMENT ON COLUMN public.versao.status_versao IS 'Status da versão, podendo assumir os valores: 1 - Em breve disponivel 2 - Disponível 3 - Baixando / Download da versão em progresso 4 - Executando Scripts / BD 5 - Atualizando aplicativo 91 - Erro download 92 - Erro execução scripts 93 - Erro atualização app 99 - Atualizada ';
COMMENT ON COLUMN public.versao.data_download_versao IS 'Data/Hora do término do download da versão';
COMMENT ON COLUMN public.versao.data_execucao_scripts IS 'Data/Hora do término da execução de scripts';
COMMENT ON COLUMN public.versao.data_atualizacao_app IS 'Data/Hora do término da atualização da app.';
COMMENT ON COLUMN public.versao.data_finalizacao_versao IS 'Data/Hora do término da atualização da aplicação.';
COMMENT ON COLUMN public.versao.notas_versao IS 'Notas da versão, informações de correções, etc.';

/* ---------------------------------------------------------------------- */
/* Add table "check_versao"                                               */
/* ---------------------------------------------------------------------- */
CREATE TABLE public.check_versao (
    id_check_versao INTEGER  NOT NULL,
    data_hora_check DATE,
    status_check CHARACTER(1),
    CONSTRAINT pk_check_versao PRIMARY KEY (id_check_versao)
);
COMMENT ON TABLE public.check_versao IS 'Tabela de Controla as checagens de versão.';
COMMENT ON COLUMN public.check_versao.id_check_versao IS 'ID do check de versão. A sequence ID_CHECK_VERSAO_SEQ será usada.';
COMMENT ON COLUMN public.check_versao.data_hora_check IS 'Data/Hora do check de versão.';
COMMENT ON COLUMN public.check_versao.status_check IS 'Status do check de versão. Valores utilizados: N - Versão não encontrada. V - Versão encontrada F - Falha na checagem da versão.';

/* ---------------------------------------------------------------------- */
/* Add table "perfil_objeto_acao"                                         */
/* ---------------------------------------------------------------------- */
CREATE TABLE public.perfil_objeto_acao (
    id_perfil_objeto_acao INTEGER  NOT NULL,
    id_perfil INTEGER  NOT NULL,
    id_objeto_acao INTEGER  NOT NULL,
    CONSTRAINT pk_perfil_objeto_acao PRIMARY KEY (id_perfil_objeto_acao)
);
COMMENT ON TABLE public.perfil_objeto_acao IS 'Tabela de vinculo do perfil com as ações do objeto do sistema.';
COMMENT ON COLUMN public.perfil_objeto_acao.id_perfil_objeto_acao IS 'ID do vínculo, sequence ID_PERFIL_OBJETO_ACAO_SEQ.';
COMMENT ON COLUMN public.perfil_objeto_acao.id_perfil IS 'Referencia do perfil.';
COMMENT ON COLUMN public.perfil_objeto_acao.id_objeto_acao IS 'Referencia da acao do objeto.';

/* ---------------------------------------------------------------------- */
/* Add table "sequence_sistema"                                           */
/* ---------------------------------------------------------------------- */
CREATE TABLE public.sequence_sistema (
    id_sequence INTEGER  NOT NULL,
    table_sequence CHARACTER VARYING(100)  NOT NULL,
    value_sequence NUMERIC(20)  NOT NULL,
    CONSTRAINT pk_sequence_sistema PRIMARY KEY (id_sequence)
);
COMMENT ON TABLE public.sequence_sistema IS 'Tabela de controle';

/* ---------------------------------------------------------------------- */
/* Add foreign key constraints                                            */
/* ---------------------------------------------------------------------- */
ALTER TABLE public.perfil_objeto_acao ADD CONSTRAINT perfil_perfil_objeto_acao 
    FOREIGN KEY (id_perfil) REFERENCES public.perfil (id_perfil);
ALTER TABLE public.perfil_objeto_acao ADD CONSTRAINT objeto_acao_perfil_objeto_acao 
    FOREIGN KEY (id_objeto_acao) REFERENCES public.objeto_acao (id_objeto_acao);
