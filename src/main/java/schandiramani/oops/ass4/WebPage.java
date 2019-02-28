package schandiramani.oops.ass4;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class WebPage {

    private String webUrl;
    private Date changedDate;

    public WebPage(String webUrl) {
        this.webUrl = webUrl;
        setChangedDate(new Date("Tue May 05 15:54:13 PDT 1013"));
    }

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public URLConnection getConnection() throws IOException {
        URL address = new URL(this.getWebUrl());
        return address.openConnection();
    }

    public boolean isDateUpdated(Date modifiedDate) {
        if (modifiedDate.after(this.getChangedDate()))
            return true;
        else
            return false;
    }
}
