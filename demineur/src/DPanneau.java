import javax.swing.*;

import metier.EtatCase;
import metier.DPartie;
import java.awt.*;

public class DPanneau extends JPanel{
	
	private DFenetre fenetre;
	private int hauteur, largeur;
	
	public DPanneau(DFenetre fe, int h, int l){
		super();
		fenetre = fe;
		hauteur = h;
		largeur = l;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		fenetre.getPartie().setEtatPartie();
		for(int i=0; i<hauteur; i++) {
			for(int j=0;j<largeur; j++){
				g.drawImage(fenetre.getIcon(i,j).getImage(),j*20,i*20,this);
			}
		}	
	}
}