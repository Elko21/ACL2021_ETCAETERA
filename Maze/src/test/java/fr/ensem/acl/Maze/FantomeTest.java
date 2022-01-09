package fr.ensem.acl.Maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ensem.acl.Maze.model.*;

public class FantomeTest {
	private Labyrinthe lab;

	@Before
	public void setUp() throws Exception {
		this.lab = new Labyrinthe("resources/maps/mapTest.txt");
	}
	
	@Test
	public void testFinTerrainCoteGauche() throws Exception {
		this.lab.getFantome().setPosX(0);
		int x = this.lab.getFantome().getPosX()/50;
			
		// assertFalse(this.lab.canMoveFantome(x-1,this.lab.getFantome().getPosY()/50));
	}

	@Test
	public void testFinTerrainCoteDroit() throws Exception {
		this.lab.getFantome().setPosX(6*50);
		int x = this.lab.getFantome().getPosX()/50;
			
		// assertFalse(this.lab.canMoveFantome(x+1,this.lab.getFantome().getPosY()/50));
	}

}
