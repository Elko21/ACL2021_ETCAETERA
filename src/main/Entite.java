package main;
//Classe Entite, les autres classes relatives à des positions héritent de cette classe. les coords
//sont récupérables par getX et getY. On peut changer les coords grace à setX, setY
public class Entite {
	private int posX;
	private int posY;
	
	Entite(int x,int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public int getX() {
		return this.posX;
	}
	public int getY() {
		return this.posY;
	}
	public void setX(int n) {
		this.posX = n;
	}
	public void setY(int n) {
		this.posY = n;
	}
}
