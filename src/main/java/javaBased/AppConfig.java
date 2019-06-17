package javaBased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  
  @Bean
  public HelloWorld getHelloWorld() {
	HelloWorld helloWorld = new HelloWorld();
	helloWorld.setMessage("Hello World using Java based config");
	
	return helloWorld;
  }
  
  
}
