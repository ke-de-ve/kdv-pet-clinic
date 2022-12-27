package kdv.spring.dependencies;

import kdv.spring.dependencies.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// after moving classes to  kdv.spring.pets  package
// we are getting error:   Parameter 0 of constructor in kdv.spring.dependencies.controllers.PetController required a bean of type 'kdv.spring.pets.PetService' that could not be found.
@ComponentScan(basePackages = {"kdv.spring.dependencies", "kdv.spring.pets"})  //explicitly list all packages that have to be scanned by Spring Framework

@SpringBootApplication
public class KdvDependenciesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(KdvDependenciesApplication.class, args);

		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.printf("I18n: %s \n", i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");
		System.out.printf("Primary bean: %s \n", myController.sayHello());

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println("2..." + propertyInjectedController.getGreeting());

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println("3..." + setterInjectedController.getGreeting());

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println("4..." + constructorInjectedController.getGreeting());
	}

}
