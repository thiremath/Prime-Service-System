server:
	ant -buildfile primeService/src/build.xml clean
	ant -buildfile primeService/src/build.xml all
	ant -buildfile primeService/src/build.xml run -Darg0=4000 -Darg1=errorLog.txt -Darg2=2
	ant -buildfile primeService/src/build.xml clean

client:
	ant -buildfile primeService/src/build.xml clean
	ant -buildfile primeService/src/build.xml all
	ant -buildfile primeService/src/build.xml run -Darg0=127.0.0.1 -Darg1=4000 -Darg2=errorLog.txt -Darg3=1
	ant -buildfile primeService/src/build.xml clean