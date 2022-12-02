package metier;

public class DCase {

	private boolean mine;
	private int mimesAlentour;
	private boolean drapeau;
	private boolean decouverte;
	private boolean selection;
	private EtatCase etatC;

	public DCase() {
		mine = false;
		decouverte = false;
		drapeau = false;
		selection = false;
		mimesAlentour = -1;
		etatC = EtatCase.PASDECOUVERT;
	}

	public boolean estMine() {
		return mine;
	}

	public EtatCase getEtatCase(EtatPartie e) {
		if (e == EtatPartie.FINI) {
			if (mine) {
				etatC = EtatCase.BOMBE;
			}
			if (drapeau && !mine) {
				etatC = EtatCase.CROIX;
			}

		}
		
		if(drapeau) {
			etatC=EtatCase.DRAPEAU;
		}
		
		
		if (decouverte) {
			
			switch (getMinesAlentour()) {
			case 0:
				etatC = EtatCase.BLANC;
				break;
			case 1:
				etatC = EtatCase.UN;
				break;
			case 2:
				etatC = EtatCase.DEUX;
				break;
			case 3:
				etatC = EtatCase.TROIS;
				break;
			case 4:
				etatC = EtatCase.QUATRE;
				break;
			case 5:
				etatC = EtatCase.CINQ;
				break;
			case 6:
				etatC = EtatCase.SIX;
				break;
			case 7:
				etatC = EtatCase.SEPT;
				break;
			case 8:
				etatC = EtatCase.HUIT;
				break;
			default:
				break;
			}

		}
		return etatC;
	}

	public int getMinesAlentour() {
		return mimesAlentour;
	}

	public boolean yaDrapreau() {
		return drapeau;
	}

	public boolean estDecouverte() {
		return decouverte;
	}

	public void setDecouverte() {
		decouverte = true;
	}

	public void selectionner() {
		selection = true;
	}

	public void deselectionner() {
		selection = false;
	}

	public boolean select() {
		return selection;
	}

	public void drapeauAction() {
		if (!decouverte)
			drapeau = (!drapeau);

	}

	public void poserBombe() {
		mine = true;
	}

	public void setMinesAlentour(int nb) {
		mimesAlentour = nb;
	}
}