import java.io.*;
public class Souris extends Animal{
	public Souris(String ID, char sexe, double poids,Test test){
		super(ID,sexe,poids,test);
	}
	public String toString(){
		return ("espece: Souris| test: "+this.test.getType()+super.toString());
	}
	public void save(BufferedWriter buff){
	try{
		buff.write("souris|"+this.test.getType()+"|");
		super.save(buff);
	}catch(IOException e){}
	}
}
