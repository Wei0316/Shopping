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
-- Temporary view structure for view `orderdetaillist`
--

DROP TABLE IF EXISTS `orderdetaillist`;
/*!50001 DROP VIEW IF EXISTS `orderdetaillist`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `orderdetaillist` AS SELECT 
 1 AS `OrderDetailID`,
 1 AS `OrderID`,
 1 AS `ProductName`,
 1 AS `ProductPrice`,
 1 AS `ProductQuantity`,
 1 AS `Total`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `orderlist`
--

DROP TABLE IF EXISTS `orderlist`;
/*!50001 DROP VIEW IF EXISTS `orderlist`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `orderlist` AS SELECT 
 1 AS `OrderID`,
 1 AS `CustomerID`,
 1 AS `CustomerName`,
 1 AS `CustomerPhone`,
 1 AS `CustomerAddress`,
 1 AS `OrderTime`,
 1 AS `OrderTotal`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `orderdetaillist`
--

/*!50001 DROP VIEW IF EXISTS `orderdetaillist`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `orderdetaillist` AS select `orderdetail`.`OrderDetailID` AS `OrderDetailID`,`orders`.`OrderID` AS `OrderID`,`product`.`ProductName` AS `ProductName`,`product`.`ProductPrice` AS `ProductPrice`,`orderdetail`.`ProductQuantity` AS `ProductQuantity`,`orderdetail`.`ProductPrice` AS `Total` from ((`orderdetail` join `product` on((`orderdetail`.`ProductID` = `product`.`ProductID`))) join `orders` on((`orderdetail`.`OrderID` = `orders`.`OrderID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `orderlist`
--

/*!50001 DROP VIEW IF EXISTS `orderlist`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `orderlist` AS select `orders`.`OrderID` AS `OrderID`,`customer`.`CustomerID` AS `CustomerID`,`customer`.`CustomerName` AS `CustomerName`,`customer`.`CustomerPhone` AS `CustomerPhone`,`customer`.`CustomerAddress` AS `CustomerAddress`,`orders`.`OrderTime` AS `OrderTime`,`orders`.`OrderTotal` AS `OrderTotal` from (`orders` join `customer` on((`orders`.`CustomerID` = `customer`.`CustomerID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-25 16:29:17
