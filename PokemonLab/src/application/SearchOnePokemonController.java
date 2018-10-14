package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Player;
import modelo.Pokemon;

public class SearchOnePokemonController {

	
	

	
	@FXML
	private ListView listview;
	@FXML
	private TextField textfield;
	@FXML
	private Button btback;
	@FXML
	private Button btsearch;
	
	private Main main;
	
	public SearchOnePokemonController() {
		
	}
	
	
	public void initialize() {
		main.getTraining().sortPokemons();
		ArrayList<Pokemon> pokemons = main.getTraining().getPokemons();
		
		textfield.setOnMouseClicked(new EventHandler<Event>() {
			
			public void handle(Event t) {
				String name = textfield.getText();
				try {
					int pos = main.getTraining().searchPokemon(name);
					if(pokemons.get(pos)==null) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("404 EROR");
						alert.setHeaderText("404 ERROR- Pokemon doesn't exist");
						alert.setContentText("Couldn't find the pok");
						alert.showAndWait();	
					}else {
					listview.getItems().addAll(pokemons.get(pos).getName());
					}
				}catch(NullPointerException e) {
					e.printStackTrace();
				}catch(IndexOutOfBoundsException e) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("404 EROR");
					alert.setHeaderText("404 ERROR- Pokemon doesn't exist");
					alert.setContentText("Couldn't find the pok");
					alert.showAndWait();	
				}
			}
		});
		
		btback.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent t) {
				try {
				openBack(t);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	
	
	public void openBack(MouseEvent t) throws Exception {
		try {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("Register.fxml")); 
			Parent showMenu = loader.load();
			Scene sceneMenu = new Scene(showMenu);
			Stage windowMenu = (Stage)((Node) t.getSource()).getScene().getWindow();
			windowMenu.setScene(sceneMenu);
			windowMenu.show();
			windowMenu.getIcons().add(new Image("images/Pokebola.png"));
			windowMenu.setTitle("REGISTER MENU");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
