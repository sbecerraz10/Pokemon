package application;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import modelo.Player;
import modelo.Training;

public class ByNameController {

	
	
	
	
	
	
	@FXML
	private ListView<String> list;

	
	private Training training;
	
	public ByNameController() {
		
	}
	
	
	
	
	public void initialize() {
		training =  new Training();
		loadPlayers();
		
		//ObservableList<Player> list = (ObservableList) training.getPlayers();
		//tview.setItems(list);
		
		sortPlayersByName();
		
		list.getItems().addAll(FXCollections.observableList(listForShow()));
		
		//tview.setItems((ObservableList) listForShow());
		//names.getColumns().addAll(listForShow());
	}
	
	
	public void loadPlayers() {
		ArrayList<Player> playersclone = (ArrayList<Player>) training.getPlayers().clone();
		
		try {
			FileInputStream filein = new FileInputStream("file/players.ser");
			ObjectInputStream obj = new ObjectInputStream(filein);
			playersclone = (ArrayList<Player>) obj.readObject();
			System.out.println(playersclone.size());
			training.setPlayers(playersclone);
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
		for(int i=0;i<training.getPlayers().size();i++) {	
			names.add(training.getPlayers().get(i).getName()+ "     "+ training.getPlayers().get(i).getScore() );
		}
		System.out.println(training.getPlayers().size()+"");
		return names;
		
	}
	
	
	public ArrayList<Player> sortPlayersByName(){
		ArrayList<Player> sort_players = new ArrayList<Player>();
		sort_players = (ArrayList<Player>) training.getPlayers().clone();
		
		
		return sort_players;
	}
	
	
	
	
}
