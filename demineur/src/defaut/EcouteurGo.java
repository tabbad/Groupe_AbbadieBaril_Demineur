package defaut;
import java.awt.event.*;

import metier.DPartie;

public class EcouteurGo implements ActionListener{
	
	DFenetre fenetre;
	DPartie partie;
	
	public EcouteurGo(DFenetre f, DPartie p){
		fenetre = f;
		partie = p;
	}
	
	
	public void actionPerformed(ActionEvent ae){
		fenetre.arretChrono();
		fenetre.initChrono();
		
		partie= new DPartie(partie.getHauteur(),
		                      partie.getLargeur(),
		                      partie.getMines());
		
		fenetre.connecterPartie(partie);
		
	}
	
}