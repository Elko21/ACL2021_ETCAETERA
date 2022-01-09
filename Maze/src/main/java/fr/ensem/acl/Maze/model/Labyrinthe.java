package fr.ensem.acl.Maze.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinthe {
	private Hero hero;
	private Tresor tresor;
	private Squelette squelette ;
	private Fantome fantome;
	private Piege trap;
	private Teleportail tp;
	private char terrain[][];
	private int l;
	private int h;

	public Hero getHero() { return this.hero; }
	public Tresor getTresor() { return this.tresor; }
	public Squelette getSquelette() { return this.squelette; }
	public Fantome getFantome() {return this.fantome; }
	public Piege getTrap() {return this.trap;}
	public Teleportail getTP() {return this.tp; }
	
	public char getTerrain(int i, int j) { return this.terrain[i][j]; }
	public void setTerrain(int i, int j, char c) { this.terrain[i][j] = c; }
	
	public int getL() { return this.l; }
	public int getH() { return this.h; }
	
	public Labyrinthe(String source) {
		this.h = 15;
		this.l = 30;
	
		this.terrain = new char[this.h][this.l];
	
	
		BufferedReader map;
		int compteur = 0;
		try {
			map = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne= map.readLine()) != null) {
				
				for(int j=0;j<ligne.length();j++) {
					this.terrain[compteur][j]= ligne.charAt(j);
				}
				compteur ++;
			}
			map.close();
		} catch (IOException e) {
			System.out.println("Map not available");
		}
		for(int i=0;i<h;i++) {
			for(int j=0;j<l;j++) {
				switch(this.terrain[i][j]) {
				case 'h':
					this.hero=new Hero(j*50,i*50,5);
					break;
				case 't':
					this.tresor= new Tresor(j*50,i*50);
					break;
				case 's':
					this.squelette = new Squelette(j*50,i*50,1);
					break;
				case 'f' :
					this.fantome = new Fantome(j*50,i*50,1);
				case 'p':
					this.trap = new Piege(j*50,i*50);
					break;
				case 'r':
					this.tp = new Teleportail(j*50,i*50);
					break;
				}
			}
		}
	}
	
	public boolean canMove(int X,int Y) {
		return (this.terrain[Y][X] != '-' && this.terrain[Y][X] != 's'  && this.terrain[Y][X] != 'h' && this.terrain[Y][X] != 'f');		
	} 
	
	public boolean canMoveSquelette(int X,int Y) {
		return (this.terrain[Y][X] != '-' && this.terrain[Y][X] != 's' && this.terrain[Y][X]!='t' && this.terrain[Y][X] != 'h' && this.terrain[Y][X] != 'f');		
	} 
	
	public boolean canMoveFantome(int X,int Y) {
		return (this.terrain[Y][X] != 's' && this.terrain[Y][X] != 'h' && this.terrain[Y][X]!='t' && this.terrain[Y][X] != 'f' && X>0 && Y>0 && Y<h-1 && X<l-1);		

	}
	public boolean isOppAround() {
		int x = this.hero.getPosX()/50;
		int y = this.hero.getPosY()/50;
		
		return (this.terrain[y-1][x-1] == 's' || 
				this.terrain[y+1][x-1] == 's' || 
				this.terrain[y-1][x+1] == 's' || 
				this.terrain[y+1][x+1] == 's' || 
				this.terrain[y-1][x] == 's' || 
				this.terrain[y][x-1] == 's' || 
				this.terrain[y+1][x] == 's' || 
				this.terrain[y][x+1] == 's' ||
				this.terrain[y-1][x-1] == 'f' || 
				this.terrain[y+1][x-1] == 'f' || 
				this.terrain[y-1][x+1] == 'f' || 
				this.terrain[y+1][x+1] == 'f' || 
				this.terrain[y-1][x] == 'f' || 
				this.terrain[y][x-1] == 'f' || 
				this.terrain[y+1][x] == 'f' || 
				this.terrain[y][x+1] == 'f');
	}
}