package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import modelo.Player;



public class ChoosePlayerController {

	
	@FXML
	private ComboBox cb_players;
	@FXML
	private Button btConfirm;
	
	private ArrayList<Player> players;
	
	
	
	public ChoosePlayerController() {
		
	}
	
	
	
	
	public void initialize() {
		loadPlayers();
		
		cb_players.setItems(FXCollections.observableArrayList(
				
				
				listForShow()
				)
				
				
		);
		
		
		
		
	}
	
	
	public void loadPlayers() {
		FileInputStream fileInStr = null;
      ObjectInputStream entrada = null;
      Player p;

      try {		
      	//Read the file that contents the pokemons
      	fileInStr = new FileInputStream("file/players.dat");
          entrada = new ObjectInputStream(fileInStr);
          boolean valid = true;
           for(int i=0;valid;i++) {
      	   if(entrada.available()>0) {
      		   p = (Player)entrada.readObject();
      		   players.add(p);
      	    }else valid = false;
           }
          
      } catch (FileNotFoundException e) {
  		e.getMessage();
      } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
          try {
              if (fileInStr != null) {
              	fileInStr.close();
              }
              if (entrada != null) {
                  entrada.close();
              }
          } catch (IOException e) {
              System.out.println(e.getMessage());
          }
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
	
}
