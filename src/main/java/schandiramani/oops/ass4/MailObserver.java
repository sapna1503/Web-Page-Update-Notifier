package schandiramani.oops.ass4;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;

public class MailObserver implements Observer<WebPage>, Serializable {

    private String mailTo;

    public MailObserver(String mailTo) {
        this.mailTo = mailTo;
    }

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
        MailSender.send("Mail",webPage, this.mailTo);
    }
}
