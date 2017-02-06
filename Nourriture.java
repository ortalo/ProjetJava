public class Nourriture implements Test{
	private Vector cachettes=new Vector();
	private Vector succes=new Vector();
	private int bestDay;
	private String type="Nourriture";
	
	public double apprentissage(int semaine){
		int lundi=semaine*5;
		int vendredi=lundi+4;
		return (this.cachettes.elementAt(lundi)-this.cachettes.elementAt(4))*100/this.cachettes.elementAt(0);
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
	public getBestDay(){
		int min=this.cachettes[0]();
		int day=new int(0);
		for(int i=0;i<5;i++){
			if(this.cachettes[i] < min){
				min=this.cachettes[i];
				day=i;
			}
		}
		return day;
	}
	public getType(){
		return this.type;
	}
}



