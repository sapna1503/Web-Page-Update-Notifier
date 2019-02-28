package schandiramani.oops.ass4;

public enum Provider {
    ALLTEL("@mms.alltelwireless.com"),
    ATT("@mms.att.net"),
    BOOSTMOBILE("@myboostmobile.com"),
    CRICKETWIRELESS("@mms.cricketwireless.net"),
    PROJECTFI("@msg.fi.google.com"),
    SPRINT("@pm.sprint.com"),
    TMOBILE("@tmomail.net"),
    USCELLULAR("@mms.uscc.net"),
    VERIZON("@vzwpix.com"),
    VIRGINMOBILE("@vmpix.com");

    private final String domain;

    Provider(String domain) {
        this.domain = domain;
    }

    public String toString() {
        return this.domain;
    }
}
