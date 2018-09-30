package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelo.Player;
/**
 * Clase ThrowController
 * @author Sebastian Becerra Z. A00352804
 * @version sep-18-2018
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
	public void initialize(URL link,Player player) {
		
		
		
		pane_pokemon.getChildren().add(new ImageView(new Image("/images/Pokebola.png".toString(),100,100,false,true)));
		pane_pokemon.setVisible(true);
		pane_flag.getChildren().add(new ImageView(new Image("/images/flag3.png".toString(),100,100,false,true)));
		pane_flag.setVisible(true);
		transition = new TranslateTransition();
		int speed = (int)(1+Math.random()*4);
		transition.setDuration(Duration.seconds(speed));
		
		transition.setNode(pane_pokemon);
		//transition.setCycleCount(Animation.INDEFINITE);
		
		
		lbplayer_name.setText(player.getName());
		lbscore.setText(player.getScore_catch()+"");
		lbtime.setText(transition.getCurrentTime().toSeconds()+"");
		
		
		btSavegame.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {

				FileOutputStream fileOutS = null;
				ObjectOutputStream salida = null;
				Player p = null;

				try
				{
					
					fileOutS = new FileOutputStream("file/players.dat");
					salida = new ObjectOutputStream(fileOutS);
					
					p = player;
					salida.writeObject(p);
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Saved");
					alert.setHeaderText("Information");
					alert.setContentText("The player has been saved successfully");

					alert.showAndWait();
				}catch(FileNotFoundException e)
				{
					System.out.println(e.getMessage());
				}catch(IOException e)
				{
					System.out.println(e.getMessage());
				}finally
				{
					try {
						if (p != null)
							fileOutS.close();
						if (salida != null)
							salida.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
		
		
		pane_pokemon.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				pane_pokemon.getChildren().clear();
				pane_pokemon.getChildren().add(new ImageView(new Image(link.toString(),100,100,false,true)));
				transition.setToX(-550);
				transition.play();
				
			}
			
		});
		
		
		transition.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
			
				
				if(pane_pokemon.getTranslateX()*-1<=pane_flag.getLayoutX()+500) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("Distancia recorrida por el pokemon");
				alert.setContentText(pane_pokemon.getTranslateX()*-1+"");
				alert.show();
				transition.stop();
				transition.setCycleCount(Animation.INDEFINITE);
				}
			}
			
		});
		
	
		
	}
	
	
}
