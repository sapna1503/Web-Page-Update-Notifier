package schandiramani.oops.ass4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
    private String fileName;

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    public void read() throws Exception {
        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            String currentLine;
            String[] token;
            int tokenLength;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();

                token = currentLine.split(" ");
                tokenLength = token.length;

                WebPage webPage = new WebPage(token[0]);
                WebPageObservable webPageObservable = new WebPageObservable(webPage);

                if (tokenLength == 2 && token[1].equalsIgnoreCase("CONSOLE")) {
                    ConsoleObserver consoleObserver = new ConsoleObserver();
                    webPageObservable.subscribe(consoleObserver);
                } else if (tokenLength == 3 && token[1].equalsIgnoreCase("MAIL")) {
                    String mailTo = token[2];
                    MailObserver mailObserver = new MailObserver(mailTo);
                    webPageObservable.subscribe(mailObserver);
                } else if (tokenLength == 4 && token[1].equalsIgnoreCase("SMS")) {
                    String smsTo = token[2];
                    String provider = token[3];
                    SmsObserver smsObserver = new SmsObserver(smsTo, provider);
                    webPageObservable.subscribe(smsObserver);
                } else {
                    throw new Exception("Invalid entry in file.");
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Invalid entry in file.");
        }
    }
}
