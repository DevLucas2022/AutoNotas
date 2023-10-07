CREATE TABLE professores (
    id_professor bigint not null auto_increment,

    nome VARCHAR(255),
    data_nascimento DATE,
    telefone VARCHAR(15),
    email VARCHAR(255),
    senha VARCHAR(64)
    primary key(id_professor)
);
