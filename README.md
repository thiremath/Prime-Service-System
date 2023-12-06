# CSX42: Assignment 4
# Subject- Design Patterns
# Fall 2023

## Member1 Name: Chaitanya Jha
## Member2 Name: Tejas Hiremath
 
-----------------------------------------------------------------------
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in primeService/src folder.
 
-----------------------------------------------------------------------
## Instruction to clean:
 
####Command: ant -buildfile primeService/src/build.xml clean
 
Description: It cleans up all the .class files that were generated when you
compiled your code.
 
-----------------------------------------------------------------------
## Instruction to compile:
 
####Command: ant -buildfile primeService/src/build.xml all
 
Description: Compiles your code and generates .class files inside the BUILD folder.
 
-----------------------------------------------------------------------
## Instruction to run:

1. Run Server

## Command :
    ant -buildfile primeService/src/build.xml run -Darg0=<PORTNUMBER> -Darg1=<errorLog.txt> -Darg2=<debugValue>

Replace <PORTNUMBER>, <errorLog_file.txt> and <debugValue> with real values. For example, if the files are available in the path, you can run it in the following manner:

## Command :
	ant -buildfile primeService/src/build.xml run -Darg0=4000 -Darg1=errorLog.txt -Darg2=9



2. Run Client

## Command :
    ant -buildfile primeService/src/build.xml run -Darg0=<IPADDRESS> -Darg1=<PORTNUMBER> -Darg2=<errorLog.txt> -Darg3=<debugValue>

Replace <IPADDRESS>, <PORTNUMBER>, <errorLog_file.txt> and <debugValue> with real values. For example, if the files are available in the path, you can run it in the following manner:

## Command :
	ant -buildfile primeService/src/build.xml run -Darg0=127.0.0.1 -Darg1=4000 -Darg2=errorLog.txt -Darg3=9


||||||||||||||||||||||||||||||||||||||||||||| (Or) ||||||||||||||||||||||||||||||||||||||||||||         

Use the makefile to save time:

1. Run Server
## Command :
    make server

2. Run Client
## Command :
    make client
 
Note: Arguments accept the absolute path of the files.
 
-----------------------------------------------------------------------
## Description:
 
The client-side programming involves establishing a socket connection using the java.net.Socket class, with communication facilitated through streams for input and output. The connection is explicitly closed after sending the message to the server. On the server side, a ServerSocket is used to wait for client requests, and a regular Socket is employed for communication with the client. The server-side code opens a socket connection on localhost, with the port number read from the command line. Each connection is handled by a new thread (ServerWorker) that reads client name and an integer value. The server checks if the integer value is greater than a threshold, and responds back to the client with messages indicating whether the integer is prime or not. The server maintains a data structure (AllPrimeQueries) to store client names and values queried, and offers a text-based menu for viewing client requests. The CheckPrime class determines if a given integer is prime. The client-side code opens a socket connection to a specified port and host, with a text-based menu allowing the client to set a name, query for prime numbers, check server responses, and quit. The PrimeDriver handles the main function, calling either ClientDriver or ServerDriver based on command line arguments. The server requires a port argument, while the client needs port and host name/IP address arguments, along with a debug value. The PrimeDriver accepts the correct number of arguments based on whether it initiates the client or server side.

-----------------------------------------------------------------------
### Quality of the Solution: 
This performing is very effiecient in handling client server connection. Multiple clients can connect to a single server and exit accordingly. If the server quits the connection, automatically all the clients are also terminated at the same time. 
Multiple threads are used in the server and client side to perform concurrent operations and save the waiting time for the users. 
A thread safe data structure- Synchronized ArrayList is used in this program to record all the client queries.

-----------------------------------------------------------------------
### Data Structures Used
We have used a synchronizedList- ArrayList<String> as it is synchronized, dynamic and as it gives O(1) access time for each elements.

-----------------------------------------------------------------------
### Time Complexity
The time complexity of this program depends upon the input Integer given by different clients. The integer is processed by the CheckPrime class and validated if the input is prime or not.
The worst case time complexity of this program remains O(n) for each user where n denotes the input integer provided by the client.

-----------------------------------------------------------------------
### Output Format
Output is generated on the command line for the server and as well as for the client. After requesting a response from the server the client the client displays the corresponding response received from the server. The server also displays the queries on the command line upon the request from user in the server menu.
Any errors are logged to errorLog.txt file.

-----------------------------------------------------------------------
### Contributions of each Team Member.
## Chaitanya Jha: 
1. Created the Initial structure of the program.
2. Implemented the Menu on the Client Side.
3. Implemented allPrimeQueries class.
4. Implemented displayClientQuery() method on the server side.
5. Implemented displayAllClientQueries() method on the server side.
6. Implemented the Debug (Logger) class.


## Tejas Hiremath: 
1. Implemented the Client Driver and created utility classes.
2. Implemented the Server menu and Server Driver.
3. Moved the server and client codes to their respective Sockets and Worker classes.
4. Implemented each client as a new thread in ServerDriver.
5. Implemented a thread on the client side as well to automatically terminate the program if the server quits.
6. Prepared the Readme.md file.

-----------------------------------------------------------------------
### 4 Slack Days Used
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------
 
"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""
 
Date: -- 6th December 2023