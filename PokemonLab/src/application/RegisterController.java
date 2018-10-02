package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Player;
import modelo.Training;
/**
 * Class RegisterController
 * @author Sebastian Becerra Z. A00352804
 * @version sept-27-2018
 */
public class RegisterController {
	
	@FXML
	private BorderPane bpane;
	@FXML
	private Button btopenplayer;
	@FXML
	private Button btaddplayer;
	
	//private Training training;
	
	
	public RegisterController() {
		
	}
	
	
	
	
	public void initialize() {
		//training = new Training();
		setWallpaper();
		
		
		
		//Open the window that contains all the already registered players
		btopenplayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent t) {
				try {
					openChoosePlayer(t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		//Pass the new player to the Menu Window
		btaddplayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent t) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Player Register");
				dialog.setHeaderText("Register To Play!");
				dialog.setContentText("Please enter your name:");

				
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()){
				    
				    String name = result.get();
				    Player p = new Player(name,0);
				    //training.setPlayer(p);
				    try {
						openMenu(t,p);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		
		
		
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
	
	public void openChoosePlayer(MouseEvent t) throws Exception {
		try {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("ChoosePlayer.fxml")); 
			Parent showMenu = loader.load();
			Scene sceneMenu = new Scene(showMenu);
			Stage windowMenu = (Stage)((Node) t.getSource()).getScene().getWindow();
			windowMenu.setScene(sceneMenu);
			windowMenu.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
