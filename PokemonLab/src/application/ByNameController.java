package application;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import modelo.CompareByName;
import modelo.Player;
import modelo.Training;

public class ByNameController {

	
	
	
	
	
	
	@FXML
	private ListView<String> list;

	private Main main;
	
	public ByNameController() {
		
	}
	
	
	
	
	public void initialize() {
		main.loadPlayers();
		
		
		main.sortPlayersByName();
		
		list.getItems().addAll(FXCollections.observableList(listForShow()));
		
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
	
	
	
	
	
	
}
