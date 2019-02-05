# currency-converter
This is a currency converter - java console application.
In this application, it is supposed that the application has one user, and it 
is single-threaded, although you can find some best practices for concurrency 
in singleton classes. 

<h1>How to run the project</h1>

! Run MainClass in com.fa2id.app<br>
! Database file name has to be passed as first argument.<br>
! The database.txt file is ready to use and it has 40 currencies<br>
<br><br>
Please note that USD will be added automatically when you run the application. There is no need to include USD to Database.txt
<br>
<br>
If you want to make your database, this is the format.<br>
XXX@NNNN$DDDDDD<br>
<br>
XXX is the currency ID like USD. It must have three characters.
@ is the separator between currency id and currency name.
NNNN is the name of the currency and the number of characters is not important.
$ is the separator between currency name and the value in USD.
DDDDD is the equivalent value of the currency in US Dollar. It can be written like 1 or 1.0 or whatever you like.
<br>
<hr>
There logger is logging the application, and you can find the logs in CurrencyConverterLog.log after execution.
