package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import modelo.Player;



public class ChoosePlayerController {

	
	@FXML
	private ListView lv_players;
	@FXML
	private Button btConfirm;
	
	private ArrayList<Player> players;
	
	
	
	public ChoosePlayerController() {
		
	}
	
	
	
	
	public void initialize() {
		players = new ArrayList<Player>();
		loadPlayers();
		//System.out.println(players.size());
		lv_players.getItems().addAll(FXCollections.observableList(listForShow()));
		lv_players.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
		
		
		btConfirm.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				
				openMenu();
			}

			
		});
		
		
	}
	
	
	public void loadPlayers() {
		ArrayList<Player> playersclone = (ArrayList<Player>) players.clone();
		
		try {
			FileInputStream filein = new FileInputStream("file/players.ser");
			ObjectInputStream obj = new ObjectInputStream(filein);
			playersclone = (ArrayList<Player>) obj.readObject();
			players = playersclone;
			obj.close();
			filein.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		
		}
		
	}
	
	
	public List<String>listForShow() {
		// TODO Auto-generated method stub
		ArrayList<String> names = new <String>ArrayList();
		for(int i=0;i<players.size();i++) {	
			names.add(players.get(i).getName());
		}
		return names;
	}
	
	public void openMenu() {
		// TODO Auto-generated method stub
		
	}
	
}
