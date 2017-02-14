import java.io.*;
import java.util.ArrayList;
public class Images implements Test{
	private ArrayList tentatives=new ArrayList(); //vecteur de tableaux de 5 int, chaque int etant le nombre de tentative par essai
	private int duree = 4 ;
	private String type="Images";
	private static Integer nbEssai=new Integer(5); //chaque jour e test se compose de n evaluations, n=nbTest
	
	public Images(int duree){
		this.duree=duree;
	}
	public double apprentissage(int semaine){
		int lundi=semaine*5;
		int vendredi=semaine+4;
		double moyenneLundi=0.0;
		double sumLundi=0.0;
		double moyenneVendredi=0.0;
		double sumVendredi=0.0;
		int[] scoresLundi=(int[])this.tentatives.get(lundi);
		int[] scoresVendredi=(int[])this.tentatives.get(vendredi);
		for(int i=0;i<this.nbEssai;i++){
			sumLundi+=scoresLundi[i];
			sumVendredi+=scoresVendredi[i];
		}
		moyenneLundi=sumLundi/nbEssai.doubleValue();
		moyenneVendredi=sumVendredi/nbEssai.doubleValue();
		return (moyenneLundi-moyenneVendredi)*100/moyenneLundi;
	}
	public void setResultats(){
		int[] resultats=new int[Images.nbEssai];
		for(int i=0;i<Images.nbEssai;i++){
			System.out.println("Jour "+(Etude.getJour()+1)+" essai nb "+i+": ");
			System.out.println("Combien de tentatives avant de trouver l image ? ");
			int rep=Etude.saisie_entier();
			resultats[i]=rep;
		}
		this.tentatives.add(resultats);
	}
	public void retireRes(){
		this.tentatives.remove(this.tentatives.size()-1);
	}
	public int getBestDay(int semaine){
		int lundi=semaine*5;
		int vendredi=semaine+4;
		double min=11.0;
		int day=0;
		for(int i=lundi;i<=vendredi;i++){
			double moyenne;
			double sum=0;
			int[] current=(int[])this.tentatives.get(i);
			for(int j=0;j<nbEssai;j++){
				sum+=current[j];
			}
			moyenne=sum/nbEssai.doubleValue();
			if(moyenne < min){
				min=moyenne;
				day=i;
			}
		}
		return day;
	}
	public String getType(){
		return this.type;
	}
	public int getDuree(){
		return this.duree;
	}
	public void save(BufferedWriter buff){
		try{
		for(int i=0;i<this.tentatives.size();i++){
			int[] essais=(int[])this.tentatives.get(i);
			for(Integer essai : essais){
				buff.write(essai.toString());
				buff.write(":");
			}
			buff.write(",");
		}
		}catch(IOException e){System.out.println("erreur");}
	}
	public void lire(String input){
		String[] jours=input.split(",");
		for(int i=0;i<jours.length;i++){
			int[] resultats=new int[this.nbEssai];
			String[] essais=jours[i].split(":");
			for(int j=0;j<essais.length;j++){
				int nbImages= Integer.valueOf(essais[i]);
				resultats[j]=nbImages;
			}
			this.tentatives.add(resultats);
		}
	}
}



