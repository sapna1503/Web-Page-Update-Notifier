package schandiramani.oops.ass4;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.io.Serializable;

public class SmsObserver implements Observer<WebPage>, Serializable {

    private String smsTo;
    private String cellProvider;

    public SmsObserver(String smsTo, String cellProvider) {
        this.smsTo = smsTo;
        this.cellProvider = cellProvider;
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
        String domain = Provider.valueOf(cellProvider.toUpperCase()).toString();
        StringBuilder stringBuilder = new StringBuilder(this.smsTo);
        stringBuilder.append(domain);
        MailSender.send("Sms", webPage, stringBuilder.toString());
    }
}
