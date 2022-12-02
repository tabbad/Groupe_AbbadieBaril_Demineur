package defaut;
import java.awt.event.*;
import javax.swing.*;

import metier.DPartie;

import java.io.*;

public class EcouteurMenu implements ActionListener{
	
	private DPartie partie;
	private DFenetre fenetre;
	
	public EcouteurMenu(DFenetre f, DPartie p){
		partie = p;
		fenetre = f;
	}
	
	
	public void actionPerformed(ActionEvent ae){
	    	if(ae.getSource() == fenetre.getNouvelle()){
			fenetre.arretChrono();
			fenetre.initChrono();
			partie=new DPartie(partie.getHauteur(),
		                      partie.getLargeur(),
		                      partie.getMines());
			fenetre.connecterPartie(partie);
		}
	       	if(ae.getSource() == fenetre.getDebutant()){
				fenetre.arretChrono();
				fenetre.initChrono();
				partie=new DPartie(9,9,10);
				fenetre.type = fenetre.DEBUTANT;
				fenetre.connecterPartie(partie);
				}
	    
		if(ae.getSource() == fenetre.getIntermediaire()){
				fenetre.arretChrono();
				fenetre.initChrono();
				partie=new DPartie(16,16,40);
				fenetre.type = fenetre.INTER;
				fenetre.connecterPartie(partie);
		}	
		if(ae.getSource() == fenetre.getExpert()){
				fenetre.arretChrono();
				fenetre.initChrono();
				partie=new DPartie(16,30,99);
				fenetre.type = fenetre.EXPERT;
				fenetre.connecterPartie(partie);
		}
		
		if(ae.getSource() == fenetre.getPerso()){
			Pref pref = new Pref(fenetre, partie);
			fenetre.type = fenetre.PERSO;

		}
		
		if(ae.getSource() == fenetre.getDesign()){
			DImageChooser choix = 
			      new DImageChooser(fenetre.getPanneauCentral() );
		}
		
		if(ae.getSource() == fenetre.getQuitter())
							System.exit(0);
							
		if(ae.getSource()==fenetre.getAide()){
			File f = new File("resources/Aide");
			Aide a = new Aide(f);;
		}
		if(ae.getSource()==fenetre.getCreateur()) 
				JOptionPane.showMessageDialog(fenetre,
				     " R�alis� par Igor DAURIAC et Nicolas FRANCOIS, Projet IHM"
				      ,"Cr�ateurs...",JOptionPane.INFORMATION_MESSAGE);
			
			
		
						
	}
	
	
}
