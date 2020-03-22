default:
	  javac cpsc2150/MyQueue/AbsQueue.java cpsc2150/MyQueue/ArrayQueue.java cpsc2150/MyQueue/IQueue.java cpsc2150/MyQueue/ListQueue.java cpsc2150/MyQueue/QueueApp.java cpsc2150/MyQueue/StringQueueApp.java

run:
	  java cpsc2150/MyQueue/QueueApp

test:
	  javac -cp .:/usr/share/java/junit4.jar cpsc2150/MyQueue/*.java 

testArr:
	  java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyQueue.TestArrayQueue

testList:
	  java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.MyQueue.TestListQueue

clean:
	  rm -f cpsc2150/MyQueue/*.class
