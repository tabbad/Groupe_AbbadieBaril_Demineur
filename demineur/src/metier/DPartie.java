package metier;

import java.lang.*;
import java.util.Random;

public class DPartie {

	private int hauteur, largeur, nbMines; // parametres de la partie
	private DCase[][] matrice;
	private int caseNonMineeRestante;
	private boolean explosion;
	private EtatPartie etatP;

	private static int NB_MINES_MIN = 10;
	private static int NB_MINES_MAX = 665;
	private static int DIMENSION_MIN = 9;
	private static int DIMENSION_MAX = 25;

	public DPartie(int h, int l, int nb) {
		hauteur = h;
		largeur = l;
		nbMines = nb;
		explosion = false;
		matrice = new DCase[h][l];
		for (int i = 0; i < hauteur; i++)
			for (int j = 0; j < largeur; j++)
				matrice[i][j] = new DCase();
		miner();
		preparerAlentour();
		caseNonMineeRestante = hauteur * largeur - nbMines;
		etatP = EtatPartie.ENCOURS;
	}

	public EtatCase getEtatCase(int a, int b) {
		return getCase(a, b).getEtatCase(etatP);

	}

	public int getNbMinMines() {
		return NB_MINES_MIN;
	}

	public int getNbMaxMines() {
		return NB_MINES_MAX;
	}

	public int getDimMin() {
		return DIMENSION_MIN;
	}

	public int getDimMax() {
		return DIMENSION_MAX;
	}

	public EtatPartie setEtatPartie() {
		if (perdu() || gagne()) {
			etatP = EtatPartie.FINI;
		}
		return (EtatPartie) etatP;
	}

	public boolean gagne() {
		return (getCaseNonMineeRestante() == 0);
	}

	public boolean perdu() {
		return aExplose();
	}

	public DCase getCase(int i, int j) {
		try {
			return matrice[i][j];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}

	}

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getMines() {
		return nbMines;
	}

	public void devoilerCase(int i, int j) {

		/* Case d�couverte */
		try {
			matrice[i][j].setDecouverte();
			caseNonMineeRestante--;
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		/* on regarde si la case est min�e */
		try {
			if (matrice[i][j].estMine())
				explosion = true;
			else {

				/* propagation �ventuelle */

				if (matrice[i][j].getMinesAlentour() == 0) {

					for (int x = -1; x < 2; x++) {
						for (int y = -1; y < 2; y++) {
							try {
								if (!matrice[i + x][j + y].estDecouverte())
									devoilerCase(i + x, j + y);
							} catch (ArrayIndexOutOfBoundsException e) {
							}
						}
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}

	}

	public void drapeauAction(int i, int j) {
		matrice[i][j].drapeauAction();
	}

	private void preparerAlentour() {
		int minesCompteur;

		for (int i = 0; i < hauteur; i++)
			for (int j = 0; j < largeur; j++) {
				minesCompteur = 0;
				if (!matrice[i][j].estMine()) {
					for (int x = -1; x < 2; x++) {
						for (int y = -1; y < 2; y++) {
							try {
								if (matrice[i + x][j + y].estMine())
									minesCompteur++;
							} catch (ArrayIndexOutOfBoundsException e) {
							}
						}
					}

					/* les mines ont �t�s compt�s */
					matrice[i][j].setMinesAlentour(minesCompteur);
				}

			}

	}

	private void miner() {
		int x, y;
		int i = 0;
		Random alea = new Random();
		while (i < nbMines) {
			x = alea.nextInt(hauteur);
			y = alea.nextInt(largeur);
			if (!matrice[x][y].estMine()) {
				matrice[x][y].poserBombe();
				i++;
			}

		}
	}

	public int nbrDrapeau() {
		int compteur = 0;
		for (int i = 0; i < hauteur; i++)
			for (int j = 0; j < largeur; j++) {
				if (matrice[i][j].yaDrapreau())
					compteur++;
			}
		return compteur;
	}

	public boolean aExplose() {
		return explosion;
	}

	public int getCaseNonMineeRestante() {
		return caseNonMineeRestante;
	}

	public void afficher() {
		System.out.println("****carte****");
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				if (matrice[i][j].estMine())
					System.out.print("M ");
				else
					System.out.print(matrice[i][j].getMinesAlentour() + " ");
			}
			System.out.println("");

		}
		System.out.println("****carte connue****");
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				if (!matrice[i][j].estDecouverte())
					System.out.print("* ");
				else if (matrice[i][j].estMine())
					System.out.print("M ");
				else
					System.out.print(matrice[i][j].getMinesAlentour() + " ");
			}
			System.out.println("");

		}
	}

}