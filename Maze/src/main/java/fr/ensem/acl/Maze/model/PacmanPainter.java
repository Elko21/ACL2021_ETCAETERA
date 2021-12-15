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
	private int WIDTH;
	private int HEIGHT;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */
	public PacmanPainter(PacmanGame jeu) {
		this.jeu = jeu;
		this.WIDTH = this.jeu.getLabyrinthe().getL() * 50;
		this.HEIGHT = this.jeu.getLabyrinthe().getH() * 50;
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		//crayon.setColor(Color.DARK_GRAY);
		//crayon.fillOval(1,1,10,10);
		drawGround(im);
		for(int i = 0; i < this.jeu.getLabyrinthe().getH(); i++) {
			for(int j = 0; j < this.jeu.getLabyrinthe().getL(); j++) {
				switch(this.jeu.getLabyrinthe().getTerrain(i,j)) 
				{
					case '-':
						drawWall(im,50*j,50*i);
						break;
					case '+':
						break;
					case 'h':
						drawHeros(im);
						break;
					case 't':
						drawTresor(im);
						break;		
					case 'm':
						drawMonstre(im);
						break;
				}					
			}
			
		}
		
	}
	
	public void drawGround(BufferedImage im) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		groundgraph.setColor(Color.LIGHT_GRAY);
		groundgraph.fillRect(0,0,WIDTH,HEIGHT);
	}
	
	public void drawWall(BufferedImage im,int X, int Y) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		groundgraph.setColor(Color.DARK_GRAY);
		groundgraph.fillRect(X,Y,50,50);
	}
	
	public void drawHeros(BufferedImage im) {
		Graphics2D herograph = (Graphics2D) im.getGraphics();
		herograph.setColor(Color.BLUE);
		herograph.fillOval(this.jeu.getLabyrinthe().getHero().getPosX(),this.jeu.getLabyrinthe().getHero().getPosY(), 50, 50);
	}
	
	public void drawTresor(BufferedImage im) {
		Graphics2D tresgraph = (Graphics2D) im.getGraphics();
		tresgraph.setColor(Color.YELLOW);
		tresgraph.fillOval(this.jeu.getLabyrinthe().getTresor().getPosX(),this.jeu.getLabyrinthe().getTresor().getPosY(),50,50);
	}
	
	public void drawMonstre(BufferedImage im) {
		Graphics2D monstregraph = (Graphics2D) im.getGraphics();
		monstregraph.setColor(Color.RED);
		monstregraph.fillOval(this.jeu.getLabyrinthe().getMonstre().getPosX(),this.jeu.getLabyrinthe().getMonstre().getPosY(), 50, 50);
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
