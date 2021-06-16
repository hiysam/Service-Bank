# Host: localhost  (Version 5.5.5-10.1.38-MariaDB)
# Date: 2021-06-16 16:16:13
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "data_nasabah"
#

DROP TABLE IF EXISTS `data_nasabah`;
CREATE TABLE `data_nasabah` (
  `id_nasabah` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `saldo` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id_nasabah`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "data_nasabah"
#

INSERT INTO `data_nasabah` VALUES (1,'hiysam',150000,'2021-06-16'),(2,'tiwi',100000,'2021-06-16'),(3,'ilham',100000,'2021-06-16'),(4,'affan',150000,'2021-06-16'),(6,'haqi',20000,'2021-06-16'),(7,'nanda',20000,'2021-06-16');

#
# Structure for table "hibernate_sequence"
#

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "hibernate_sequence"
#

INSERT INTO `hibernate_sequence` VALUES (8);

#
# Structure for table "transaksi"
#

DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `username_tujuan` varchar(50) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `create_transaksi` date DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "transaksi"
#

INSERT INTO `transaksi` VALUES (5,'hiysam','ST','hiysam',100000,'2021-06-16'),(6,'hiysam','ST','hiysam',90000,'2021-06-16'),(7,'haqi','ST','haqi',10000,'2021-06-16'),(8,'hiysam','TF','affan',10000,'2021-06-16'),(9,'hiysam','TF','affan',40000,'2021-06-16'),(10,'nanda','ST','nanda',10000,'2021-06-16');
