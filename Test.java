import java.io.BufferedWriter;
public interface Test{
	public void setResultats();
	public double apprentissage(int semaine);
	public int getBestDay(int semaine);
	public String getType();
	public void save(BufferedWriter buff);
	public void lire(String input);
}

