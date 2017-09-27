package autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DVDPlayer implements CompactDisc {

	private String genre;
	
	public void setGenre(String genre){
		this.genre = genre;
	}
	
	@Override
	public void play() {
		
		if(!genre.isEmpty()){
			System.out.println("Play a "+ genre + " movie");
		}
		else{
			System.out.println("No genre has been picked");
		}
		
	}

}
