package main;
import java.util.Scanner;
//Classe Héros pour appeler le personnage de l'utilisateur. Hérite de la classe personnage : 
//Il peut attaquer, perdre des points de vie, se déplacer, à venir partie graphique.
public class Heros extends Personnage{
	Heros(int x,int y, int damage, int hp){
		super(x,y,damage,hp);
		
	}
//Fonction du déplacement du personnage du héros. Demande juste la direction, main fait le reste
	public String move() {
		@SuppressWarnings("resource")
		Scanner direction1 = new Scanner(System.in);
		System.out.println("Dans quelle direction doit aller le héros ? (N,S,E,O)");
		String dep = direction1.nextLine();
		return dep;
			
		
		}
			
	}
	

