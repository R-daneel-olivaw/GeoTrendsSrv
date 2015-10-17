CREATE DATABASE  IF NOT EXISTS `geotrends` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `geotrends`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: geotrends
-- ------------------------------------------------------
-- Server version	5.6.27-log

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
-- Table structure for table `keywords`
--

DROP TABLE IF EXISTS `keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keywords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `region_id` int(11) NOT NULL,
  `added_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `region_fk_idx` (`region_id`),
  CONSTRAINT `keyword_reg_fk` FOREIGN KEY (`region_id`) REFERENCES `regions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3245 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keywords`
--

LOCK TABLES `keywords` WRITE;
/*!40000 ALTER TABLE `keywords` DISABLE KEYS */;
INSERT INTO `keywords` VALUES (3205,'ASUS ZenFone 2',13,'2015-10-16 13:35:30'),(3206,'Abdul Kalam',13,'2015-10-15 12:50:54'),(3207,'Bruce Lee Movie Ratings',13,'2015-10-16 15:10:11'),(3208,'Bruce Lee Review',13,'2015-10-16 13:35:30'),(3209,'Cric Buzz',13,'2015-10-15 17:40:03'),(3210,'Cricinfo',13,'2015-10-15 17:40:03'),(3211,'Cricket Score',13,'2015-10-16 13:35:30'),(3212,'Dhoom 4',13,'2015-10-16 13:35:30'),(3213,'ESPN',13,'2015-10-16 13:35:30'),(3214,'India vs South Africa',13,'2015-10-14 16:02:58'),(3215,'Lamar Odom',13,'2015-10-16 13:35:30'),(3216,'Live Cricket',13,'2015-10-16 13:35:30'),(3217,'Live Cricket Score',13,'2015-10-16 13:35:30'),(3218,'Live Score',13,'2015-10-15 17:40:03'),(3219,'Mahindra Mojo',13,'2015-10-16 13:35:30'),(3220,'Nusrat Fateh Ali Khan',13,'2015-10-14 16:02:58'),(3221,'Pyaar ka Punchnama 2',13,'2015-10-16 13:35:30'),(3222,'Samsung Z3',13,'2015-10-15 12:50:54'),(3223,'Zaheer Khan',13,'2015-10-15 17:40:03'),(3224,'cricket',13,'2015-10-16 13:35:30'),(3225,'Mets',15,'2015-10-16 13:35:39'),(3226,'Steve Gleason',15,'2015-10-16 13:35:39'),(3227,'Mets Dodgers',15,'2015-10-16 13:35:39'),(3228,'UCLA Football',15,'2015-10-16 13:35:39'),(3229,'Bridge of Spies',15,'2015-10-16 13:35:39'),(3230,'Auburn Football',15,'2015-10-16 13:35:39'),(3231,'Dyson sphere',15,'2015-10-16 13:35:39'),(3232,'Goosebumps',15,'2015-10-16 13:35:39'),(3233,'Netflix Down',15,'2015-10-16 13:35:39'),(3234,'Bosses Day',15,'2015-10-16 13:35:39'),(3235,'Olivia Wilde',15,'2015-10-16 13:35:39'),(3236,'Julio Jones',15,'2015-10-16 13:35:39'),(3237,'Derrick Coleman',15,'2015-10-16 13:35:39'),(3238,'TotalBiscuit',15,'2015-10-16 13:35:39'),(3239,'ALS',15,'2015-10-16 13:35:39'),(3240,'Texas Rangers',15,'2015-10-15 12:51:04'),(3241,'Astros',15,'2015-10-15 12:51:04'),(3242,'Houston Astros',15,'2015-10-15 12:51:04'),(3243,'Abby Lee Miller',15,'2015-10-15 12:51:04'),(3244,'Scott Disick',15,'2015-10-15 12:51:04');
/*!40000 ALTER TABLE `keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `region` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `region_UNIQUE` (`region`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (13,'IN'),(15,'US');
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-17 13:34:28
