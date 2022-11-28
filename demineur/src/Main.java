import java.io.*;
import java.util.*;

import metier.DMatrice;

public class Main{
	public static void main(String[] args){	
			DMatrice partie = new DMatrice(9,9,10);
			DFenetre fenetre = new DFenetre(partie);
		
			EcouteurGo e = new EcouteurGo(fenetre,partie);
			fenetre.getGo().addActionListener(e);
		
			EcouteurFenetre ecouteurFenetre = new EcouteurFenetre(fenetre);
			fenetre.addWindowListener(ecouteurFenetre);
		
			EcouteurMenu ecouteurMenu = new EcouteurMenu(fenetre,partie);
			fenetre.ecouterMenu(ecouteurMenu);
	}	
}

