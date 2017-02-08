import java.util.ArrayList;
public class Labyrinthe implements Test{
	private ArrayList temps=new ArrayList();
	private int bestDay;
	private int duree;
	private String type="Labyrinthe";
	
	public Labyrinthe(int duree){
		this.duree=duree;
	}

	public double apprentissage(int semaine){
		int lundi=semaine*5; // Pour semaine 0: lundi =0 vendredi =4, semaine 1: lundi=5, vendredi=9, semaine 2: 10,14...
		int vendredi=lundi+4;
		double tempsLundi=(double)this.temps.get(lundi);
		double tempsVendredi=(double)this.temps.get(vendredi);
		return (tempsLundi-tempsVendredi)*100/tempsLundi;
	}
	public void setResultats(){
		System.out.println("Saisir le temps pour sortir du labyrinthe (secs): ");
		double temps=Etude.saisie_double();
		this.temps.add(temps);
	}
	public int getBestDay(int semaine){
		int lundi=semaine*5; // Pour semaine 0: lundi =0 vendredi =4, semaine 1: lundi=5, vendredi=9, semaine 2: 10,14...
		int vendredi=lundi+4;
		double min=(double)this.temps.get(lundi);
		int day=0;
		for(int i=lundi;i<=vendredi;i++){
			double current=(double)this.temps.get(i);
			if(current < min){
				min=current;
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
	public void save(bufferedWriter buff){
		buff.write(
}



