create table administrador (
	id_adm INT(5) AUTO_INCREMENT PRIMARY KEY,
	cpf_adm VARCHAR(14) UNIQUE,
	senha VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	nome_adm VARCHAR(50) NOT NULL,
	tipo_conta varchar(13) DEFAULT 'Administrador'
);

create table funcionario (
	id_func INT(5) AUTO_INCREMENT PRIMARY KEY,
	cpf_func VARCHAR(14) UNIQUE,
	senha VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	nome_func VARCHAR(50) NOT NULL,
	tipo_conta varchar(13) DEFAULT 'Funcionario',
	status INT(1) NOT NULL DEFAULT 1
);

-- TABELA DE LIGAÇÃO ENTRE ADM E FUNCIONARIO
create table cadastra(
	id_func INT,
	id_adm INT, 
	FOREIGN KEY (id_func) REFERENCES funcionario(id_func),
	FOREIGN KEY (id_adm) REFERENCES administrador(id_adm)
);

create table reserva(

	id_reserva INT AUTO_INCREMENT UNIQUE KEY,
	id_func INT,
	cpf_cliente VARCHAR(50),
	num_quarto INT (3) PRIMARY KEY KEY,
	data_saida VARCHAR(10) NOT NULL,
	data_entrada VARCHAR(10) NOT NULL
);

create table cliente(
	id_cliente INT AUTO_INCREMENT UNIQUE KEY,
	cpf_cliente VARCHAR(14) PRIMARY KEY NOT NULL,
	nome_cliente VARCHAR(50) NOT NULL,
	email varchar(50) NOT NULL,
	telefone VARCHAR(15)
);


ALTER TABLE reserva

ADD FOREIGN KEY (id_func) REFERENCES funcionario(id_func),
ADD FOREIGN KEY(cpf_cliente) REFERENCES cliente(cpf_cliente);
