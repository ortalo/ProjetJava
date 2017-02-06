import java.io.*;
import java.util.*;

public class Etude{
	private Vector animaux=new Vector;
	private Vector souris=new Vector;
	private Vector singes=new Vector;
	private int jour;
	public static void main(String[] args){
		System.out.println("Bonjour nous sommes jour "+this.jour);
		if(this.jour.equals(getDuree)){
			System.out.println("Nous sommes au derner jour de l'experience, voulez vous realiser le bilan? O/N ");
			String rep=saisie_chaine;
			if(rep.charAt(0).equals("o") || rep.charAt(0).equals("O")){
				bilan();
			}
		}

	}


	public void newJour(){
		this.jour++;
		for(Enumeration e=animaux.elements();e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			a.toString();
			if(a.isVivant()){
				System.out.println("Animal toujours vivant? O/N");
				rep=saisie_chaine();
				if(rep.charAt(0).equals("o") || rep.charAt(0).equals("O")){
					System.out.println("Entrez le poids de l'animal: 0.0 ");
					double p=saisie_double;
					a.setPoids(p);
				}else{
					a.setVivant();
				}
			}
		}
	}
	public void addAnimal(){
		System.out.println("Entrez l'IDentifiant: ");
		String ID=saisie_chaine;

		boolean q=true;
		while(q){
		System.out.println("Entrez le sexe M/F: ");
		String input=saisie_chaine;
		char sexe;
		if(input.charAt(0).equals("M") || input.charAt(0).equals("F")){
			sexe=input.charAt(0);
			q=false;
		}else{
			Systeme.out.println("Mauvaise entree");
		}}

		double poids;
		System.out.println("Entrez le poids(0.0 g) ");
		poids=saisie_double;

		q=true;
		while(q){
			System.out.println("Quel test doit passer l'animal ? ");
			System.out.println("Labyrinthe(0), Nourriture(1), ou images(2) ? ");
			String input=saisie_entier;
			Test test;
			if(input.equals(0) || input.equals(1) || input.equals(2)){
				switch(input){
					case 0:test=new Labyrinthe();q=false;break;
					case 1:test=new Nourriture();q=false;break;
					case 2:test=new Images();q=false;break;
				}
			}else{
				Systeme.out.println("Mauvaise entree");
			}
		}

		q=true;
		while(q){
			System.out.println("Quel est l'espece de l'animal ? ");
			System.out.println("souris(0), singe(1)  ? ");
			String input=saisie_entier;
			if(input.equals(0) || input.equals(1) || input.equals(2)){
				switch(input){
					case 0: Animal a=new Souris(ID,sexe,poids,test);
						this.animaux.addElement(a);
						this.souris.addElement(a);
						q=false;break;
					case 1: Animal a=new Singe(ID,sexe,poids,test);
						this.animaux.addElement(a);
						this.singes.addElement(a);
						q=false;break;
				}
			}else{
				Systeme.out.println("Mauvaise entree");
			}
		}

	}
	public int getJour(){
		return this.jour;
	}
	public void bilan(){
		for(Enumeration e=this.animaux.elements();e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			System.out.println("------------Animal---------- ");
			a.toString();
			System.out.println("Progression: "+a.getTest().apprentissage()+" %");
			System.out.println("Meilleur jour: "+a.getTest().getBestDay());
			if(a.isStress){
				System.out.println("stressé");
			}
		}
	}

	public Vector bestGroup(Vector souris, Vector singes){
		void getAppMoy(Vector animaux){
			int nbElements=new int(0);
			double sum=new double(0.0);
			for(Enumeration e=animaux.elements();e.hasMoreElements();){
				Animal a=(Animal)e.nextElement();
				nbElements++;
				sum+=a.getTest().apprentissage();
			}
			return sum/(double)nbElements;
		}
		if (getAppMoy(souris) > getAppMoy(singes){
			return souris
		}else{
			return singes
		}
	}

	public Animal bestOf(Vector animaux){
		Animal best= animaux.ElementAt(0);
		for(Enumeration e=animaux.elements();e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			if(a.getTest().apprentissage() > best.getTest().apprentissage()){
				best=a;
			}
		}
		return best;
	}

			
	}
	
	
	
	
	
	public static String saisie_chaine (){
	try {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String chaine=buff.readLine();
		return chaine;
	}
	catch(IOException e) {
		System.out.println(" impossible de travailler" +e)
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
	public static int saisie_double (){
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

