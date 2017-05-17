package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CursoControle implements Initializable {
	
	@FXML
	private MenuItem menuItemCadastrarCurso;
	@FXML
	private AnchorPane TelaCadastrarCurso;
	@FXML
	private Label lblCodigo;	
	@FXML
	private TextField txtCodigo;
	@FXML
	private Label lblNomeCurso;	
	@FXML
	private TextField txtNomeCurso;
	@FXML
	private Label lblNomeCoordenador;	
	@FXML
	private TextField txtNomeCoordenador;
	@FXML
	private Label lblTurno;	
	@FXML
	private TextField txtTurno;
	@FXML
	private Label lblPeriodo;	
	@FXML
	private TextField txtPeriodo;
	@FXML
    private ComboBox<String> ComboNomeCoordenador;
	 @FXML
	    private Button btnCadastrar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
