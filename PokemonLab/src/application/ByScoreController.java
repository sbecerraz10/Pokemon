package application;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Player;
import modelo.Training;

public class ByScoreController {

	
	
	@FXML
	private ListView<String> list;

	
	private Training training;
	
	public ByScoreController() {
		
	}
	
	
	
	
	public void initialize() {
		training =  new Training();
		loadPlayers();
		
		//ObservableList<Player> list = (ObservableList) training.getPlayers();
		//tview.setItems(list);
		
		sortPlayersByScore();
		
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
	
	
	public ArrayList<Player> sortPlayersByScore(){
		ArrayList<Player> sort_players = new ArrayList<Player>();
		sort_players = (ArrayList<Player>) training.getPlayers().clone();
		
		//Collections.sort(sort_players, training.COMPARE_BY_SCORE);
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < sort_players.size(); i++) {
			Player p1 = sort_players.get(i);
			int cual = i;	
			//Se selecciona el menor 
			for (int j = i+1; j < sort_players.size(); j++) {
				Player p2 = sort_players.get(j);
				if(p2.compareTo(p1)>0) {
					p1 = p2;
					cual = j;
				}
			}
			
			//Intercambio
			//int n = arr[i];
			//arr[cual] = n;
			
			Player p3 = sort_players.get(i);
			sort_players.set(i,p1);
			
			
					
		}
		//return System.currentTimeMillis() - t1;
		
		
		
		return sort_players;
	}
	
	
	
	
	
	
}
