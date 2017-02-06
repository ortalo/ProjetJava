public class Souris extends Animal{
	public Souris(String ID, char sexe, double poids,Test test){
		super(ID,sexe,poids,test);
	}
	public void toString(){
		System.out.println("Souris, test: "+this.test.getType());
		super();
	}

