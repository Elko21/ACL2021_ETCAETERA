package fr.ensem.acl.Maze.engine;

import java.awt.event.KeyListener;

import fr.ensem.acl.Maze.model.Cmd;

/**
 * @author Horatiu Cirstea
 * 
 * controleur qui envoie des commandes au jeu 
 * 
 */
public interface GameController extends KeyListener {

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd[] getCommand();

}
