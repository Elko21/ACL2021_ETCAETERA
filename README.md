# ACL2021_ETCAETERA

# Membres de l'équipe :
	_ Elko RAMBELONoSOAVINA
 	_ Thibaut DE CARVALHO
 	_ Clément BRUN
 	_ Yassine NADRANI

# Description du projet :
	Développement d'un jeu de labyrinthe en utilisant : 
		_ Langage de programmation : Java
		_ Moteur de jeu sur Arche (Université de Lorraine)
		_ Versionning : Git
		_ Outil de build : Apache Maven
		_ Méthode Scrum Agile

# Comment compiler et exécuter l'application Maze ?
	Pré-requis :
		_ Avoir apache-maven installé sur son PC (lien url : https://maven.apache.org/download.cgi) en suivant les instructions sur la page web : http://maven.apache.org/install.html
		_ Avoir Java JDK (requis pour exécuter Maven)

	Procédure :
		_ Ouvrir l'invite de commande
		_ Aller au répertoire du projet où se situe le fichier pom.xml (Project Object Model)
		_ Exécuter la ligne de commande suivante : mvn clean install
		_ Ensuite : java -jar target/Maze-4.0.0.jar

# Comment jouer au jeu du labyrinthe qu'on a nommé "Maze" ?
	L'utilisateur a une marge de choix de 3 niveaux. En saisissant le numéro du niveau correspondant, le je se lance dans une nouvelle fenêtre et la partie est lancée.
	L'utilisateur peut déplacer le héros en utilisant les flèches du clavier ou en utilisant les touches Z, Q, S, D : Z pour le haut, Q pour la gauche, S pour le bas et D pour la droite. Le héros peut également attaquer les monstres en utilisant la touche Espace.
	La partie est déclarée gagnée si le héros atteint le trésor.
