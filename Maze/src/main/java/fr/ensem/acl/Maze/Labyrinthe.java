package fr.ensem.acl.Maze;

public class Labyrinthe {
	protected Hero hero;
	protected Mur mur = new Mur(2,1);
	protected Tresor tresor;
	private char terrain[][];
	private int l;
	private int h;
	
	Labyrinthe(int n, int m){
		h = n;
		l = m;
		
		terrain = new char[this.h][this.l];
		
		hero = new Hero(1,1);
		
		tresor = new Tresor(this.l-2,this.h-2);
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < l; j++) {
				if ((i != 0 && i != (this.h)-1 && j != 0 && j != (this.l)-1) && this.mur.isFree(j,i))
					this.terrain[i][j] = '+';
				else
					this.terrain[i][j] = '-';
				
				if (i == this.hero.getPosY() && j == this.hero.getPosX())
					this.terrain[i][j] = 'h';
				
				if (this.tresor.isEnd(j,i))
					this.terrain[i][j] = 't';
			}
		}
		
	}
	
	public void display() {
		for(int i = 0; i < this.h; i++) {
			for(int j = 0; j < this.l; j++) {
				switch(this.terrain[i][j]) 
				{
					case '-':
						System.out.print("#");
						break;
					case '+':
						System.out.print(" ");
						break;
					case 'h':
						System.out.print("O");
						break;
					case 't':
						System.out.print("$");
						break;						
				}					
			}
			
			System.out.print("\n");
		}
	}
	
	public void canMove(String cmd) {
		int x = this.hero.getPosX();
		int y = this.hero.getPosY();
		
		switch(cmd) 
		{
			case "q":
				x--;
				break;
			case "Q":
				x--;
				break;
			case "d":
				x++;
				break;
				
			case "D":
				x++;
				break;
			case "z":
				y--;
				break;
			case "Z":
				y--;
				break;
			case "s":
				y++;
				break;
			case "S":
				y++;
				break;
			default:
				System.out.println("Attention !!! Commande non prise en compte. Veuillez entrer une commande valable !");
		}
		
		// Vérification si zone accessible
		if (this.mur.isFree(x, y)) {
			// Zone accessible donc le héro se déplace et laisse une case libre derrière lui
			this.terrain[this.hero.getPosY()][this.hero.getPosX()] = '+';
			// Mise à jour de la position du héro
			this.hero.update(x,y);
			this.terrain[this.hero.getPosY()][this.hero.getPosX()] = 'h';			
			
		}
			
		
	} 
}
