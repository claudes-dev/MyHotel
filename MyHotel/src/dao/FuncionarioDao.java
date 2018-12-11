package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.start.myhotel.model.Administrador;
import br.com.start.myhotel.model.Funcionario;
import br.com.start.myhotel.model.Reserva;
import connection.ConexaoFactory;
import excecoes.ExcecaoBusca;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoExclusao;

public class FuncionarioDao {

	// 1- FUNÇÃO PARA CADASTRAR RESERVA
	public void cadastrarReserva(Reserva r) throws ExcecaoCadastro {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into reserva ");
		sql.append("(id_reserva, id_func, data_entrada, data_saida, pagamento, id_cliente, id_servico, id_quarto ) ");
		sql.append("values (?,?,?,?,?,?,?,?)");

		Connection conexao = ConexaoFactory.getConnection();
		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setInt(1, r.getIdReserva());
			comando.setString(2, r.getIdFuncionario());
			comando.setString(3, r.getDataEntrada());
			comando.setString(4, r.getDataSaida());
			comando.setDouble(5, r.getValor());
			comando.setString(6, r.getIdCliente());
			comando.setInt(7, r.getIdServico());
			comando.setInt(8, r.getNumQuarto());

			comando.executeUpdate();

			System.out.println("Inserido no banco");
		} catch (SQLException excecao) {
			throw new ExcecaoCadastro("Não foi inserido");
		}
	}

	// 2- FUNÇÃO PARA SUSPENDER RESERVA
	public void suspenderReserva(Reserva r) throws ExcecaoExclusao {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from reserva ");
		sql.append("where id_reserva = ?");

		Connection conexao = ConexaoFactory.getConnection();
		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setInt(1, r.getIdReserva());

			comando.executeUpdate();

			System.out.println("Reserva suspensa");
		} catch (SQLException excecao) {
			throw new ExcecaoExclusao("Reserva não foi suspensa");
		}
	}

	// 3- FUNÇÃO PARA BUSCAR TODAS RESERVAS
	public ArrayList<Reserva> listar() throws ExcecaoBusca {
		StringBuilder sql = new StringBuilder();
		sql.append("select id_reserva, id_cliente ");
		sql.append("from reserva");

		Connection conexao = ConexaoFactory.getConnection();

		PreparedStatement comando = null;
		ResultSet resultado = null;
		try {
			comando = conexao.prepareStatement(sql.toString());

			resultado = comando.executeQuery();
			System.out.println("Conexão para inseriri no banco, executada com sucesso");
		} catch (SQLException excecao) {
			throw new ExcecaoBusca("Execução da conexão não concluída");
		}
		ArrayList<Reserva> lista = new ArrayList<Reserva>();
		try {
			while (resultado.next()) {
				Reserva r = new Reserva();
				r.setIdReserva(resultado.getInt("id_reserva"));
				r.setIdCliente(resultado.getString("id_cliente"));

				lista.add(r);
			}
			conexao.close();
			System.out.println("Lista buscada com sucesso");
		} catch (SQLException e) {
			throw new ExcecaoBusca("Erro ao buscar lista");
		}

		return lista;

	}
	
	// 4- FUNÇÃO PARA BUSCAR UMA RESERVA
	public void buscarReserva(Reserva reserva) throws ExcecaoBusca {
		
			StringBuilder sql = new StringBuilder();
			sql.append("select id_reserva,id_cliente ");
			sql.append("from reserva");

			try {
				Connection conexao = ConexaoFactory.getConnection();

				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				comando.setInt(1, reserva.getIdReserva());
				comando.setString(2, reserva.getIdCliente());

				ResultSet resultado = comando.executeQuery();

			} catch (SQLException excecao) {
				throw new ExcecaoBusca("Erro ao busca administrador");
			}
		}
	
	public ArrayList<Funcionario> listarFunc() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select cpf_func,senha, nome_func, tipo_conta, email, status ");
		sql.append("from funcionario");
		

		Connection conexao = ConexaoFactory.getConnection();
		PreparedStatement comando = null;
		ResultSet resultado = null;
		
	 comando = conexao.prepareStatement(sql.toString());
		
	 resultado = comando.executeQuery();


		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		while(resultado.next()) {
			Funcionario f = new Funcionario();
			f.setCpf(resultado.getString("cpf_func"));
			f.setSenha(resultado.getString("senha"));
			f.setNome(resultado.getString("nome_func"));
			f.setTipoConta(resultado.getString("tipo_conta"));
			f.setEmail(resultado.getString("email"));
			f.setStatus(resultado.getInt("status"));
			
			lista.add(f);
		}
		

		try {
			conexao.close();
		} catch (SQLException e) {
		}
		
		return lista;

	}
	}