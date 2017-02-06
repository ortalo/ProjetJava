public class Nourriture implements Test{
	private Vector cachettes=new Vector();
	private Vector succes=new Vector();
	private int bestDay;
	private int duree = 4 ;
	private String type="Nourriture";
	
	public double apprentissage(int semaine){
		int lundi=semaine*5;
		int vendredi=lundi+4;
		return (this.cachettes.elementAt(lundi)-this.cachettes.elementAt(vendredi))*100/this.cachettes.elementAt(lundi);
	}
	public setResultats(){
		System.out.println("La nourriture a-t-elle ete retrouvee? (succes) O/N ");
		String rep=Etude.saisie_chaine;
		if(rep.charAt(0).equals("o") || rep.charAt(0).equals("O")){
			this.succes[Etude.getJour()]=true;
		}
		System.out.println("Combien de cachettes explorees? )");
		int nb=Etude.saisie_entier;
		this.cachettes[Etude.getJour()]=nb;
	}
	public getBestDay(int semaine){
		int lundi=semaine*5;
		int vendredi=lundi+4;
		int min=this.cachettes.elementAt(lundi);
		int day=new int();
		for(int i=lundi;i<vendedi;i++){
			int current=this.cachettes.elementAt(i);
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



