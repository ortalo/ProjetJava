import java.util.ArrayList;
import java.io.*;
public class Singe extends Animal{
	public Singe(String ID, char sexe, double poids,Test test){
		super(ID,sexe,poids,test);
	}
	public String toString(){
		return ("Espece: Singe|"+super.toString());
	}
	public void save(BufferedWriter buff){
		try{
		buff.write("singe-"+this.test.getType()+"-");
		super.save(buff);
		}catch(IOException e){}
	}
}
