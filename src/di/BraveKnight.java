package di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BraveKnight implements Knight {
	
	private Quest quest;

	public void embarkOnQuest() {
		quest.embark();
	}
	
	public Quest getQuest() {
		return quest;
	}
	
	@Autowired
	@Qualifier("SlayDragonQuest")
	public void setQuest(Quest quest) {
		this.quest = quest;
	}
}