package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.util.Callback;
import modelo.Player;

public class SearchOnePlayerController {

	
	
	
	@FXML
	private ListView listview;
	@FXML
	private TextField textfield;
	@FXML
	private Button btback;
	@FXML
	private Button btsearch;
	
	private Main main;
	
	public SearchOnePlayerController() {
		
	}
	
	
	public void initialize() {
		main.loadPlayers();
		main.sortPlayersByName();
		ArrayList<Player> players = main.getTraining().getPlayers();
		
		textfield.setOnMouseClicked(new EventHandler<Event>() {
			
			public void handle(Event t) {
				String name = textfield.getText();
				try {
					int pos = main.getTraining().searchPlayer(name);
					if(players.get(pos)==null) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("404 EROR");
						alert.setHeaderText("404 ERROR- Player doesn't exist");
						alert.setContentText("Couldn't find the player");
						alert.showAndWait();	
					}else {
					listview.getItems().addAll(players.get(pos).getName() + " " + players.get(pos).getScore());
					}
				}catch(NullPointerException e) {
					e.printStackTrace();
				}catch(IndexOutOfBoundsException e) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("404 EROR");
					alert.setHeaderText("404 ERROR- Player doesn't exist");
					alert.setContentText("Couldn't find the player");
					alert.showAndWait();	
				}
			}
		});
		
		btsearch.setOnMouseClicked(new EventHandler<Event>() {
			
			public void handle(Event t) {
				String name = textfield.getText();
				try {
					int pos = main.getTraining().searchPlayer(name);
					if(players.get(pos)==null) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("404 EROR");
						alert.setHeaderText("404 ERROR- Player doesn't exist");
						alert.setContentText("Couldn't find the player");
						alert.showAndWait();	
					}else {
					listview.getItems().addAll(players.get(pos).getName() + " " + players.get(pos).getScore());
					}
				}catch(NullPointerException e) {
					e.printStackTrace();
				}catch(IndexOutOfBoundsException e) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("404 EROR");
					alert.setHeaderText("404 ERROR- Player doesn't exist");
					alert.setContentText("Couldn't find the player");
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
