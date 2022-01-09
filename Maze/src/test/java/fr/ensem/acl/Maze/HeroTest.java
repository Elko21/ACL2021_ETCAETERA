package fr.ensem.acl.Maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ensem.acl.Maze.model.*;

public class HeroTest {
	private Labyrinthe lab;
	
	@Before
	public void setUp() throws Exception {
		this.lab = new Labyrinthe("resources/maps/mapTest.txt");
	}
	
	@Test
	public void testFinTerrainCoteGauche() throws Exception {
		this.lab.getHero().setPosX(0);
		int x = this.lab.getHero().getPosX()/50;
			
		// assertFalse(this.lab.canMove(x-1,this.lab.getHero().getPosY()/50));
	}
	
	@Test
	public void testFinTerrainCoteDroit() throws Exception {
		this.lab.getHero().setPosX(6*50);
		int x = this.lab.getFantome().getPosX()/50;
			
		// assertFalse(this.lab.canMove(x+1,this.lab.getHero().getPosY()/50));
	}

}
