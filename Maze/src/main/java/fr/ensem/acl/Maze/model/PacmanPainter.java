package fr.ensem.acl.Maze.model;

import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

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
		groundgraph.setColor(new Color(208,212,92));
		groundgraph.fillRect(0,0,WIDTH,HEIGHT);
	}
	
	public void drawWall(BufferedImage im,int X, int Y) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("..\\Graphism icons\\Tiny Adventure Pack\\Tiny Adventure Pack\\Other\\Misc\\Bush.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		groundgraph.drawImage(img,X+2,Y+2,46,46, null);
	}
	
	public void drawHeros(BufferedImage im) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("..\\Graphism icons\\Tiny Adventure Pack\\Tiny Adventure Pack\\Character\\Char_one\\Idle\\character1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		groundgraph.drawImage(img,this.jeu.getLabyrinthe().getHero().getPosX()+2,this.jeu.getLabyrinthe().getHero().getPosY()+2,46,46, null);
	}
	
	public void drawTresor(BufferedImage im) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("..\\Graphism icons\\Tiny Adventure Pack\\Tiny Adventure Pack\\Other\\Misc\\Chest1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		groundgraph.drawImage(img,this.jeu.getLabyrinthe().getTresor().getPosX()+2,this.jeu.getLabyrinthe().getTresor().getPosY()+2,46,46, null);
	}
	
	public void drawMonstre(BufferedImage im) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("..\\Graphism icons\\Tiny Adventure Pack\\Tiny Adventure Pack\\Skeleton\\Idle\\Skeleton1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		groundgraph.drawImage(img,this.jeu.getLabyrinthe().getMonstre().getPosX()+2,this.jeu.getLabyrinthe().getMonstre().getPosY()+2,46,46, null);
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
