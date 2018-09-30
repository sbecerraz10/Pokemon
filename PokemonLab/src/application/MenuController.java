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
 * @version sep-18-2018
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
	
	private Training training;
	
	
	private URL link;
	
	public MenuController() {
		
	}
	
	
	public void initialize(Player p) {

		training = new Training();
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
				// TODO Auto-generated method stub
				//String option = pokemon_option.getValue().toString();
				//System.out.println(pokemon_option.getValue());
				System.out.println(pokemon_option.getValue());
				String option = "Pikachu";
				if(!option.isEmpty()) {
					//Enable Buttons
					btthrowpk.setDisable(false);
					btcatchpk.setDisable(false);
					//Search for the pokemon selected
					Pokemon pk = null;
					boolean stop = false;
					int times = 0;
					for(int i=0;i<training.getPokemons().size() || !stop ;i++) {
						
						if(option.equals(training.getPokemons().get(i).getName())) {
							pk = training.getPokemons().get(i);
							//Then We Show The Preview
							pane_preview.getChildren().add(new ImageView(new Image(training.getPokemons().get(i).getLinkgif().toString(),100,100,false,true)));
							link = training.getPokemons().get(i).getLinkgif();
							stop = true;
						}if(times==training.getPokemons().size()) {
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
		for(int i=0;i<training.getPokemons().size();i++) {	
			names.add(training.getPokemons().get(i).getName());
		}
		List<String> pok_names = names;
		return names;
	}


//	public void loadpokemons() {
//		// TODO Auto-generated method stub
//		FileInputStream fileInStr = null;
//        ObjectInputStream entrada = null;
//        Pokemon p;
//
//        try {		
//        	//Read the file that contents the pokemons
//        	fileInStr = new FileInputStream("pok.dat");
//            entrada = new ObjectInputStream(fileInStr);
//            boolean valid = true;
////             for(int i=0;valid;i++) {
////        	   if(entrada.available()>0) {
////        		   p = (Pokemon)entrada.readObject();
////        		   pokemons.add(p);
////        	    }else valid = false;
////             }
//            p = (Pokemon) entrada.readObject();
//             pokemons.add(p);
//             System.out.println(pokemons.size());
//             System.out.println(p.getName());
//             
//            
//        } catch (FileNotFoundException e) {
//        	System.out.println("I dont exist");
//    		e.getMessage();
//    		loadPokForFirstTime();
//        } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//            try {
//                if (fileInStr != null) {
//                	fileInStr.close();
//                }
//                if (entrada != null) {
//                    entrada.close();
//                }
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//	}


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
	
	
	
	
//	public void loadPokForFirstTime() {
//		FileOutputStream fileout = null;
//		ObjectOutputStream objectout = null;
//		Pokemon pikachu = null;
//		//String pikachu = null;
//		
//		try {
//			fileout = new FileOutputStream("pok.dat");
//			objectout= new ObjectOutputStream(fileout);
//
//			URL linkimagepikachu = getClass().getResource("images/Pikachu.jpg");
//			URL linkgifpikachu = getClass().getResource("images/Pikachu_running.gif");
//			pikachu = new Pokemon("Pikachu",linkimagepikachu,linkgifpikachu);
//			//pikachu= "SIIII";
//			objectout.writeObject(pikachu);
//			System.out.print("Already Serialized");
//		}catch(FileNotFoundException e) {
//			e.getMessage();
//		}catch(IOException e) {
//			e.getMessage();
//		}finally {
//			try {
//				if (pikachu != null)
//					fileout.close();
//				if (objectout!= null)
//					objectout.close();
//			} catch (IOException e) {
//				System.out.println(e.getMessage());
//			}
//
//		}
//			
//	}
	
	

	
	public void openThrow(MouseEvent t, Player p) throws IOException {

		try { 
			FXMLLoader loader=new FXMLLoader(getClass().getResource("Throw.fxml")); 
			Parent showThrow = loader.load(); 
			ThrowController trController=loader.getController(); 
			trController.initialize(link,p);
			Scene sceneThrow = new Scene(showThrow);
			Stage windowThrow =  (Stage)((Node) t.getSource()).getScene().getWindow();
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
			ctController.initialize(link,p);
			Scene sceneCatch = new Scene(showCatch);
			Stage windowCatch =  (Stage)((Node) t.getSource()).getScene().getWindow();
			windowCatch.setScene(sceneCatch);
			windowCatch.show();
		} catch (IOException e) { 
				e.printStackTrace();
		}
		
	}
	
	
	
	
}
