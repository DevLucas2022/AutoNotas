CREATE TABLE professores (
    id bigint not null auto_increment,
    nome VARCHAR(255),
    data_nascimento DATE,
    telefone VARCHAR(15),
    email VARCHAR(255),

    primary key(id)
);
