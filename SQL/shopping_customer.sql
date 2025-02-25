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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CustomerID` int NOT NULL AUTO_INCREMENT,
  `CustomerName` varchar(45) DEFAULT NULL,
  `CustomerPhone` varchar(45) DEFAULT NULL,
  `CustomerAddress` varchar(45) DEFAULT NULL,
  `CustomerEmail` varchar(45) DEFAULT NULL,
  `CustomerPassword` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'王大明','0912-876-543','台北市信義區松仁路100號','wang.daming@example.com','custPassword1'),(2,'李小華','0915-118-486','新北市新店區中正路200號','li.xiaohua@example.com','custPassword2'),(3,'林美玲','0934-654-321','台中市北區中清路300號','lin.meiling@example.com','custPassword3'),(4,'陳建華','0945-543-210','高雄市苓雅區五福一路400號','chen.jianhua@example.com','custPassword4'),(5,'張淑芬','0956-432-109','台南市南區健康路500號','zhang.shufen@example.com','custPassword5'),(6,'趙子龍','0967-321-098','新竹市香山區經國路600號','zhao.zilong@example.com','custPassword6'),(7,'周杰倫','0948-123-753','嘉義市東區民族路700號','zhou.jielun@example.com','custPassword7'),(8,'許茹芸','0989-109-876','彰化市北斗鎮斗中路800號','xu.ruyun@example.com','custPassword8'),(9,'黃立行','0911-185-648','花蓮市吉安鄉中山路900號','huang.lixing@example.com','custPassword9'),(10,'謝霆鋒','0901-987-654','宜蘭市羅東鎮公正路1000號','xie.tingfeng@example.com','custPassword10');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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
