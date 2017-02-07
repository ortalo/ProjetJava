public class Singe extends Animal{
	public Singe(String ID, char sexe, double poids,Test test){
		super(ID,sexe,poids,test);
	}
	public String toString(){
		return ("Espece: Singe| test: "+this.test.getType()+super.toString());
	}
}
