package kdv.spring.kdvpetclinic;

import kdv.spring.kdvpetclinic.controllers.MyController;
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
	}

}
