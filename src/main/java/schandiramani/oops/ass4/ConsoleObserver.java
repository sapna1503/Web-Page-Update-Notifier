package schandiramani.oops.ass4;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;

public class ConsoleObserver implements Observer<WebPage>, Serializable {

    @Override
    public void onError(Throwable e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(WebPage webPage) {
        System.out.println(webPage.getWebUrl() + " was modified at " + webPage.getChangedDate());
    }

}
