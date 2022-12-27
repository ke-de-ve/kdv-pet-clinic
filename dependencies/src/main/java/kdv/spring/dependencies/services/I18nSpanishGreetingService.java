package kdv.spring.dependencies.services;

//@Service("i18nService")
//@Profile("ES")
public class I18nSpanishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
