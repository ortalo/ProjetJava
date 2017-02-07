import java.util.ArrayList;

public class Nourriture implements Test{
	private ArrayList cachettes=new ArrayList();
	private ArrayList succes=new ArrayList();
	private int bestDay;
	private int duree = 4 ;
	private String type="Nourriture";
	
	public Nourriture(int duree){
		this.duree=duree;
	}
	public double apprentissage(int semaine){
		int lundi=semaine*5;
		int vendredi=lundi+4;
		return ((double)this.cachettes.get(lundi)-(double)this.cachettes.get(vendredi))*100/(double)this.cachettes.get(lundi);
	}
	public void setResultats(){
		System.out.println("La nourriture a-t-elle ete retrouvee? (succes) O/N ");
		String rep=Etude.saisie_chaine();
		if(rep.charAt(0)=='o' || rep.charAt(0)=='O'){
			this.succes.add(true);
		}
		System.out.println("Combien de cachettes explorees? )");
		double nb=(double)Etude.saisie_double();
		this.cachettes.add(nb);
	}
	public int getBestDay(int semaine){
		int lundi=semaine*5;
		int vendredi=lundi+4;
		double min=(double)this.cachettes.get(lundi);
		int day=0;
		for(int i=lundi;i<=vendredi;i++){
			double current=(double)this.cachettes.get(i);
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
}



