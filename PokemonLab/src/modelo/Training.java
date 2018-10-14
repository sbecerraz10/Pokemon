package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Clase Training
 * @author Sebastian Becerra Z. A00352804
 * @version sep-18-2018
 */

public class Training {
	//Atributos
	private ArrayList<Pokemon> pokemons;
	
	private ArrayList<Player> players;
	
	
	
	/**
	 * Constructor
	 * Initialize the pokemon's list
	 */
	public Training() {
		pokemons = new <Pokemon>ArrayList();
		players = new <Player>ArrayList();
		createPokemons();
	}
	
	
	/**
	 * Method addPokemon
	 * Add a Pokemon object to the list
	 * @param pk: Pokemon Object
	 */
	public void addPokemon(Pokemon pk) {
		pokemons.add(pk);
	}

	
	
	/**
	 * Method getPokemons
	 * @return pokemons: List of pokemons
	 */
	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void setPokemons(ArrayList<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	
	
	/**
	 * 
	 * @param p
	 */
	public void setPlayer(Player p) {
		players.add(p);
	}
	
	
	
	
	/**
	 * Method createPokemons
	 * Brings the links of the image and the gif, create an object type
	 * Pokemon, then add it to the List
	 * pre: Pokemons!=null
	 * pre: URL exist
	 */
	public void createPokemons() {
		

		
		URL linkimagepikachu = getClass().getResource("/images/Pikachu.jpg");
		URL linkgifpikachu = getClass().getResource("/images/Pikachu_running.gif");
		Pokemon pikachu = new Pokemon("Pikachu",linkimagepikachu,linkgifpikachu);
		pokemons.add(pikachu);
		
		URL linkimagepokedex = getClass().getResource("/images/pokedex.png");
		URL linkgifpokedex = getClass().getResource("/images/Pokedex_gif.gif");
		Pokemon pokedex = new Pokemon("Pokedex",linkimagepokedex,linkgifpokedex);
		pokemons.add(pokedex);
		
		URL linkimagecharizard = getClass().getResource("/images/Charizard.png");
		URL linkgifcharizard = getClass().getResource("/images/Charizard_gif.gif");
		Pokemon charizard = new Pokemon("Charizard",linkimagecharizard,linkgifcharizard);
		pokemons.add(charizard);
		
	}
	
	public void loadPlayers() {
		ArrayList<Player> playersclone = (ArrayList<Player>) players.clone();
		
		try {
			FileInputStream filein = new FileInputStream("file/players.ser");
			ObjectInputStream obj = new ObjectInputStream(filein);
			playersclone = (ArrayList<Player>) obj.readObject();
			players = playersclone;
			System.out.println(players.size());
			obj.close();
			filein.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		
		}
		
	}
	
	public void savePlayer(Player p) {
		FileOutputStream fileOutS = null;
		ObjectOutputStream salida = null;

		try
		{
			
			fileOutS = new FileOutputStream("file/players.ser");
			salida = new ObjectOutputStream(fileOutS);
			boolean stop = false;
//			for(int i=0;i<p.size() && !stop;i++) {
//				if(p.get(i).getName().equals(player.getName())) {
//					p.remove(i);
//					p.add(i, player);
//					stop = true;
//				}else	p.add(player);
//			}
//			
			
			if(players.contains(p)) {
				System.out.println("SII ENTRO");
				int pos = players.indexOf(p);
				players.remove(p);
				players.add(p);
			}else players.add(p); 
			
			
			
			salida.writeObject(players);
			salida.close();
			fileOutS.close();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Saved");
			alert.setHeaderText("Information");
			alert.setContentText("The player has been saved successfully");
			System.out.println(p);
			alert.showAndWait();
		}catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	
	
	public ArrayList<Player> sortPlayersByScore(){
		ArrayList<Player> sort_players = new ArrayList<Player>();
		sort_players = (ArrayList<Player>) players.clone();
		
		for (int i = 0; i < sort_players.size(); i++) {
			Player top = sort_players.get(i);
			int cual = i;	
			//We select the top one
			for (int j = i+1; j < sort_players.size(); j++) {
				if(sort_players.get(j).compareTo(top) > 0) {
					top = sort_players.get(j);
					cual = j;
				}
			}
			
			
			//Interchange
			Player p1 = sort_players.get(i);
			sort_players.set(i, top);
			sort_players.set(cual,p1);
			
		}
		
		this.setPlayers(sort_players);
		
		
		return sort_players;
		
	}
	
	
	public ArrayList<Player> sortPlayersByName(){
		ArrayList<Player> sort_players = new ArrayList<Player>();
		sort_players = (ArrayList<Player>) players.clone();
		
		
		for(int i=0;i<sort_players.size();i++) {
			Player top = sort_players.get(i);
			int cual = i;
			//We select the top one
			for(int j=i+1;j<sort_players.size();j++) {
				CompareByName cm = new CompareByName();
				if(cm.compare(top, sort_players.get(j)) < 0) {
					top = sort_players.get(j);
					cual = j;
					
					
				}
			}
			
			
			//Interchange
			Player p1 = sort_players.get(i);
			sort_players.set(i,top);
			sort_players.set(cual, p1);
			
			
			
		}
		
		this.setPlayers(sort_players);
		
		return sort_players;
	}
	
	public ArrayList<String> getPlayersNames(){
		ArrayList<String> names =  new ArrayList<String>();
		ArrayList<Player> pla = sortPlayersByName();
		for(int i =0;i<pla.size();i++) {
			names.add(pla.get(i).getName());
		}
		return names;
	}
	
	public int searchPlayer(String name) throws NullPointerException {
		ArrayList<Player> psorted = sortPlayersByName();
		int center=0;
		int higher= players.size()-1 ;
		int lower=0;
		Player p1 = new Player(name,0);
		
		
		while(lower<=higher) {
			center = (higher+lower)/2;
			CompareByName cm = new CompareByName();
			if(psorted.get(center).getName().equalsIgnoreCase(name)) {
				return center;
			}else if(cm.compare(p1,players.get(center) ) > 0) {
				higher = center - 1;
			}else {
				lower = center + 1;
			}
			
		}
		
		return -1;
	}
	
	
	public ArrayList<Pokemon> sortPokemons(){
		ArrayList<Pokemon> pokemons_sorted = new ArrayList<Pokemon>();
	 	pokemons_sorted = (ArrayList<Pokemon>) pokemons.clone();
		for (int i = 0; i < pokemons_sorted.size(); i++) {
			Pokemon top = pokemons_sorted.get(i);
			int cual = i;
			//We Select the top one
			for (int j = i + 1 ; j < pokemons_sorted.size(); j++) {
				if(top.compareTo(pokemons_sorted.get(j)) > 0) {
					top = pokemons_sorted.get(j);
					cual = j;
				}
			}
			//Interchange
			Pokemon p1 = pokemons_sorted.get(i);
			pokemons_sorted.set(i,top);
			pokemons_sorted.set(cual, p1);
			
		}
	 	this.setPokemons(pokemons_sorted);
	 	
		return pokemons_sorted;
	}
	
	public int searchPokemon(String name) {
		
		ArrayList<Pokemon> psorted = sortPokemons();
		int center=0;
		int higher= pokemons.size()-1 ;
		int lower=0;
		Pokemon p1 = new Pokemon(name);
		
		
		while(lower<=higher) {
			center = (higher+lower)/2;
			if(psorted.get(center).getName().equalsIgnoreCase(name)) {
				return center;
			}else if(p1.compareTo(psorted.get(center)) < 0) {
				higher = center - 1;
			}else {
				lower = center + 1;
			}
			
		}
		return -1;
	}
	
	
	
	
}
