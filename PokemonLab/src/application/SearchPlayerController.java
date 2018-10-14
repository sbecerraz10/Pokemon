package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.util.Callback;
import modelo.Player;

public class SearchPlayerController {

	@FXML
	private ListView listview;
	@FXML
	private TextField textfield;
	@FXML
	private Button btback;
	
	private Main main;
	
	public SearchPlayerController() {
		
	}
	
	
	public void initialize() {
		main.loadPlayers();
		main.sortPlayersByName();
		showPlayers(listForShow());
		
		
	}
	
	public void showPlayers(List<String> list) {
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
