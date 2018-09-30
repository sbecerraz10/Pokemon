package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
/**
 * Clase Main
 * @author Sebastian Becerra Z. A00352804
 * @version sep-18-2018
 */


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Register.fxml"));
			Scene scene = new Scene(root,759,428);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method main
	 * @param args: String arrangement
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
