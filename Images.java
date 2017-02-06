public class Images implements Test{
	private int[][] tentatives=new int[5][5];
	private int bestDay;
	private String type="Images";
	
	public double apprentissage(){
		double moyenne0=new double();
		int sum0=new int(0);
		double moyenne4=new double();
		int sum4=new int(0);
		for(int i=0;i<5;i++){
			sum0+=tentatives[0][i];
			sum4+=tentatives[4][i];
		}
		moyenne0=(double)sum0/(double)5;
		moyenne4=(double)sum4/(double)5;
		return (moyenne0-moyenne4)*100/moyenne0;
	}
	public setResultats(){
		for(int i=0;i<5;i++){
			System.out.println("Jour "+Etudes.getJour()+" essai nb "+i+": ");
			System.out.println("Combien de tentatives avant de trouver l image ? ");
			int rep=Etude.saisie_entier;
			this.tentatives[Etude.getJour()][i]=rep;
		}
	}
	public getBestDay(){
		double min=11.0;
		int day=new int(0);
		for(int i=0;i<5;i++){
			double moyenne=new double();
			int sum=new int(0);
			for(int j=0;j<5;j++){
				sum+=tentatives[i][j];
			}
			moyenne=(double)sum/(double)5;
			if(moyenne < min){
				min=moyenne;
				day=i;
			}
		}
		return day;
	}
	public getType(){
		return this.type;
	}

}



