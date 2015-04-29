CREATE DATABASE  IF NOT EXISTS `feedback` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `feedback`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: feedback
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Table structure for table `submitfeedback`
--

DROP TABLE IF EXISTS `submitfeedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submitfeedback` (
  `feed_id` int(11) NOT NULL AUTO_INCREMENT,
  `names` varchar(45) DEFAULT NULL,
  `addr` varchar(45) DEFAULT NULL,
  `pcon` bigint(20) DEFAULT NULL,
  `cname` varchar(45) DEFAULT NULL,
  `ccon` bigint(20) DEFAULT NULL,
  `feed` varchar(45) DEFAULT NULL,
  `dates` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`feed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submitfeedback`
--

LOCK TABLES `submitfeedback` WRITE;
/*!40000 ALTER TABLE `submitfeedback` DISABLE KEYS */;
INSERT INTO `submitfeedback` VALUES (1,'nilam','vxd',785,'dcdd',784,'gooooooood','2015-03-29 05:29:22');
/*!40000 ALTER TABLE `submitfeedback` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-02  1:17:09
CREATE DATABASE  IF NOT EXISTS `registration` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `registration`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: registration
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Table structure for table `dr_reg`
--

DROP TABLE IF EXISTS `dr_reg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dr_reg` (
  `dr_id` int(11) NOT NULL AUTO_INCREMENT,
  `dr_name` varchar(45) DEFAULT NULL,
  `dr_add` varchar(45) DEFAULT NULL,
  `dr_con` varchar(45) DEFAULT NULL,
  `dr_edu` varchar(45) DEFAULT NULL,
  `dr_pass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dr_reg`
--

LOCK TABLES `dr_reg` WRITE;
/*!40000 ALTER TABLE `dr_reg` DISABLE KEYS */;
INSERT INTO `dr_reg` VALUES (1,'nilam','as','22','dr','mandar'),(2,'nanda','sds','3456','ds','nanda'),(3,'mandar','sfd','2344','sdsd','mad'),(4,'sneha','shgf','3964','mmdd','ss'),(5,'varad','hst','3567','md','varad'),(6,'mandar','ich','8087805789','be','mandar'),(7,'aam','j','86','k','aam'),(8,'aam','j','86','k','aam'),(9,'i','jdjd','555','jfj','i'),(10,'i','jdjd','555','jfj','i');
/*!40000 ALTER TABLE `dr_reg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-02  1:17:09
CREATE DATABASE  IF NOT EXISTS `vision` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `vision`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: vision
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Table structure for table `ngo_info`
--

DROP TABLE IF EXISTS `ngo_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ngo_info` (
  `ngo_id` int(11) NOT NULL AUTO_INCREMENT,
  `ngo_name` varchar(45) DEFAULT NULL,
  `ngo_addr` varchar(45) DEFAULT NULL,
  `ngo_con_no` bigint(20) DEFAULT NULL,
  `ngo_incharge` varchar(45) DEFAULT NULL,
  `ngo_pswd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ngo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ngo_info`
--

LOCK TABLES `ngo_info` WRITE;
/*!40000 ALTER TABLE `ngo_info` DISABLE KEYS */;
INSERT INTO `ngo_info` VALUES (1,'nilampujari','chandur',123456789,'nanda','NILAM'),(2,'a','sidj',555,'hhh','a'),(3,'g','g',3,'g','g'),(4,'sit','sit',123,'sit','sit');
/*!40000 ALTER TABLE `ngo_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-02  1:17:09
