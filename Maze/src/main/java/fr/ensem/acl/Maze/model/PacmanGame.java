package fr.ensem.acl.Maze.model;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import fr.ensem.acl.Maze.engine.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class PacmanGame implements Game {
	private Labyrinthe maze;
	
	public Labyrinthe getLabyrinthe() {
		return this.maze;
	}
	
	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source) {
		this.maze = new Labyrinthe(20,30);
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
	}
	
	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		System.out.println("Execute "+commande);
		int x = this.maze.getHero().getPosX();
		int y = this.maze.getHero().getPosY();
		
		switch(commande){
		case LEFT:
			x = x - 50;
			break;
		case RIGHT:
			x = x + 50;
			break;
		case DOWN:
			y = y + 50;
			break;
		case UP:
			y = y -50;
			break;
		}
		
		
		// Vérification si zone accessible
		if (this.maze.canMove(x/50,y/50)) {
			// Zone accessible donc le héro se déplace et laisse une case libre derrière lui
			this.maze.setTerrain((this.maze.getHero().getPosY()/50),(this.maze.getHero().getPosX()/50),'+');
			// Mise à jour de la position du héro
			this.maze.getHero().moveTo(x,y);
			this.maze.setTerrain((this.maze.getHero().getPosY()/50),(this.maze.getHero().getPosX()/50),'h');			
		}
		
		
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		
		return this.maze.getHero().getPosX()==this.maze.getTresor().getPosX() && this.maze.getHero().getPosY()==this.maze.getTresor().getPosY();
	}

}
