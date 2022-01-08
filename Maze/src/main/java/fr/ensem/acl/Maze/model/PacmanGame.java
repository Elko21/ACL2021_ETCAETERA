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
				
				boolean monsterCantMove=true;
				if (isCommande) { //Si on a une commande
					while (monsterCantMove) {
						int xMonsterNext,yMonsterNext; //Prochaine position possible du monstre
						int xMonster_old=this.maze.getMonstre().getPosX(); //Position actuelle
						int yMonster_old=this.maze.getMonstre().getPosY();
						
						xMonsterNext= this.maze.getMonstre().posVoisineRandom()[0]; //Prochaine position est la position voisine random
						yMonsterNext= this.maze.getMonstre().posVoisineRandom()[1];
						
						// On choisit une position accessible pour le monstre
						if (xMonster_old-xMonsterNext==50 && yMonster_old-yMonsterNext==0){
							this.maze.getMonstre().setDirection('q');
							if (this.maze.canMove(xMonsterNext/50, yMonsterNext/50)) {
								this.maze.getMonstre().moveTo(xMonsterNext,yMonsterNext);
							}
							break;
						}
						else if (xMonster_old-xMonsterNext==-50 && yMonster_old-yMonsterNext==0){
							this.maze.getMonstre().setDirection('d');
							if (this.maze.canMove(xMonsterNext/50, yMonsterNext/50)) {
								this.maze.getMonstre().moveTo(xMonsterNext,yMonsterNext);
							}
							break;

						}
						else if (xMonster_old-xMonsterNext==0 && yMonster_old-yMonsterNext==50){
							this.maze.getMonstre().setDirection('z');
							if (this.maze.canMove(xMonsterNext/50, yMonsterNext/50)) {
								this.maze.getMonstre().moveTo(xMonsterNext,yMonsterNext);
							}
							break;

						}
						else if (xMonster_old-xMonsterNext==0 && yMonster_old-yMonsterNext==-50){
							this.maze.getMonstre().setDirection('s');
							if (this.maze.canMove(xMonsterNext/50, yMonsterNext/50)) {
								this.maze.getMonstre().moveTo(xMonsterNext,yMonsterNext);
							}
							break;
						}
					
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
