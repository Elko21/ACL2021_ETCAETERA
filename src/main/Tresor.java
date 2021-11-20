package projetLabyrinthe;


public class Tresor extends Entite{
	
	private Tresor(int X, int Y) {
		super(X,Y);
	}
	
	private void ouvert() {
		System.out.println("Le coffre est ouvert");
	}
	
}
