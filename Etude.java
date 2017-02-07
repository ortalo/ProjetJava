import java.io.*;
import java.util.*;

public class Etude{
	private static ArrayList animaux=new ArrayList();
	private static ArrayList souris=new ArrayList();
	private static ArrayList singes=new ArrayList();
	private static int jour=-1;
	private static int semaine=0;
	private static int duree=4;
	
	public static void main(String[] args){
		boolean q=true;
		while(q){
			System.out.println("Bonjour nous sommes jour "+(Etude.jour+1)+" de la semaine "+(Etude.semaine+1));
			if(Etude.jour==Etude.duree){
				System.out.println("Nous sommes au derner jour de l'experience, voulez vous realiser le bilan? O/N ");
				String rep=saisie_chaine();
				if(rep.charAt(0)=='o' || rep.charAt(0)=='O'){
					bilan();
				}
			}	
			menu();
			int choix=saisie_entier();
			switch(choix){
				case 1:newJour();break;
				case 2:addAnimal();break;
				case 3:bilan();break;
				case 6:q=false;break;
				default:System.out.println("Mauvaise entree");
			}
		}
	}

	public static void menu(){
		System.out.println("------Menu------");
		System.out.println("1-Nouveau jour (mise a jour des poids et des resultats de chaque animal)");
		System.out.println("2-Ajouter un animal");
		System.out.println("3-Lancer bilan");
		System.out.println("4-Sauver");
		System.out.println("5-charger");
		System.out.println("6-Quitter");
	}



	public static void newJour(){
		Etude.jour++;
		if( Etude.jour > 4 ){
			Etude.semaine++;
		}

		for(Enumeration e=Collections.enumeration(animaux);e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			System.out.println(a.toString());
			if(a.isVivant()){
				System.out.println("Animal toujours vivant? O/N");
				String rep=saisie_chaine();
				if(rep.charAt(0)=='o' || rep.charAt(0)=='O'){
					System.out.println("Entrez le poids de l'animal: 0.0 ");
					double p=saisie_double();
					a.setPoids(p);
					System.out.println("Enregistrement des resultats au test: ");
					a.getTest().setResultats();
				}else{
					a.setVivant();
				}
			}
		}
	}
	public static void addAnimal(){
		System.out.println("Entrez l'IDentifiant: ");
		String ID=saisie_chaine();
		
		char sexe='u';
		boolean q=true;
		while(q){
		System.out.println("Entrez le sexe M/F: ");
		String input=saisie_chaine();
		if(input.charAt(0)=='M' || input.charAt(0)=='F'){
			sexe=input.charAt(0);
			q=false;
		}else{
			System.out.println("Mauvaise entree");
		}}

		q=true;
		double poids=0.0;
		while(q){
		try{
		System.out.println("Entrez le poids(0.0 g) ");
		poids=saisie_double();q=false;
		}catch(Exception e){
			System.out.println("Mauvaise entree");
		}
		}

		
		Test test=new Labyrinthe(duree);
		q=true;
		while(q){
			System.out.println("Quel test doit passer l'animal ? ");
			System.out.println("Labyrinthe(0), Nourriture(1), ou images(2) ? ");
			try{
				int input=saisie_entier();	
				if(input==0 || input==1 || input==2){
					switch(input){
						case 0:test=new Labyrinthe(duree);q=false;break;
						case 1:test=new Nourriture(duree);q=false;break;
						case 2:test=new Images(duree);q=false;break;
					}
				}else{
					System.out.println("Mauvaise entree");
				}

			}catch(Exception e){
				System.out.println("Mauvaise entree");
			}
			}
		q=true;
		while(q){
			System.out.println("Quel est l'espece de l'animal ? ");
			System.out.println("souris(0), singe(1)  ? ");
			try{
				int input=saisie_entier();
				if( input==0 || input==1 ){
					switch(input){
						case 0: Animal a=new Souris(ID,sexe,poids,test);
							animaux.add(a);
							souris.add(a);
							q=false;break;
						case 1: Animal b=new Singe(ID,sexe,poids,test);
							animaux.add(b);
							singes.add(b);
							q=false;break;
					}
				}else{
					System.out.println("Mauvaise entree");
				}
			}catch(Exception e){
				System.out.println("Mauvaise entree");
			}
		}

	}
	public static int getJour(){
		return Etude.jour;
	}
	public static void bilan(){
		for(Enumeration e=Collections.enumeration(animaux);e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			System.out.println("------------Animal---------- ");
			System.out.println(a.toString());
			System.out.println("Progression: "+a.getTest().apprentissage(Etude.semaine)+" %");
			System.out.println("Meilleur jour: "+a.getTest().getBestDay(Etude.semaine));
			if(a.isStress()){
				System.out.println("stressé");
			}
		}
	}
	private static double getAppMoy(ArrayList animaux){
			int nbElements=0;
			double sum=0.0;
			for(Enumeration e=Collections.enumeration(animaux);e.hasMoreElements();){
				Animal a=(Animal)e.nextElement();
				nbElements++;
				sum+=a.getTest().apprentissage(Etude.semaine);
			}
			return (double)sum/(double)nbElements;
	}
	public static ArrayList bestGroup(ArrayList souris, ArrayList singes){
		
		if (getAppMoy(souris) > getAppMoy(singes)){
			return souris;
		}else{
			return singes;
		}
	}

	public static Animal bestOf(ArrayList animaux){
		Animal best= (Animal)animaux.get(0);
		for(Enumeration e=Collections.enumeration(animaux);e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			if(a.getTest().apprentissage(Etude.semaine) > best.getTest().apprentissage(Etude.semaine)){
				best=a;
			}
		}
		return best;
	}
	
	public static String saisie_chaine (){
	try {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String chaine=buff.readLine();
		return chaine;
	}
	catch(IOException e) {
		System.out.println(" impossible de travailler" +e);
			return null;
	}
	}
    	public static int saisie_entier (){
		try{
			BufferedReader buff = new BufferedReader
				(new InputStreamReader(System.in));
			String chaine=buff.readLine();
			int num = Integer.parseInt(chaine);
			return num;
			}
		catch(IOException e){return 0;}
	}
	public static double saisie_double (){
		try{
			BufferedReader buff = new BufferedReader
				(new InputStreamReader(System.in));
			String chaine=buff.readLine();
			double num = Double.parseDouble(chaine);
			return num;
			}
		catch(IOException e){return 0;}
	}
}

