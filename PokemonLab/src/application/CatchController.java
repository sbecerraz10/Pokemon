package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Player;
import modelo.Pokemon;
import modelo.Training;
/**
 * Clase CatchController
 * @author Sebastian Becerra Z. A00352804
 * @version sep-18-2018
 */

public class CatchController{

	//Atributos
	@FXML
	private Pane pane_pokemon;
	@FXML
	private Pane pane_flag;
	@FXML
	private Label lbplayer_name;
	@FXML
	private Label lbscore;
	@FXML
	private Label lbtime;
	@FXML
	private Button btSavegame;
	@FXML
	private Button btbyname;
	@FXML
	private Button btbyscore;
	
	private TranslateTransition transition;
	
	private Main main;
	
	
	
	/**
	 * Constructor
	 * Empty
	 */
	public CatchController() {
		
	}
	
	
	
	/**
	 * Method initialize
	 * Must initialize the class
	 * @param link: link of pokemon's gif
	 */
	public void initialize(Pokemon pk, Player p) {
		
		startAnimation(pk.getLinkgif());
			lbplayer_name.setText(p.getName());
			lbscore.setText(p.getScore()+"");
			lbtime.setText(transition.getCurrentTime().toSeconds()+"");
		
		
		pane_pokemon.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				
				if(Training.LIMIT-(pane_pokemon.getTranslateX()*-1)>pane_flag.getLayoutX()){
					transition.stop();
					pane_pokemon.getChildren().clear();
					pane_pokemon.getChildren().add(new ImageView(new Image("/images/Pokebola.png".toString(),100,100,false,true)));
					
					p.setScore(pane_pokemon.getTranslateX()*-1);
					lbscore.setText(p.getScore()+"");
				}
			}
			
		});
		

		
		btSavegame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
					savePlayer(p);
			}
		});
		

		btbyname.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent t) {
				try {
					openByName(t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btbyscore.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent t) {
				try {
					openByScore(t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void startAnimation(URL link) {
	
		pane_pokemon.getChildren().add(new ImageView(new Image(link.toString(),100,100,false,true)));
		pane_pokemon.setVisible(true);
		pane_flag.setVisible(true);
		pane_flag.getChildren().add(new ImageView(new Image("/images/flag3.png".toString(),100,100,false,true)));
		transition = new TranslateTransition();
		int speed = (int)(1+Math.random()*4);
		transition.setDuration(Duration.seconds(speed));
		transition.setNode(pane_pokemon);
		transition.setCycleCount(Animation.INDEFINITE);
		transition.setToX(-Training.LIMIT);
		transition.play();
		
	}
	

	
	public void savePlayer(Player player) {
		main.savePlayer(player);
	}
	
	

	public void openByName(MouseEvent t) throws Exception {
		try {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("ByName.fxml")); 
			Parent showMenu = loader.load();
			ByNameController mc =  loader.getController();
			Scene sceneMenu = new Scene(showMenu);
			Stage windowMenu = (Stage)((Node) t.getSource()).getScene().getWindow();
			windowMenu.getIcons().add(new Image("images/Pokebola.png"));
			windowMenu.setScene(sceneMenu);
			windowMenu.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openByScore(MouseEvent t) throws Exception {
		try {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("ByScore.fxml")); 
			Parent showMenu = loader.load();
			Scene sceneMenu = new Scene(showMenu);
			Stage windowMenu = (Stage)((Node) t.getSource()).getScene().getWindow();
			windowMenu.setScene(sceneMenu);
			windowMenu.getIcons().add(new Image("images/Pokebola.png"));
			windowMenu.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	


	
	
}
