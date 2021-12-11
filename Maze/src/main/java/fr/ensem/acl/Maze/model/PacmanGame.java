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
	protected Hero heros;
	protected Tresor tresor;
	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source) {
		this.heros= new Hero(0,0);
		this.tresor = new Tresor(500,500);
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
		switch(commande){
		case LEFT:
			heros.setPosX(heros.getPosX()-50);
			break;
		case RIGHT:
			heros.setPosX(heros.getPosX()+50);
			break;
		case DOWN:
			heros.setPosY(heros.getPosY()+50);
			break;
		case UP:
			heros.setPosY(heros.getPosY()-50);
			break;
		}
		
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		
		return heros.getPosX()==tresor.getPosX() && heros.getPosY()==tresor.getPosY();
	}

}
