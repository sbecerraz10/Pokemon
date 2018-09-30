package application;

import java.net.URL;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelo.Player;
/**
 * Clase CatchController
 * @author Sebastian Becerra Z. A00352804
 * @version sep-18-2018
 */

public class CatchController {

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
	
	
	
	public static final int LIMIT = 600;
	private TranslateTransition transition;
	
	
	
	
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
	public void initialize(URL link, Player p) {
		
		
		startAnimation(link);
			lbplayer_name.setText(p.getName());
			lbscore.setText(p.getScore_catch()+"");
			lbtime.setText(transition.getCurrentTime().toSeconds()+"");
		
		
		pane_pokemon.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				
				if(LIMIT-(pane_pokemon.getTranslateX()*-1)>pane_flag.getLayoutX()){
					transition.stop();
					pane_pokemon.getChildren().clear();
					pane_pokemon.getChildren().add(new ImageView(new Image("/images/Pokebola.png".toString(),100,100,false,true)));
					
				}
			}
			
		});
		

		transition.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
//					transition.playFromStart();
				//	transition.playFrom(Duration.seconds(0.0));
				
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
		transition.setToX(-LIMIT);
		transition.play();
		
	}
	
	
}
