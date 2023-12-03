server:
	ant -buildfile primeService/src/build.xml clean
	ant -buildfile primeService/src/build.xml all
	ant -buildfile primeService/src/build.xml run -Darg0=4000

client:
	ant -buildfile primeService/src/build.xml clean
	ant -buildfile primeService/src/build.xml all
	ant -buildfile primeService/src/build.xml run -Darg0=127.0.0.1 -Darg1=4000