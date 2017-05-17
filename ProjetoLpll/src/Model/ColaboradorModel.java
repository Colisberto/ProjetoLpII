package Model;
/*
 Classe onde se define todos atributos do Objeto e seus metodos gheters e seters
 */

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ColaboradorModel {
	
	private SimpleIntegerProperty id = new SimpleIntegerProperty();
	private final SimpleStringProperty login = new SimpleStringProperty();
	private final SimpleStringProperty senha = new SimpleStringProperty();
    private final SimpleStringProperty cpf = new SimpleStringProperty();
    private final SimpleStringProperty nome = new SimpleStringProperty();
    private final SimpleStringProperty rg = new SimpleStringProperty();
    private final SimpleStringProperty endereco = new SimpleStringProperty();
    private final SimpleStringProperty foneFixo = new SimpleStringProperty();
    private final SimpleStringProperty foneCelular = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();
    
    
    
    // metodo Costrutor da classe
    public  ColaboradorModel(String cpf, String nome ) {
    	
    	this.cpf.set(cpf);
        this.nome.set(nome);
      

    }

	public ColaboradorModel() { // metodo construtor Vasio.
		
	}
	public int  getId() {
		return id.get();
	}

    public SimpleIntegerProperty idProperty() {
        return id;
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public String getLogin() {
		return login.get();
	}
	public SimpleStringProperty loginProperty() {
        return login;
    }
	public void setLogin(String login) {
        this.login.set(login);
    }
	public String getSenha() {
		return senha.get();
	}
	public SimpleStringProperty senhaProperty() {
        return senha;
    }
	public void setSenha(String senha) {
        this.senha.set(senha);
    }

    public String getCpf() {
		return cpf.get();
	}
	public SimpleStringProperty cpfProperty() {
        return cpf;
    }
	public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }
	public String getNome() {
		return nome.get();
	}
	
	public SimpleStringProperty nomeProperty() {
	        return nome;
    }
	 
	 public void setNome(String nome) {
	        this.nome.set(nome);
    }
	 public String getRg() {
			return rg.get();
		}
	 public SimpleStringProperty rgProperty() {
	        return rg;
	    }
	 public void setRg(String rg) {
	        this.rg.set(rg);
	    }
	 public String getEndereco() {
			return endereco.get();
		}
	 public SimpleStringProperty enderecoProperty() {
	        return endereco;
	    }
	 public void setEndereco(String endereco) {
	        this.endereco.set(endereco);
	    }
	 public String getFoneFixo() {
			return foneFixo.get();
		}
	 public SimpleStringProperty foneFixoProperty() {
	        return foneFixo;
	    }
	 public void setFoneFixo(String foneFixo) {
	        this.foneFixo.set(foneFixo);
	    }
	 public String getFoneCelular() {
			return foneCelular.get();
		}
	 public SimpleStringProperty foneCelularProperty() {
	        return foneFixo;
	    }
	 public void setFoneCelular(String foneCelular) {
	        this.foneCelular.set(foneCelular);
	    }
	 public String getEmail() {
			return email.get();
		}
	 public SimpleStringProperty emailProperty() {
	        return email;
	    }
	 public void setEmail(String email) {
	        this.email.set(email);
	    }

}
