package main;
import java.util.Scanner;

public class Heros extends Personnage{
	Heros(int x,int y, int damage, int hp){
		super(x,y,damage,hp);
		
	}
	public String move() {
		@SuppressWarnings("resource")
		Scanner direction1 = new Scanner(System.in);
		System.out.println("Dans quelle direction doit aller le héros ? (N,S,E,O)");
		String dep = direction1.nextLine();
		return dep;
			
		
		}
			
	}
	

