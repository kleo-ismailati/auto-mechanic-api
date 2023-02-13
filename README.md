# Car Mechanic Backend

## Description
Car repair status tracking application made in Spring

### Technologies used
* Java 11
* Spring Boot 2.5.5
* Lombok
* Swagger Documentation (OpenAPI v3)
* MySQL

### Tools used
* IntelliJ IDEA
* MySQL Workbench
* Postman

## Authors and acknowledgment
* Kleo Ismailati
* Klajdi Hoxha

## Setup
1. Create new directory and clone project from git.
2. Download maven dependencies
3. Under ```resources/application.properties``` change your datasource and mail username and password if needed
4. Create schema in MySQL Workbench named **car_mechanic** or whatever it is called in your ```spring.datasource.url```
5. Change in **application.properties** ```spring.sql.init.mode=always``` to never
6. Run the application and quit it once it is done creating the tables
7. Reset **application.properties** entry to ```spring.sql.init.mode=always``` (Adds new admin with username/password: monkey/Monkey123)
8. You are done! Run your application at ```localhost:8080/swagger-ui/``` if you didn't change the URL and access it.

## Project status
In development