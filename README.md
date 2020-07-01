# tweeter-assignment

1. Input can be given in two format
	1. File (Each line is considered as a tweet)
	2. Tweets in for of text (On console)
2. Hashtag will be space seprated
3. used LFUCache for sorting (sorting will be done according to freq and recent used)
4. sampleTweet.txt is a sample file for the tweets.


Used Design Pattern - 
Singleton

How To Run - 
go to src\com\twitter\StartApplication.java and run as java application

info : When user will make a tweet it will increase the count by one and update in the LFUCache. At the end of the application it will print top trending tweets

for Sample Output please refer PDF file(SampleOutput)
