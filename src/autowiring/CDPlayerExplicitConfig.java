package autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

public class CDPlayerExplicitConfig{
	
	@Bean
	@Primary
	public CompactDisc getSgtPepper(){
		System.out.println("hey");
		return new SgtPepper();
	}
	@Bean
	public MediaPlayer getCDPlayer(){
		return new CDPlayer(getSgtPepper());
	}

	@Bean
	@Qualifier("dvd")
	@Conditional(GenreAvailableCondtion.class)
	public DVDPlayer getDVDPlayer(){
		return new DVDPlayer();
	}
}
