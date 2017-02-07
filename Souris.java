public class Souris extends Animal{
	public Souris(String ID, char sexe, double poids,Test test){
		super(ID,sexe,poids,test);
	}
	public String toString(){
		return ("espece: Souris| test: "+this.test.getType()+super.toString());
	}
}
