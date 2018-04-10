-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: commoditydb
-- ------------------------------------------------------
-- Server version	5.7.7-rc-log

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
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `name` varchar(35) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `length` decimal(18,2) DEFAULT NULL,
  `width` decimal(18,2) DEFAULT NULL,
  `height` decimal(18,2) DEFAULT NULL,
  `weight` decimal(18,2) DEFAULT NULL,
  `stackable` bit(1) DEFAULT b'0',
  `freight_class_type_id` int(11) DEFAULT NULL,
  `freight_packaging_type_id` int(11) DEFAULT NULL,
  `nmfc` varchar(10) DEFAULT NULL,
  `freight_goods_type_id` int(11) DEFAULT NULL,
  `value` decimal(18,2) DEFAULT NULL,
  `insurance_condition` varchar(20) DEFAULT NULL,
  `insurance_oversized` bit(1) DEFAULT NULL,
  `stated_quantity` decimal(18,2) DEFAULT NULL,
  `stated_quantity_packaging_type` int(11) DEFAULT NULL,
  `haz` bit(1) DEFAULT NULL,
  `haz_identification_number` varchar(50) DEFAULT NULL,
  `haz_proper_shipping_name` varchar(50) DEFAULT NULL,
  `freight_haz_class_type_id` int(11) DEFAULT NULL,
  `freight_haz_packaging_group_type_id` int(11) DEFAULT NULL,
  `haz_emergency_contact_name` varchar(50) DEFAULT NULL,
  `haz_emergency_contact_phone` varchar(50) DEFAULT NULL,
  `haz_placard_required` bit(1) DEFAULT NULL,
  `haz_placard_details` varchar(50) DEFAULT NULL,
  `haz_flashpoint_temperature` varchar(50) DEFAULT NULL,
  `haz_additional_details` varchar(50) DEFAULT NULL,
  `haz_err` varchar(50) DEFAULT NULL,
  `document_id` int(11) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modify_date` varchar(50) DEFAULT NULL,
  `add_insurance_reminder` bit(1) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `document_id` (`document_id`),
  CONSTRAINT `commodity_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `commodity_ibfk_2` FOREIGN KEY (`document_id`) REFERENCES `document` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (2,2,'commodity-23','third commodity',NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,3,'user-2','2018-04-09 17:06:58',NULL,NULL,'\0',NULL),(6,2,'commodity-5','third commodity',NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'user-2','2018-04-09 17:06:58',NULL,NULL,NULL,NULL),(7,2,'commodity-6','third commodity',NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,'user-2','2018-04-09 17:06:58',NULL,NULL,'\0',NULL),(8,2,'commodity-7','third commodity',NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,3,'user-2','2018-04-09 17:06:58',NULL,NULL,'\0',NULL),(9,2,'commodity-9','third commodity',NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,NULL,NULL,NULL,3,'user-2','2018-04-09 17:06:58',NULL,NULL,'\0',NULL);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-10 14:55:10
