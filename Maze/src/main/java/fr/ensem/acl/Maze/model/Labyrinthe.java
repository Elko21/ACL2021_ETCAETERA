package fr.ensem.acl.Maze.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinthe {
	private Hero hero;
	private Tresor tresor;
	private Monstre monstre ;
	private char terrain[][];
	private int l;
	private int h;

	public Hero getHero() { return this.hero; }
	public Tresor getTresor() { return this.tresor; }
	public Monstre getMonstre() { return this.monstre; }
	
	
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
				}
			}
		}
		/*
		 * for(int i = 0; i < h; i++) { for(int j = 0; j < l; j++) { if ((i != 0 && i !=
		 * (this.h)-1 && j != 0 && j != (this.l)-1) && this.mur.isFree(i,j))
		 * this.terrain[i][j] = '+'; else this.terrain[i][j] = '-'; if (i ==
		 * this.mur.getPosX() && j == this.mur.getPosY()) this.terrain[i][j] = '-';
		 * 
		 * if (i == (this.hero.getPosY()/50) && j == (this.hero.getPosX()/50))
		 * this.terrain[i][j] = 'h';
		 * 
		 * if (this.tresor.isEnd((j+1)*50,(i+1)*50)) this.terrain[i][j] = 't';
		 */
		/*
		 * } }
		 */
	}
	
	public boolean canMove(int X,int Y) {
		return (this.terrain[Y][X] != '-');		
	} 
	

}