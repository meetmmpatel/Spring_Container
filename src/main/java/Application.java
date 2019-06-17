import javaBased.AppConfig;
import javaBased.HelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xmlBased.Car;


public class Application {
  public static void main(String[] args) {
	disableWarning();
	javaBasedConfig();
	xmlBasedCofig();
	
  }
  
  public static void javaBasedConfig() {
	AnnotationConfigApplicationContext configApplicationContext =
			new AnnotationConfigApplicationContext(AppConfig.class);
	
	HelloWorld objOne = configApplicationContext.getBean(HelloWorld.class);
	HelloWorld objTwo = configApplicationContext.getBean(HelloWorld.class);
	System.out.println(objOne.getMessage());
	System.out.println(objOne.hashCode());
	System.out.println(objTwo.hashCode());
	
	
	objTwo.setMessage("This is for obj two");
	System.out.println(objTwo.getMessage());
	
	//Singleton so ObjOne and Two will have get and set methods
	System.out.println(objOne.getMessage());
	configApplicationContext.close();
  }
  
  public static void xmlBasedCofig() {
	
	ApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	Car car = (Car) context.getBean("car");
	
	car.setCarColor("Silver Car!!");
	System.out.println(car.getCarColor());
	Car carTwo = (Car)context.getBean("car");
	System.out.println("Car One Hashcode: " + car.hashCode());
	System.out.println("Car Two Hashcode: " + carTwo.hashCode());
	
  }
  
  public static void disableWarning() {
	System.err.close();
	System.setErr(System.out);
  }
}
