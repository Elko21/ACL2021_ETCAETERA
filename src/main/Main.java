package start;


/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) {

		// creation du jeu particulier et de son afficheur
		Game game = new Game();

		// classe qui lance le moteur de jeu generique
		game.run();
	}

}
