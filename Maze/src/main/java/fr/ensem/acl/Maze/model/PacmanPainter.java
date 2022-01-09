package fr.ensem.acl.Maze.model;

import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Font;

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
		this.HEIGHT = (this.jeu.getLabyrinthe().getH()+1) * 50;
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
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
					case 's':
						drawSquelette(im);
						break;
					case 'f':
						drawFantome(im);
						break;
				}					
			}
		}
		drawHP(im);
		drawEndingMessage(im);
		drawHP(im);
	}
	
	public void drawGround(BufferedImage im) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		groundgraph.setColor(new Color(208,212,92));
		groundgraph.fillRect(0,0,this.WIDTH,this.HEIGHT);
	}
	
	public void drawWall(BufferedImage im, int X, int Y) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/img/Other/Misc/Bush.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		groundgraph.drawImage(img,X+2,Y+2,46,46, null);
	}
	
	public void drawHeros(BufferedImage im) {
		int k=0;
		char dir=this.jeu.getLabyrinthe().getHero().getDirection();
		
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/img/Character/Char_one/Char_4_sides.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (dir=='s'){
			k=0;
			
		}
		else if (dir=='d'){
			k=1;
		}
		else if (dir=='z'){
			k=2;
		}
		else if(dir=='q'){
			k=3;
		}
		
		
		int X=this.jeu.getLabyrinthe().getHero().getPosX()+2;
		int Y=this.jeu.getLabyrinthe().getHero().getPosY()+2;
		groundgraph.drawImage(img,X,Y,46+X,46+Y,16*k,0,16*k+16,16, null);
	}
	
	public void drawTresor(BufferedImage im) {
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/img/Other/Misc/Chest1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		groundgraph.drawImage(img,this.jeu.getLabyrinthe().getTresor().getPosX()+2,this.jeu.getLabyrinthe().getTresor().getPosY()+2,46,46, null);
	}
	
	public void drawSquelette(BufferedImage im) {
		int k=0;
		char dir=this.jeu.getLabyrinthe().getSquelette().getDirection();
		
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/img/Skeleton/Skel_4Sides.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (dir=='s'){
			k=0;
			
		}
		else if (dir=='d'){
			k=1;
		}
		else if (dir=='z'){
			k=2;
		}
		else if(dir=='q'){
			k=3;
		}
		
		
		int X=this.jeu.getLabyrinthe().getSquelette().getPosX()+2;
		int Y=this.jeu.getLabyrinthe().getSquelette().getPosY()+2;
		groundgraph.drawImage(img,X,Y,46+X,46+Y,16*k,0,16*k+16,16, null);
	}
	
	public void drawFantome(BufferedImage im) {
		
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/img/Ghost/ghost.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		int X=this.jeu.getLabyrinthe().getFantome().getPosX()+2;
		int Y=this.jeu.getLabyrinthe().getFantome().getPosY()+2;
		groundgraph.drawImage(img,X,Y,46,46, null);
		}
	public void drawEndingMessage(BufferedImage im) {
		Graphics g = (Graphics) im.getGraphics();
		String endText;
		
		Font font = new Font("Courier", Font.BOLD, 50);
	    
		g.setFont(font);
	    g.setColor(Color.BLACK);
	    
		if (this.jeu.isFinished()) if(this.jeu.getLabyrinthe().getHero().getHP() == 0) endText= "Ouch !!! Le monstre vous a eu ..."; 
		else endText = "Le TRESOR !!! Vous êtes riche !";
		else if (this.jeu.isTrapTriggered()) endText = "Un PIEGE !!! Vous êtes mort !";
		else endText = "";
		
	    g.drawString(endText, Math.round(this.WIDTH/2) - 25*Math.round(endText.length()/2), Math.round((this.HEIGHT-50)/2));
	}
	
	public void drawHP(BufferedImage im) {
		Graphics g = (Graphics) im.getGraphics();
		Graphics2D groundgraph = (Graphics2D) im.getGraphics();
		
		Font font = new Font("Arial", Font.BOLD, 25);
		g.setFont(font);
	    g.setColor(Color.BLACK);
	    g.drawString("HP",this.WIDTH-50,this.HEIGHT-20);
	    
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("resources/img/Other/Heart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < this.jeu.getLabyrinthe().getHero().getHP(); i++) {
			groundgraph.drawImage(img,(this.WIDTH-90)-i*50,this.HEIGHT-40,25,25, null);
		}
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
