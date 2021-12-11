package fr.ensem.acl.Maze.model;

public class Labyrinthe {
	private Hero hero;
	private Tresor tresor;
	private Mur mur = new Mur(2,1);
	private char terrain[][];
	private int l;
	private int h;

	public Hero getHero() { return this.hero; }
	public Tresor getTresor() { return this.tresor; }
	public Mur getMur() { return this.mur; }
	
	public char getTerrain(int i, int j) { return this.terrain[i][j]; }
	public void setTerrain(int i, int j, char c) { this.terrain[i][j] = c; }
	
	public int getL() { return this.l; }
	public int getH() { return this.h; }
	
	public Labyrinthe(int n, int m) {
		this.h = n;
		this.l = m;
	
		this.terrain = new char[this.h][this.l];
	
		this.hero = new Hero(50,50);
	
		this.tresor = new Tresor((this.l-2)*50,(this.h-2)*50);
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < l; j++) {
				if ((i != 0 && i != (this.h)-1 && j != 0 && j != (this.l)-1) && this.mur.isFree(j,i))
					this.terrain[i][j] = '+';
				else
					this.terrain[i][j] = '-';
				
				if (i == (this.hero.getPosY()/50) && j == (this.hero.getPosX()/50))
					this.terrain[i][j] = 'h';
				
				if (this.tresor.isEnd((j+1)*50,(i+1)*50))
					this.terrain[i][j] = 't';
			}
		}
	}
	
	public boolean canMove(int X,int Y) {
		return (this.terrain[Y][X] != '-');		
	} 
	

}