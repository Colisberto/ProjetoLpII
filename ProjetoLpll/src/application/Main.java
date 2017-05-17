package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException  {
		
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/Visao/telaPrincipal.fxml"));
			
			Scene scene = new Scene(root,800,600);
			primaryStage.setScene(scene);
			
			
			primaryStage.setTitle(""); // TITILO DA TELA
			primaryStage.show();
		 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
