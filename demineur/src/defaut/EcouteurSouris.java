package defaut;
import java.awt.event.*;
import java.io.*;

import metier.DPartie;
import metier.EtatPartie;

public class EcouteurSouris  implements MouseListener, MouseMotionListener{
	
	private DPartie partie;
	private DFenetre fenetre;
	private int sourisX, sourisY;
	private boolean gauchePresse;
	
	public EcouteurSouris(DFenetre f){
		fenetre = f;
		partie = fenetre.getPartie();
		gauchePresse = false;
	}
	
	public void mouseReleased(MouseEvent me){
		sourisX = me.getX()/20;
		sourisY = me.getY()/20;
		try{
		  if( partie.setEtatPartie() == EtatPartie.ENCOURS
		       && !(partie.getMatrice()[sourisY][sourisX].yaDrapreau())){
			
			if(me.getButton()==me.BUTTON1){
				gauchePresse = false;
				try{
					partie.getMatrice()[sourisY][sourisX].selectionner();
				}
				catch(NullPointerException npe){  }
				try{
					partie.devoilerCase(sourisY,sourisX);
				}
				catch(NullPointerException npe){  }
				fenetre.lancerChrono();
				if(partie.gagne()){
					fenetre.goGagne();
					fenetre.arretChrono();
				}					
				else
					if(partie.perdu()){
						fenetre.goPerdu();
						fenetre.arretChrono();
					}
					else
						fenetre.goCool();
			}	
			
				

			
		  }
		}
		catch(NullPointerException npe){  }
		me.getComponent().repaint();
	}
	
	public void mousePressed(MouseEvent me){
		sourisX = me.getX()/20;
		sourisY = me.getY()/20;
		if(!partie.perdu() && !partie.gagne()){
			
			
			
			if(me.getButton()==me.BUTTON1){
				gauchePresse = true;
				partie.getMatrice()[sourisY][sourisX].selectionner();
				fenetre.goOups();
			}	
			if(me.getButton()==me.BUTTON3){
				partie.drapeauAction(sourisY,sourisX);					
				fenetre.miseAJourCompteur();
				
			}
		}
		me.getComponent().repaint();
	}
	
	public void mouseExited(MouseEvent me){
		if(gauchePresse)
			fenetre.goCool();
	}
	
	public void mouseEntered(MouseEvent me){
		if(gauchePresse)
			fenetre.goOups();	
	}
	
	
	public void mouseDragged(MouseEvent me){
		int x = me.getX()/20;
		int y = me.getY()/20;
		if(((x!=sourisX) || (y!=sourisY)) && gauchePresse){
			try{
				partie.getMatrice()[sourisY][sourisX].deselectionner();
			}
			catch(NullPointerException npe){  }
			sourisX = x;
			sourisY = y;
			try{
				partie.getMatrice()[sourisY][sourisX].selectionner();
			}
			catch(NullPointerException npe){  }
			me.getComponent().repaint();
		
		}	
	
	} 
	/* Non implement�  */
    public void mouseMoved(MouseEvent me){
    	
    }  
    
    public void mouseClicked(MouseEvent e){
    }
	

}
