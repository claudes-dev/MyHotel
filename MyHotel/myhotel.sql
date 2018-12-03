create table administrador (
	id_adm INT AUTO INCREMENT PRIMARY KEY,
	cpf_adm VARCHAR(14) UNIQUE,
	senha VARCHAR(10) NOT NULL,
	nome_adm VARCHAR(25) NOT NULL
);

create table funcionario (
	id_func INT AUTO INCREMENT PRIMARY KEY,
	cpf_func VARCHAR(14) UNIQUE,
	senha VARCHAR(10) NOT NULL,
	nome_func VARCHAR(25) NOT NULL
);

create table cliente(
	id_cliente INT AUTO INCREMENT PRIMARY KEY,
	cpf_cliente VARCHAR(14) UNIQUE NO 	NULL,
	nome_cliente VARCHAR(25) NOT NULL,
	id_reserva INT,
	data_nasc DATE NOT NULL,
	email varchar(50) NOT NULL,
);

create table reserva(
	
);
