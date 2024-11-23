Last login: Fri Nov 22 15:25:16 on ttys000
/Users/shivamrai/.zshrc:4: command not found: xport
shivamrai@shivams-MacBook-Air ~ % mysql -u root -p;
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 10
Server version: 8.0.39 MySQL Community Server - GPL

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> -- Create the database
mysql> CREATE DATABASE OnlineVoting;
Query OK, 1 row affected (0.02 sec)

mysql> 
mysql> -- Use the database
mysql> USE OnlineVoting;
Database changed
mysql> 
mysql> -- Create the candidates table
mysql> CREATE TABLE Candidates (
    ->     id INT AUTO_INCREMENT PRIMARY KEY,
    ->     name VARCHAR(100) NOT NULL,
    ->     votes INT DEFAULT 0
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> 
mysql> -- Insert three candidates
mysql> INSERT INTO Candidates (name, votes) VALUES 
    -> ('Candidate 1', 0),
    -> ('Candidate 2', 0),
    -> ('Candidate 3', 0);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> 
mysql> -- View the candidates
mysql> SELECT * FROM Candidates;
+----+-------------+-------+
| id | name        | votes |
+----+-------------+-------+
|  1 | Candidate 1 |     0 |
|  2 | Candidate 2 |     0 |
|  3 | Candidate 3 |     0 |
+----+-------------+-------+
3 rows in set (0.00 sec)

mysql> 








