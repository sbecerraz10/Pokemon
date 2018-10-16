package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SearchPokemonController {
	@FXML
	private ListView listview;
	@FXML
	private TextField textfield;
	@FXML
	private Button btback;
	
	private Main main;
	
	public SearchPokemonController() {
		
	}
	
	
	public void initialize() {
		main.getTraining().sortPokemons();
		showPokemons(listForShow());
		
		
	}
	
	public void showPokemons(List<String> list) {
		//'myListView' is your ListView, 'myTextField' is your textfield
		ObservableList<String> rawData = FXCollections.observableArrayList(list);
		FilteredList<String> filteredList= new FilteredList<>((ObservableList)rawData, data -> true);
		listview.setItems(filteredList);
		textfield.textProperty().addListener(((observable, oldValue, newValue) -> {
		        filteredList.setPredicate(data -> {
		            if (newValue == null || newValue.isEmpty()){
		                return true;
		            }
		            String lowerCaseSearch = newValue.toLowerCase();
		            if(data.contains(lowerCaseSearch)) {
		            	return true;
		            }else 
		            	return false;
		            
		            
		        });	
		    }));
		 //Wrap the FilteredList in a SortedList.
	    SortedList<String> sortedData = new SortedList<>(filteredList);

	    //put the sorted list into the listview
	    listview.setItems(sortedData);
	    

	    listview.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
	        public ListCell<String> call(ListView<String> param) {
	            final Label leadLbl = new Label();
	            final Tooltip tooltip = new Tooltip();
	            final ListCell<String> cell = new ListCell<String>(){
	              @Override
	                public void updateItem(String item, boolean empty){
	                  super.updateItem(item,empty);
	                  if(item != null){
	                      leadLbl.setText(item);
	                      setText(item);
	                      tooltip.setText(item);
	                      setTooltip(tooltip);
	                  }else {
	                	  leadLbl.setText("");
	                	  setText("");
	                  }
	              }
	            };
	            return cell;
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
	
	public List<String>listForShow() {
		// TODO Auto-generated method stub
		ArrayList<String> names = new <String>ArrayList();
		for(int i=0;i<main.getTraining().getPokemons().size();i++) {	
			names.add(main.getTraining().getPokemons().get(i).getName());
		}
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
