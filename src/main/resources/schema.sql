CREATE SCHEMA IF NOT EXISTS `buildings`;
USE `buildings`;


CREATE TABLE IF NOT EXISTS meeting_info(
　id bigint(4000) NOT NULL AUTO_INCREMENT,
  roomid int(11) NOT NULL, 
  username VARCHAR(64),
  title VARCHAR(10),
  day VARCHAR(20),
  start TIMESTAMP,
  end TIMESTAMP, 
  purpose VARCHAR(64),
  owner VARCHAR(64),
  people int(20),
  remarks VARCHAR(100)
);



CREATE TABLE IF NOT EXISTS users(
  username VARCHAR(64) NOT NULL primary key,
  password VARCHAR(128) NOT NULL
  authority enum('ADMIN','USER')not null
);

CREATE TABLE IF NOT EXISTS announcement(
　announce_id int NOT NULL AUTO_INCREMENT,
  day_post TIMESTAMP,
  message VARCHAR(64),
  );

CREATE TABLE IF NOT EXISTS user_info(
  username VARCHAR(64),
  owner VARCHAR(20),
  address int,
  workplace VARCHAR(64),
  mailaddress VARCHAR(100),
  information VARCHAR(100),
  phone int,
  );