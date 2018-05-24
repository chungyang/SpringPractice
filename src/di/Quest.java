package di;

public interface Quest {
	
	public void embark();
	
	public String questName();
	
	public int questNumber();
	
	public default int default_questNumber() {
		return Math.abs(questNumber()) + 1;
	}
	
//	public default String default_

}
