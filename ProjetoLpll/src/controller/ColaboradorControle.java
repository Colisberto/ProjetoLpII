package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import Model.ColaboradorModel;
import Negocio.ColaboradorNegocio;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ColaboradorControle implements Initializable{
	
	@FXML
	private MenuItem menuItemCadastrarColaborador;
	@FXML
	private AnchorPane TelaCadastroColaborador;
	
	private ColaboradorModel colaborador;
	
	@FXML
	private TextField txtId;
	@FXML
    private TextField txtCPF;
	@FXML
	private Label lblCPF;	
	@FXML
	private TextField txtNome;
	@FXML
	private Label lblNome;
	@FXML
    private Button btnCadastrar;
	@FXML
	private TextField txtRG;
	@FXML
	private Label lblRg;
	@FXML
	private TextField txtEndereco;
	@FXML
	private Label lblEndereco;
	@FXML
	private TextField txtFoneFixo;
	@FXML
	private Label lblFoneFixo;
	@FXML
	private TextField txtFoneCelular;
	@FXML
	private Label lblFoneCelular;
	@FXML
	private TextField txtEmail;
	@FXML
	private Label lblEmail;
	
	private Object main;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	ColaboradorNegocio colaboradorNegocio = new ColaboradorNegocio();
	
	 // Metodo que pega valores digitados pelo usuário e seta nos atributos do pacote Model Classe ColaboradorModel
    private void pegaValores(ColaboradorModel colaborador) {
    	
    	colaborador.setCpf(txtCPF.getText());
    	colaborador.setNome(txtNome.getText());
    	colaborador.setRg(txtRG.getText());
    	colaborador.setEndereco(txtEndereco.getText());
    	colaborador.setFoneFixo(txtFoneFixo.getText());
    	colaborador.setFoneCelular(txtFoneCelular.getText());
    	colaborador.setEmail(txtEmail.getText());
   
       
    }
    private void setaValores(ColaboradorModel colaborador) {

    	txtId.setText(String.valueOf(colaborador.getId()));
        txtCPF.setText(colaborador.getCpf());
        txtNome.setText(colaborador.getNome());
        txtRG.setText(colaborador.getRg());
        txtEndereco.setText(colaborador.getEndereco());
        txtFoneFixo.setText(colaborador.getFoneFixo());
        txtFoneCelular.setText(colaborador.getFoneCelular());
        txtEmail.setText(colaborador.getEmail());

    }
    
    //metodo para salvar dados no banco
    @FXML
    private void cadastrarColaborador()throws SQLException{
        String validar;
        boolean validacao = false;
        colaborador = new ColaboradorModel();
        pegaValores(colaborador);
        validacao = validarCampos(); //chama metodo validar campos
        if(validacao) {
            if (colaborador.getId() == 0) {
                 validar = colaboradorNegocio.salvar(colaborador); // chama metodo da camada negocio de clienteNegocio
                if(validar.equals("salvo")) {
                   // clientes.add(cliente);
                   //populaView(clientes);

                    String msg = "Objeto inserido na tabela!";
                    //exibeMensagem(msg);
                    //limpaCampos();
                }else{
                    //exibeMensagem(validar);
                	System.out.println(validar);
                }
            //} else {
            	//validar = clienteNegocio.Editar(cliente); // chamada do metodo editar caso selecionado opção EDITAR
               // if (validar.equals("salvo")) {
                    //listarClientes();

                    //String msg = "Objeto editado com sucesso!";
                   //exibeMensagem(msg);

                    //limpaCampos();
                    btnCadastrar.setText("Salvar");
                //}else{
                    //exibeMensagem(validar);
                }
            }
        }

    
    
    public boolean validarCampos(){
    	
    	String cpf = txtCPF.getText();
        String nome =  txtNome.getText();
        

        List<Control>  controls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        if(cpf.equals("") || cpf == null){
            sb.append("O CPF não pode ser vazio!. \n");
            controls.add(txtCPF);
        if(nome.equals("") || nome == null){
            sb.append("O nome não pode ser vazio!. \n");
            controls.add(txtNome);
        }
       
        }
    
        exibeMensagem(sb.toString());
        animaCamposValidados(controls);

        return sb.toString().isEmpty();
}
    
    public void animaCamposValidados(List<Control> controls) {
        controls.forEach(control -> {
            RotateTransition rotateTransition = new RotateTransition(Duration.millis(60), control);
            rotateTransition.setFromAngle(-4);
            rotateTransition.setToAngle(4);
            rotateTransition.setCycleCount(8);
            rotateTransition.setAutoReverse(true);
            rotateTransition.setOnFinished((ActionEvent event1) ->{
                control.setRotate(0);
            });
            rotateTransition.play();
        });
        if(!controls.isEmpty()){
            controls.get(0).requestFocus();
        }
    }

    public void exibeMensagem(String msg){
        Notifications.create()
                .title("Atenção")
                .text(String.valueOf(msg))
                .owner(main)
                .hideAfter(Duration.seconds(3))
                .darkStyle()
                .position(Pos.TOP_RIGHT)
                .showInformation();


    }	

}
