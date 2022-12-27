package kdv.spring.di.config;

import kdv.spring.di.datasource.FakeDataSource;
import kdv.spring.di.repositories.EnglishGreetingRepository;
import kdv.spring.di.repositories.EnglishGreetingRepositoryImpl;
import kdv.spring.di.services.*;
import kdv.spring.pets.PetService;
import kdv.spring.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:kdv-di-config.xml")
@PropertySource("classpath:datasource.properties")
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${di.username}") String username,
                                  @Value("${di.password}") String password,
                                  @Value("${di.jdbcurl}") String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        System.out.println("---> " + fakeDataSource);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean("i18nService")
    @Profile("ES")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean   // ("i18nService") can use this or name of the method
    @Profile({"EN", "default"})
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    // @Bean  now defined in  kdv-di-config.xml  file
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }
}
