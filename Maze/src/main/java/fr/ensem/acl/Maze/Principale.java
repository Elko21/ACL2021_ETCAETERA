package main;

import java.io.IOException;
import java.util.Scanner;

public class Principale {
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
		Heros player = new Heros(0,0);
		Tresor chest = new Tresor(5,3);
		Scanner lectureClavier = new Scanner(System.in);
		
		while(true) {
			String posJoueur = "Position Héros : (" + player.getX() + ", " + player.getY() + ")";
			System.out.println(" Position Trésor : ("+chest.getX()+","+chest.getY()+")");
			System.out.println(posJoueur);
			System.out.print("Ecrire Command (L/R/U/D) : ");
			String cmd = lectureClavier.next();
			player.move(cmd);
			if (player.getX()==chest.getX() && player.getY()==chest.getY()) {
				chest.ouvrir();
				break;
			}
			clearScreen();

		}
	}

}
