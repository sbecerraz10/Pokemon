package modelo;

import java.io.Serializable;

/**
 * Class Player
 * @author Sebastian Becerra Z. A00352804
 * @version sept-20-2018
 */
public class Player implements Serializable {

	
	//Atributos
	
	private String name;
	private int score_throw;
	private int score_catch;
	
	/**
	 * Constructor
	 * @param name :name of the player
	 * @param score_throw :score of the throw mode
	 * @param score_catch :score of the catch mode
	 */
	public Player(String name, int score_throw, int score_catch) {
		this.name = name;
		this.score_throw = score_throw;
		this.score_catch = score_catch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore_throw() {
		return score_throw;
	}

	public void setScore_throw(int score_throw) {
		this.score_throw = score_throw;
	}

	public int getScore_catch() {
		return score_catch;
	}

	public void setScore_catch(int score_catch) {
		this.score_catch = score_catch;
	}

	
	
	
}
