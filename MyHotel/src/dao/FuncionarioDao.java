package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.start.myhotel.model.Administrador;
import br.com.start.myhotel.model.Cliente;
import br.com.start.myhotel.model.Funcionario;
import br.com.start.myhotel.model.Quarto;
import br.com.start.myhotel.model.Reserva;
import connection.ConexaoFactory;
import excecoes.ExcecaoBusca;
import excecoes.ExcecaoCadastro;
import excecoes.ExcecaoExclusao;
import br.com.start.myhotel.model.Reserva;

public class FuncionarioDao {

	
	// ADICIONAL CLIENTE
		public void adicionarCliente(Cliente c) throws ExcecaoCadastro{
			StringBuilder sql = new StringBuilder();
			sql.append("insert into cliente ");
			sql.append("(nome_cliente,cpf_cliente,email,telefone) ");
			sql.append("values(?,?,?,?)");
			
			Connection conexao = ConexaoFactory.getConnection();
			
			try {
				PreparedStatement comando = conexao.prepareStatement(sql.toString());
				comando.setString(1, c.getNome());
				comando.setString(2, c.getCpf());
				comando.setString(3, c.getEmail());
				comando.setString(4, c.getTelefone());
				
				comando.executeUpdate();
				
			}catch(SQLException excecao) {
				throw new ExcecaoCadastro("Cliente não foi inserido");
			} try {
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
	// 1- F UNÇÃO PARA CADASTRAR RESERVA
	public void cadastrarReserva(Reserva r) throws ExcecaoCadastro {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into reserva ");
		sql.append("(id_func, data_entrada, data_saida, cpf_cliente, num_quarto) ");
		sql.append("values (?,?,?,?,?)");

		Connection conexao = ConexaoFactory.getConnection();
		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			
			comando.setInt(1, r.getIdFuncionario());
			comando.setString(2, r.getDataEntrada());
			comando.setString(3, r.getDataSaida());
			comando.setString(4, r.getcpfCliente());
			comando.setInt(5, r.getNumQuarto());

			comando.executeUpdate();

			System.out.println("Inserido no banco");
		} catch (SQLException excecao) {
			throw new ExcecaoCadastro("Não foi inserido");
		} try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		} try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 3- FUNÇÃO PARA BUSCAR TODAS RESERVAS
	public ArrayList<Reserva> listarReservas() throws ExcecaoBusca {
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
				Reserva reserva = new Reserva();
				Reserva r = new Reserva();
				r.setIdReserva(resultado.getInt("id_reserva"));
				r.setcpfCliente(resultado.getString("cpf_cliente"));

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
		
		Connection conexao = ConexaoFactory.getConnection();
		
		try {
			
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setInt(1, reserva.getIdReserva());
			comando.setString(2, reserva.getcpfCliente());

			ResultSet resultado = comando.executeQuery();

		} catch (SQLException excecao) {
			throw new ExcecaoBusca("Erro ao busca administrador");
		} try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Função pra buscar

	public Funcionario buscarPorEmail(String f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from funcionario ");
		sql.append("where email = ?");

		Connection conexao = ConexaoFactory.getConnection();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f);
		ResultSet resultado = comando.executeQuery();

//		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM funcionario WHERE email = ?");

		Funcionario retorno = null;

		if (resultado.next()) {

			retorno = new Funcionario();
			retorno.setCpf(resultado.getString("cpf_func"));
			retorno.setSenha(resultado.getString("senha"));
			retorno.setNome(resultado.getString("nome_func"));
			retorno.setTipoConta(resultado.getString("tipo_conta"));
			retorno.setEmail(resultado.getString("email"));
			retorno.setStatus(resultado.getInt("status"));
			
		}

		try {
			conexao.close();
		} catch (SQLException e) {
		}

		return retorno;

	}

	public ArrayList<Funcionario> listarFunc() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select cpf_func,senha, nome_func, tipo_conta, email, status, id_func ");
		sql.append("from funcionario");

		Connection conexao = ConexaoFactory.getConnection();
		PreparedStatement comando = null;
		ResultSet resultado = null;

		comando = conexao.prepareStatement(sql.toString());

		resultado = comando.executeQuery();

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		while (resultado.next()) {
			Funcionario f = new Funcionario();
			f.setCpf(resultado.getString("cpf_func"));
			f.setSenha(resultado.getString("senha"));
			f.setNome(resultado.getString("nome_func"));
			f.setTipoConta(resultado.getString("tipo_conta"));
			f.setEmail(resultado.getString("email"));
			f.setStatus(resultado.getInt("status"));
			f.setIdFunc(resultado.getInt("id_func"));

			lista.add(f);
		}

		try {
			conexao.close();
		} catch (SQLException e) {
		}

		return lista;

	}

	public ArrayList<Cliente> listarCliente() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select cpf_cliente, nome_cliente, email, telefone ");
		sql.append("from cliente");

		Connection conexao = ConexaoFactory.getConnection();
		PreparedStatement comando = null;
		ResultSet resultado = null;

		comando = conexao.prepareStatement(sql.toString());

		resultado = comando.executeQuery();

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		while (resultado.next()) {
			Cliente c = new Cliente();
			c.setCpf(resultado.getString("cpf_cliente"));
			c.setNome(resultado.getString("nome_cliente"));
			c.setEmail(resultado.getString("email"));
			c.setTelefone(resultado.getString("telefone"));
			
			lista.add(c);
		}

		try {
			conexao.close();
		} catch (SQLException e) {
		}

		return lista;

	}

	public List<Quarto> listarQuartos() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select id_quarto, num_quarto, andar_quarto ");
		sql.append("from quarto");

		Connection conexao = ConexaoFactory.getConnection();
		PreparedStatement comando = null;
		ResultSet resultado = null;

		resultado = comando.executeQuery();

		ArrayList<Quarto> lista = new ArrayList<Quarto>();

		while (resultado.next()) {
			Quarto q = new Quarto();
			q.setIdQuarto(resultado.getInt("id_quarto"));
			q.setIdQuarto(resultado.getInt("num_quarto"));
			q.setIdQuarto(resultado.getInt("andar_quarto"));

			
			lista.add(q);
		}

		try {
			conexao.close();
		} catch (SQLException e) {
		}

		return lista;

	} 


}