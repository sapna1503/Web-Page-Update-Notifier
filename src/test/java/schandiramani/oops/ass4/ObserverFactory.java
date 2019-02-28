package schandiramani.oops.ass4;

import io.reactivex.Observer;

import static org.mockito.Mockito.mock;

public class ObserverFactory extends AbstractFactory {

    @Override
    Observer getMockObserver(String observer) {
        if (observer.equalsIgnoreCase("CONSOLE")) {
            return mock(ConsoleObserver.class);
        }

        if (observer.equalsIgnoreCase("MAIL")) {
            return mock(MailObserver.class);
        }

        if (observer.equalsIgnoreCase("SMS")) {
            return mock(SmsObserver.class);
        }
        return null;
    }

}
