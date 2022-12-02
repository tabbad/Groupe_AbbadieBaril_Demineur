package defaut;
import javax.swing.*;

import metier.DPartie;
import metier.EtatCase;

import java.awt.*;

public class DImageur{
	
	public static String repertoire = "resources/Images/Classic";
	
	public static String getRepertoire(){
		return repertoire;
	}
	
	public static void setRepertoire(String s){
		repertoire = s;
	}
	
	public static ImageIcon getIcon(EtatCase e){
		switch (e) {
		case PASDECOUVERT:return new ImageIcon(repertoire+"/Inconnue.GIF");
		case DRAPEAU:return new ImageIcon(repertoire+"/Drapeau.GIF");
		case BOMBE:return new ImageIcon(repertoire+"/Mine.GIF");
		case CROIX:return new ImageIcon(repertoire+"/Croix.GIF");
		case BLANC: return new ImageIcon(repertoire+"/Vide.GIF");
		case UN: return new ImageIcon(repertoire+"/1.GIF");
		case DEUX: return new ImageIcon(repertoire+"/2.GIF");
		case TROIS: return new ImageIcon(repertoire+"/3.GIF");
		case QUATRE: return new ImageIcon(repertoire+"/4.GIF");
		case CINQ: return new ImageIcon(repertoire+"/5.GIF");
		case SIX: return new ImageIcon(repertoire+"/6.GIF");
		case SEPT: return new ImageIcon(repertoire+"/7.GIF");
		case HUIT: return new ImageIcon(repertoire+"/8.GIF");
		default : return new ImageIcon(repertoire+"/Mine.GIF");
		}

	}
	
}