package fr.ensem.acl.Maze.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fr.ensem.acl.Maze.engine.GamePainter;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class PacmanPainter implements GamePainter {
	private PacmanGame jeu;
	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 100;
	protected static final int HEIGHT = 100;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */
	public PacmanPainter(PacmanGame jeu) {
		this.jeu = jeu;
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		//crayon.setColor(Color.DARK_GRAY);
		//crayon.fillOval(1,1,10,10);
		drawHeros(im);
		drawTresor(im);
	}
	public void drawHeros(BufferedImage im) {
		Graphics2D herograph = (Graphics2D) im.getGraphics();
		herograph.setColor(Color.red);
		herograph.fillOval(jeu.heros.getX(),jeu.heros.getY(), 100, 100);
	}	
	public void drawTresor(BufferedImage im) {
		Graphics2D tresgraph = (Graphics2D) im.getGraphics();
		tresgraph.setColor(Color.yellow);
		tresgraph.fillOval(jeu.tresor.getX(),jeu.tresor.getY(),100,100);
	}
	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

}
