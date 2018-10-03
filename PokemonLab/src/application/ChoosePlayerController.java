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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
				String name = (String) lv_players.getSelectionModel().getSelectedItem();
				for(int i=0;i<players.size();i++) {
					if(players.get(i).getName().equals(name)) {
						Player p = players.get(i);
						try {
							openMenu(t,p);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
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
	
	
	
	public void openMenu(MouseEvent t,Player p) throws Exception {
		try {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("Menu.fxml")); 
			Parent showMenu = loader.load();
			MenuController mc =  loader.getController();
			mc.initialize(p);
			Scene sceneMenu = new Scene(showMenu);
			Stage windowMenu = (Stage)((Node) t.getSource()).getScene().getWindow();
			windowMenu.setScene(sceneMenu);
			windowMenu.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
