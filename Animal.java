public abstract class Animal {
	protected String ID;
	protected char sexe;
	protected double poidsInitial;
	protected double poidsCourrant;
	protected boolean stress;
	protected boolean vivant;
	protected Test test;

	public Animal(String ID, char sexe, double poids,Test test){
		this.ID=ID;
		this.sexe=sexe;
		this.poidsInitial=poids;
		this.poidsCourrant=poids;
		this.stress=false;
		this.test=test;
		this.vivant=true;
	}

	public Test getTest(){
		return this.test;
	}

	public boolean isVivant(){
		return this.vivant;
	}

	public void setVivant(){
		this.vivant = !this.vivant;
	}

	public boolean isStress(){
		return this.stress;
	}

	public void setPoids(double pPoids){
		this.poidsCourrant=pPoids;
		if( (this.poidsInitial-this.poidsCourrant) > 0.1*poidsInitial){
			this.stress=true;
		}else{
			this.stress=false;
		}
	}
	public String toString(){
		String vie;
		if(this.vivant){
			vie=" vivant ";
		}else{
			vie=" mort ";
		}
		String etat;
		if(this.stress){
			etat=" stressé ";
		}else{
			etat=" serein ";
		}

		return("| ID: "+this.ID+"| sexe:"+this.sexe+"| poids initial: "+
				this.poidsInitial+"| poids actuel: "+this.poidsCourrant+
				"| condition: "+etat+" "+vie);
	}	
}


