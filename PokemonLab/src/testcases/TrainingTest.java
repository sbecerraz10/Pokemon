package testcases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Player;
import modelo.Training;

class TrainingTest {

	
	private Training training;
	private ArrayList<Player> expected;
	
	public TrainingTest() {
		
		
	}
	
	public void escenario1() {
		training =  new Training();
		Player p1  = new Player("Sebastian",450);
		Player p2  = new Player("Xavier",500);
		Player p3  = new Player("Ana",1000);
		Player p4  = new Player("Philippe",250);
		
		training.setPlayer(p1);
		training.setPlayer(p2);
		training.setPlayer(p3);
		training.setPlayer(p4);
		
		expected = new ArrayList<Player>();
		expected.add(p3);
		expected.add(p2);
		expected.add(p1);
		expected.add(p4);
	}
	

	public void escenario2() {
		training =  new Training();
		Player p1  = new Player("Sebastian",450);
		Player p2  = new Player("Xavier",500);
		Player p3  = new Player("Ana",1000);
		Player p4  = new Player("Philippe",250);
		
		training.setPlayer(p1);
		training.setPlayer(p2);
		training.setPlayer(p3);
		training.setPlayer(p4);
		
		expected = new ArrayList<Player>();
		expected.add(p3);
		expected.add(p4);
		expected.add(p1);
		expected.add(p2);
	}
	
	
	@Test
	public void testSortByScore() {
		escenario1();
		training.sortPlayersByScore();
		assertTrue(training.sortPlayersByScore().equals(expected));
	}
	
	
	@Test
	public void testSortByName() {
		escenario2();
		training.sortPlayersByName();
		assertTrue(training.sortPlayersByName().equals(expected));
	}
	
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
