CREATE TABLE alunos (
    id_aluno bigint not null auto_increment,

    nome VARCHAR(255),
    curso VARCHAR(255),
    ra VARCHAR(25),
    email VARCHAR(255),
    senha VARCHAR(64)

    primary key(id_aluno)
);
