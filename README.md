# fromDatabaseToJSON
install Maven on your machine [here](https://maven.apache.org/download.cgi) for Windows

or enter 
```sh
$ sudo apt install maven
```
on a linux system

to compile source files enter on the project root folder
```sh
$ mvn compile
```

to run migration of your database enter
```sh
$ mvn flyway:migrate
```

to remove compiled files enter
```sh
$ mvn clean
``` 
