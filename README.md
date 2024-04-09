# Auto Mechanic API

## Description

Auto Repair Status Tracking Application made in Spring Boot

## Author

* Kleo Ismailati

### Technologies used

* Java 11
* Spring Boot 2.5.5
* Lombok
* Swagger 2 Documentation
* MySQL

### Tools used

* IntelliJ IDEA
* MySQL Workbench
* Postman

## Prerequisite

* JDK 11 or OpenJDK 11 installed
* MySQL installed
* Docker installed

## Setup

1. Create new directory and clone project from git.
2. Download maven dependencies.
3. Under ```resources/application-dev.properties``` and ```resources/application-setup-dev.properties``` change your
   datasource and mail username and password if needed.
4. Create schema in MySQL Workbench named **auto_mechanic** or whatever it is called in your ```spring.datasource.url```
5. Change profile in **application.properties** ```spring.profiles.active=dev```.
   to ```spring.profiles.active=setup-dev```.
6. Run the application and quit it once it is done creating the tables.
7. Reset **application.properties** entry to ```spring.profiles.active=dev``` (Adds new admin with username/password:
   ```admin/Admin123```).
8. You are done! Run your application at ```localhost:8080/swagger-ui/``` if you didn't change the URL and access it.
9. You can now sign in as admin with credentials ```admin``` as username and ```Admin123``` as password for testing
   purposes.

## Setup Docker

1. Run ```$env:PROFILE="setup-docker";docker-compose up -d``` in powershell inside project folder, or \
   ```PROFILE=setup-docker docker-compose up -d``` in shell.
2. Run ```docker-compose stop app``` to stop your application service.
3. Run ```$env:PROFILE="docker";docker-compose up app -d``` in powershell or \
   ```PROFILE=docker docker-compose up app -d``` in shell to rebuild app with new environment variable.
4. Done! You can access your API in ```http://localhost:6868```.

## Rebuild app in Docker

1. Run ```docker-compose stop app``` to stop the application.
2. Run ```docker-compose up app -d``` to rebuild.

**(CAUTION!)** \
You can run ```docker compose down --rmi all -v``` to clean **EVERYTHING** created by docker-compose.

## Project status

Always in development! 🛠️ Never perfect! 🛠️
