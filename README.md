# Web-Page-Update-Notifier
Using RxJava a small system is built to notify people ( via text message or email ) when web pages have been updated using Observer pattern. 

You are to support three ways to notify a person that a page has changed. First just text sent to
standard out (console). Second sending an email. Third sending a text message. Your program
should read a file containing a list of URL of webpages. Each url starts a new line in the file.
Each URL is followed by a space then the type of output (console, email, sms). If it is an email
then we need the email address. If an sms we need two pieces of information: 10 digit phone
number and name of the cell provider. Each piece of information is separated by a space.

Some examples:
http://www.eli.sdsu.edu/courses/fall18/cs635/notes/index.html console
http://www.eli.sdsu.edu/index.html mail whitney@sdsu.edu
http://www.eli.sdsu.edu/courses/fall18/cs635/notes/index.html sms
6195943535 verizon
http://www.eli.sdsu.edu/courses/fall18/cs635/notes/index.html sms
6191234567 att
http://www.eli.sdsu.edu/index.html console 

The program should be able to run indefinitely and notify users when one of the pages
changes. 

Carrier               MMS gateway domain
Alltel            [insert 10-digit number]@mms.alltelwireless.com
AT&T              [insert 10-digit number]@mms.att.net
Boost Mobile      [insert 10-digit number]@myboostmobile.com
Cricket Wireless  [insert 10-digit number]@mms.cricketwireless.net
Project Fi        [insert 10-digit number]@msg.fi.google.com
Sprint            [insert 10-digit number]@pm.sprint.com
T-Mobile          [insert 10-digit number]@tmomail.net
U.S. Cellular     [insert 10-digit number]@mms.uscc.net
Verizon           [insert 10-digit number]@vzwpix.com
Virgin Mobile     [insert 10-digit number]@vmpix.com
