package fr.ensem.acl.Maze.model;

public class Labyrinthe {
	private Hero hero;
	private Tresor tresor;
	protected Mur mur = new Mur(2,1);
	private char terrain[][];
	private int l;
	private int h;

	public Labyrinthe(int n, int m) {
		h = n;
		l = m;
	
		terrain = new char[this.h][this.l];
	
		hero = new Hero(1,1);
	
		tresor = new Tresor(this.l-2,this.h-2);
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < l; j++) {
				if ((i != 0 && i != (this.h)-1 && j != 0 && j != (this.l)-1) && this.mur.isFree(j,i))
					this.terrain[i][j] = '+';
				else
					this.terrain[i][j] = '-';
				
				if (i == this.hero.getPosY() && j == this.hero.getPosX())
					this.terrain[i][j] = 'h';
				
				if (this.tresor.isEnd(j,i))
					this.terrain[i][j] = 't';
			}
		}
	}
	
	

}