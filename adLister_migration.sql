
#
#
# DROP DATABASE IF EXISTS adlister_db;
# CREATE DATABASE IF NOT EXISTS adlister_db;
USE adlister_db;

#
# CREATE USER 'ad_lister_user'@'localhost' IDENTIFIED BY 'listeruser';
#
#  GRANT ALL ON adlister_db.* TO 'ad_lister_user'@'localhost';

CREATE TABLE IF NOT EXISTS users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR (200) NOT NULL,
    password VARCHAR (200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ads(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR (100) NOT NULL,
    description VARCHAR (300) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    PRIMARY KEY (id)
);