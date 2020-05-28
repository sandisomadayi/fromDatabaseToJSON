# fromDatabaseToJSON
install Maven on your machine by clicking [here](https://maven.apache.org/download.cgi) for Windows

to install maven for Linux system enter the following command on your terminal
```sh
$ sudo apt install maven
```

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
