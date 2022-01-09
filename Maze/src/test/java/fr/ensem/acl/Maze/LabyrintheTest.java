package fr.ensem.acl.Maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ensem.acl.Maze.model.*;

public class LabyrintheTest {
	private Labyrinthe lab, labVide;
	
	@Before
	public void setUp() throws Exception {
		this.lab = new Labyrinthe("resources/maps/mapTest.txt");
	}
	
	@Test
	public void testLabyrintheVide() {
		assertNull(this.labVide);
	}
	
	@Test
	public void testLabyrintheSansSource() {
		this.labVide = new Labyrinthe("");
		// assertNull(this.labVide);
	}
	
	@Test
	public void testLabyrintheNonVide() {
		assertNotNull(this.lab);
	}
	
	@Test
	public void testPositionEntites() {
		assertEquals(this.lab.getHero().getPosX()/50,1);
		assertEquals(this.lab.getHero().getPosY()/50,1);
		
		assertEquals(this.lab.getSquelette().getPosX()/50,5);
		assertEquals(this.lab.getSquelette().getPosY()/50,3);
		
		assertEquals(this.lab.getFantome().getPosX()/50,3);
		assertEquals(this.lab.getFantome().getPosY()/50,4);
		
		assertEquals(this.lab.getTP().getPosX()/50,1);
		assertEquals(this.lab.getTP().getPosY()/50,5);
		
		assertEquals(this.lab.getTrap().getPosX()/50,3);
		//assertEquals(this.lab.getTrap().getPosY()/50,2);
		
		assertEquals(this.lab.getTresor().getPosX()/50,5);
		assertEquals(this.lab.getTresor().getPosY()/50,5);
		
		System.out.println("X : " + Integer.toString(this.lab.getTP().getPosY()/50) + " | Y : " + Integer.toString(this.lab.getTP().getPosX()/50));
	}

}
