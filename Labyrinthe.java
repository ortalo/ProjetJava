
public class Labyrinthe implements Test{
	private Vector temps=new Vector();
	private int bestDay;
	private String type="Labyrinthe";
	
	public double apprentissage(int semaine){
		int lundi=semaine*5; // Pour semaine 0: lundi =0 vendredi =4, semaine 1: lundi=5, vendredi=9, semaine 2: 10,14...
		int vendredi=lundi+4;
		return (this.temps.elementAt(lundi)-this.temps.elementAt(vendredi))*100/this.temps.elementAt(lundi);
	}
	public void setResultats(){
		System.out.println("Saisir le temps pour sortir du labyrinthe (secs): ");
		int temps=Etude.saisie_entier;
		this.temps.elementAt(Etude.getJour())=temps;
	}
	public void getBestDay(int semaine){
		int lundi=semaine*5; // Pour semaine 0: lundi =0 vendredi =4, semaine 1: lundi=5, vendredi=9, semaine 2: 10,14...
		int vendredi=lundi+4;
		int min=this.temps.elementAt(lundi);
		int day= new int();
		for(int i=lundi;i<=vendredi;i++){
			int current=this.temps.elementAt(i);
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
}



