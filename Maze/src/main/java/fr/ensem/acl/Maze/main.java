package fr.ensem.acl.Maze;

import java.io.IOException;
import java.util.Scanner;

public class main {
	private static Labyrinthe lab = new Labyrinthe(10,15);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("This is the main program of the Maze Game !\n Would want to play?");
		run();
	}
	
	public static void run() {
		boolean finished = false;
		Scanner lectureClavier = new Scanner(System.in);
		
		do {
			clearScreen();
			// Affichage du labyrinthe avec tous les éléments du décor
			lab.display();
			
			System.out.println("Entrez une commande (Q/S/D/Z) : ");
			String cmd = lectureClavier.next();
			lab.canMove(cmd);
			
			if (lab.tresor.isEnd(lab.hero.getPosX(),lab.hero.getPosY())) {
				finished = true;
				System.out.println("Vous avez atteint le trésor. Partie terminée !");
			}
			
		} while(!finished);
	}
	
	public static void clearScreen() {
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } 
	    catch (IOException | InterruptedException ex) {}
	}

}
