package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CursoModel {
	
	private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty cpf = new SimpleStringProperty();
    private final SimpleStringProperty nome = new SimpleStringProperty();
    private final SimpleStringProperty rg = new SimpleStringProperty();
    private final SimpleStringProperty endereco = new SimpleStringProperty();
    
    
    public CursoModel(){
    	
    }
    
    
    
    
	public SimpleIntegerProperty getId() {
		return id;
	}
	public void setId(SimpleIntegerProperty id) {
		this.id = id;
	}
	public SimpleStringProperty getCpf() {
		return cpf;
	}
	public SimpleStringProperty getNome() {
		return nome;
	}
	public SimpleStringProperty getRg() {
		return rg;
	}
	public SimpleStringProperty getEndereco() {
		return endereco;
	}
    

}
