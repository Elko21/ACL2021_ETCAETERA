package fr.ensem.acl.Maze.engine;

import fr.ensem.acl.Maze.model.Cmd;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * moteur de game generique.
 * On lui passe un game et un afficheur et il permet d'executer un game.
 */
public class GameEngineGraphical {

	/**
	 * le game a executer
	 */
	private Game game;

	/**
	 * l'afficheur a utiliser pour le rendu
	 */
	private GamePainter gamePainter;

	/**
	 * le controlleur a utiliser pour recuperer les commandes
	 */
	private GameController gameController;

	/**
	 * l'interface graphique
	 */
	private GraphicalInterface gui;

	/**
	 * construit un moteur
	 * 
	 * @param game
	 *            game a lancer
	 * @param gamePainter
	 *            afficheur a utiliser
	 * @param gameController
	 *            controlleur a utiliser
	 *            
	 */
	public GameEngineGraphical(Game game, GamePainter gamePainter, GameController gameController) {
		// creation du game
		this.game = game;
		this.gamePainter = gamePainter;
		this.gameController = gameController;
	}

	/**
	 * permet de lancer le game
	 */
	public void run() throws InterruptedException {

		// creation de l'interface graphique
		this.gui = new GraphicalInterface(this.gamePainter,this.gameController);

		// boucle de game
		while (!(this.game.isTresorAtteint()|| this.game.doesMonstreAttaque() || this.game.isTrapTriggered())) {
			// demande controle utilisateur
			Cmd c = this.gameController.getCommand();
			// fait evoluer le game
			this.game.evolve(c);
			// affiche le game
			this.gui.paint();
			// met en attente
			Thread.sleep(100);
		}
		String endText;
		if (this.game.isTresorAtteint()) endText = "Vous avez gagné! Vous êtes riche!";
		else if (this.game.isTrapTriggered()) endText="Vous avez marché sur un piège, vous etes mort !";
		else endText="Le monstre vous a eu....";
		// affiche le texte de victoire ou d'échec sur le panel
		this.gui.showText(endText);
	}

}
