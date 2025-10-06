# Employee Management System in Java

A console-based Java program that allows **user/admin login** and manages **employee data** with MySQL. Demonstrates **JDBC database connectivity**, input handling with Scanner, and basic console-based management.

## Features

- User login (input username and password)  
- Admin login (input admin name and password)  
- Insert employee data (ID, Name, Department, Salary, Location) into MySQL database  
- Demonstrates JDBC connectivity and SQL operations  

## Technologies Used

- Java 17+  
- MySQL  
- JDBC  
- Scanner (for console input)  

## Setup / Installation

1. Install **Java JDK 17+** and **MySQL**.  
2. Create a MySQL database and table:

```sql
CREATE DATABASE data;
CREATE TABLE data (
    Id INT PRIMARY KEY,
    Name VARCHAR(50),
    Dept VARCHAR(50),
    salary INT,
    location VARCHAR(50)
);
```

3. Download MySQL JDBC driver (mysql-connector-java-x.x.x.jar).

4. Place your .java file in a folder matching the package (if any).

5. Compile:
```
javac -cp .:mysql-connector-java-x.x.x.jar project1.java
```

6. Run:

java -cp .:mysql-connector-java-x.x.x.jar project1


Note: On Windows, replace : with ; in the classpath.
