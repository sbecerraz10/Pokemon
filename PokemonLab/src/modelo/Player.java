package modelo;

import java.io.Serializable;
import java.util.Comparator;

import application.CatchController;

/**
 * Class Player
 * @author Sebastian Becerra Z. A00352804
 * @version oct-01-2018
 */
public class Player implements Serializable, Comparable<Player> {

	
	//Atributos y Constantes
	
	public static double POINT1 = 250;
	public static double POINT2 = 500;
	public static double POINT3 = 750;
	
	public static int POINT1_SCORE = 750;
	public static int POINT2_SCORE = 500;
	public static int POINT3_SCORE = 250;
	
	
	
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

	public void setScore(double x) {
		
		if(x < POINT1) {
			score+= POINT1_SCORE;
		}else if(x < POINT2 && x > POINT1) {
			score += POINT2_SCORE;
		}else if(x < POINT3 && x > POINT2) {
			score += POINT3_SCORE;
		}
		
		
	}


	
	@Override
	public int compareTo(Player other) {
		// TODO Auto-generated method stub
		int r = 0;
		if(this.score > other.getScore()) {
			r = 1;
		}else r = -1;
		
		return r;
	}

	


	
	
	
}
