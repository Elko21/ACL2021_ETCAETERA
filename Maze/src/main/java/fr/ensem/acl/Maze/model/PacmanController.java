package fr.ensem.acl.Maze.model;

import java.awt.event.KeyEvent;

import fr.ensem.acl.Maze.engine.GameController;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * controleur de type KeyListener
 * 
 */
public class PacmanController implements GameController {

	/**
	 * commande Action (attack, defend, take)
	 */
	private Cmd cmdActionEnCours;
	
	/**
	 * detection de relachement de l'attaque
	 */
	private boolean isReleased = true;
	
	/**
	 * commande en cours
	 */
	private Cmd cmdDirectionEnCours;
	
	
	
	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public PacmanController() {
		this.cmdActionEnCours = Cmd.IDLE;
		this.cmdDirectionEnCours = Cmd.IDLE;
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd[] getCommand() {
		Cmd[] cmd = {this.cmdDirectionEnCours,this.cmdActionEnCours};
		return cmd;
	}
	
	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		// si on appuie sur 'q',commande joueur est gauche
		case KeyEvent.VK_Q:
		case KeyEvent.VK_LEFT:
			this.cmdDirectionEnCours = Cmd.LEFT;
			break;
		case KeyEvent.VK_Z:
		case KeyEvent.VK_UP:
			this.cmdDirectionEnCours = Cmd.UP;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			this.cmdDirectionEnCours = Cmd.DOWN;
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			this.cmdDirectionEnCours = Cmd.RIGHT;
			break;
		case KeyEvent.VK_SPACE:
			if (this.isReleased) { this.isReleased = false; this.cmdActionEnCours = Cmd.ATTACK; }
			else this.cmdActionEnCours = Cmd.IDLE;
			break;
		}
	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		this.cmdDirectionEnCours = Cmd.IDLE;
		
		this.isReleased = true;
		this.cmdActionEnCours = Cmd.IDLE;
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {
		
	}

}
