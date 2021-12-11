package fr.ensem.acl.Maze.start;

import fr.ensem.acl.Maze.model.PacmanPainter;

import fr.ensem.acl.Maze.engine.GameEngineGraphical;
import fr.ensem.acl.Maze.model.PacmanController;
import fr.ensem.acl.Maze.model.PacmanGame;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		PacmanPainter painter = new PacmanPainter(game);
		PacmanController controller = new PacmanController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
