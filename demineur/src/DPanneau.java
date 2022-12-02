import javax.swing.*;

import metier.EtatCase;
import metier.DPartie;
import java.awt.*;

public class DPanneau extends JPanel{
	
	private DFenetre fenetre;
	
	public DPanneau(DFenetre fe){
		super();
		fenetre = fe;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		fenetre.getPartie().setEtatPartie();
		for(int i=0; i<fenetre.getPartie().getHauteur(); i++) {
			for(int j=0;j<fenetre.getPartie().getLargeur(); j++){
				g.drawImage(fenetre.getIcon(i,j).getImage(),j*20,i*20,this);
			}
		}	
	}
}