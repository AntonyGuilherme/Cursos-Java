INSERT INTO usuarios(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$QJSuvCDCMwzTJvReD3/V5eNZJmbaFoU8SetOGxWTb6br2n/vUwjzi');
INSERT INTO usuarios(nome, email, senha) VALUES('Administrador', 'adm@email.com', '$2a$10$QJSuvCDCMwzTJvReD3/V5eNZJmbaFoU8SetOGxWTb6br2n/vUwjzi');

INSERT INTO cursos(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO cursos(nome, categoria) VALUES('HTML 5', 'Front-end');

INSERT INTO topicos(titulo, mensagem, data_criacao, status, id_autor, id_curso) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO topicos(titulo, mensagem, data_criacao, status, id_autor, id_curso) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO topicos(titulo, mensagem, data_criacao, status, id_autor, id_curso) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);

INSERT INTO perfis(id,nome) VALUES(1,'ROLE_ALUNO');
INSERT INTO perfis(id,nome) VALUES(2,'ROLE_MODERADOR');

INSERT INTO usuarios_perfis(id_usuario,id_perfil) VALUES(1,1);
INSERT INTO usuarios_perfis(id_usuario,id_perfil) VALUES(2,2);
