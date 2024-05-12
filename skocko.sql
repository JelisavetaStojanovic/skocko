/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.28-MariaDB : Database - skocko
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`skocko` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `skocko`;

/*Table structure for table `igra` */

DROP TABLE IF EXISTS `igra`;

CREATE TABLE `igra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `kombinacija` varchar(50) DEFAULT NULL,
  `namestu` bigint(20) DEFAULT NULL,
  `vanmesta` bigint(20) DEFAULT NULL,
  `rezultat` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rezultat` (`rezultat`),
  CONSTRAINT `igra_ibfk_1` FOREIGN KEY (`rezultat`) REFERENCES `rezultat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `igra` */

insert  into `igra`(`id`,`kombinacija`,`namestu`,`vanmesta`,`rezultat`) values 
(1,'4-0-0-1',1,1,1),
(2,'1-1-0-7',0,2,2),
(3,'3-0-4-1',4,0,2);

/*Table structure for table `rezultat` */

DROP TABLE IF EXISTS `rezultat`;

CREATE TABLE `rezultat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumVreme` datetime DEFAULT NULL,
  `dobitnaKomb` varchar(50) DEFAULT NULL,
  `brPokusaja` bigint(20) DEFAULT NULL,
  `rezultat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `rezultat` */

insert  into `rezultat`(`id`,`datumVreme`,`dobitnaKomb`,`brPokusaja`,`rezultat`) values 
(1,'2024-05-12 13:08:39','4-1-1-2',1,'izgubio'),
(2,'2024-05-12 17:32:42','3-0-4-1',2,'pobedio');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
