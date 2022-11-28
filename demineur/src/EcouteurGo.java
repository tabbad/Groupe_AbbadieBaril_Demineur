import java.awt.event.*;

import metier.DMatrice;

public class EcouteurGo implements ActionListener{
	
	DFenetre fenetre;
	DMatrice partie;
	
	public EcouteurGo(DFenetre f, DMatrice p){
		fenetre = f;
		partie = p;
	}
	
	
	public void actionPerformed(ActionEvent ae){
		fenetre.arretChrono();
		fenetre.initChrono();
		
		partie= new DMatrice(partie.getHauteur(),
		                      partie.getLargeur(),
		                      partie.getMines());
		
		fenetre.connecterPartie(partie);
		
	}
	
}