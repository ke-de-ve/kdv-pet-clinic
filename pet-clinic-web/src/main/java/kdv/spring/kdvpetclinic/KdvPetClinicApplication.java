package kdv.spring.kdvpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KdvPetClinicApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(KdvPetClinicApplication.class, args);
	}

}
