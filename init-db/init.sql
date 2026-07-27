CREATE DATABASE IF NOT EXISTS usuario_db;
CREATE DATABASE IF NOT EXISTS rutina_db;
CREATE DATABASE IF NOT EXISTS progreso_db;

CREATE USER IF NOT EXISTS 'fitness_user'@'%' IDENTIFIED BY 'fitness_pass';
GRANT ALL PRIVILEGES ON usuario_db.* TO 'fitness_user'@'%';
GRANT ALL PRIVILEGES ON rutina_db.* TO 'fitness_user'@'%';
GRANT ALL PRIVILEGES ON progreso_db.* TO 'fitness_user'@'%';
FLUSH PRIVILEGES;
