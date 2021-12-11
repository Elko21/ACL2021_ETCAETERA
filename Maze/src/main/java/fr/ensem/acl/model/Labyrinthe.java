package model;

public class Labyrinthe {
	private Hero hero;
	private Tresor tresor;
	private char terrain[][];
	private int l;
	private int h;

public Labyrinthe(int n, int m){
	h = n;
	l = m;

	terrain = new char[this.h][this.l];

	hero = new Hero(1,1);

	tresor = new Tresor(this.l-2,this.h-2);
}

}