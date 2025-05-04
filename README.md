# Lab 8: JDBC

This is a simple Todo List application built with Java and PostgreSQLDB.
The application uses a PostgreSQL database for storing tasks and performs CRUD operations. CRUD stands for Create, Read, Update, and Delete.
It allows users to add, list, mark as complete, and delete tasks.

## Prerequisites

- Download and install [Docker for Desktop](https://www.docker.com/).
- Java Development Kit (JDK) 11+.
- An IDE (like IntelliJ IDEA or Eclipse) for Java development.
- Apache Maven installed and enabled on your IDE.

## Usage

Follow the steps below to set up and run the application:

### 1. Download Docker

Download and install Docker from the [official website](https://www.docker.com/products/docker-desktop/).

### 2. Run `docker-compose up`

Navigate to the project directory and run the following command to start the PostgreSQL DB and PgAdmin services:

```bash
docker-compose up
```

This will start the PostgreSQL database and Adminer (a web-based database management tool for PostgreSQL).

### 3. Log into Adminer

- Open your browser and go to PgAdmin at [http://localhost:5050](http://localhost:5050) login using the credentials defined 
in the `.env` file and listed below:
  - **Email**: example@example.com
  - **Password**: changeme
- Register a new server (Right click on Servers -> Register -> Server):
  - **Name**: `PostgreSQLServer`
- Click on the connection tab and enter the following details as defined in the `.env` file:
  - **Host**: `postgres`
  - **Port**: `5432`
  - **Username**: `postgres`
  - **Password**: `changeme`
- Click on the **Save** button to save the server configuration.
- Select the database from the Object Explorer: **PostgreSQLServer** -> **Databases** -> **tododb**

### 4. Create the Database
- Right-click on the database (tododb) and select Query Tool
- Paste the following SQL code for creating the required tables and click **Execute**.

```sql
CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    completed BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 5. Download the PostgreSQL database driver
- Open the project in your IDE and open the `pom.xml` file.
- Add the maven dependency for the [PostgreSQL driver](https://mvnrepository.com/artifact/org.postgresql/postgresql) in your `pom.xml` file:

```xml
    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.7.5</version>
    </dependency>
 ```

### 6. Run the Main Class

- Open the DatabaseConnection class at `src/main/java/sa/edu/kau/fcit/cpit305/DatabaseConnection.java` and make sure the database credentials match those in . If not, update them accordingly.
- Run the main class `App` at `src/main/java/sa/edu/kau/fcit/cpit305/App.java`.
- You will be prompted to select an option:

```
=== Todo List Application ===
1. Add new task
2. List all tasks
3. Mark task as complete
4. Delete task
5. Exit
Choose an option:
```
- Enter the number corresponding to the action you want to perform and follow the prompts.
- Run the accompanying tests to ensure everything is working correctly.

## LICENSE
This project is licensed under the MIT License.
