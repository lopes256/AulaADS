insert into cadastro.aluno(nome_aluno, data_cadastro) values('JOAO JOSE', '2023-01-19');
insert into cadastro.aluno(nome_aluno, data_cadastro) values('MARIA MARIA', '2023-01-19');
insert into cadastro.aluno(nome_aluno, data_cadastro) values('BOB ALO', '2023-01-19');

insert into cadastro.professor(nome_professor, data_cadastro) values('JOSE MARIA', '2023-01-19');
insert into cadastro.professor(nome_professor, data_cadastro) values('SILVA BEL', '2023-01-19');

insert into cadastro.curso(nome_curso, hora_aula, data_inicio, data_final) values('MATEMATICA', 60, '2023-02-01', '2023-02-28');
insert into cadastro.curso(nome_curso, hora_aula, data_inicio, data_final) values('FISICA', 60, '2023-02-01', '2023-02-28');
insert into cadastro.curso(nome_curso, hora_aula, data_inicio, data_final) values('LOGICA DE PROGRAMACAO', 80, '2023-02-01', '2023-03-15');
insert into cadastro.curso(nome_curso, hora_aula, data_inicio, data_final) values('PROGRAMACAO ORIENTADA A OBJETOS', 100, '2023-02-01', '2023-03-30');

insert into aulas(codigo_curso, codigo_professor) values(1, 1);
insert into aulas(codigo_curso, codigo_professor) values(2, 1);
insert into aulas(codigo_curso, codigo_professor) values(3, 2);
insert into aulas(codigo_curso, codigo_professor) values(4, 2);
insert into aulas(codigo_curso, codigo_professor) values(1, 2);
