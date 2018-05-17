package di;
import java.io.PrintStream;


public class SlayDragonQuest implements Quest {
	private PrintStream stream;
	public SlayDragonQuest(PrintStream stream) {
		this.stream = stream;
	}
	@Override
	public void embark() {
		stream.println("Embarking on quest to slay the dragon!");
	}
	@Override
	public String questName() {
		return "Slay Dragon";
	}
	
	@Override
	public int questNumber() {
		return 0;
	} 

}