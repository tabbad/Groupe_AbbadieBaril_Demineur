package defaut;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import metier.DPartie;

public interface IDPartie {

	public void connecterPartie(DPartie p);

	public DPartie getPartie();
	
	public ImageIcon getIcon(int i, int j);
	
	public void ecouterMenu(ActionListener al);
	
	public JMenuItem getNouvelle();
	
	public JMenuItem getDebutant();
	
	public JMenuItem getIntermediaire();
	
	public JMenuItem getExpert();
	
	public JMenuItem getPerso();
	
	public JMenuItem getDesign();
	
	public JMenuItem getQuitter();
	
	public JMenuItem getAide();
	
	public JMenuItem getCreateur();
	
	public JButton getGo();
	
	public DPanneau getPanneauCentral();
	
	public void goPerdu();
	
	public void goGagne();
	
	public void goOups();
	
	public void goCool();
	
	public void miseAJourCompteur();
	
	public void lancerChrono();
	
	public void arretChrono();
	
	public void initChrono();
	
	public void pauseChrono();
	
	public void repriseChrono();
	
	public int getChrono();
}
