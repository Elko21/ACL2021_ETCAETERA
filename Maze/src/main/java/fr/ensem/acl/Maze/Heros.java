package main;
//Classe Héros pour appeler le personnage de l'utilisateur. Hérite de la classe personnage : 
//Il peut attaquer, perdre des points de vie, se déplacer, à venir partie graphique.
public class Heros{
	private int posX;
	private int posY;
	Heros(int x,int y){
		this.posX = x;
		this.posY = y;
	}
	public int getX() {
		return this.posX;
	}
	public int getY() {
		return this.posY;
	}
	public void setX(int x) {
		this.posX=x;
	}
	public void setY(int y) {
		this.posY=y;
	}
	
}
			
	
	