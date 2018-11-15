-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: database2system
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `everyrecord`
--

DROP TABLE IF EXISTS `everyrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `everyrecord` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `charge` double DEFAULT NULL,
  `inventory` double DEFAULT NULL,
  `recordDate` datetime DEFAULT NULL,
  `typeEnum` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `everyrecord`
--

LOCK TABLES `everyrecord` WRITE;
/*!40000 ALTER TABLE `everyrecord` DISABLE KEYS */;
INSERT INTO `everyrecord` VALUES (1,50,0,'2018-10-01 00:00:00','MONTHLYCHARGE',1),(2,50,0,'2018-10-01 00:00:00','MONTHLYCHARGE',2),(3,100,0,'2018-10-01 00:00:00','MONTHLYCHARGE',3),(4,0,3,'2018-10-08 00:00:00','ANSWER',1),(5,5.6,58,'2018-10-28 00:00:00','CALL',2),(6,114,538,'2018-10-03 00:00:00','LOCALFLOW',1),(7,60,210,'2018-10-05 00:00:00','DOMESTICFLOW',1),(8,60,520,'2018-10-15 00:00:00','LOCALFLOW',2),(9,0,20,'2018-10-05 00:00:00','DOMESTICFLOW',2),(10,19.2,582,'2018-10-08 00:00:00','CALL',3),(11,0,1,'2018-10-12 00:00:00','CHIT',3),(12,0.1,1,'2018-10-18 00:00:00','CHIT',1),(13,76,38,'2018-10-20 00:00:00','LOCALFLOW',3);
/*!40000 ALTER TABLE `everyrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monthlybill`
--

DROP TABLE IF EXISTS `monthlybill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monthlybill` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `totalAnswerTime` double DEFAULT NULL,
  `totalCallTime` double DEFAULT NULL,
  `totalCharge` double DEFAULT NULL,
  `totalChits` double DEFAULT NULL,
  `totalDomesticFlow` double DEFAULT NULL,
  `totalLocalFlow` double DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monthlybill`
--

LOCK TABLES `monthlybill` WRITE;
/*!40000 ALTER TABLE `monthlybill` DISABLE KEYS */;
INSERT INTO `monthlybill` VALUES (1,3,0,224.1,1,210,538,1),(2,0,58,115.6,0,20,520,2),(3,0,582,119.2,1,0,0,3);
/*!40000 ALTER TABLE `monthlybill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packageservice`
--

DROP TABLE IF EXISTS `packageservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packageservice` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `domesticFlow` double DEFAULT NULL,
  `localFlow` double DEFAULT NULL,
  `monthlyCharge` double DEFAULT NULL,
  `overCallPrice` double DEFAULT NULL,
  `overChitPrice` double DEFAULT NULL,
  `overDomesticFlowPrice` double DEFAULT NULL,
  `overLocalFlowPrice` double DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `totalCallTime` double DEFAULT NULL,
  `totalChits` double DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packageservice`
--

LOCK TABLES `packageservice` WRITE;
/*!40000 ALTER TABLE `packageservice` DISABLE KEYS */;
INSERT INTO `packageservice` VALUES (1,200,500,50,0.7,0,6,3,'包月大流量套餐',50,0),(2,0,0,50,0.6,0.2,0,0,'包月大通话套餐',500,100);
/*!40000 ALTER TABLE `packageservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packageservicedao`
--

DROP TABLE IF EXISTS `packageservicedao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packageservicedao` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `domesticFlow` double DEFAULT NULL,
  `localFlow` double DEFAULT NULL,
  `monthlyCharge` double DEFAULT NULL,
  `overCallPrice` double DEFAULT NULL,
  `overChitPrice` double DEFAULT NULL,
  `overDomesticFlowPrice` double DEFAULT NULL,
  `overLocalFlowPrice` double DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `totalCallTime` double DEFAULT NULL,
  `totalChits` double DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packageservicedao`
--

LOCK TABLES `packageservicedao` WRITE;
/*!40000 ALTER TABLE `packageservicedao` DISABLE KEYS */;
INSERT INTO `packageservicedao` VALUES (1,200,500,50,0.7,0,6,3,'包月大流量套餐',50,0),(2,0,0,50,0.6,0.2,0,0,'包月大通话套餐',500,100);
/*!40000 ALTER TABLE `packageservicedao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packageservicerecord`
--

DROP TABLE IF EXISTS `packageservicerecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packageservicerecord` (
  `prid` int(11) NOT NULL AUTO_INCREMENT,
  `availability` bit(1) DEFAULT NULL,
  `effiencicy` bit(1) DEFAULT NULL,
  `orderDate` datetime DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`prid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packageservicerecord`
--

LOCK TABLES `packageservicerecord` WRITE;
/*!40000 ALTER TABLE `packageservicerecord` DISABLE KEYS */;
INSERT INTO `packageservicerecord` VALUES (1,'','','2018-09-02 00:00:00',1,1),(2,'','','2018-09-12 00:00:00',2,2),(3,'\0','\0','2018-09-26 00:00:00',2,2),(4,'','','2018-09-12 00:00:00',1,3),(5,'','\0','2018-09-04 00:00:00',2,3);
/*!40000 ALTER TABLE `packageservicerecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `phonenumber` varchar(255) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'13046539662','gsy'),(2,'18345789801','lml'),(3,'13012557129','gyd');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-30 12:14:08
