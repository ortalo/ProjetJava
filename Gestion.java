import java.io.*;
import java.util.*;

public class Gestion
{
    public static void  main ( String [] arg)
    {
	Vector mol = new Vector();
	while(true)
	    {
		affiche_menu();
		int choix = saisie_entier();
		switch (choix)
		    {
		    case 1 : creerMol(mol);break;
		    case 2 : print(mol);break;
		    case 0 : System.exit(0);break;
		    default : System.out.println("0, 1 ou 2...");
		    }
	    }
    }
    public static void creerMol(Vector mol)
    {
	System.out.println("Donnez un nom a votre molecule");
	String nom = saisie_chaine();
	System.out.println("Donnez son poids");
	int poids = saisie_entier();
	Molecule item = new Molecule(nom,poids);
	mol.addElement(item);
    }

    public static void print ( Vector mol)
    {
	for (Enumeration e = mol.elements(); e.hasMoreElements();)
	    {
		Molecule item = (Molecule)e.nextElement();
		item.affiche();
	    }
    }

    public static void affiche_menu()
    {
	System.out.println("");
	System.out.println("Menu");
	System.out.println("Que voulez-vous faire ?");
	System.out.println("1 : Nombre/noms/poids molecules");
	System.out.println("2 : Afficher le tableau des molecules");
	System.out.println("0 : Quitter");
	System.out.print("Choix : ");
    }
    
    public static String saisie_chaine ()
    {
	try {
	    BufferedReader buff = new BufferedReader
		(new InputStreamReader(System.in));
	    String chaine=buff.readLine();
	    return chaine;
	}
	catch(IOException e) {
	    System.out.println(" impossible de travailler" +e);
	    return null;
	}
    }

    public static int saisie_entier ()
    {
	try{
	    BufferedReader buff = new BufferedReader
		(new InputStreamReader(System.in));
	    String chaine=buff.readLine();
	    int num = Integer.parseInt(chaine);
	    return num;
	}
	catch(IOException e){return 0;}
    }

}
