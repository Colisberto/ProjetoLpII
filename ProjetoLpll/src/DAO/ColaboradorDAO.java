package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DaoUtil.ConectionFactory;
import Model.ColaboradorModel;

public class ColaboradorDAO {

	    //são obrigatorios este tres metodos
		private Connection conexao; // pegando a conexão criada em daoUtil
		private Statement stmt; //
		private PreparedStatement stm; // executador de SQL
		
		/*String retirada do banco Mysql de criação dos atributos prepara para receber os dados gerados
		   pelo metodo salvar abaixo*/
		String sqlSalvar = "INSERT INTO colaboradores (login, senha, cpf, nome, rg, endereco, foneFixo, foneCelular, email)" +
				"VALUES " + "(?,?,?,?,?,?,?,?,?)";
		
		// METODO CONSTRUTOR
		/*public ColaboradorDAO() throws SQLException{
			
			ConectionFactory factory = new ConectionFactory();
			conexao = factory.criarConexao();
			
		}*/
		
		public ColaboradorDAO() {

			ConectionFactory factory = new ConectionFactory();
			try {
				conexao = factory.criarConexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		// metodo pegando dados do pacote de modelo para salvar em banco String sql salvar do banco
		public String salvar(ColaboradorModel colaborador)throws SQLException{
		    String salvo = "Falso"	;
		
			try{
				
			 conexao.setAutoCommit(false);	
			 stm = (PreparedStatement) conexao.prepareStatement(sqlSalvar);
			 stm.setString(1, colaborador.getLogin());
			 stm.setString(2, colaborador.getSenha());
			 stm.setString(3, colaborador.getCpf());
			 stm.setString(4, colaborador.getNome());
			 stm.setString(5, colaborador.getRg());
			 stm.setString(6, colaborador.getEndereco());
			 stm.setString(7, colaborador.getFoneFixo());
			 stm.setString(8, colaborador.getFoneCelular());
			 stm.setString(9, colaborador.getEmail());
			 
			 
			 stm.executeUpdate();
			 conexao.commit();
			 salvo = "salvo";
			 
		}catch (Exception e){//testando a conexão se é nula ou não
			
			if (conexao != null){
				try{
					System.out.println(" Efetuando Rollback");
					conexao.rollback();
					salvo = "erro ao gravar " + e.getMessage();
				}catch (SQLException e1){
					System.out.println(" Erro na Conexão" + e1.getMessage());
					salvo = "e1";
					
				}
			}
				
			}
			return salvo;
		} 
		
		public List<ColaboradorModel> buscar() throws SQLException {
			List<ColaboradorModel> listaColaborador = new ArrayList<ColaboradorModel>();

			ResultSet resposta = null;

			try {

				stmt = (Statement) conexao.createStatement();
				resposta = stmt.executeQuery("select * from colaboradores ");
				while (resposta.next()) {
					ColaboradorModel colaboradorModel = new ColaboradorModel();

					colaboradorModel.setId(resposta.getInt("id"));
					colaboradorModel.setLogin(resposta.getString("login"));
					colaboradorModel.setSenha(resposta.getString("senha"));
					colaboradorModel.setCpf(resposta.getString("cpf"));
					colaboradorModel.setNome(resposta.getString("nome"));
					colaboradorModel.setRg(resposta.getString("rg"));
					colaboradorModel.setEndereco(resposta.getString("endereco"));
					colaboradorModel.setFoneFixo(resposta.getString("foneFixo"));
					colaboradorModel.setFoneCelular(resposta.getString("foneCelular"));
					colaboradorModel.setEmail(resposta.getString("email"));
					

					listaColaborador.add(colaboradorModel);

				}
			} catch (SQLException e) {
				System.out.println("Erro na consulta 1:" + e.getMessage());
			}
			return listaColaborador;

		}
}
