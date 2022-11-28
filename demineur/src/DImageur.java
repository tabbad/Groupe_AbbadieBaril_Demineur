import javax.swing.*;

import metier.DMatrice;

import java.awt.*;

public class DImageur{
	
	private DMatrice partie;
	public String repertoire = "resources/Images/Classic";
	
	public DImageur(DMatrice p){
		partie = p;
	}
	
	public String getRepertoire(){
		return repertoire;
	}
	
	public void setRepertoire(String s){
		repertoire = s;
	}
	
	
	ImageIcon getImage(int i, int j){
		
		if(!partie.perdu() && !partie.gagne()){
			if(partie.getCase(i,j).yaDrapreau())
				return new ImageIcon(repertoire+"/Drapeau.GIF");
			if(!partie.getCase(i,j).estDecouverte()){
				if(partie.getCase(i,j).select())
					return new ImageIcon(repertoire+"/Select.GIF");
				else
					return new ImageIcon(repertoire+"/Inconnue.GIF");
			}
			switch(partie.getCase(i,j).getMinesAlentour()){
					case 0: return new ImageIcon(repertoire+"/Vide.GIF");
					case 1: return new ImageIcon(repertoire+"/1.GIF");
					case 2: return new ImageIcon(repertoire+"/2.GIF");
					case 3: return new ImageIcon(repertoire+"/3.GIF");
					case 4: return new ImageIcon(repertoire+"/4.GIF");
					case 5: return new ImageIcon(repertoire+"/5.GIF");
					case 6: return new ImageIcon(repertoire+"/6.GIF");
					case 7: return new ImageIcon(repertoire+"/7.GIF");
					case 8: return new ImageIcon(repertoire+"/8.GIF");
					default : return new ImageIcon(repertoire+"/Mine.GIF");
				}
		}
		else{
			if(partie.perdu()){
				if((partie.getCase(i,j).yaDrapreau())
			   		&& !(partie.getCase(i,j).estMine() ))
			   			return new ImageIcon(repertoire+"/Croix.GIF");
			   	if(partie.getCase(i,j).estMine())
			   		return new ImageIcon(repertoire+"/Mine.GIF");
			   	if(!partie.getCase(i,j).estDecouverte())
					return new ImageIcon(repertoire+"/Inconnue.GIF");	
			 		switch(partie.getCase(i,j).getMinesAlentour()){
						case 0: return new ImageIcon(repertoire+"/Vide.GIF");
						case 1: return new ImageIcon(repertoire+"/1.GIF");
						case 2: return new ImageIcon(repertoire+"/2.GIF");
						case 3: return new ImageIcon(repertoire+"/3.GIF");
						case 4: return new ImageIcon(repertoire+"/4.GIF");
						case 5: return new ImageIcon(repertoire+"/5.GIF");
						case 6: return new ImageIcon(repertoire+"/6.GIF");
						case 7: return new ImageIcon(repertoire+"/7.GIF");
						case 8: return new ImageIcon(repertoire+"/8.GIF");
						default : return new ImageIcon(repertoire+"/Mine.GIF");
					}
			}
			else {
				switch(partie.getCase(i,j).getMinesAlentour()){
						case 0: return new ImageIcon(repertoire+"/Vide.GIF");
						case 1: return new ImageIcon(repertoire+"/1.GIF");
						case 2: return new ImageIcon(repertoire+"/2.GIF");
						case 3: return new ImageIcon(repertoire+"/3.GIF");
						case 4: return new ImageIcon(repertoire+"/4.GIF");
						case 5: return new ImageIcon(repertoire+"/5.GIF");
						case 6: return new ImageIcon(repertoire+"/6.GIF");
						case 7: return new ImageIcon(repertoire+"/7.GIF");
						case 8: return new ImageIcon(repertoire+"/8.GIF");
						default : return new ImageIcon(repertoire+"/Drapeau.GIF");
				}
			}
		}
	}
	
}