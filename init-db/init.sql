CREATE DATABASE IF NOT EXISTS fitness_db;

CREATE USER IF NOT EXISTS 'fitness_user'@'%' IDENTIFIED BY 'fitness_pass';
GRANT ALL PRIVILEGES ON fitness_db.* TO 'fitness_user'@'%';
FLUSH PRIVILEGES;
