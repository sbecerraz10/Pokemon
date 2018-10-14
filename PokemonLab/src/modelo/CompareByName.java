package modelo;

import java.util.Comparator;

public class CompareByName implements Comparator<Player> {

	
	@Override
	public int compare(Player p1, Player p2) {
		// TODO Auto-generated method stub
		return p2.getName().compareToIgnoreCase(p1.getName());
		
	}
	
	
	
}
