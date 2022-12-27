package kdv.spring.dependencies.services;

import kdv.spring.dependencies.repositories.EnglishGreetingRepository;

//@Service("i18nService")
//@Profile({"EN", "default"})
public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreeting();
    }
}
