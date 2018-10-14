package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Player;
import modelo.Pokemon;
import modelo.Training;
/**
 * Clase MenuController
 * @author Sebastian Becerra Z. A00352804
 * @version oct-02-2018
 */

public class MenuController{
	
	
	@FXML
	private Button btthrowpk;
	@FXML
	private Button btcatchpk;
	@FXML
	private Label lbMessage;
	@FXML
	private Label lbMessage1;
	@FXML
	private Pane pane;
	@FXML
	private Pane pane_preview ;
	@FXML
	private ComboBox pokemon_option;
	@FXML
	private BorderPane bpane;
	
	
	private Main main;
	
	private Pokemon pokemon;
	
	
	public MenuController() {
		
	}
	
	
	public void initialize(Player p) {
		pokemon = new Pokemon();
		setWallpaper();
		btthrowpk.setDisable(true);
		btcatchpk.setDisable(true);
		
		
		
		pokemon_option.setItems(FXCollections.observableArrayList(
				
				
				listForShow()
				)
				
				
		);
		
		
		pokemon_option.valueProperty().addListener(new ChangeListener<String>() {
			
			

			@Override
			public void changed(ObservableValue ov, String oldValue, String newValue) {
				
				String option = (String) pokemon_option.getValue();
				if(!option.isEmpty()) {
					//Enable Buttons
					btthrowpk.setDisable(false);
					btcatchpk.setDisable(false);
					//Search for the pokemon selected
					boolean stop = false;
					int times = 0;
					for(int i=0;i<main.getTraining().getPokemons().size() || !stop ;i++) {
						
						if(option.equals(main.getTraining().getPokemons().get(i).getName())) {
							pokemon = main.getTraining().getPokemons().get(i);
							//Then We Show The Preview
							pane_preview.getChildren().add(new ImageView(new Image(main.getTraining().getPokemons().get(i).getLinkgif().toString(),100,100,false,true)));
							pokemon.setLinkgif(main.getTraining().getPokemons().get(i).getLinkgif());
							stop = true;
						}if(times==main.getTraining().getPokemons().size()) {
							stop = true;
						}
						times++;
					}
					
					
					
				}
			}
		});
		
		
		lbMessage1.setText(p.getName());
		
		
		btthrowpk.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				try {
					openThrow(t,p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		btcatchpk.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				try {
					
					openCatch(t,p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
		List<String> pok_names = names;
		return names;
	}




	public void setWallpaper() {
		Image image1 = new Image("images/pokemon-background-.jpg");
		BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		Background background2 = new Background(new BackgroundImage(image1,
	            BackgroundRepeat.NO_REPEAT,
	            BackgroundRepeat.NO_REPEAT,
	            BackgroundPosition.CENTER,
	            bSize));
		bpane.setBackground(background2);
		
	}
	
	
	

	
	public void openThrow(MouseEvent t, Player p) throws IOException {

		try { 
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Throw.fxml")); 
			Parent showThrow = loader.load(); 
			ThrowController trController=loader.getController(); 
			trController.initialize(pokemon,p);
			Scene sceneThrow = new Scene(showThrow);
			Stage windowThrow =  (Stage)((Node) t.getSource()).getScene().getWindow();
			windowThrow.getIcons().add(new Image("images/Pokebola.png"));
			windowThrow.setScene(sceneThrow);
			windowThrow.show();
			
		} catch (IOException e) { 
				e.printStackTrace();
		}
		
	}
	
	
	public void openCatch(MouseEvent t,Player p) throws IOException{
		try { 
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Catch.fxml")); 
			Parent showCatch = loader.load(); 
			CatchController ctController=loader.getController(); 
			ctController.initialize(pokemon,p);
			Scene sceneCatch = new Scene(showCatch);
			Stage windowCatch =  (Stage)((Node) t.getSource()).getScene().getWindow();
			windowCatch.getIcons().add(new Image("images/Pokebola.png"));
			windowCatch.setTitle("CATCH MODE");
			windowCatch.setScene(sceneCatch);
			windowCatch.show();
		} catch (IOException e) { 
				e.printStackTrace();
		}
		
	}
	
	
	
	
}
