package fr.ensem.acl.Maze;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import fr.ensem.acl.Maze.model.*;
public class PersonnageTest {
	private Labyrinthe lab;

	@Before
	public void setUp() throws Exception {
		this.lab = new Labyrinthe("resources/maps/mapTest.txt");
	}
	
	@Test
	public void testAttackHero() throws Exception {
		int hp1 = this.lab.getFantome().getHP();
		this.lab.getHero().setPosX(100);
		this.lab.getHero().setPosY(100);
		this.lab.getFantome().setPosX(150);
		this.lab.getFantome().setPosY(100);
		this.lab.getHero().setDirection('s');
		this.lab.getHero().attack(this.lab.getFantome());
		int hp2 = this.lab.getFantome().getHP();
		assertEquals(hp1-1,hp2);
	}
	@Test 
	public void testAttackHerosansvie() throws Exception{
		this.lab.getHero().setHP(0);
		this.lab.getHero().setPosX(150);
		this.lab.getHero().setPosY(100);
		this.lab.getFantome().setPosX(100);
		this.lab.getFantome().setPosY(100);
		this.lab.getFantome().setDirection('s');
		this.lab.getFantome().attack(this.lab.getHero());
		assertEquals(this.lab.getHero().getHP(),0);
	}
	
	@Test
	public void testCanAttack() throws Exception {
		this.lab.getHero().setPosX(150);
		this.lab.getHero().setPosY(100);
		this.lab.getFantome().setPosX(100);
		this.lab.getFantome().setPosY(100);
		this.lab.getFantome().setDirection('s');
		boolean a1 = this.lab.getFantome().canAttack(this.lab.getHero());
		assertEquals(a1,true);
	}
	@Test
	public void testCanAttackFalse() throws Exception {
		this.lab.getHero().setPosX(150);
		this.lab.getHero().setPosY(100);
		this.lab.getFantome().setPosX(100);
		this.lab.getFantome().setPosY(100);
		this.lab.getHero().setDirection('s');
		boolean a1 = this.lab.getHero().canAttack(this.lab.getFantome());
		assertEquals(a1,false);
	}
	@Test 
	public void testSelfAttack() throws Exception {
		boolean a1 = this.lab.getHero().canAttack(this.lab.getHero());
		assertEquals(a1,false);
	}
}
