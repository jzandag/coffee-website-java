/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 5.5.60-log : Database - projectdb2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projectdb2` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `projectdb2`;

/*Table structure for table `coffee_request` */

DROP TABLE IF EXISTS `coffee_request`;

CREATE TABLE `coffee_request` (
  `coffeereq_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_date` datetime DEFAULT NULL,
  `brew_date` datetime DEFAULT NULL,
  `coffee_level` int(11) DEFAULT NULL,
  `creamer_level` int(11) DEFAULT NULL,
  `queue` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sugar_level` int(11) DEFAULT NULL,
  `config` bigint(20) DEFAULT NULL,
  `userID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`coffeereq_id`),
  KEY `FKD553ED1CCABB417E` (`config`),
  KEY `FKD553ED1CE9A6F062` (`userID`),
  KEY `FKD553ED1CFEC2AF74` (`userID`),
  CONSTRAINT `FKD553ED1CCABB417E` FOREIGN KEY (`config`) REFERENCES `config` (`id`),
  CONSTRAINT `FKD553ED1CE9A6F062` FOREIGN KEY (`userID`) REFERENCES `config` (`id`),
  CONSTRAINT `FKD553ED1CFEC2AF74` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `coffee_request` */

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_key` varchar(255) DEFAULT NULL,
  `config_status` int(11) DEFAULT NULL,
  `config_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `config` */

insert  into `config`(`id`,`config_key`,`config_status`,`config_value`) values 
(1,'SYSTEM_MAINTENANCE',1,'System Maintenance');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`email`,`password`,`role`,`username`) values 
(1,'zidrexandag06@gmail.com','c93ccd78b2076528346216b3b2f701e6','admin','admin1234'),
(2,'Test@co','16d7a4fca7442dda3ad93c9a726597e4','user','test1234'),
(3,'test12345@gg','c06db68e819be6ec3d26c6038d8e8d1f','user','test12345'),
(4,'rod@s','d8578edf8458ce06fbc5bb76a58c5ca4','user','rodessa'),
(6,'raspi','c93ccd78b2076528346216b3b2f701e6','machine','raspi');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
