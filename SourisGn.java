import java.io.*;
import java.util.ArrayList;
public class SourisGn extends Souris{
	public SourisGn(String ID, char sexe, double poids,Test test){
		super(ID,sexe,poids,test);
	}
	public String toString(){
		return ("espece: SourisGn|"+super.toString());
	}
	public void save(BufferedWriter buff){
	try{
		buff.write("sourisGn-"+this.test.getType()+"-");
		super.save(buff);
	}catch(IOException e){}
	}
}
