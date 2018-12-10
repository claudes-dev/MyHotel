package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			comando.setInt(8 , r.getNumQuarto());

			comando.executeUpdate();

			System.out.println("Inserido no banco");
			}catch(SQLException excecao) {
				throw new ExcecaoCadastro("Não foi inserido");
			}
	}

	// 2- FUNÇÃO PARA SUSPENDER RESERVA
	public void suspenderReserva(Reserva r) throws ExcecaoExclusao{
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from reserva ");
		sql.append("where id_reserva = ?");
		
		Connection conexao = ConexaoFactory.getConnection();
		try {
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, r.getIdReserva());
		
		comando.executeUpdate();

		System.out.println("Reserva suspensa");
		}catch(SQLException excecao) {
			throw new ExcecaoExclusao("Reserva não foi suspensa");
		}
	}
	
	
	// 3- FUNÇÃO PARA BUSCAR TODAS RESERVAS

	public  ArrayList<Reserva> listarTodosClientes() throws ExcecaoBusca {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id_cliente, id_reserva ");
		sql.append("from reserva");
		

		Connection conexao = ConexaoFactory.getConnection();
		
		PreparedStatement comando = null;
		ResultSet resultado = null;
		
	 comando = conexao.prepareStatement(sql.toString());
		
	 resultado = comando.executeQuery();

		Reserva retorno = null;
		return null;
	}
	
}
	

/**tras apenas  um
//	if (resultado.next()) {
//		retorno = new Funcionario();
//		retorno.setCpf(resultado.getString("cpf_func"));
//		retorno.setNome(resultado.getString("nome_func"));
//		
//	}
	
	ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
//	 List a1 = new ArrayList();
	while(resultado.next()) {
		Funcionario f = new Funcionario();
		f.setCpf(resultado.getString("cpf_func"));
		f.setSenha(resultado.getString("senha"));
		f.setNome(resultado.getString("nome_func"));
		f.setTipoConta(resultado.getString("tipo_conta"));
		
		lista.add(f);
	}
	

	try {
		conexao.close();
	} catch (SQLException e) {
	}
	
	return lista;

*/