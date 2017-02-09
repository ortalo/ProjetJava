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
			System.out.println("------Bonjour nous sommes jour "+(Etude.jour+1)+" de la semaine "+(Etude.semaine+1)+"------");
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
				case 1:addAnimal();break;
				case 2:System.out.println("Quelle espèce afficher ? souris(1),singes(2)");
				       int espece=0;
				       boolean loop=true;
				       while(loop){
						try{
						espece=saisie_entier();
						if( choix==1 || choix==2 ){
							loop=false;
						}else{System.out.println("Mauvaise entree");}
				
						}catch(Exception e){System.out.println("Mauvaise entree");}
					}
			       		switch(espece){
				 		case 1:afficheAnimaux(Etude.souris);break;
						case 2:afficheAnimaux(Etude.singes);break;
						default:System.out.println("Mauvaise entree");
					}
					break;
				case 3:newJour();break;
				case 4:bilan();break;
				case 5:ecrire(animaux);break;
				case 7:q=false;break;
				default:System.out.println("Mauvaise entree");break;
			}
		}
	}

	public static void menu(){
		System.out.println("------Menu------");
		System.out.println("1-Ajouter un animal");
		System.out.println("2-Afficher animaux");
		System.out.println("3-Nouveau jour (mise a jour des poids et des resultats de chaque animal)");
		System.out.println("4-Lancer bilan");
		System.out.println("5-Sauver");
		System.out.println("6-charger");
		System.out.println("7-Quitter");
	}


	public static void afficheAnimaux(ArrayList animaux){
		for(Enumeration e=Collections.enumeration(animaux);e.hasMoreElements();){
			Animal a= (Animal)e.nextElement();
			System.out.println("------Animal------");
			System.out.println(a.toString());
		}
	}

	public static void newJour(){
		Etude.jour++;
		if( Etude.jour > 4 ){
			Etude.semaine++;
		}

		for(Enumeration e=Collections.enumeration(animaux);e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			System.out.println("------Animal------");
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
		if( Etude.jour >=0 ){
			System.out.println("Vous tentez d'ajouter un animal à une etude en cours.");
		}else{
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

		
		Test test=null;
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
	public static void ecrire (ArrayList animaux){
		try{
		BufferedWriter buffEtude=new BufferedWriter
		(new FileWriter("savedEtude.txt"));
		buffEtude.write((new Integer(Etude.jour)).toString()+"|"+
				(new Integer(Etude.semaine)).toString()+"|"+(new Integer(Etude.duree)).toString());
		buffEtude.flush();
		buffEtude.close();

		BufferedWriter buff=new BufferedWriter
		(new FileWriter("savedAnimals.txt"));
		buff.newLine();
		for(Enumeration e = Collections.enumeration(animaux);e.hasMoreElements();){
			Animal courant = (Animal)e.nextElement();
			courant.save(buff);
			buff.newLine();
		}
		buff.flush();
		buff.close();
		}catch(IOException e){System.out.println("Erreur de sauvegarde");}
	}

	public static void lire (ArrayList animaux,ArrayList singes,ArrayList souris)throws IOException{
		BufferedReader buffEtude=new BufferedReader(new FileReader("savedEtude.txt"));
		BufferedReader buff=new BufferedReader(new FileReader("savedAnimals.txt"));
		try {

			String etude = buff.readLine();
			String[] etudeVals=etude.split("|");
			int jour= Integer.valueOf(etudeVals[0]).intValue();
			Etude.jour=jour;
			int semaine= Integer.valueOf(etudeVals[1]).intValue();
			Etude.semaine=semaine;
			int duree= Integer.valueOf(etudeVals[2]).intValue();
			Etude.duree=duree;

			for(;;){
				String animal=buff.readLine();
				String[] attAnimal=animal.split("|");
				char sexe=attAnimal[2];
				double poidsInitial=Double.valueOf(attAnimal[3]).doubleValue();
				double poidsCourrant=Double.valueOf(attAnimal[4]).doubleValue();
				boolean vivant=Boolean.valueOf(attAnimal[5]);
				Test test=testIs(attAnimal[1]);



				}
		}catch (InstantiationException e){
			System.out.println("Fini");
			buff.close();
		}
	}
	private static Test testIs(String s){
		if(s.equals("Labyrinthe")){
			Test test=new Labyrinthe(Etude.getDuree());
			return test;}
		if(s.equals("Nourriture")){
			Test test=new Nourriture(Etude.getDuree());
			return test;}
		if(s.equals("Images")){
			Test test=new Images(Etude.getDuree());
			return test;
			}
	}
}
