package fr.ensem.acl.Maze.model;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

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
	private Labyrinthe maze2;
	
	public Labyrinthe getLabyrinthe() {
		return this.maze;
	}
	
	public Labyrinthe getMaze2(){
		return this.maze2;
		
	}
	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source) {
		
		int dif =0;
		try {
			
		while(dif > 3 || dif <1) {
		Scanner difficulty = new Scanner(System.in);
		System.out.println("Quel niveau voulez vous faire ?(1/2/3)");
		dif = difficulty.nextInt();
		}
		} catch(InputMismatchException e) {
			System.out.println("Il faut donner un chiffre entre 1 et 3");
		}
		
		switch(dif) {
		case 1:
			this.maze = new Labyrinthe("resources/maps/maze.txt");
			this.maze2 = new Labyrinthe("resources/maps/mazeplain.txt");			
			break;
		case 2:
			this.maze = new Labyrinthe("resources/maps/maze2.txt");
			this.maze2 = new Labyrinthe("resources/maps/mazeplain2.txt");
			break;
		case 3:
			this.maze = new Labyrinthe("resources/maps/maze3.txt");
			this.maze2 = new Labyrinthe("resources/maps/mazeplain3.txt");
			break;
		}
		try {
			this.maze.getHero().toString();
		}catch(NullPointerException e) {
			System.out.println("Il manque un héros");
		}
		try {
			this.maze.getFantome().toString();
		}catch(NullPointerException e) {
			System.out.println("Il manque un fantome");
		}
		try {
			this.maze.getSquelette().toString();
		}catch(NullPointerException e) {
			System.out.println("Il manque un squelette");
		}
		try {
			this.maze.getTresor().toString();
		}catch(NullPointerException e) {
			System.out.println("Il manque un trésor");
		}
		try {
			this.maze.getTrap().toString();
		}catch(NullPointerException e) {
			System.out.println("Il manque un piège");
		}
		try {
			this.maze.getTP().toString();
		}catch(NullPointerException e) {
			System.out.println("Il manque un portail");
		}
		
		
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
		
		// Processus d'attaque du héros quand commande activée 
		if (cmdAction == Cmd.ATTACK) {
			this.maze.getHero().attack(this.maze.getSquelette());
			System.out.println("PV Squelette : " + Integer.toString(this.maze.getSquelette().getHP()));
			this.maze.getHero().attack(this.maze.getFantome());
			System.out.println("PV Fantome : " + Integer.toString(this.maze.getFantome().getHP()));
		}
		
		
		switch(cmdDir){
		case LEFT:
			x = x - 50;
			this.maze.getHero().setDirection('q');
			break;
		case RIGHT:
			x = x + 50;
			this.maze.getHero().setDirection('d');
			break;
		case DOWN:
			y = y + 50;
			this.maze.getHero().setDirection('s');
			break;
		case UP:
			y = y -50;
			this.maze.getHero().setDirection('z');
			break;
		}
		
		// Vérification si zone accessible
		if (this.maze.canMove(x/50,y/50)) {
			// Zone accessible donc le personnage (héros ou monstre) se déplace et laisse une case libre derrière lui
			this.maze.setTerrain((this.maze.getHero().getPosY()/50),(this.maze.getHero().getPosX()/50),'+');


			// Mise à jour de la position du héro
			this.maze.getHero().moveTo(x,y);
			this.maze.setTerrain((this.maze.getHero().getPosY()/50),(this.maze.getHero().getPosX()/50),'h');			
			
			
			
			
			if (this.maze.getTP().canTeleport(this.maze.getHero().getPosX(), this.maze.getHero().getPosY()))
			{
				this.maze.getHero().setPosX(250);
				this.maze.getHero().setPosY(100);
			}
			
		}
		
		// Mise à jour de la position du fantome
		// Vérifier d'abord si le fantome n'est pas mort
		if (this.maze.getSquelette().getHP() > 0) {
			// Processus d'attaque du fantome quand proche du héros
			this.maze.getSquelette().attack(this.maze.getHero());
				
				// Boucle jusqu'à ce que le fantome se déplace vers une position vacante
				while (true) {
					int xSqueletteNext,ySqueletteNext; //Prochaine position possible du monstre
					int xSquelette_old=this.maze.getSquelette().getPosX(); //Position actuelle
					int ySquelette_old=this.maze.getSquelette().getPosY();
					
					xSqueletteNext= this.maze.getSquelette().posVoisineRandom()[0]; //Prochaine position est la position voisine random
					ySqueletteNext= this.maze.getSquelette().posVoisineRandom()[1];
					
					// Direction du squelette
					if (xSquelette_old-xSqueletteNext==50 && ySquelette_old-ySqueletteNext==0){
						this.maze.getSquelette().setDirection('q');
						if (this.maze.canMoveSquelette(xSqueletteNext/50, ySqueletteNext/50)) {
							this.maze.setTerrain((this.maze.getSquelette().getPosY()/50),(this.maze.getSquelette().getPosX()/50),'+');
							this.maze.getSquelette().moveTo(xSqueletteNext,ySqueletteNext);
						}
						break;
					}
					else if (xSquelette_old-xSqueletteNext==-50 && ySquelette_old-ySqueletteNext==0){
						this.maze.getSquelette().setDirection('d');
						if (this.maze.canMoveSquelette(xSqueletteNext/50, ySqueletteNext/50)) {
							this.maze.setTerrain((this.maze.getSquelette().getPosY()/50),(this.maze.getSquelette().getPosX()/50),'+');
							this.maze.getSquelette().moveTo(xSqueletteNext,ySqueletteNext);
						}
						break;

					}
					else if (xSquelette_old-xSqueletteNext==0 && ySquelette_old-ySqueletteNext==50){
						this.maze.getSquelette().setDirection('z');
						if (this.maze.canMoveSquelette(xSqueletteNext/50, ySqueletteNext/50)) {
							this.maze.setTerrain((this.maze.getSquelette().getPosY()/50),(this.maze.getSquelette().getPosX()/50),'+');
							this.maze.getSquelette().moveTo(xSqueletteNext,ySqueletteNext);
						}
						break;

					}
					else if (xSquelette_old-xSqueletteNext==0 && ySquelette_old-ySqueletteNext==-50){
						this.maze.getSquelette().setDirection('s');
						if (this.maze.canMoveSquelette(xSqueletteNext/50, ySqueletteNext/50)) {
							this.maze.setTerrain((this.maze.getSquelette().getPosY()/50),(this.maze.getSquelette().getPosX()/50),'+');
							this.maze.getSquelette().moveTo(xSqueletteNext,ySqueletteNext);
						}
						break;
					}
			}
				this.maze.setTerrain((this.maze.getSquelette().getPosY()/50),(this.maze.getSquelette().getPosX()/50),'s');

		}
		else this.maze.setTerrain((this.maze.getSquelette().getPosY()/50),(this.maze.getSquelette().getPosX()/50),'+');		// Quand monstre meurt il laisse un espace après lui
		
		
		if (this.maze.getFantome().getHP() > 0) {
			// Processus d'attaque du fantome quand proche du héros
			this.maze.getFantome().attack(this.maze.getHero());
				
				// Boucle jusqu'à ce que le fantome se déplace vers une position vacante
				while (true) {
					int xFantomeNext,yFantomeNext; //Prochaine position possible du monstre
					int xFantome_old=this.maze.getFantome().getPosX(); //Position actuelle
					int yFantome_old=this.maze.getFantome().getPosY();
					
					xFantomeNext= this.maze.getFantome().posVoisineRandom()[0]; //Prochaine position est la position voisine random
					yFantomeNext= this.maze.getFantome().posVoisineRandom()[1];
					
					// Direction du fantôme
					if (xFantome_old-xFantomeNext==50 && yFantome_old-yFantomeNext==0){
						this.maze.getFantome().setDirection('q');
						if (this.maze.canMoveFantome(xFantomeNext/50, yFantomeNext/50)) {
							
							if (this.maze2.getTerrain(yFantome_old/50, xFantome_old/50)=='+') {
								this.maze.setTerrain(yFantome_old/50,xFantome_old/50,'+');
							}
							else if (this.maze2.getTerrain(yFantome_old/50, xFantome_old/50)=='-') {
								this.maze.setTerrain(yFantome_old/50,xFantome_old/50,'-');
							}
							this.maze.getFantome().moveTo(xFantomeNext,yFantomeNext);
						}
						break;
					}
					else if (xFantome_old-xFantomeNext==-50 && yFantome_old-yFantomeNext==0){
						this.maze.getFantome().setDirection('d');
						if (this.maze.canMoveFantome(xFantomeNext/50, yFantomeNext/50)) {
							
							if (this.maze2.getTerrain(yFantome_old/50, xFantome_old/50)=='+') {
								this.maze.setTerrain(yFantome_old/50,xFantome_old/50,'+');
							}
							else if (this.maze2.getTerrain(yFantome_old/50, xFantome_old/50)=='-') {
								this.maze.setTerrain(yFantome_old/50,xFantome_old/50,'-');
							}
							this.maze.getFantome().moveTo(xFantomeNext,yFantomeNext);
						}
						break;
					}
					else if (xFantome_old-xFantomeNext==0 && yFantome_old-yFantomeNext==50){
						this.maze.getFantome().setDirection('z');
						if (this.maze.canMoveFantome(xFantomeNext/50, yFantomeNext/50)) {
							
							if (this.maze2.getTerrain(yFantome_old/50, xFantome_old/50)=='+') {
								this.maze.setTerrain(yFantome_old/50,xFantome_old/50,'+');
							}
							else if (this.maze2.getTerrain(yFantome_old/50, xFantome_old/50)=='-') {
								this.maze.setTerrain(yFantome_old/50,xFantome_old/50,'-');
							}
							this.maze.getFantome().moveTo(xFantomeNext,yFantomeNext);
						}
						break;
					}
					else if (xFantome_old-xFantomeNext==0 && yFantome_old-yFantomeNext==-50){
						this.maze.getFantome().setDirection('s');
						if (this.maze.canMoveFantome(xFantomeNext/50, yFantomeNext/50)) {
							
							if (this.maze2.getTerrain(yFantome_old/50, xFantome_old/50)=='+') {
								this.maze.setTerrain(yFantome_old/50,xFantome_old/50,'+');
							}
							else if (this.maze2.getTerrain(yFantome_old/50, xFantome_old/50)=='-') {
								this.maze.setTerrain(yFantome_old/50,xFantome_old/50,'-');
							}
							this.maze.getFantome().moveTo(xFantomeNext,yFantomeNext);
						}
						break;
					}
			}
				this.maze.setTerrain((this.maze.getFantome().getPosY()/50),(this.maze.getFantome().getPosX()/50),'f');

		}
		else 
			if (this.maze2.getTerrain(this.maze.getFantome().getPosY()/50, this.maze.getFantome().getPosX()/50) == '-')
				this.maze.setTerrain((this.maze.getFantome().getPosY()/50),(this.maze.getFantome().getPosX()/50),'-');
			else
				this.maze.setTerrain((this.maze.getFantome().getPosY()/50),(this.maze.getFantome().getPosX()/50),'-');
		
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
}
