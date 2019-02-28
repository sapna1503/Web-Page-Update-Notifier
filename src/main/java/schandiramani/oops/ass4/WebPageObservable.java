package schandiramani.oops.ass4;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import java.util.Date;

public class WebPageObservable {

    private Observable<WebPage> webPageObservable;

    public WebPageObservable(WebPage webPage){
        webPageObservable = Observable.create(getWebPageObservableOnSubscribe(webPage));
    }

    public void subscribe(Observer<? super WebPage> observer){
        webPageObservable.subscribe(observer);
    }

    private ObservableOnSubscribe<WebPage> getWebPageObservableOnSubscribe(WebPage webPage){
        return emitter -> {
            Thread t = new Thread(() -> {
                try {
                    while (!emitter.isDisposed()) {
                        Date modifiedDate = new Date(webPage.getConnection().getLastModified());
                        if (webPage.isDateUpdated(modifiedDate)) {
                            webPage.setChangedDate(modifiedDate);
                            emitter.onNext(webPage);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t.start();
        };
    }
}
