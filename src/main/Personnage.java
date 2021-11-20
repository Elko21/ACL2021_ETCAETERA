package main;
//Classe Personnage qui représente les personnages du labyrinthe (monstres, héros). Ils infligent 
//tous des dégats et ont des points de vie. Ils peuvent attaquer (pas de riposte).
public class Personnage extends Entite{
	private int damage;
	private int hp;
	public Personnage(int x,int y, int damage,int hp) {
		super(x,y);
		this.damage = damage;
		this.hp = hp;
	}
	public int getDamage() {
		return this.damage;
	}
	public int getHP() {
		return this.hp;
	}
	public void setDamage(int n) {
		this.damage=n;
	}
	public void setHP(int n) {
		this.hp = n;
	}
	public void attaque(Personnage adversaire) {
		adversaire.hp -= this.damage;
	}
}
