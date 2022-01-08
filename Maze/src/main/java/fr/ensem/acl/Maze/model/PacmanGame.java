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
		this.maze = new Labyrinthe("resources/maps/maze.txt");
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
	public void evolve(Cmd cmdDir,Cmd cmdAction) {
		System.out.println("Execute " + cmdDir + " and " + cmdAction);
		int x = this.maze.getHero().getPosX();
		int y = this.maze.getHero().getPosY();
		
		boolean isCommande = false;
		switch(cmdDir){
		case LEFT:
			x = x - 50;
			this.maze.getHero().setDirection('q');
			isCommande = true;
			break;
		case RIGHT:
			x = x + 50;
			this.maze.getHero().setDirection('d');
			isCommande = true;
			break;
		case DOWN:
			y = y + 50;
			this.maze.getHero().setDirection('s');
			isCommande = true;
			break;
		case UP:
			y = y -50;
			this.maze.getHero().setDirection('z');
			isCommande = true;
			break;
		}
		
		// Processus d'attaque du héros quand commande activée 
		if (cmdAction == Cmd.ATTACK) this.maze.getHero().attack(this.maze.getMonstre());
		
		// Vérification si zone accessible
		if (this.maze.canMove(x/50,y/50)) {
			// Zone accessible donc le personnage (héros ou monstre) se déplace et laisse une case libre derrière lui
			this.maze.setTerrain((this.maze.getHero().getPosY()/50),(this.maze.getHero().getPosX()/50),'+');
			this.maze.setTerrain((this.maze.getMonstre().getPosY()/50),(this.maze.getMonstre().getPosX()/50),'+');
			// Mise à jour de la position du héro
			this.maze.getHero().moveTo(x,y);
			this.maze.setTerrain((this.maze.getHero().getPosY()/50),(this.maze.getHero().getPosX()/50),'h');			
			
			// Mise à jour de la position du/des monstre(s)
			// Vérifier d'abord si le monstre n'est pas mort
			if (this.maze.getMonstre().getHP() != 0) {
				// Processus d'attaque du monstre quand proche du héros
				this.maze.getMonstre().attack(this.maze.getHero());
				
				if (isCommande) {
					int xMonster,yMonster;
					int x_old=this.maze.getMonstre().getPosX();
					int y_old=this.maze.getMonstre().getPosY();
					
					xMonster= this.maze.getMonstre().posVoisineRandom()[0];
					yMonster= this.maze.getMonstre().posVoisineRandom()[1];
					
					if (x_old-xMonster==50 && y_old-yMonster==0){
						this.maze.getMonstre().setDirection('q');
					}
					else if (x_old-xMonster==-50 && y_old-yMonster==0){
						this.maze.getMonstre().setDirection('d');
					}
					else if (x_old-xMonster==0 && y_old-yMonster==50){
						this.maze.getMonstre().setDirection('z');
					}
					else if (x_old-xMonster==0 && y_old-yMonster==-50){
						this.maze.getMonstre().setDirection('s');
					}
					
					if (this.maze.canMove(xMonster/50, yMonster/50)) {
						this.maze.getMonstre().moveTo(xMonster,yMonster);
					}
					isCommande=false;
				}
				this.maze.setTerrain((this.maze.getMonstre().getPosY()/50),(this.maze.getMonstre().getPosX()/50),'m');
			}
			
			
			if (this.maze.getTP().canTeleport(this.maze.getHero().getPosX(), this.maze.getHero().getPosY()))
			{
				this.maze.getHero().setPosX(250);
				this.maze.getHero().setPosY(100);
			}
			
		}
		
		
	}

	/**
	 * verifier si le jeu est fini
	 */
	
	@Override
	public boolean isFinished() {
		return(this.maze.getHero().getHP() == 0 || this.maze.getTresor().isEnd(this.maze.getHero().getPosX(), this.maze.getHero().getPosY()));
	}
	
	@Override
	public boolean isTrapTriggered() {
		return (this.maze.getTrap().isTriggered(this.maze.getHero().getPosX(), this.maze.getHero().getPosY()));
	}
	
	/*
	@Override
	public boolean doesMonstreAttaque() {
		return(this.maze.getHero().getPosX()==this.maze.getMonstre().getPosX() && this.maze.getHero().getPosY()==this.maze.getMonstre().getPosY());
	}
	*/

}
