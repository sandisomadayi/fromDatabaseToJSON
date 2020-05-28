# fromDatabaseToJSON
install Maven on your machine [here](https://maven.apache.org/download.cgi) for Windows
or enter 
```sh
$ sudo apt install maven
```
on a linux system

run
```sh
$ mvn compile
```
to compile source files

```sh
$ mvn flyway:migrate
```
to migrate your database

```sh
$ mvn clean
``` 
to remove compiled files
