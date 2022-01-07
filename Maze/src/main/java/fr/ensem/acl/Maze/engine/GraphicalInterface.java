package fr.ensem.acl.Maze.engine;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * interface graphique avec son controller et son afficheur
 *
 */
public class GraphicalInterface  {

	/**
	 * le Panel pour l'afficheur
	 */
	private DrawingPanel panel;
	
	/**
	 * la construction de l'interface graphique: JFrame avec panel pour le game
	 * 
	 * @param gamePainter l'afficheur a utiliser dans le moteur
	 * @param gameController l'afficheur a utiliser dans le moteur
	 * 
	 */
	public GraphicalInterface(GamePainter gamePainter, GameController gameController){
		JFrame f = new JFrame();
		f.setTitle("MAZE");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// attacher le panel contenant l'afficheur du game
		this.panel=new DrawingPanel(gamePainter);
		f.setContentPane(this.panel);
		
		// attacher controller au panel du game
		this.panel.addKeyListener(gameController);	
		
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}
	
	/**
	 * mise a jour du dessin
	 */
	public void paint() {
		this.panel.drawGame();	
	}
	
	public void showText(String t) {
		JFrame fr=new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(800, 300); 
		
		JLabel label = new JLabel(t,SwingConstants.CENTER);
		
		label.setFont(new Font("Serif", Font.BOLD, 40));
        fr.add(label);
        
        fr.setVisible(true);
		fr.getContentPane().setFocusable(true);
		fr.getContentPane().requestFocus();
	}
	
}
