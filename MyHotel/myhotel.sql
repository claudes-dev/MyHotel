create table administrador (
	id_adm INT(5) AUTO_INCREMENT PRIMARY KEY,
	cpf_adm VARCHAR(14) UNIQUE,
	senha VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	nome_adm VARCHAR(45) NOT NULL,
	tipo_conta varchar(13) DEFAULT 'Administrador'
);

create table funcionario (
	id_func INT(5) AUTO_INCREMENT PRIMARY KEY,
	cpf_func VARCHAR(14) UNIQUE,
	senha VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	nome_func VARCHAR(45) NOT NULL,
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



create table quarto(
	id_quarto INT (5) AUTO_INCREMENT PRIMARY KEY,
	num_quarto INT (3) NOT NULL,
	andar_quarto INT (1) NOT NULL,
	preco_diaria DOUBLE NOT NULL,
	preco_mensal DOUBLE NOT NULL,
	qtd_banheiro INT (1) NOT NULL
);



create table reserva(

	id_reserva INT AUTO_INCREMENT PRIMARY KEY,
	id_func INT,
	id_cliente INT,
	id_quarto INT,
	data_saida DATE NOT NULL,
	data_entrada DATE NOT NULL,
	pagamento DOUBLE NOT NULL
);

create table cliente(
	id_cliente INT AUTO_INCREMENT PRIMARY KEY,
	cpf_cliente VARCHAR(14) UNIQUE NOT NULL,
	nome_cliente VARCHAR(25) NOT NULL,
	email varchar(50) NOT NULL,
	telefone VARCHAR(15),
	FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)
);
-- tabela que liga funcionario efetuando reserva

create table efetua(
	id_reserva INT,
	id_func INT,
	FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva),
	FOREIGN KEY (id_func) REFERENCES funcionario(id_func)
);

/*tabela que liga funcionario ao cliente ou seja check in*/
	
create table check_in (
	id_cliente INT,
	id_func INT,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
	FOREIGN KEY (id_func) REFERENCES funcionario(id_func)
);

-- ligacao de reservas com servicos

create table contem(
	id_reserva INT,
	
	FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)
	
);

-- ligacao de reserva com cliente 
create table tem(
	id_cliente INT,
	id_reserva INT,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
	FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)
	
);
	
-- ligacao de reserva com quarto
create table possui(
	id_quarto INT,
	id_reserva INT,
	FOREIGN KEY (id_quarto) REFERENCES quarto(id_quarto),
	FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)

);



ALTER TABLE cliente
ADD FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva);

ALTER TABLE reserva

ADD FOREIGN KEY (id_func) REFERENCES funcionario(id_func),
ADD	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
ADD	FOREIGN KEY (id_quarto) REFERENCES quarto(id_quarto);