
public class Labyrinthe implements Test{
	private int[] temps=new int[5];
	private int bestDay;
	private String type="Labyrinthe";
	
	public double apprentissage(){
		return (this.temps[0]-this.temps[4])*100/this.temps[0];
	}
	public void setResultats(){
		System.out.println("Saisir le temps pour sortir du labyrinthe (secs): ");
		int temps=Etude.saisie_entier;
		this.temps[Etude.getJour()]=temps;
	}
	public void getBestDay(){
		int min=this.temps[0];
		int day= new int();
		for(int i=0;i<5;i++){
			if(this.temps[i] < min){
				min=this.temps[i];
				day=i;
			}
		}
		return day;
	}
	public String getType(){
		return this.type;
	}
}



