public class Singe extends Animal{
	public Singe(String ID, char sexe, double poids,Test test){
		super(ID,sexe,poids,test);
	}
	public void toString(){
		System.out.println("Singe, test: "+this.test.getType());
		super();
	}

