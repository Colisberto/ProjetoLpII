package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DaoUtil.ConectionFactory;
import Model.ColaboradorModel;
import Model.CursoModel;

public class CursoDAO {
	
	//são obrigatorios este tres metodos
			private Connection conexao; // pegando a conexão criada em daoUtil
			private Statement stmt; //
			private PreparedStatement stm; // executador de SQL
			
			/*String retirada do banco Mysql de criação dos atributos prepara para receber os dados gerados
			   pelo metodo salvar abaixo*/
			String sqlSalvar = "INSERT INTO curso (codigo, nomeCurso, turno, periodo)" +
					"VALUES " + "(?,?,?,?)";
			
			// METODO CONSTRUTOR
			public CursoDAO() throws SQLException{
				
				ConectionFactory factory = new ConectionFactory();
				conexao = factory.criarConexao();
				
			}
			
			// metodo pegando dados do pacote de modelo para salvar em banco String sql salvar do banco
			public String salvar(CursoModel curso)throws SQLException{
			    String salvo = "Falso"	;
			
				try{
					
				 conexao.setAutoCommit(false);	
				 stm = (PreparedStatement) conexao.prepareStatement(sqlSalvar);
			
				 stm.setString(1, curso.getCodigo());
				 stm.setString(2, curso.getNomeCurso());
				 stm.setString(3, curso.getTurno());
				 stm.setString(4, curso.getEndereco());
				 
				 
				 
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

}
