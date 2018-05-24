package di;
import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("SlayDragonQuest")
public class SlayDragonQuest implements Quest {
	
	private PrintStream stream;
	
	@Autowired
	public SlayDragonQuest(PrintStream stream) {
		this.stream = stream;
	}
	@Override
	public void embark() {
		
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