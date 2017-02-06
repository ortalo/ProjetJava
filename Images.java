public class Images implements Test{
	private Vector tentatives=new Vector; //vecteur de tableaux de 5 int, chaque int etant le nombre de tentative par essai
	private int bestDay;
	private int duree = 4 ;
	private String type="Images";
	private int nbEssai=5; //chaque jour e test se compose de n evaluations, n=nbTest
	
	public double apprentissage(int semaine){
		int lundi=semaine*5;
		int vendredi=semaine+4;
		double moyenneLundi=new double();
		int sumLundi=new int();
		double moyenneVendredi=new double();
		int sumVendredi=new int();
		int[] scoresLundi=this.tentatives.elementAt(lundi);
		int[] scoresVendredi=this.tentatives.elementAt(vendredi);
		for(int i=0;i<this.nbEssai;i++){
			sumLundi+=scoresLundi[i];
			sumVendredi+=scoresVendredi[i];
		}
		moyenneLundi=(double)sumLundi/(double)5;
		moyenneVendredi=(double)sumVendredi/(double)5;
		return (moyenneLundi-moyenneVendredi)*100/moyenneLundi;
	}
	public setResultats(){
		for(int i=0;i<this.nbEssai;i++){
			System.out.println("Jour "+Etudes.getJour()+" essai nb "+i+": ");
			System.out.println("Combien de tentatives avant de trouver l image ? ");
			int rep=Etude.saisie_entier;
			int jour=Etude.getJour();
			this.tentatives.elementAt(jour)[i]=rep;
		}
	}
	public getBestDay(int semaine){
		int lundi=semaine*5;
		int vendredi=semaine+4;
		double min=11.0;
		int day=new int();
		for(int i=lundi;i<=vendredi;i++){
			double moyenne=new double();
			int sum=new int();
			int[] current=this.tentatives.elementAt(i);
			for(int j=0;j<nbEssai;j++){
				sum+=current[j];
			}
			moyenne=(double)sum/(double)nbEssai;
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
}



