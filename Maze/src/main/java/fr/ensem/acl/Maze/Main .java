package main;
import java.io.IOException;
import java.util.Scanner;


public class Main{

	private static Heros player;
	private static Tresor tresor;
	private static Mur murs;
	
	
	public Main()  {
		this.player = new Heros(0, 0, 0, 100);
		this.tresor = new Tresor(5, 5);

	}
	
	public static void run() {
		
		Scanner lectureClavier = new Scanner(System.in);
		
		while(true /*Condition de d�passement � v�rifier apr�s*/) {
			String posJoueur = "Position joueur : (" + player.getX() + ", " + player.getY() + ")";
			System.out.println(posJoueur);
			System.out.print("Ecrire Command (L/R/U/D) : ");
			String cmd = lectureClavier.next();
			update(cmd);
			System.out.println(" Position tr�sor : ("+tresor.getX()+","+tresor.getY()+")");
			if (player.getX()==tresor.getX() && player.getY()==tresor.getY()) {
				System.out.println("Vous avez atteint le tr�sor, Partie termin�e !");
				break;
			}
			clearScreen();

		}
	}
	
	public static void update(String cmd) { // Dans une zone de taille (0,10)x(0,15)  
		if (cmd.equals("L")) {
			if (player.getX()>0) player.setX(player.getX() - 1);
		}
		else if (cmd.equals("R")) {
			if (player.getX()<10) player.setX(player.getX() + 1);
		} 
		else if (cmd.equals("U")) {
			if (player.getY()<15) player.setY(player.getY() + 1);
		} 
		else if (cmd.equals("D")) {
			if (player.getY()>0) player.setY(player.getY() - 1);
		}
		else System.out.println("Veuillez saisir une commande valable : ");
		
	}
	
	public static void clearScreen(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } 
	    catch (IOException | InterruptedException ex) {}
	}

	
	public static void main(String[] args) {
		 run();
	}
	 
}
