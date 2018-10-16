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
 * Clase ThrowController
 * @author Sebastian Becerra Z. A00352804
 * @version oct-15-2018
 */

public class ThrowController {
	//Atributos
	@FXML
	private Pane pane_pokemon;
	@FXML
	private Pane pane_flag;
	@FXML
	private Button btSavegame;
	@FXML
	private Label lbplayer_name;
	@FXML
	private Label lbscore;
	@FXML
	private Label lbtime;
	@FXML
	private Button btbyname;
	@FXML
	private Button btbyscore;
	
	private Main main;
	
	
	private TranslateTransition transition;
	
	
	
	
	/**
	 * Constructor
	 * Empty
	 */
	public ThrowController() {
		
	}
	
	

	/**
	 * Method initialize
	 * Must initialize the class
	 * @param link: link of pokemon's gif
	 */
	public void initialize(Pokemon pk,Player player) {
		
		pane_pokemon.getChildren().add(new ImageView(new Image("/images/Pokebola.png".toString(),100,100,false,true)));
		pane_pokemon.setVisible(true);
		pane_flag.getChildren().add(new ImageView(new Image("/images/flag3.png".toString(),100,100,false,true)));
		pane_flag.setVisible(true);
		
		transition = new TranslateTransition();
		int speed = (int)(1+Math.random()*4);
		transition.setDuration(Duration.seconds(speed));
		transition.setNode(pane_pokemon);
		
		
		lbplayer_name.setText(player.getName());
		lbscore.setText(player.getScore()+"");
		lbtime.setText(transition.getCurrentTime().toSeconds()+"");
		
	
		
		
		btSavegame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				savePlayers(player);
			}
		});
		
		
		pane_pokemon.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				pane_pokemon.getChildren().clear();
				pane_pokemon.getChildren().add(new ImageView(new Image(pk.getLinkgif().toString(),100,100,false,true)));
				transition.setToX(-550);
				transition.play();
				player.setScore(Training.LIMIT-Player.POINT3_SCORE);
				lbscore.setText(player.getScore()+"");
			}
			
		});
		
		
		transition.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
					
				
					transition.stop();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Distancia recorrida por el pokemon");
					alert.setContentText(pane_pokemon.getTranslateX()*-1+"");
					alert.show();
					
			
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

	public void savePlayers(Player player) {
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
