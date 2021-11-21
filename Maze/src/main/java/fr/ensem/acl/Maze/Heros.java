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
	public void move(String cmd) { // Dans une zone de taille (0,10)x(0,15)  
		if (cmd.equals("L")) {
			if (this.getX()>0) this.setX(this.getX() - 1);
		}
		else if (cmd.equals("R")) {
			if (this.getX()<10) this.setX(this.getX() + 1);
		} 
		else if (cmd.equals("U")) {
			if (this.getY()<15) this.setY(this.getY() + 1);
		} 
		else if (cmd.equals("D")) {
			if (this.getY()>0) this.setY(this.getY() - 1);
		}
		else System.out.println("Veuillez saisir une commande valable");
		
	}
	
}
			
	
	