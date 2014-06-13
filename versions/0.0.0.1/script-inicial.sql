
-- DADOS DEFAULT

INSERT INTO PERFIL (ID_PERFIL, nome, ativo) VALUES (1, 'Admin', 'S');

INSERT INTO USUARIO (ID_USUARIO, NOME, LOGIN, EMAIL, SENHA, ATIVO, ID_PERFIL, PATH_FOTO) VALUES (1, 'Orlando Burli Junior', 'orlando', 'orlando.burli@gmail.com', '123', 'S', 1, '');

COMMIT;


