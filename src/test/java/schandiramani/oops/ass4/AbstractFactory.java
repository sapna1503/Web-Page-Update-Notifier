package schandiramani.oops.ass4;

import io.reactivex.Observer;

public abstract class AbstractFactory {
    abstract Observer getMockObserver(String observer);
}
