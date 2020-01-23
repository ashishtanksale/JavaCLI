# JavaCLI

Project title

This Java application allows you to fetch data from MySQL server, From your choice of a database and a table and load it into a CSV file.

Prerequisites

Basic Java knowledge, including an installed version of the JVM and Maven.
Basic MySQL knowledge, including an installed version of MySQL workbench.

How Does this application Work?

User can create table of his choice or either connect to existing table, When the application will start, User will be asked to enter the operation no., 1 for fetch and 0 to terminate the program. If user enters 1, Then user has to enter db name and table name. It will take configuration from .properties file and connect to database. Then it will fetch the data from the given table and load the data to CSV file.   

How to run this application?

Before running the application, following criteria must be met:-
•	Properties file should be present in the target directory where .jar file will be created. 
•	Properties file should contain configurations such as driver, url(database server), username, password for database connection and system username to load table data into CSV file.
Run the jar file, provide operation no., provide db name and table name, You will get a CSV file with all data of a table in system folder.

Command to run application from CLI:
Java –jar full-path-jarfile.jar 
