run:
	ant -buildfile primeService/src/build.xml clean
	ant -buildfile primeService/src/build.xml all
	ant -buildfile primeService/src/build.xml run -Darg0=0