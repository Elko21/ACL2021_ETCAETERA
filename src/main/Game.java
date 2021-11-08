package start;

import java.util.Scanner;

import elements.Player;

public class Game {

	private Heros player;
	private Tresor tresor;
	
	public Game()  {
		this.player = new Player();
		this.tresor = new Tresor();

	}
	
	public void run() {
		
		Scanner lectureClavier = new Scanner(System.in);
		
		while(true) {
			String posJoueur = "Position joueur : (" + this.player.getX() + ", " + this.player.getY() + ")";
			System.out.println(posJoueur);
			System.out.println("écrire Command (L/R/U/D) : ");
			String cmd = lectureClavier.next();
			this.update(cmd);
			System.out.prinln(" Position trésor : ("+this.tresor.getX()+","+this.tresor.getY()+")");
			if (this.player.getX()==this.tresor.getX() && this.player.getY()==this.tresor.getY()) {
				System.out.println("Vous avez atteint le trésor, Partie terminée !");
				break;
			}
		}
	}
	
	public void update(String cmd) { // Dans une zone de taille (0,10)x(0,15)
		if (cmd.equals("L")) {
			if (this/player.getX()>0) this.player.setX(this.player.getX() - 1);
		}
		else if (cmd.equals("R")) {
			if (this.player.getX()<10) this.player.setX(this.player.getX() + 1);
		} 
		else if (cmd.equals("U")) {
			if (this.player.getY()<15) this.player.setY(this.player.getX() + 1);
		} 
		else if (cmd.equals("D")) {
			if (this.player.getY()>0) this.player.setY(this.player.getX() - 1);
		}
		else System.out.println("Veuillez saisir une commande valable : ");
		
	}


}
