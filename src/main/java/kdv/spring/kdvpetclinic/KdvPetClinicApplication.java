package kdv.spring.kdvpetclinic;

import kdv.spring.kdvpetclinic.controllers.ConstructorInjectedController;
import kdv.spring.kdvpetclinic.controllers.MyController;
import kdv.spring.kdvpetclinic.controllers.PropertyInjectedController;
import kdv.spring.kdvpetclinic.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KdvPetClinicApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(KdvPetClinicApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.printf("greeting: %s \n", greeting);

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println("2..." + propertyInjectedController.getGreeting());

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println("3..." + setterInjectedController.getGreeting());

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println("4..." + constructorInjectedController.getGreeting());
	}

}
