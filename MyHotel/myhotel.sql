create table Administrador (
	cpf_adm VARCHAR(14) PRIMARY KEY,
	senha VARCHAR(10) NOT NULL,
	nome_adm VARCHAR(25) NOT NULL
);

create table funcionario (
	cpf_func VARCHAR(14) PRIMARY KEY,
	senha VARCHAR(10) NOT NULL,
	nome_func VARCHAR(25) NOT NULL
);

