import java.io.*;
import java.util.*;

public class Etude{
	private static ArrayList<List<Animal>> animaux = new ArrayList<List<Animal>>();
	private static ArrayList<Animal> singes = new ArrayList<Animal>();
	private static ArrayList<Animal> souris = new ArrayList<Animal>();
	private static int jour=-1;
	private static int semaine=0;
	private static int duree=4;
	
	public static void main(String[] args){
		animaux.add(souris);
		animaux.add(singes);
		boolean q=true;
		while(q){
			System.out.println("\n------Jour "+(Etude.jour+1)+" de la semaine "+(Etude.semaine+1)+"------");
			if(Etude.jour==Etude.duree){
				System.out.println("\nNous sommes au derner jour de l'experience, voulez vous realiser le bilan? O/N ");
				String rep=saisie_chaine();
				if(rep.charAt(0)=='o' || rep.charAt(0)=='O'){
					bilan();
				}
			}	
			menu();
			int choix=saisie_entier();
			switch(choix){
				case 1:addAnimal();break;
				case 2:System.out.println("\nQuelle espèce afficher ? souris(0),singes(1)");
				       int espece=0;
				       boolean loop=true;
				       while(loop){
						try{
						espece=saisie_entier();
						if( espece==0 || espece==1 ){
							loop=false;
						}else{System.out.println("Mauvaise entree");}
				
						}catch(Exception e){System.out.println("Mauvaise entree");}
					}
			       		afficheAnimaux((ArrayList)animaux.get(espece));break;
			     case 3:modifierAnimal(animaux);break;
				case 4:newJour();break;
				case 5:bilan();break;
				case 6:ecrire(animaux);break;
				case 7:try{
					       lire(animaux);break;
				}catch(FileNotFoundException e){
					System.out.println(e);break;
				}
				case 8:q=false;break;
				default:System.out.println("Mauvaise entree");break;
			}
		}
	}

	public static void menu(){
		System.out.println("\n------Menu------");
		System.out.println("1-Ajouter un animal");
		System.out.println("2-Afficher animaux");
		System.out.println("3-Modifier un animal");
		System.out.println("4-Nouveau jour (mise a jour des poids et des resultats de chaque animal)");
		System.out.println("5-Lancer bilan");
		System.out.println("6-Sauver");
		System.out.println("7-charger");
		System.out.println("8-Quitter");
	}


	public static void afficheAnimaux(ArrayList espece){
		for(Enumeration e=Collections.enumeration(espece);e.hasMoreElements();){
			Animal a= (Animal)e.nextElement();
			System.out.println("------Animal------");
			System.out.println(a.toString());
			}
		}

	public static void newJour(){
		Etude.jour++;
		if( Etude.jour > 4 ){
			Etude.semaine++;
			Etude.jour=0;
		}
		for(Enumeration ea=Collections.enumeration(animaux);ea.hasMoreElements();){
			ArrayList array=(ArrayList)ea.nextElement();
		
		for(Enumeration e=Collections.enumeration(array);e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			System.out.println("------Animal------");
			System.out.println(a.toString());
			if(a.isVivant()){
				System.out.println("\nAnimal toujours vivant? O/N");
				String rep=saisie_chaine();
				if(rep.charAt(0)=='o' || rep.charAt(0)=='O'){
					System.out.println("\nEntrez le poids de l'animal: 0.0 ");
					double p=saisie_double();
					a.setPoids(p);
					System.out.println("\nEnregistrement des resultats au test: ");
					a.getTest().setResultats();
				}else{
					a.setVivant();
				}
			}
		}}
	}
	public static void addAnimal(){
		if( Etude.jour >=0 ){
			System.out.println("\nVous tentez d'ajouter un animal à une etude en cours.");
		}
	else{	
		String espece=null;
		boolean q=true;
		while(q){
			System.out.println("\nQuel groupe d'animal ?");
			System.out.println("\nsouris Labyrinthe(0),souris Nourriture(1) singe(2) ? ");
			try{
				espece=saisie_chaine();	
				if(espece.equals("0") || espece.equals("1")|| espece.equals("2")){
					q=false;
				}else{
					System.out.println("Mauvaise entree");
				}

			}catch(Exception e){
				System.out.println("Mauvaise entree");
			}
		}

		String ID=null;
		q=true;
		while(q){
			System.out.println("Entrez l'IDentifiant: ");
			ID=saisie_chaine();
			boolean existeDeja=false;
			for(Enumeration ea=Collections.enumeration(animaux);ea.hasMoreElements();){
				ArrayList array=(ArrayList)ea.nextElement();
				for(Enumeration e=Collections.enumeration(array);e.hasMoreElements();){
					Animal a=(Animal)e.nextElement();
					if(a.getID().equals(ID)){
						System.out.println("Cet ID existe deja: ");
						System.out.println(a.toString());
						existeDeja=true;
						break;
					}
				}
			}
			if( ! existeDeja ){
				q=false;
			}
		}


		char sexe='u';
		q=true;
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
		

		/*Pour modularité future, il sera possible de demander le test à passer. Il sera envoyé en parametre à AnimalIs()
		Test test=null;
		q=true;
		while(q){
			System.out.println("Quel test doit passer l'animal ? ");
			System.out.println("Labyrinthe(0), Nourriture(1), ou images(2) ? ");
			try{
				String input=saisie_chaine();	
				if(input.equals("0") || input.equals("1") || input.equals("2")){
					test=testIs(input);q=false;
				}else{
					System.out.println("Mauvaise entree");
				}

			}catch(Exception e){
				System.out.println("Mauvaise entree");
			}
		}
		Pour le moment, etant donné que chaque groupe dispose d'un test specifique la variable espece (groupe) nous permet
		de choisir le test correspondant, en effet les indices associés à espece et test concordent */
		Test test=testIs(espece);
		System.out.println("espece: "+espece+" ID: "+ID+" sexe: "+sexe+" poids: "+poids+"test : "+test.getType());
		if(areYouSure()){
			animalIs(espece,ID,sexe,poids,poids,true,test);
		}else{
			System.out.println("Annulation, animal non ecrit");
		}
	  }
	}
	
	public static void modifierAnimal(ArrayList animaux){
		System.out.println("\n A quelle espèce appartient l'animal que voulez modifier ? souris(0),singes(1)");
		int espece=0;
		boolean loop1=true;
		while(loop1){
			try{
			espece=saisie_entier();
			if( espece==0 || espece==1 ){
				loop1=false;
			}else{System.out.println("Mauvaise entree");}
			}catch(Exception e){System.out.println("Mauvaise entree");}
		}
		afficheAnimaux((ArrayList)animaux.get(espece));
		System.out.println("Donnez l'ID de l'animal que vous voulez modifier dans la liste");
		String ID=saisie_chaine();
		for(Enumeration e=Collections.enumeration((ArrayList)animaux.get(espece));e.hasMoreElements();){
			Animal s= (Animal)e.nextElement();
			String ID_s=s.getID();
			if (ID_s.equals(ID)){
				boolean loop = true;
				while(loop){
					System.out.println("Que voulez-vous modifier ?\n") ;
					System.out.println("1-Son ID");
					System.out.println("2-Son sexe");
					System.out.println("3-Son poid initial");
					System.out.println("4-Son poid courant");
					System.out.println("5-Son statut (vivant ou mort)");
					System.out.println("6-Son resultat au dernier test (supprime et remplace la deriere valeur)");
					System.out.println("7-Quitter");
					int reponse = saisie_entier();
					switch(reponse){
						case 1 : System.out.println("Donnez le nouvel ID");
							String new_ID = saisie_chaine();
							s.setID(new_ID); break;
						case 2 : System.out.println("Donnez le nouveau sexe");
							String new_sex = saisie_chaine();
							char new_sexe = new_sex.charAt(0);
							s.setSexe(new_sexe); break;
						case 3 : System.out.println("Donnez le nouveau poids initial");
							double new_poids_initial = saisie_double();
							s.setPoidsInitial(new_poids_initial); break;
						case 4 : System.out.println("Donnez le nouveau poids courant");
							double new_poids_courant = saisie_double();
							s.setPoids(new_poids_courant); break;
						case 5 : System.out.println("Vivant (1) ou Mort (0) ?");
							double alive = saisie_double();
							if (alive == 1){
								s.isVivant();
							}
							else if (alive == 0){
								s.setVivant();
							}
							else{
								System.out.println("saisie invalide (0 ou 1)");
							}
							break;
						case 6 : System.out.println("Animal toujours vivant? O/N");
							String rep=saisie_chaine();
							if(rep.charAt(0)=='o' || rep.charAt(0)=='O'){
								System.out.println("Entrez le poids de l'animal: 0.0 ");
								double p=saisie_double();
								s.setPoids(p);
								System.out.println("Enregistrement des resultats au test: ");
								s.getTest().retireRes();
								s.getTest().setResultats();
							}else{
								s.setVivant();
							}
						case 7: loop=false;break;
						default: System.out.println("Mauvaise entree");break;
					}
				}
			}
		}
	}

	
	public static int getJour(){
		return Etude.jour;
	}
	public static void bilan(){
		if(Etude.jour != Etude.duree){
			System.out.println("Impossible de lancer le bilan, la semaine n'est pas finie");
		}else{
		for(Enumeration ea=Collections.enumeration(animaux);ea.hasMoreElements();){
			ArrayList array=(ArrayList)ea.nextElement();
			System.out.println("------------------------Group------------------------");
		for(Enumeration e=Collections.enumeration(array);e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			System.out.println("\n------------Animal---------- ");
			System.out.println(a.toString());
			System.out.println("Progression: "+a.getTest().apprentissage(Etude.semaine)+" %");
			System.out.println("Meilleur jour: "+a.getTest().getBestDay(Etude.semaine));
			if(a.isStress()){
				System.out.println("stressé");
			}
		}
		System.out.println("\nApprentissage moyen du groupe:");
		System.out.println(getAppMoy(array));
		}
		bestGroup(animaux);
		compareStress();
		}
	}
	public static double getAppMoy(ArrayList group){
			int nbElements=0;
			double sum=0.0;
			for(Enumeration e=Collections.enumeration(group);e.hasMoreElements();){
				Animal a=(Animal)e.nextElement();
				nbElements++;
				sum+=a.getTest().apprentissage(Etude.semaine);
			}
			return (double)sum/(double)nbElements;
	}
	public static void compareStress(){
		ArrayList<Animal> stress = new ArrayList<Animal>();
		ArrayList<Animal> noStress = new ArrayList<Animal>();
		for(Enumeration ea=Collections.enumeration(animaux);ea.hasMoreElements();){
			ArrayList array=(ArrayList)ea.nextElement();
		
		for(Enumeration e=Collections.enumeration(array);e.hasMoreElements();){
			Animal a=(Animal)e.nextElement();
			if(a.isStress()){
				stress.add(a);
			}else{
				noStress.add(a);
			}
		}
		}
		System.out.println("\nApprentissage moyen des animaux stréssés:");
		System.out.println(getAppMoy(stress));
		System.out.println("Apprentissage moyen des animaux non stréssés:");
		System.out.println(getAppMoy(noStress));


	}

	public static void bestGroup(ArrayList animaux){
		ArrayList best=null;
		double maxApp=0.0;
		for(Enumeration e=Collections.enumeration(animaux);e.hasMoreElements();){
			ArrayList group=(ArrayList)e.nextElement();
			double res= getAppMoy(group);
			if(res>maxApp){	
				maxApp=res;
				best=group;
			}
		}
		System.out.println("\nLe meileur group est :");
		afficheAnimaux(best);
		System.out.println("\nApprentissage moyen :");
		System.out.println(maxApp);
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
		buffEtude.write((new Integer( Etude.jour + 1 )).toString()+"-"+// le +1 a Etude. jour permet de sauver le -1 eventuel en 0, car										// -1 fait buger le "valueOf(int) dans lire()

				(new Integer(Etude.semaine)).toString()+"-"+(new Integer(Etude.duree)).toString());
		buffEtude.flush();
		buffEtude.close();

		BufferedWriter buff=new BufferedWriter
		(new FileWriter("savedAnimals.txt"));

		for(Enumeration ea = Collections.enumeration(animaux) ; ea.hasMoreElements() ; ){
			ArrayList array = (ArrayList)ea.nextElement() ;
			for(Enumeration e = Collections.enumeration(array) ; e.hasMoreElements() ; ){
				Animal courant = (Animal)e.nextElement();
				courant.save(buff);
				buff.newLine();
			}
		}
		buff.flush();
		buff.close();
		}catch(IOException e){System.out.println("Erreur de sauvegarde");}
	}

	public static void lire (ArrayList animaux)throws FileNotFoundException{
		boolean	q=true;
		while(q){
			System.out.println("\n Charger Etude (mise a jour des dates, duree...) (0) ou animaux (1) ?");
			try{
				double input=saisie_double();	
				if(input == 0){
			//--------------------Lire etude-----------------------//	
					BufferedReader buffEtude=new BufferedReader(new FileReader("savedEtude.txt"));
					String etude=null;String[] etudeVals=null;int jour=0;int duree=0;
					try {
						etude = buffEtude.readLine();
						}catch (IOException e){System.out.println(e);}
					etudeVals=etude.split("-");
					jour= (Integer.valueOf((String)etudeVals[0]).intValue())-1;
					Etude.jour=jour;
					semaine= Integer.valueOf((String)etudeVals[1]).intValue();
					Etude.semaine=semaine;
					try {
						duree= Integer.valueOf((String)etudeVals[2]).intValue();
						Etude.duree=duree;
						buffEtude.close();
					}catch (Exception e){
						System.out.println("Impossible de lire le fichier d'etude");
					}
					q=false;
			//--------------------Lire Animaux-----------------------//	
				
		}else if(input == 1){
		
			BufferedReader buff=new BufferedReader(new FileReader("savedAnimals.txt"));
			try{	
			for(;;){
				String a="";String espece="";String ID=""; 
				char sexe='u'; double poidsInitial=0.0;double poidsCourrant=0.0;boolean vivant=true;
				try{
				a=buff.readLine();
				}catch (IOException e){System.out.println(e);}
				String[] attAnimal=a.split("-");
				espece=attAnimal[0];
				ID=attAnimal[2];
				sexe=attAnimal[3].charAt(0);
				poidsInitial=Double.valueOf(attAnimal[4]).doubleValue();
				poidsCourrant=Double.valueOf(attAnimal[5]).doubleValue();
				vivant=Boolean.valueOf(attAnimal[6]);
				Test test=testIs(attAnimal[1]);
				test.lire(attAnimal[7]);
				animalIs(espece,ID,sexe,poidsInitial,poidsCourrant,vivant,test);
			}
			}catch(NullPointerException e){}
			catch(ArrayIndexOutOfBoundsException e2){}
				try{buff.close();}catch(IOException io){System.out.println(io);}
				System.out.println("fini");
			q=false;
			//---------------Mauvaise entree--------------------//
				}else{
					System.out.println("mauvaise entree");
				}
		}catch(IOException e){
				System.out.println("Mauvaise entree");
			}
		}

	}
	public static Test testIs(String s){
		Test test=new Labyrinthe(Etude.duree);
		if(s.equals("Labyrinthe")||s.equals("0")){
			test=new Labyrinthe(Etude.duree);
		}
		if(s.equals("Nourriture")||s.equals("1")){
			test=new Nourriture(Etude.duree);
		}
		if(s.equals("Images")||s.equals("2")){
			test=new Images(Etude.duree);
			}
		return test;
	}
	public static void animalIs(String s,String ID,char sexe,double poids, double poidsCourrant,boolean vivant,Test test){
		if((s.equals("0"))||(s.equals("sourisGl"))){
			Animal a=new SourisGl(ID,sexe,poids,test);
			a.setPoids(poidsCourrant);
			a.setStress();
			if( ! (vivant) ){a.setVivant();}
			Etude.animaux.get(0).add(a);
		}else if((s.equals("1"))||(s.equals("sourisGn"))){
			Animal a=new SourisGn(ID,sexe,poids,test);
			a.setPoids(poidsCourrant);
			a.setStress();
			if( ! (vivant) ){a.setVivant();}
			Etude.animaux.get(0).add(a);
		}else if((s.equals("2"))||(s.equals("singe"))){
			Animal a=new Singe(ID,sexe,poids,test);
			a.setPoids(poidsCourrant);
			a.setStress();
			if( ! (vivant) ){a.setVivant();}
			Etude.animaux.get(1).add(a);
		}
		
	}
	public static boolean areYouSure(){
		boolean output=false;
		System.out.println("Etes vous sur? O/N");
		boolean question=true;
		while(question){
			try{
				String reponse=saisie_chaine();
				if(reponse.equalsIgnoreCase("O")){
					output= true;question=false;
				}else if(reponse.equalsIgnoreCase("N")){
					output= false;question=false;
				}else{
					System.out.println("Saisir O ou N");
				}	
			}catch(Exception e){
					System.out.println("Mauvaise entree");
				}
		}
		return output;
	}
}
