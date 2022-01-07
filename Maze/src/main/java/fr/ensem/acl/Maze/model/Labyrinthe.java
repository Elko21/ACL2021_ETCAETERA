package fr.ensem.acl.Maze.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinthe {
	private Hero hero;
	private Tresor tresor;
	private Monstre monstre ;
	private Piege trap;
	private char terrain[][];
	private int l;
	private int h;

	public Hero getHero() { return this.hero; }
	public Tresor getTresor() { return this.tresor; }
	public Monstre getMonstre() { return this.monstre; }
	public Piege getTrap() {return this.trap;}
	
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
					this.hero=new Hero(j*50,i*50);
					break;
				case 't':
					this.tresor= new Tresor(j*50,i*50);
					break;
				case 'm':
					this.monstre = new Monstre(j*50,i*50);
					break;
				case 'p':
					this.trap = new Piege(j*50,i*50);
				}
			}
		}
	}
	
	public boolean canMove(int X,int Y) {
		return (this.terrain[Y][X] != '-');		
	} 
	
	public boolean canDamage() {
		int x = this.hero.getPosX()/50;
		int y = this.hero.getPosY()/50;
		
		return (this.terrain[x-1][y-1] == 'm' || 
				this.terrain[x-1][y+1] == 'm' || 
				this.terrain[x+1][y-1] == 'm' || 
				this.terrain[x+1][y+1] == 'm' || 
				this.terrain[x][y-1] == 'm' || 
				this.terrain[x-1][y] == 'm' || 
				this.terrain[x][y+1] == 'm' || 
				this.terrain[x+1][y] == 'm');
	}
}