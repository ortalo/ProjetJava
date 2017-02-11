import java.io.BufferedWriter;
import java.io.IOException;
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
		this.setStress();
	}
	public void setStress(){
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

		return("test: "+this.test.getType()+"| ID: "+this.ID+"| sexe:"+this.sexe+"| poids initial: "+
				this.poidsInitial+"| poids actuel: "+this.poidsCourrant+
				"| condition: "+etat+" "+vie);
	}
	void save(BufferedWriter buff)throws IOException{
		buff.write(this.ID);
		buff.write("-");
		buff.write(this.sexe);
		buff.write("-");
		buff.write((new Double(this.poidsInitial)).toString());
		buff.write("-");
		buff.write((new Double(this.poidsCourrant)).toString());
		buff.write("-");
		if(this.vivant){buff.write("true");}else{buff.write("false");}
		buff.write("-");
		this.test.save(buff);
	}
}
