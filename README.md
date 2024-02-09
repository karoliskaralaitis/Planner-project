# Planner-project
An online planner that helps you track your goals and habits.

### Requirements
* Language JDK 17
* Check if JAVA_HOME uses JDK 17

## Run DB with Docker
### Run MySQL
```
docker compose up -d mysqldb
```

### Run PostgreSQL
```
docker compose up -d postgresqldb
```

### Run pgAdmin for PostgreSQL
```
docker compose up -d pgadmin4
```

## Run application using Spring Boot
### on H2 DB
```
./mvnw spring-boot:run
```

### on MySql DB
```
./mvnw spring-boot:run -Dspring.profiles.active=mysql
```

### on PostgreSQL DB
```
./mvnw spring-boot:run -Dspring.profiles.active=pg
```

## Access the application
http://localhost:8080