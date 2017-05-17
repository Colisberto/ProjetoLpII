package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Negocio.ColaboradorNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuControle implements Initializable {
	
	@FXML
	private Pane paneInicial;
	@FXML 
	private TextField txtLogin;
	@FXML 
	private PasswordField txtSenha;
	@FXML 
	private Label mensagem;
	@FXML 
	private MenuBar menuBar;
	@FXML 
	private MenuItem menuItemCadastrarUniversidade;
	@FXML 
	private MenuItem menuItemCadastrarColaborador;
	@FXML 
	private MenuItem menuItemCadastrarCurso;
	@FXML 
	private MenuItem menuItemCadastrarDepartamento;
	@FXML 
	private MenuItem meuItemCadastrarCategoria;
	@FXML 
	private MenuItem menuItemCadastarTutoria;
	@FXML 
	private MenuItem menuItemCadastrarParametro;
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	    // metodo para abrir tela de cadastro de parceiro ---FUNCIONANDO
		@FXML 
		public void abrirCadastrarColaborador(ActionEvent event)throws IOException {
			
			URL arquivoFXML;
			arquivoFXML = getClass().getResource("/Visao/CadastrarColaborador.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			paneInicial.getChildren().clear();
			paneInicial.getChildren().add(fxmlParent);
			
		}
		
		@FXML 
		public void abrirCadastrarCurso(ActionEvent event)throws IOException {
			
			URL arquivoFXML;
			arquivoFXML = getClass().getResource("/Visao/CadastroCurso.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			paneInicial.getChildren().clear();
			paneInicial.getChildren().add(fxmlParent);
			
		}
		@FXML 
		public void abrirCadastrarDepartamento(ActionEvent event)throws IOException {
			
			URL arquivoFXML;
			arquivoFXML = getClass().getResource("/Visao/CadastroDepartamento.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			paneInicial.getChildren().clear();
			paneInicial.getChildren().add(fxmlParent);
			
		}
		
		@FXML 
		public void abrirCadastrarCategoria(ActionEvent event)throws IOException {
			
			URL arquivoFXML;
			arquivoFXML = getClass().getResource("/Visao/CadastroCategoria.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			paneInicial.getChildren().clear();
			paneInicial.getChildren().add(fxmlParent);
			
		}
		
		@FXML 
		public void abrirCadastrarUniversidade(ActionEvent event)throws IOException {
			
			URL arquivoFXML;
			arquivoFXML = getClass().getResource("/Visao/CadastroUniversidade.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			paneInicial.getChildren().clear();
			paneInicial.getChildren().add(fxmlParent);
			
		}
		
		@FXML 
		public void abrirCadastrarOcorrencia(ActionEvent event)throws IOException {
			
			URL arquivoFXML;
			arquivoFXML = getClass().getResource("/Visao/RegistroOcorrência.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			paneInicial.getChildren().clear();
			paneInicial.getChildren().add(fxmlParent);
			
		}
		
		@FXML 
		public void abrirCadastrarTutoria(ActionEvent event)throws IOException {
			
			URL arquivoFXML;
			arquivoFXML = getClass().getResource("/Visao/CadastroTutoria.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			paneInicial.getChildren().clear();
			paneInicial.getChildren().add(fxmlParent);
			
		}
		@FXML 
		public void abrirCadastrarParametro(ActionEvent event)throws IOException {
			
			URL arquivoFXML;
			arquivoFXML = getClass().getResource("/Visao/CadastroParametroPorFuncao.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			paneInicial.getChildren().clear();
			paneInicial.getChildren().add(fxmlParent);
			
		}
		
		

		

		
		@FXML public void btnEntrar(ActionEvent event) throws IOException, SQLException {
			verificarLogin();
			
		}

		ColaboradorNegocio colaboradorNegocio = new ColaboradorNegocio();
		
		// metodo que checa na camada de negocio login de acesso ao cadastro
		public void verificarLogin () throws IOException, SQLException {

	        if(colaboradorNegocio.verificarLogin(txtLogin.getText() , txtSenha.getText()).equals("naoentra") ) {
	            mensagem.setText("Insira Login e senha corretamente");
	        }else if (colaboradorNegocio.verificarLogin(txtLogin.getText() , txtSenha.getText()).equals("entra")){


	            menuBar.setDisable(false);
	            URL arquivoFXML;
	            arquivoFXML = getClass().getResource("/Visao/inicial.fxml");
	            Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
	            paneInicial.getChildren().clear();
	            paneInicial.getChildren().add(fxmlParent);
	        }
			
		}

		@FXML public void btnCancelar(ActionEvent event) {}

		

		

}
