CREATE DATABASE  IF NOT EXISTS `shopping` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shopping`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EmployeeID` int NOT NULL AUTO_INCREMENT,
  `EmployeeName` varchar(45) DEFAULT NULL,
  `EmployeePosition` varchar(45) DEFAULT NULL,
  `EmployeePhone` varchar(45) DEFAULT NULL,
  `EmployeeAddress` varchar(45) DEFAULT NULL,
  `EmployeeEmail` varchar(45) DEFAULT NULL,
  `EmployeePassword` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'王小明','員工','0912-345-678','台北市大安區復興南路一段123號','wang.xiaoming@example.com','Password123'),(2,'李淑娟','主管','0923-456-789','新北市板橋區中山路456號','li.shujuan@example.com','Password456'),(4,'林美玲','員工','0916-188-156','高雄市左營區博愛一路101號','lin.meiling@example.com','Password101'),(5,'張淑芬','主管','0956-789-012','台南市東區崇德路202號','zhang.shufen@example.com','Password202'),(6,'趙子龍','員工','0967-890-123','新竹市東區光復路303號','zhao.zilong@example.com','Password303'),(7,'周杰倫','主管','0978-901-234','嘉義市西區友愛路404號','zhou.jielun@example.com','password404'),(8,'許茹芸','主管','0989-012-345','彰化市彰化區中山路505號','xu.ruyun@example.com','Password505'),(9,'黃立行','員工','0990-123-456','花蓮市花蓮區和平路606號','huang.lixing@example.com','Password606'),(10,'謝霆鋒','主管','0901-234-567','宜蘭市宜蘭區東門路707號','xie.tingfeng@example.com','Password707');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-25 16:29:17
