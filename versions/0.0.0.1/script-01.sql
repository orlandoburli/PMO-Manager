/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v6.1.0                     */
/* Target DBMS:           PostgreSQL 8.3                                  */
/* Project file:          db-model.dez                                    */
/* Project name:          PMO-Manager                                     */
/* Author:                Orlando Burli / André Cruz                      */
/* Script type:           Alter database script                           */
/* Created on:            2013-11-21 01:42                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Add table "usuario"                                                    */
/* ---------------------------------------------------------------------- */
CREATE TABLE usuario (
    id_usuario INTEGER  NOT NULL,
    nome_usuario CHARACTER VARYING(100),
    email_usuario CHARACTER VARYING(200),
    senha_usuario CHARACTER VARYING(100),
    status_usuario CHARACTER(1),
    CONSTRAINT pk_usuario PRIMARY KEY (id_usuario)
);
COMMENT ON TABLE usuario IS 'Tabela de usuários do sistema.';
COMMENT ON COLUMN usuario.id_usuario IS 'ID do usuário, sequencial. Sequence ID_USUARIO_SEQ.';
COMMENT ON COLUMN usuario.nome_usuario IS 'Nome do Usuário.';
COMMENT ON COLUMN usuario.email_usuario IS 'Email do usuário, será usado como login.';
COMMENT ON COLUMN usuario.senha_usuario IS 'Senha do usuário, criptografada em SHA-1.';
COMMENT ON COLUMN usuario.status_usuario IS 'Status do usuário, podendo assumir os valores: A - Ativo I - Inativo E - Excluído';

/* ---------------------------------------------------------------------- */
/* Add table "perfil"                                                     */
/* ---------------------------------------------------------------------- */
CREATE TABLE perfil (
    id_perfil INTEGER  NOT NULL,
    nome_perfil CHARACTER VARYING(100),
    status_perfil CHARACTER VARYING(1),
    CONSTRAINT pk_perfil PRIMARY KEY (id_perfil)
);
COMMENT ON TABLE perfil IS 'Tabela de Perfis de acesso ao sistema.';
COMMENT ON COLUMN perfil.id_perfil IS 'ID do perfil, sequencial.';
COMMENT ON COLUMN perfil.nome_perfil IS 'Nome do perfil, exibido para o usuário.';
COMMENT ON COLUMN perfil.status_perfil IS 'Status do perfil, pode assumir os valores: A - Ativo I - Inativo E - Excluído';

/* ---------------------------------------------------------------------- */
/* Add table "usuario_perfil"                                             */
/* ---------------------------------------------------------------------- */
CREATE TABLE usuario_perfil (
    id_usuario_perfil INTEGER  NOT NULL,
    id_usuario INTEGER  NOT NULL,
    id_perfil INTEGER  NOT NULL,
    CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario_perfil)
);
COMMENT ON TABLE usuario_perfil IS 'Tabela que vincula os perfis do usuário. Pode ser mais de um.';
COMMENT ON COLUMN usuario_perfil.id_usuario_perfil IS 'ID de vínculo de usuario/perfil, sequence ID_USUARIO_PERFIL_SEQ.';
COMMENT ON COLUMN usuario_perfil.id_usuario IS 'Referencia da tabela usuario.';
COMMENT ON COLUMN usuario_perfil.id_perfil IS 'Referencia da tabela perfil.';

/* ---------------------------------------------------------------------- */
/* Add table "objeto"                                                     */
/* ---------------------------------------------------------------------- */
CREATE TABLE objeto (
    id_objeto INTEGER  NOT NULL,
    nome_objeto CHARACTER VARYING(100),
    descricao_objeto CHARACTER VARYING(200),
    CONSTRAINT pk_objeto PRIMARY KEY (id_objeto)
);
COMMENT ON TABLE objeto IS 'Tabela de Objetos do sistema. Exemplo: Cadastro de Empresas, Consulta de Empresas, Cadastro de Clientes, Relatório de Faturamento, etc.';
COMMENT ON COLUMN objeto.id_objeto IS 'Id do Objeto. Não sequencial, ID''s definidos pela manutenção do sistema.';
COMMENT ON COLUMN objeto.nome_objeto IS 'Nome do Objeto, identificador do mesmo no sistema. Somente minúsculas, sem espaços ou acentos.';
COMMENT ON COLUMN objeto.descricao_objeto IS 'Descrição do Objeto, exibido ao usuário.';

/* ---------------------------------------------------------------------- */
/* Add table "acao"                                                       */
/* ---------------------------------------------------------------------- */
CREATE TABLE acao (
    id_acao INTEGER  NOT NULL,
    descricao_acao CHARACTER VARYING(100),
    chave_acao CHARACTER VARYING(50),
    CONSTRAINT pk_acao PRIMARY KEY (id_acao)
);
COMMENT ON TABLE acao IS 'Tabela pré-cadastrada de ações do sistema, como consultar, visualizar, editar, excluir, incluir, etc.';
COMMENT ON COLUMN acao.id_acao IS 'ID da ação, sequencial.';
COMMENT ON COLUMN acao.descricao_acao IS 'Descrição da ação, valor que será exibido ao usuário.';
COMMENT ON COLUMN acao.chave_acao IS 'String identificadora da ação. Maiusculas e sem espaços/acentos.';

/* ---------------------------------------------------------------------- */
/* Add table "objeto_acao"                                                */
/* ---------------------------------------------------------------------- */
CREATE TABLE objeto_acao (
    id_objeto_acao INTEGER  NOT NULL,
    id_objeto INTEGER  NOT NULL,
    id_acao INTEGER  NOT NULL,
    CONSTRAINT pk_objeto_acao PRIMARY KEY (id_objeto_acao)
);
COMMENT ON TABLE objeto_acao IS 'Vínculo da ação com o Objeto do Sistema. Para cada ação que o objeto tiver, deve ser criado um vínculo nesta tabela.';
COMMENT ON COLUMN objeto_acao.id_objeto_acao IS 'ID do Objeto, Sequencial. Sequence ID_OBJETO_ACAO_SEQ deve ser usada.';
COMMENT ON COLUMN objeto_acao.id_objeto IS 'Referencia da tabela Objeto.';
COMMENT ON COLUMN objeto_acao.id_acao IS 'Referencia da tabela Acao.';

/* ---------------------------------------------------------------------- */
/* Add table "perfil_objeto"                                              */
/* ---------------------------------------------------------------------- */
CREATE TABLE perfil_objeto (
    id_perfil_objeto INTEGER  NOT NULL,
    id_perfil INTEGER  NOT NULL,
    id_objeto INTEGER  NOT NULL,
    CONSTRAINT pk_perfil_objeto PRIMARY KEY (id_perfil_objeto)
);
COMMENT ON TABLE perfil_objeto IS 'Tabela de vinculo entre perfil e objeto, trata das permissões do usuário no sistema, em quais objetos ele tem acesso.';
COMMENT ON COLUMN perfil_objeto.id_perfil_objeto IS 'ID de vinculo, sequence ID_PERFIL_OBJETO_SEQ.';
COMMENT ON COLUMN perfil_objeto.id_perfil IS 'Referencia da tabela perfil';
COMMENT ON COLUMN perfil_objeto.id_objeto IS 'Referencia da tabela objeto.';

/* ---------------------------------------------------------------------- */
/* Add foreign key constraints                                            */
/* ---------------------------------------------------------------------- */
ALTER TABLE usuario_perfil ADD CONSTRAINT usuario_usuario_perfil 
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE usuario_perfil ADD CONSTRAINT perfil_usuario_perfil 
    FOREIGN KEY (id_perfil) REFERENCES perfil (id_perfil);
ALTER TABLE objeto_acao ADD CONSTRAINT objeto_objeto_acao 
    FOREIGN KEY (id_objeto) REFERENCES objeto (id_objeto);
ALTER TABLE objeto_acao ADD CONSTRAINT acao_objeto_acao 
    FOREIGN KEY (id_acao) REFERENCES acao (id_acao);
ALTER TABLE perfil_objeto ADD CONSTRAINT perfil_perfil_objeto 
    FOREIGN KEY (id_perfil) REFERENCES perfil (id_perfil);
ALTER TABLE perfil_objeto ADD CONSTRAINT objeto_perfil_objeto 
    FOREIGN KEY (id_objeto) REFERENCES objeto (id_objeto);
