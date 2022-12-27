package kdv.spring.dependencies;

import kdv.spring.dependencies.controllers.*;
import kdv.spring.dependencies.services.PrototypeBean;
import kdv.spring.dependencies.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KdvDependenciesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(KdvDependenciesApplication.class, args);

		System.out.println("\n -------- Controllers ---------");

		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.printf("I18n: %s \n", i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");
		System.out.printf("Primary bean: %s \n", myController.sayHello());

		System.out.println("\n -------- 3 Dependency Injection types ---------");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println("2..." + propertyInjectedController.getGreeting());

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println("3..." + setterInjectedController.getGreeting());

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println("4..." + constructorInjectedController.getGreeting());

		System.out.println("\n-------- Bean Scopes ---------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println("singletonBean1: " + singletonBean1.getMyScope() + " >> " + singletonBean1);
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println("singletonBean2: " + singletonBean2.getMyScope() + " >> " + singletonBean2);

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println("prototypeBean1: " + prototypeBean1.getMyScope() + " >> " + prototypeBean1);
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println("prototypeBean2: " + prototypeBean2.getMyScope() + " >> " + prototypeBean2);
	}

}
