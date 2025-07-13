CREATE DATABASE aplicacaojava;

-- Após criar o banco, conecte-se a ele e execute o seguinte:

CREATE TABLE login (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL
);
