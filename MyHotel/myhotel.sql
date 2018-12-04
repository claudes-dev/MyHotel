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

create table quarto(
	id_quarto INT AUTO INCREMENT PRIMARY KEY,
	num_quarto INT NOT NULL,
	andar_quarto INT NOT NULL,
	preco_diaria DOUBLE NOT NULL,
	preco_mensa DOUBLE NOT NULL,
	qtd_banheiro INT NOT NULL,

);

create table servico (
	id_servico INT AUTO INCREMENT PRIMARY KEY,
	nome_servico VARCHAR(20) NOT NULL,
	preco_servico DOUBLE NOT NULL,
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

id_reserva INT AUTO INCREMENT PRIMARY KEY,
id_func INT NOT NULL UNIQUE,
id_cliente INT NOT NULL UNIQUE,
id_quarto INT NOT NULL UNIQUE,
id_servico INT NOT NULL UNIQUE,
data_saída DATE NOT NULL,
data_entrada DATE NOT NULL,
pagamento DOUBLE NOT NULL,

);


