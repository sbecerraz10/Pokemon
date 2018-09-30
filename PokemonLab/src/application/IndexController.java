package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Player;
import modelo.Training;
/**
 * Clase IndexController
 * @author Sebastian Becerra Z. A00352804
 * @version sep-18-2018
 */

public class IndexController {
//	
//	//Atributos
//	@FXML
//	private Button btPikachu;
//	@FXML
//	private Button btCharizard;
//	@FXML
//	private Button btPokedex;
//	@FXML
//	private Button btRegister;	
//	@FXML 
//	private Label lbMessage; 
//	
//	protected Training training;
//	
//	
//	/**
//	 * Constructor
//	 * Instance a Training Object
//	 */
//	public IndexController() {
//		training = new Training();
//	}
//	
//	
//	
//	
//	/**
//	 * Method initialize
//	 * Must initialize the class
//	 */
//	public void initialize(){
//		
//		btPikachu.setText("");
//		btCharizard.setText("");
//		btPokedex.setText("");
//		btPikachu.setGraphic(new ImageView(new Image(training.getPokemons().get(0).getLinkimage().toString(),222,157,false,true)));
//		btCharizard.setGraphic(new ImageView(new Image(training.getPokemons().get(1).getLinkimage().toString(),221,156,false,true)));
//		btPokedex.setGraphic(new ImageView(new Image(training.getPokemons().get(2).getLinkimage().toString(),221,156,false,true)));
//		
//		btPokedex.setDisable(true);
//		btCharizard.setDisable(true);
//		btPikachu.setDisable(true);
//		
//		
//		btRegister.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent t) {
//				TextInputDialog dialog = new TextInputDialog();
//				dialog.setTitle("Player Register");
//				dialog.setHeaderText("Register To Play!");
//				dialog.setContentText("Please enter your name:");
//
//				// Traditional way to get the response value.
//				Optional<String> result = dialog.showAndWait();
//				if (result.isPresent()){
//				    //System.out.println("Your name: " + result.get());
//				    String name = result.get();
//				    training.setPlayer(new Player(name,0,0));
//					btPokedex.setDisable(false);
//					btCharizard.setDisable(false);
//					btPikachu.setDisable(false);
//					btRegister.setDisable(true);
//				}
//
//				// The Java 8 way to get the response value (with lambda expression).
//				result.ifPresent(name -> System.out.println("Your name: " + name));
//			}
//		});
//		
//		btPikachu.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent t) {
//				try {
//					openMenu(t);
//					training.setIdClick(1);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		});
//		
//		
//		btCharizard.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent t) {
//				try {
//					training.setIdClick(2);
//					openMenu(t);
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		});
//		
//		btPokedex.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent t) {
//				try {
//					training.setIdClick(3);
//					openMenu(t);
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		});
//		
//	}
//	
//	
//	/**
//	 * Method openMenu
//	 * @param t:Event
//	 * @throws IOException - Exception for files
//	 */
//	public void openMenu(MouseEvent t) throws IOException {
//
//		try { 
//			FXMLLoader loader=new FXMLLoader(getClass().getResource("Menu.fxml")); 
//			Parent root = (Parent) loader.load(); 
//			MenuController menController=loader.getController(); 
//			if(training.getIdClick()==1) {
//				menController.initialize(training.getIdClick(),training.getPokemons().get(0).getLinkgif());
//			}if(training.getIdClick()==2) {
//				menController.initialize(training.getIdClick(),training.getPokemons().get(1).getLinkgif());
//			}if(training.getIdClick()==3) {
//				menController.initialize(training.getIdClick(),training.getPokemons().get(2).getLinkgif());
//			}
//			
//			
//			
//			Stage stage=new Stage(); 
//			stage.setScene(new Scene(root)); 
//			stage.show(); 	
//		} catch (IOException e) { 
//				e.printStackTrace();
//		}
//		
//	}
//	
//	
	
}
