package main;
//Classe Labyrinthe avec pour l'instant seulement ses délimitations "cote". 
//Le dépassement renvoie Vrai ou Faux selon si un déplacement de personnage sort ou non des limites.
public class Labyrinthe {
	private int cote;
	
	Labyrinthe(int longueur){
		this.cote = longueur;
	}
	public boolean depassement(Entite entite) {
		boolean cond = (0<entite.getX()<<this.cote && 0<<entite.getY()<this.cote);
		return cond;
	}
}
