package fr.ensem.acl.Maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ensem.acl.Maze.model.*;

public class MazeTest {
	private Labyrinthe lab;
	
	@Before
	public void setUp() throws Exception {
		this.lab = new Labyrinthe("resources/maps/mapTest.txt");
	}
	
	
	@Test
	public void test1HeroLabyrinthe() {
		assertEquals(1,this.lab.getHero().getPosX()/50);
	}
	
	/*
	@Test
	public void test2HeroLabyrinthe() {
		assertEquals(1,this.lab.getHero().getPosY()/50);
	}
	
	@Test
	public void test1MonstreLabyrinthe() {
		assertEquals(1,this.lab.getSquelette().getPosX()/50);
	}
	
	@Test
	public void test2MonstreLabyrinthe() {
		assertEquals(3,this.lab.getSquelette().getPosY()/50);
	}
	
	@Test
	public void test1PiegeLabyrinthe() {
		assertEquals(3,this.lab.getTrap().getPosX()/50);
	}
	
	@Test
	public void test2PiegeLabyrinthe() {
		assertEquals(1,this.lab.getTrap().getPosY()/50);
	}
	
	@Test
	public void test1TresorLabyrinthe() {
		assertEquals(3,this.lab.getTresor().getPosX()/50);
	}
	
	@Test
	public void test2TresorLabyrinthe() {
		assertEquals(3,this.lab.getTresor().getPosY()/50);
	}
	
	@Test
	public void test1MoveTo() {
		this.lab.getHero().moveTo(this.lab.getHero().getPosX(),2*50);
		assertEquals(2,this.lab.getHero().getPosY()/50);
	}
	
	@Test
	public void test2MoveTo() {
		this.lab.getHero().moveTo(2*50,this.lab.getHero().getPosY());
		assertEquals(2,this.lab.getHero().getPosX()/50);
	}
	
	@Test
	public void testTresor() {
		this.lab.getHero().moveTo(3*50,3*50);
		assertTrue(this.lab.getTresor().isEnd(this.lab.getHero().getPosX(),this.lab.getHero().getPosY()));
	}
	
	@Test
	public void testPiege() {
		this.lab.getHero().moveTo(3*50,1*50);
		assertTrue(this.lab.getTrap().isTriggered(this.lab.getHero().getPosX(),this.lab.getHero().getPosY()));
	}
	
	@Test
	public void testMur() {
		this.lab.getHero().moveTo(3*50,1*50);
		assertTrue(this.lab.canMove(this.lab.getHero().getPosX()/50,this.lab.getHero().getPosY()/50));
	}
	*/
}

