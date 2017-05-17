package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DepartamentoControle implements Initializable {
	
	@FXML
	private MenuItem menuItemCadastrarDepartamento;
	@FXML
	private AnchorPane TelaCadastroDepartamento;
	
	@FXML
    private TextField txtDepartamento;
	@FXML
	private Label lblDepartamento;
	@FXML
    private TextField txtCargo;
	@FXML
	private Label lblCargo;
	@FXML
    private TextField txtUsuario;
	@FXML
	private Label lblUsuario;
	@FXML
    private Button btncadastrarDepartamento;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
