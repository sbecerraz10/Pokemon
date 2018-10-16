package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.CompareByName;
import modelo.Player;
import modelo.Training;

public class ByNameController {

	
	
	
	
	
	
	@FXML
	private ListView<String> list;
	@FXML
	private Button btback;
	private Main main;
	
	public ByNameController() {
		
	}
	
	
	
	
	public void initialize() {
		main.loadPlayers();
		
		
		main.sortPlayersByName();
		
		list.getItems().addAll(FXCollections.observableList(listForShow()));
		
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
	
	
	
	
	
	public List<String>listForShow() {
		// TODO Auto-generated method stub
		ArrayList<String> names = new <String>ArrayList();
		for(int i=0;i<main.getTraining().getPlayers().size();i++) {	
			names.add(main.getTraining().getPlayers().get(i).getName()+ "     "+ main.getTraining().getPlayers().get(i).getScore() );
		}
		System.out.println(main.getTraining().getPlayers().size()+"");
		return names;
		
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
