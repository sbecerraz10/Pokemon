package modelo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

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



	
}
