package kdv.spring.dependencies.services;

//@Service("i18nService")
//@Profile({"EN", "default"})
public class I18nEnglishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
