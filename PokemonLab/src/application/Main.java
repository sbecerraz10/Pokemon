package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Player;
import modelo.Training;
import modelo.Pokemon;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
/**
 * Clase Main
 * @author Sebastian Becerra Z. A00352804
 * @version oct-11-2018
 */


public class Main extends Application {
	
	
	private static Training training;
	
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
		training = new Training();
		launch(args);
	}
	
	public static void men() {
		System.out.println("hpla");
	}
	
	
	public static void loadPlayers() {
		training.loadPlayers();
	}
	public static void sortPlayersByScore() {
		training.sortPlayersByScore();
	}
	public static void sortPlayersByName() {
		training.sortPlayersByName();
	}
	public static Training getTraining() {
		return training;
	}
	public static void  savePlayer(Player p) {
		loadPlayers();
		training.savePlayer(p);
	}
	public List<String> getPlayersName(){
		loadPlayers();
		return (List<String>)training.getPlayersNames();
	}
	
	public int searchPlayer(String name) throws NullPointerException {
		return training.searchPlayer(name);
	}
	
	public ArrayList<Pokemon> sortPokemons() {
		return training.sortPokemons();
	}
	

	
	
	
}
