package schandiramani.oops.ass4;

import io.reactivex.Observer;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.IOException;
import java.net.URLConnection;
import java.util.Date;

import static org.mockito.Mockito.*;

public class TestWebPage {

    private WebPage mockWebPage;
    private URLConnection mockConnection;
    private WebPageObservable webPageObservable;
    private Observer observer;


    @Test
    public void testConsoleObserver() throws IOException {
        // Arrange
        mockWebPage = Mockito.mock(WebPage.class);
        mockConnection = Mockito.mock(URLConnection.class);
        when(mockWebPage.getConnection()).thenReturn(mockConnection);
        when(mockWebPage.getConnection().getLastModified()).thenReturn(1543100053000L);
        when(mockWebPage.isDateUpdated(any(Date.class))).thenReturn(true);

        doCallRealMethod().when(mockWebPage).setChangedDate(new Date(1543100053000L));
        doCallRealMethod().when(mockWebPage).getChangedDate();

        //Act
        webPageObservable = new WebPageObservable(mockWebPage);
        observer = new ObserverFactory().getMockObserver("CONSOLE");
        webPageObservable.subscribe(observer);

        //Assert
        verify(mockWebPage, atLeast(1)).setChangedDate(any(Date.class));
        Assert.assertEquals(new Date("Sat Nov 24 15:54:13 PDT 2018"), mockWebPage.getChangedDate());
        verify(observer, atLeast(1)).onNext(mockWebPage);
    }

    @Test
    public void testMailObserver() throws IOException {
        // Arrange
        mockWebPage = mock(WebPage.class);
        mockConnection = mock(URLConnection.class);
        when(mockWebPage.getConnection()).thenReturn(mockConnection);
        when(mockWebPage.getConnection().getLastModified()).thenReturn(1543100053000L);
        when(mockWebPage.isDateUpdated(any(Date.class))).thenReturn(true);

        doCallRealMethod().when(mockWebPage).setChangedDate(new Date(1543100053000L));
        doCallRealMethod().when(mockWebPage).getChangedDate();

        //Act
        webPageObservable = new WebPageObservable(mockWebPage);
        observer = new ObserverFactory().getMockObserver("MAIL");
        webPageObservable.subscribe(observer);

        //Assert
        verify(mockWebPage, atLeast(1)).setChangedDate(any(Date.class));
        Assert.assertEquals(new Date("Sat Nov 24 15:54:13 PDT 2018"), mockWebPage.getChangedDate());
        verify(observer, atLeast(1)).onNext(mockWebPage);
    }

    @Test
    public void testSmsObserver() throws IOException {
        // Arrange
        mockWebPage = mock(WebPage.class);
        mockConnection = mock(URLConnection.class);
        when(mockWebPage.getConnection()).thenReturn(mockConnection);
        when(mockWebPage.getConnection().getLastModified()).thenReturn(1543100053000L);
        when(mockWebPage.isDateUpdated(any(Date.class))).thenReturn(true);

        doCallRealMethod().when(mockWebPage).setChangedDate(new Date(1543100053000L));
        doCallRealMethod().when(mockWebPage).getChangedDate();

        //Act
        webPageObservable = new WebPageObservable(mockWebPage);
        observer = new ObserverFactory().getMockObserver("SMS");
        webPageObservable.subscribe(observer);

        //Assert
        verify(mockWebPage, atLeast(1)).setChangedDate(any(Date.class));
        Assert.assertEquals(new Date("Sat Nov 24 15:54:13 PDT 2018"), mockWebPage.getChangedDate());
        verify(observer, atLeast(1)).onNext(mockWebPage);
    }

//    @Test
//    public void testForMailSend() throws IOException {
//
//        // Arrange
//        mockWebPage = mock(WebPage.class);
//        mockConnection = mock(URLConnection.class);
//        when(mockWebPage.getConnection()).thenReturn(mockConnection);
//        when(mockWebPage.getConnection().getLastModified()).thenReturn(1543100053000L);
//        when(mockWebPage.isDateUpdated(any(Date.class))).thenReturn(true);
//
//        doCallRealMethod().when(mockWebPage).setChangedDate(new Date(1543100053000L));
//        doCallRealMethod().when(mockWebPage).getChangedDate();
//
//        PowerMockito.mockStatic(MailSender.class);
//        PowerMockito.doNothing().when(MailSender.class);
//        MailSender.send(mockWebPage, anyString());
//
//        //Act
//        webPageObservable = new WebPageObservable(mockWebPage);
//        observer = new ObserverFactory().getMockObserver("MAIL");
//        webPageObservable.subscribe(observer);
//
//        //Assert
//        verify(mockWebPage, atLeast(1)).setChangedDate(any(Date.class));
//        Assert.assertEquals(new Date("Sat Nov 24 15:54:13 PDT 2018"), mockWebPage.getChangedDate());
//        verify(observer, atLeast(1)).onNext(mockWebPage);
//
//        PowerMockito.verifyStatic(MailSender.class);
//        MailSender.send(mockWebPage, anyString());
//
//    }

}
