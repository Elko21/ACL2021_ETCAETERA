package fr.ensem.acl.Maze.model;

public class Squelette extends Monstre {
	
	public Squelette(int x, int y, int h){
		super(x,y,h);
	}
	
	/*public void move() {
	boolean squeletteCantMove=true;
		while (squeletteCantMove) {
			int xSqueletteNext,ySqueletteNext; //Prochaine position possible du monstre
			int xSquelette_old=this.getPosX(); //Position actuelle
			int ySquelette_old=this.getPosY();
			
			xSqueletteNext= this.posVoisineRandom()[0]; //Prochaine position est la position voisine random
			ySqueletteNext= this.posVoisineRandom()[1];
			
			// On choisit une position accessible pour le monstre
			if (xSquelette_old-xSqueletteNext==50 && ySquelette_old-ySqueletteNext==0){
				this.setDirection('q');
				if (this.maze.canMove(xSqueletteNext/50, ySqueletteNext/50)) {
					this.moveTo(xSqueletteNext,ySqueletteNext);
				}
				break;
			}
			else if (xSquelette_old-xSqueletteNext==-50 && ySquelette_old-ySqueletteNext==0){
				this.setDirection('d');
				if (this.maze.canMove(xSqueletteNext/50, ySqueletteNext/50)) {
					this.moveTo(xSqueletteNext,ySqueletteNext);
				}
				break;

			}
			else if (xSquelette_old-xSqueletteNext==0 && ySquelette_old-ySqueletteNext==50){
				this.setDirection('z');
				if (this.maze.canMove(xSqueletteNext/50, ySqueletteNext/50)) {
					this.moveTo(xSqueletteNext,ySqueletteNext);
				}
				break;

			}
			else if (xSquelette_old-xSqueletteNext==0 && ySquelette_old-ySqueletteNext==-50){
				this.setDirection('s');
				if (this.maze.canMove(xSqueletteNext/50, ySqueletteNext/50)) {
					this.moveTo(xSqueletteNext,ySqueletteNext);
				}
				break;
			}
		
		}
	}*/
}
