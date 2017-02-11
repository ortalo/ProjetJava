import java.io.*;
import java.util.ArrayList;
public class SourisGl extends Souris{
	public SourisGl(String ID, char sexe, double poids,Test test){
		super(ID,sexe,poids,test);
	}
	public String toString(){
		return ("espece: SourisGl|"+super.toString());
	}
	public void save(BufferedWriter buff){
	try{
		buff.write("sourisGl-"+this.test.getType()+"-");
		super.save(buff);
	}catch(IOException e){}
	}
}
