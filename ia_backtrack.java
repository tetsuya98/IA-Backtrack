import java.util.*;

public class ia_backtrack {

	public static int[] appregle(int nb) {
		int tab[];
		//if (nb >= 5) {
			tab = new int[3];
			tab[0] = 5;
			tab[1] = 2;
			tab[2] = 1;
		/*}else{
			if (nb >= 2) {
				tab = new int[2];
			tab[0] = 2;
			tab[1] = 1;
			}else{
				if (nb >= 1) {
					tab = new int[1];
					tab[0] = 1;
				}else { tab = null ;}			
			}
		}*/

		return tab;
	}

	public static int[] newregle(int[] regle) {
		int tab[] = new int[regle.length-1];
		for (int i = 1; i < regle.length; i++) {
			tab[i-1] = regle[i];
		} 
		return tab;
	}
		
	public static String backtrack(int nb) {
		String chemin;
		int regle[];
		int r_nb, r = 0;
		if(nb == 0) { return ""; }
		else { if(nb < 1) { return "echec"; } 
			else {
				regle = appregle(nb);
				chemin = "echec";
				while(chemin.equals("echec") && regle != null) {
					r = regle[0];
					regle = newregle(regle);
					r_nb = nb - r;
					chemin = backtrack(r_nb);
				}
				if (!chemin.equals("echec")) {
					return chemin + " " + r;
				}else {
					return "echec";
				}
			}
		}
	}

	public static void main(String[] args) {
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Saisir un nombre : ");
			int saisie = scan.nextInt();
			String res = backtrack(saisie);
			System.out.println("----------------------------------------------");
			System.out.println(res);
			System.out.println("----------------------------------------------");
		}
		
	}
}