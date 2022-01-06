package fr.ensem.acl.Maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ensem.acl.Maze.model.*;

public class MazeTest {
	private Hero hero;
	private Monstre monstre;
	private Piege piege;
	private Mur mur;
	private Labyrinthe lab;
	
	@Before
	public void setUp() throws Exception {
		hero = new Hero(5,5);
		monstre = new Monstre(6,5);
	}

	@Test
	public void test1MoveTo() {
		hero.moveTo(hero.getPosX(),6);
		assertEquals(6,hero.getPosY());
	}
	
	@Test
	public void test2MoveTo() {
		hero.moveTo(6,5);
		assertEquals(6,hero.getPosX());
	}

}
