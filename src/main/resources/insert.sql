
INSERT INTO cv(id, conhecimentos, nome, email, cargo, sumario, idioma, status) VALUES('d1516d33-ff6f-4dc9-aedf-9316421096cb', 'nodeJS', 'joao', 'joao@gmail', 'programador jr', 'sou um programador', 'portugues', 0);

INSERT INTO experiencia(id, cargo, data_inicio, data_termino, atividades) VALUES('661556c2-7c71-4d26-a170-c89e45b9b151', 'programador', '18/02/1998', '18/02/2002', 'programacao');

INSERT INTO educacao(id, nome_instituicao, curso, data_inicio, data_termino) VALUES('775c7b9f-6ce2-4919-8696-c751dd322ac3','ufrgs', 'computacao', '18/02/1998', '18/02/2002');

INSERT INTO secoes(id, titulo, campo_texto) VALUES('bb1ebadf-50c8-463c-8eb3-6f3998a466f3','secao', 'descricao');

INSERT INTO cv_experiencia (cv_id, experiencia_id) values
        ('d1516d33-ff6f-4dc9-aedf-9316421096cb', '661556c2-7c71-4d26-a170-c89e45b9b151');
INSERT INTO cv_educacao (cv_id, educacao_id) values
        ('d1516d33-ff6f-4dc9-aedf-9316421096cb', '775c7b9f-6ce2-4919-8696-c751dd322ac3');
INSERT INTO cv_secoes (cv_id, secoes_id) values
        ('d1516d33-ff6f-4dc9-aedf-9316421096cb', 'bb1ebadf-50c8-463c-8eb3-6f3998a466f3');