package modelo;

import java.io.Serializable;

/**
 * Class Player
 * @author Sebastian Becerra Z. A00352804
 * @version oct-01-2018
 */
public class Player implements Serializable {

	
	//Atributos
	
	private String name;
	private int score;
	
	/**
	 * Constructor
	 * @param name :name of the player
	 * @param score :score of the player
	 */
	public Player(String name,int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}



	
	
	
}
