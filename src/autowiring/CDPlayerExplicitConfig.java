package autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerExplicitConfig {
	@Bean
	public CompactDisc getSgtPepper(){
		return new SgtPepper();
	}
	@Bean
	public CDPlayer getCDPlayer(){
		return new CDPlayer(getSgtPepper());
	}

}
