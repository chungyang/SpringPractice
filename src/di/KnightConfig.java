package di;

import java.io.PrintStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class KnightConfig {
	
	@Bean
	public PrintStream getPrintStream() {
		return new PrintStream(System.out);
	}

}
