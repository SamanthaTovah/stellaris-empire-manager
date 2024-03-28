-- MySQL dump 10.13  Distrib 8.3.0, for Linux (aarch64)
--
-- Host: localhost    Database: empiredb
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOG`
--

LOCK TABLES `DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOG` VALUES ('create_appearance_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',1,'EXECUTED','9:e97a9185697e0094b1de0d92dabb2fab','createTable tableName=appearance','',NULL,'4.26.0',NULL,NULL,'0079199431'),('create_trait_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',2,'EXECUTED','9:74ce285a28c23f76235c1b390c1b5c40','createTable tableName=trait','',NULL,'4.26.0',NULL,NULL,'0079199431'),('create_planet_class_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',3,'EXECUTED','9:d01913390cf55ba6b30982fca30464a1','createTable tableName=planet_class','',NULL,'4.26.0',NULL,NULL,'0079199431'),('create_origin_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',4,'EXECUTED','9:c70872378759f075b548125ee1dddfc0','createTable tableName=origin','',NULL,'4.26.0',NULL,NULL,'0079199431'),('create_species_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',5,'EXECUTED','9:d0fc4e92655439ab9b9723fc0158b8e4','createTable tableName=species; createTable tableName=species_trait; addPrimaryKey constraintName=pk_species_trait, tableName=species_trait; addForeignKeyConstraint baseTableName=species_trait, constraintName=fk_species_trait_species, referencedTab...','',NULL,'4.26.0',NULL,NULL,'0079199431'),('create_homeworld_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',6,'EXECUTED','9:f45a1c34f5292533a6fb7d035bf435d6','createTable tableName=homeworld','',NULL,'4.26.0',NULL,NULL,'0079199431'),('create_civic_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',7,'EXECUTED','9:d793bfe8cebb0e299e524d683957125e','createTable tableName=civic','',NULL,'4.26.0',NULL,NULL,'0079199431'),('create_government_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',8,'EXECUTED','9:95a67fa74c73e66fe357b235a63089ac','createTable tableName=government','',NULL,'4.26.0',NULL,NULL,'0079199431'),('create_empire_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 13:59:59',9,'EXECUTED','9:3d86b29584e70a23b41bab21c4ff63e0','createTable tableName=empire; createTable tableName=empire_ethics; addForeignKeyConstraint baseTableName=empire_ethics, constraintName=fk_empire_ethics_empire, referencedTableName=empire; createTable tableName=empire_civic; addPrimaryKey constrain...','',NULL,'4.26.0',NULL,NULL,'0079199431'),('init_origin','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',10,'EXECUTED','9:229ab76e664e80486a1c9f52bbe9adb2','insert tableName=origin; insert tableName=origin; insert tableName=origin; insert tableName=origin; insert tableName=origin; insert tableName=origin; insert tableName=origin; insert tableName=origin; insert tableName=origin; insert tableName=origi...','',NULL,'4.26.0',NULL,NULL,'0079199431'),('init_appearance_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',11,'EXECUTED','9:1b36521a1ac698ee291662601d9567e0','insert tableName=appearance; insert tableName=appearance; insert tableName=appearance; insert tableName=appearance; insert tableName=appearance; insert tableName=appearance; insert tableName=appearance; insert tableName=appearance; insert tableNam...','',NULL,'4.26.0',NULL,NULL,'0079199431'),('init_trait_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',12,'EXECUTED','9:2955dadfbaa0033f4c49d00b270b9869','insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert ...','',NULL,'4.26.0',NULL,NULL,'0079199431'),('init_planet_class_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',13,'EXECUTED','9:95b81dc004f4d746198e7182a73f056d','insert tableName=planet_class; insert tableName=planet_class; insert tableName=planet_class; insert tableName=planet_class; insert tableName=planet_class; insert tableName=planet_class; insert tableName=planet_class; insert tableName=planet_class;...','',NULL,'4.26.0',NULL,NULL,'0079199431'),('init_civic_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',14,'EXECUTED','9:c4853a66b0d9675dcc2becc9852f3751','insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert ...','',NULL,'4.26.0',NULL,NULL,'0079199431'),('init_government_table','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',15,'EXECUTED','9:97f3f74a0c1d61f46ceee9b446671064','insert tableName=government; insert tableName=government; insert tableName=government; insert tableName=government; insert tableName=government; insert tableName=government; insert tableName=government; insert tableName=government; insert tableNam...','',NULL,'4.26.0',NULL,NULL,'0079199431'),('add_inherent_traits','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',16,'EXECUTED','9:f90529e20bb7865a0b26994c728bdbb1','insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait; insert tableName=trait','',NULL,'4.26.0',NULL,NULL,'0079199431'),('add_apocalypse_starting_worlds','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',17,'EXECUTED','9:8e13d3023c2b691df45b772acff77daa','insert tableName=planet_class; insert tableName=planet_class','',NULL,'4.26.0',NULL,NULL,'0079199431'),('add_apocalypse_origins','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',18,'EXECUTED','9:7600fd3dc4c7e8d27a79c5ed49b644a2','insert tableName=origin; insert tableName=origin','',NULL,'4.26.0',NULL,NULL,'0079199431'),('add_naval_contractors_civic','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',19,'EXECUTED','9:6a068d39e6b25484cbd3f230a8eef39e','insert tableName=civic','',NULL,'4.26.0',NULL,NULL,'0079199431'),('add_organic_reprocessing_civic_machine_intelligence','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 14:00:00',20,'EXECUTED','9:68d921b3731ce2414d0bec9c5863a787','insert tableName=civic','',NULL,'4.26.0',NULL,NULL,'0079199431'),('remove_regular_organic_reprocessing_civic','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-10 15:25:38',21,'EXECUTED','9:8ae3c718bcd0a90768695995f3ec7297','delete tableName=civic','',NULL,'4.26.0',NULL,NULL,'0084338527'),('add_elo_columns','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-11 19:28:33',22,'EXECUTED','9:c2da6cfa8f1e91a3d5c7c69018fe0ed0','addColumn tableName=empire','',NULL,'4.26.0',NULL,NULL,'0185313908'),('reset_elo','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-11 20:20:15',23,'EXECUTED','9:69122e877c1af57568648edca88419e4','update tableName=empire','',NULL,'4.26.0',NULL,NULL,'0188415137'),('reset_elo_fully','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-11 20:23:18',24,'EXECUTED','9:2976bd8257ce8708dcf61afbe3612e62','update tableName=empire','',NULL,'4.26.0',NULL,NULL,'0188598604'),('reset_elo_fully_again','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-11 20:29:21',25,'EXECUTED','9:2976bd8257ce8708dcf61afbe3612e62','update tableName=empire','',NULL,'4.26.0',NULL,NULL,'0188961715'),('add_pooled_knowledge_civic','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-12 09:33:30',26,'EXECUTED','9:10bb65508c053556a8c95f98f7986b40','insert tableName=civic','',NULL,'4.26.0',NULL,NULL,'0236010064'),('add_barbaric_despoilers_civic','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-14 15:22:39',27,'EXECUTED','9:fc6605886ec5eb139e3671c850d09870','insert tableName=civic','',NULL,'4.26.0',NULL,NULL,'0429759742'),('add_victory_boolean_columns_to_empire','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-15 14:47:37',28,'EXECUTED','9:a8a5df428b825cdc95480e063e05b6a3','addColumn tableName=empire','',NULL,'4.26.0',NULL,NULL,'0514057147'),('add_humanoid_dlc','Samantha Tovah','db/changelog/db.changelog-master.xml','2024-03-15 16:00:12',29,'EXECUTED','9:6398aee120e153d13d1819411d93b7b0','insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=civic; insert tableName=trait; insert tableName=origin','',NULL,'4.26.0',NULL,NULL,'0518412786');
/*!40000 ALTER TABLE `DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int NOT NULL,
  `LOCKED` tinyint NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOGLOCK`
--

LOCK TABLES `DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOGLOCK` VALUES (1,0,NULL,NULL);
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appearance`
--

DROP TABLE IF EXISTS `appearance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appearance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appearance`
--

LOCK TABLES `appearance` WRITE;
/*!40000 ALTER TABLE `appearance` DISABLE KEYS */;
INSERT INTO `appearance` VALUES (1,'Humanoid'),(2,'Machine'),(3,'Mammalian'),(4,'Reptilian'),(5,'Avian'),(6,'Arthropoid'),(7,'Molluscoid'),(8,'Fungoid'),(9,'Plantoid'),(10,'Lithoid'),(11,'Necroid'),(12,'Aquatic'),(13,'Toxoid');
/*!40000 ALTER TABLE `appearance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `civic`
--

DROP TABLE IF EXISTS `civic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `civic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `civic`
--

LOCK TABLES `civic` WRITE;
/*!40000 ALTER TABLE `civic` DISABLE KEYS */;
INSERT INTO `civic` VALUES (1,'Anglers'),(2,'Byzantine Bureaucracy'),(3,'Catalytic Processing'),(4,'Corvée System'),(5,'Cutthroat Politics'),(6,'Diplomatic Corps'),(7,'Efficient Bureaucracy'),(8,'Environmentalist'),(9,'Functional Architecture'),(10,'Memorialists'),(11,'Merchant Guilds'),(12,'Meritocracy'),(13,'Mining Guilds'),(14,'Mutagenic Spas'),(15,'Parliamentary System'),(16,'Police State'),(17,'Reanimators'),(18,'Scavengers'),(19,'Shadow Council'),(20,'Agrarian Idyll'),(21,'Aristocratic Elite'),(22,'Beacon of Liberty'),(23,'Citizen Service'),(24,'Death Cult'),(25,'Distinguished Admiralty'),(26,'Exalted Priesthood'),(27,'Fanatic Purifiers'),(28,'Feudal Society'),(29,'Free Haven'),(30,'Idealistic Foundation'),(31,'Idyllic Bloom'),(32,'Imperial Cult'),(33,'Inward Perfection'),(34,'Nationalistic Zeal'),(35,'Philosopher King'),(36,'Relentless Industrialists'),(37,'Shared Burdens'),(38,'Slaver Guilds'),(39,'Technocracy'),(40,'Warrior Culture'),(41,'Anglers (Corporate)'),(42,'Brand Loyalty'),(43,'Catalytic Recyclers'),(44,'Criminal Heritage'),(45,'Franchising'),(46,'Free Traders'),(47,'Media Conglomerate'),(48,'Mutagenic Spas (Corporate)'),(49,'Permanent Employment'),(50,'Private Prospectors'),(51,'Public Relations Specialists'),(52,'Ruthless Competition'),(53,'Scavengers (Corporate)'),(54,'Trading Posts'),(55,'Corporate Death Cult'),(56,'Gospel of the Masses'),(57,'Indentured Assets'),(58,'Private Military Companies'),(59,'Relentless Industrialists (Corporate)'),(60,'Ascetic'),(61,'Devouring Swarm'),(62,'Divided Attention'),(63,'Empath'),(64,'Memorialists (Hive Mind)'),(65,'Natural Neural Network'),(66,'One Mind'),(68,'Permutation Pools'),(69,'Strength of Legions'),(70,'Subspace Ephapse'),(71,'Subsumed Will'),(72,'Idyllic Bloom (Hive Mind)'),(73,'Constructobot'),(74,'Delegated Functions'),(75,'Determined Exterminator'),(76,'Driven Assimilator'),(77,'Factory Overclocking'),(78,'Hyper Lubrication Basin'),(79,'Introspective'),(80,'Maintenance Protocols'),(81,'Memorialists (Machine Intelligence)'),(82,'OTA Updates'),(83,'Organic Reprocessing (Hive Mind)'),(84,'Rapid Replicator'),(85,'Rockbreakers'),(86,'Rogue Servitor'),(87,'Static Research Analysis'),(88,'Unitary Cohesion'),(89,'Warbots'),(90,'Zero-Waste Protocols'),(91,'Naval Contractors'),(92,'Organic Reprocessing (Machine Intelligence)'),(93,'Pooled Knowledge'),(94,'Barbaric Despoilers'),(95,'Pleasure Seekers'),(96,'Pompous Purists'),(97,'Masterful Crafters'),(98,'Corporate Hedonism'),(99,'Mastercraft Inc.');
/*!40000 ALTER TABLE `civic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empire`
--

DROP TABLE IF EXISTS `empire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empire` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `species` bigint NOT NULL,
  `homeworld` bigint NOT NULL,
  `authority` varchar(255) NOT NULL,
  `government` bigint NOT NULL,
  `elo` int NOT NULL DEFAULT '1000',
  `elo_comparisons` int NOT NULL DEFAULT '0',
  `won_small_galaxy` tinyint NOT NULL DEFAULT '0',
  `won_medium_galaxy` tinyint NOT NULL DEFAULT '0',
  `won_large_galaxy` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_empire_species` (`species`),
  KEY `fk_empire_government` (`government`),
  KEY `fk_empire_homeworld` (`homeworld`),
  CONSTRAINT `fk_empire_government` FOREIGN KEY (`government`) REFERENCES `government` (`id`),
  CONSTRAINT `fk_empire_homeworld` FOREIGN KEY (`homeworld`) REFERENCES `homeworld` (`id`),
  CONSTRAINT `fk_empire_species` FOREIGN KEY (`species`) REFERENCES `species` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empire`
--

LOCK TABLES `empire` WRITE;
/*!40000 ALTER TABLE `empire` DISABLE KEYS */;
INSERT INTO `empire` VALUES (1,'Saathid Directorate',1,1,'OLIGARCHIC',35,1453,70,0,0,0),(2,'Chimm',67,67,'HIVE_MIND',58,1424,71,1,0,0),(3,'Consensus of Spyr K\'tah',3,3,'DEMOCRATIC',34,1364,70,0,0,0),(4,'Yldar Divine Accord',4,4,'OLIGARCHIC',13,995,71,0,0,0),(5,'Byrd Butchers',5,5,'IMPERIAL',48,1234,70,0,0,0),(6,'League of Helpers',6,6,'MACHINE_INTELLIGENCE',61,755,71,0,0,0),(7,'Groot Organism',7,7,'HIVE_MIND',57,618,70,0,0,0),(8,'Replicator Continuum',8,8,'MACHINE_INTELLIGENCE',65,907,70,0,0,0),(9,'Ummat al-Ezra',81,81,'DICTATORIAL',11,1099,70,0,0,0),(10,'Fblthp Friendship Foundation',10,10,'OLIGARCHIC',17,1259,70,0,0,0),(11,'Zoif Knowledge Seekers',11,11,'MACHINE_INTELLIGENCE',64,1203,70,0,0,0),(12,'United Stellar Provinces',61,61,'CORPORATE',50,959,70,0,0,0),(13,'Thornmaw Intersolar',13,13,'CORPORATE',49,783,70,0,0,0),(14,'Imperium of Man',68,68,'OLIGARCHIC',46,1412,70,1,0,0),(15,'World Eaters',15,15,'HIVE_MIND',58,810,70,0,0,0),(16,'United Nations of Earth',16,16,'DEMOCRATIC',1,904,70,0,0,0),(17,'Coalition of Plenty',17,17,'DEMOCRATIC',1,1188,70,0,0,0),(18,'Ryouka Democratic Reformers',18,18,'DEMOCRATIC',45,1333,70,0,0,0),(19,'Furbold Trade Consortium',19,19,'CORPORATE',50,1206,70,0,0,0),(20,'Alliance of Snaz Goba',20,20,'DEMOCRATIC',30,1207,70,0,0,0),(21,'Custodial Glimmer Confederation',75,75,'DICTATORIAL',18,1109,71,0,0,0),(22,'Devourers of Yuggoth',22,22,'DICTATORIAL',32,765,71,0,0,0),(23,'Council of Pestilence',23,23,'OLIGARCHIC',2,879,70,0,0,0),(24,'Serenity Supervisors',24,24,'MACHINE_INTELLIGENCE',62,1003,70,0,0,0),(25,'Unity of Terra',25,25,'IMPERIAL',7,1229,70,0,0,0),(26,'Enlightened Blin\'Fin Hegemony',26,26,'IMPERIAL',7,731,71,0,0,0),(27,'Habibi Collective',27,27,'HIVE_MIND',57,744,70,0,0,0),(28,'United Systems of America',88,88,'DEMOCRATIC',20,1204,70,0,0,0),(29,'Mumra Bonded Merchants',82,82,'CORPORATE',50,1082,70,0,0,0),(30,'Commonality of Loam',30,30,'DICTATORIAL',18,932,70,0,0,0),(31,'InnoWeave Persistent Systems & Artisan Solutions',83,83,'CORPORATE',50,1045,70,0,0,0),(32,'Democratic People\'s Republic of Norkea',32,32,'IMPERIAL',7,1301,71,0,0,0),(33,'Samsung Interstellar Co., Ltd.',59,59,'CORPORATE',49,1054,71,0,0,0),(34,'Blorp Collectors',34,34,'MACHINE_INTELLIGENCE',63,872,70,0,0,0),(35,'Hierarchy of Dwarrowdelf',70,70,'IMPERIAL',33,995,70,0,0,0),(36,'Serene Mloriac Mentorship',36,36,'DICTATORIAL',18,987,70,0,0,0),(37,'Kingdom of Rusalem',37,37,'IMPERIAL',8,1232,70,0,0,0),(38,'Illuminated Mag\'moid Technocracy',38,38,'IMPERIAL',37,613,70,0,0,0),(39,'State of Progress',39,39,'DICTATORIAL',32,938,70,0,0,0),(40,'Goblina Radiant Sovereignty',89,89,'CORPORATE',51,1084,71,0,0,0),(41,'Regime of Great Light',41,41,'OLIGARCHIC',25,554,70,0,0,0),(42,'Greenleaf Syndicate',42,42,'CORPORATE',53,697,70,0,0,0),(43,'Cerebral Sludge Collective',43,43,'HIVE_MIND',57,731,70,0,0,0),(44,'United Citizen Federation',73,73,'DEMOCRATIC',28,1394,70,0,0,0),(45,'Qelp Multitude',45,45,'HIVE_MIND',57,544,70,0,0,0),(46,'Laviosan Message of Redemption',46,46,'CORPORATE',51,769,70,0,0,0),(47,'Twice-Lived Hegemony',47,47,'IMPERIAL',23,667,70,0,0,0),(48,'Prosperity Gospel',79,79,'CORPORATE',51,1413,70,0,0,0),(49,'Prophets of Freeport',49,49,'CORPORATE',55,803,70,0,0,0),(50,'Abyssal Serenity Ventures',50,50,'CORPORATE',49,1137,70,0,0,0),(51,'Order of Gourmand Cleansers',51,51,'DICTATORIAL',47,706,70,0,0,0),(52,'Sacrosanct Imperium',53,53,'IMPERIAL',39,882,70,0,0,0),(53,'Pooter Cohesion',54,54,'MACHINE_INTELLIGENCE',60,762,70,0,0,0),(54,'Great Noxious Deluge',55,55,'HIVE_MIND',57,681,71,0,0,0),(55,'Etherreal Remnants of Silent Gys',56,56,'IMPERIAL',14,644,70,0,0,0),(57,'Black Sky Enterprises',85,85,'CORPORATE',49,1372,70,0,0,0),(58,'Cult of the Star Phoenix',63,63,'IMPERIAL',15,885,70,0,0,0),(59,'Crystalline Vanguard',64,64,'OLIGARCHIC',40,764,70,0,0,0),(60,'Drakonian Conservators',65,65,'OLIGARCHIC',13,960,71,0,0,0),(61,'Aquarian Interstellar Assembly',66,66,'DEMOCRATIC',30,1168,71,0,0,0),(62,'Citizen Consumer Conglomorate',74,74,'CORPORATE',49,1380,70,1,0,0),(63,'Arechnex Swarm',76,76,'MACHINE_INTELLIGENCE',61,1120,71,0,0,0),(64,'Galactic Harvest Holdings',84,84,'CORPORATE',50,1069,70,0,0,0),(65,'Tranquil Gardyn',87,87,'OLIGARCHIC',17,930,70,0,0,0),(66,'Sporeguard Sanctum',90,90,'OLIGARCHIC',13,950,68,0,0,0),(67,'Epicurian Collective',91,91,'DEMOCRATIC',40,1183,26,0,0,0);
/*!40000 ALTER TABLE `empire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empire_civic`
--

DROP TABLE IF EXISTS `empire_civic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empire_civic` (
  `empire_id` bigint NOT NULL,
  `civic_id` bigint NOT NULL,
  PRIMARY KEY (`empire_id`,`civic_id`),
  KEY `fk_empire_civic_civic` (`civic_id`),
  CONSTRAINT `fk_empire_civic_civic` FOREIGN KEY (`civic_id`) REFERENCES `civic` (`id`),
  CONSTRAINT `fk_empire_civic_empire` FOREIGN KEY (`empire_id`) REFERENCES `empire` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empire_civic`
--

LOCK TABLES `empire_civic` WRITE;
/*!40000 ALTER TABLE `empire_civic` DISABLE KEYS */;
INSERT INTO `empire_civic` VALUES (17,1),(30,1),(61,1),(22,2),(36,4),(4,6),(10,6),(38,6),(60,8),(51,9),(47,10),(17,11),(3,12),(20,12),(35,13),(39,13),(61,15),(36,16),(47,17),(23,18),(22,19),(23,19),(30,20),(37,21),(16,22),(18,23),(44,23),(52,24),(41,25),(4,26),(14,26),(60,26),(66,26),(5,27),(14,27),(18,27),(51,27),(26,28),(37,28),(55,28),(9,29),(10,29),(65,29),(16,30),(20,30),(28,30),(65,31),(52,32),(58,32),(1,33),(21,33),(55,33),(25,34),(28,34),(32,34),(44,34),(5,35),(25,35),(26,35),(32,35),(58,35),(39,36),(1,39),(3,39),(38,39),(41,40),(59,40),(66,40),(50,41),(33,42),(40,42),(50,43),(42,44),(49,44),(46,45),(12,46),(19,46),(29,46),(31,46),(64,46),(33,47),(48,47),(62,47),(57,48),(29,49),(64,52),(12,54),(19,54),(40,56),(46,56),(48,56),(49,56),(13,58),(62,58),(42,59),(57,59),(27,60),(45,60),(2,61),(15,61),(43,62),(27,64),(43,65),(54,66),(15,69),(2,70),(45,71),(7,72),(6,75),(63,75),(34,76),(63,78),(11,79),(8,80),(24,80),(53,80),(7,83),(8,84),(24,86),(11,87),(53,88),(6,89),(13,91),(34,92),(54,93),(59,94),(67,94),(9,95),(67,95),(21,97),(35,97),(31,99);
/*!40000 ALTER TABLE `empire_civic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empire_ethics`
--

DROP TABLE IF EXISTS `empire_ethics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empire_ethics` (
  `empire` bigint NOT NULL,
  `ethic` varchar(255) NOT NULL,
  KEY `fk_empire_ethics_empire` (`empire`),
  CONSTRAINT `fk_empire_ethics_empire` FOREIGN KEY (`empire`) REFERENCES `empire` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empire_ethics`
--

LOCK TABLES `empire_ethics` WRITE;
/*!40000 ALTER TABLE `empire_ethics` DISABLE KEYS */;
INSERT INTO `empire_ethics` VALUES (1,'PACIFIST'),(1,'XENOPHOBE'),(1,'MATERIALIST'),(2,'GESTALT_CONSCIOUSNESS'),(3,'FANATIC_EGALITARIAN'),(3,'MATERIALIST'),(4,'XENOPHILE'),(4,'FANATIC_SPIRITUALIST'),(5,'MILITARIST'),(5,'FANATIC_XENOPHOBE'),(6,'GESTALT_CONSCIOUSNESS'),(7,'GESTALT_CONSCIOUSNESS'),(8,'GESTALT_CONSCIOUSNESS'),(10,'PACIFIST'),(10,'FANATIC_XENOPHILE'),(11,'GESTALT_CONSCIOUSNESS'),(12,'MATERIALIST'),(13,'FANATIC_MILITARIST'),(13,'AUTHORITARIAN'),(14,'FANATIC_XENOPHOBE'),(14,'SPIRITUALIST'),(15,'GESTALT_CONSCIOUSNESS'),(16,'FANATIC_EGALITARIAN'),(16,'XENOPHILE'),(17,'EGALITARIAN'),(17,'FANATIC_XENOPHILE'),(18,'MILITARIST'),(18,'FANATIC_XENOPHOBE'),(19,'PACIFIST'),(19,'FANATIC_XENOPHILE'),(20,'PACIFIST'),(20,'EGALITARIAN'),(20,'MATERIALIST'),(22,'AUTHORITARIAN'),(22,'XENOPHOBE'),(22,'MATERIALIST'),(23,'AUTHORITARIAN'),(23,'FANATIC_XENOPHOBE'),(24,'GESTALT_CONSCIOUSNESS'),(25,'MILITARIST'),(25,'XENOPHOBE'),(25,'MATERIALIST'),(26,'MILITARIST'),(26,'AUTHORITARIAN'),(26,'XENOPHILE'),(27,'GESTALT_CONSCIOUSNESS'),(30,'FANATIC_PACIFIST'),(30,'AUTHORITARIAN'),(32,'MILITARIST'),(32,'FANATIC_AUTHORITARIAN'),(33,'EGALITARIAN'),(33,'FANATIC_MATERIALIST'),(34,'GESTALT_CONSCIOUSNESS'),(35,'XENOPHOBE'),(35,'FANATIC_MATERIALIST'),(36,'PACIFIST'),(36,'AUTHORITARIAN'),(36,'XENOPHILE'),(37,'MILITARIST'),(37,'AUTHORITARIAN'),(37,'MATERIALIST'),(38,'PACIFIST'),(38,'XENOPHILE'),(38,'MATERIALIST'),(39,'AUTHORITARIAN'),(39,'XENOPHOBE'),(39,'MATERIALIST'),(41,'FANATIC_MILITARIST'),(41,'SPIRITUALIST'),(42,'AUTHORITARIAN'),(42,'XENOPHILE'),(42,'MATERIALIST'),(43,'GESTALT_CONSCIOUSNESS'),(44,'FANATIC_MILITARIST'),(44,'EGALITARIAN'),(45,'GESTALT_CONSCIOUSNESS'),(46,'MILITARIST'),(46,'FANATIC_SPIRITUALIST'),(47,'MILITARIST'),(47,'FANATIC_AUTHORITARIAN'),(48,'XENOPHILE'),(48,'SPIRITUALIST'),(49,'MILITARIST'),(49,'EGALITARIAN'),(49,'SPIRITUALIST'),(50,'AUTHORITARIAN'),(50,'XENOPHILE'),(50,'SPIRITUALIST'),(51,'FANATIC_XENOPHOBE'),(51,'SPIRITUALIST'),(52,'AUTHORITARIAN'),(52,'XENOPHOBE'),(52,'SPIRITUALIST'),(53,'GESTALT_CONSCIOUSNESS'),(54,'GESTALT_CONSCIOUSNESS'),(55,'PACIFIST'),(55,'XENOPHOBE'),(55,'SPIRITUALIST'),(12,'EGALITARIAN'),(12,'XENOPHILE'),(58,'AUTHORITARIAN'),(58,'FANATIC_SPIRITUALIST'),(59,'FANATIC_MILITARIST'),(59,'AUTHORITARIAN'),(60,'PACIFIST'),(60,'XENOPHILE'),(60,'SPIRITUALIST'),(61,'FANATIC_EGALITARIAN'),(61,'MATERIALIST'),(62,'MILITARIST'),(62,'EGALITARIAN'),(62,'XENOPHILE'),(21,'FANATIC_PACIFIST'),(21,'XENOPHOBE'),(63,'GESTALT_CONSCIOUSNESS'),(9,'FANATIC_XENOPHILE'),(9,'SPIRITUALIST'),(48,'AUTHORITARIAN'),(29,'AUTHORITARIAN'),(29,'XENOPHOBE'),(29,'MATERIALIST'),(31,'PACIFIST'),(31,'XENOPHILE'),(31,'MATERIALIST'),(64,'MILITARIST'),(64,'XENOPHOBE'),(64,'MATERIALIST'),(57,'AUTHORITARIAN'),(57,'FANATIC_MATERIALIST'),(65,'PACIFIST'),(65,'EGALITARIAN'),(65,'XENOPHILE'),(28,'MILITARIST'),(28,'EGALITARIAN'),(28,'XENOPHILE'),(40,'EGALITARIAN'),(40,'FANATIC_SPIRITUALIST'),(66,'FANATIC_MILITARIST'),(66,'SPIRITUALIST'),(67,'MILITARIST'),(67,'EGALITARIAN'),(67,'XENOPHOBE');
/*!40000 ALTER TABLE `empire_ethics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `government`
--

DROP TABLE IF EXISTS `government`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `government` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `government`
--

LOCK TABLES `government` WRITE;
/*!40000 ALTER TABLE `government` DISABLE KEYS */;
INSERT INTO `government` VALUES (1,'Representative Democracy'),(2,'Plutocratic Oligarchy'),(3,'Constitutional Dictatorship'),(4,'Despotic Empire'),(5,'Communal Parity'),(6,'Elective Monarchy'),(7,'Enlightened Monarchy'),(8,'Feudal Empire'),(9,'Theocratic Republic'),(10,'Theocratic Oligarchy'),(11,'Theocratic Dictatorship'),(12,'Theocratic Monarchy'),(13,'Holy Tribunal'),(14,'Celestial Empire'),(15,'Divine Empire'),(16,'Moral Democracy'),(17,'Irenic Bureacracy'),(18,'Irenic Dictatorship'),(19,'Irenic Monarchy'),(20,'Military Commissariat'),(21,'Military Junta'),(22,'Military Dictatorship'),(23,'Star Empire'),(24,'Assembly of Clans'),(25,'War Council'),(26,'Martial Dictatorship'),(27,'Martial Empire'),(28,'Citizen Republic'),(29,'Citizen Stratocracy'),(30,'Direct Democracy'),(31,'Executive Committee'),(32,'Totalitarian Regime'),(33,'Despotic Hegemony'),(34,'Rational Consensus'),(35,'Science Directorate'),(36,'Technocratic Dictatorship'),(37,'Illuminated Autocracy'),(38,'Grim Council'),(39,'Mortal Empire'),(40,'Bandit Commune'),(41,'Bandit Kingdom'),(42,'Band of Blood'),(43,'Defensive Union'),(44,'Dimensional Covenant'),(45,'Purity Assembly'),(46,'Purification Committee'),(47,'Purity Order'),(48,'Blood Court'),(49,'Megacorporation'),(50,'Trade League'),(51,'MegaChurch'),(52,'Worker Cooperative'),(53,'Criminal Syndicate'),(54,'Pirate Haven'),(55,'Subversive Cult'),(56,'Sacrificial MegaChurch'),(57,'Collective Consciousness'),(58,'Ravenous Hive'),(59,'Parasitic Overmind'),(60,'Artificial Intelligence Network'),(61,'Rogue Defense System'),(62,'Autonomous Service Grid'),(63,'Catalog Index'),(64,'Intelligent Research Link'),(65,'Industrious Production Core');
/*!40000 ALTER TABLE `government` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeworld`
--

DROP TABLE IF EXISTS `homeworld`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homeworld` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `homeworld_name` varchar(255) NOT NULL,
  `star_name` varchar(255) DEFAULT NULL,
  `planet_class` bigint NOT NULL,
  `origin` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_homeworld_planet_class` (`planet_class`),
  KEY `fk_homeworld_origin` (`origin`),
  CONSTRAINT `fk_homeworld_origin` FOREIGN KEY (`origin`) REFERENCES `origin` (`id`),
  CONSTRAINT `fk_homeworld_planet_class` FOREIGN KEY (`planet_class`) REFERENCES `planet_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeworld`
--

LOCK TABLES `homeworld` WRITE;
/*!40000 ALTER TABLE `homeworld` DISABLE KEYS */;
INSERT INTO `homeworld` VALUES (1,'Saathurna',NULL,11,5),(2,'Chimm',NULL,1,1),(3,'Spyria',NULL,12,6),(4,'Yldaraan',NULL,5,23),(5,'Byrd',NULL,10,4),(6,'Haven',NULL,14,1),(7,'Home',NULL,6,9),(8,'Processor Alpha',NULL,13,12),(9,'Ez',NULL,3,10),(10,'Fbl',NULL,4,7),(11,'Zoifan',NULL,11,5),(12,'Earth',NULL,5,8),(13,'Bloomdoworld Zeta',NULL,15,27),(14,'Terra',NULL,10,4),(15,'Kharn',NULL,1,11),(16,'Earth',NULL,5,1),(17,'Plenty',NULL,4,19),(18,'Discord',NULL,14,28),(19,'Bold',NULL,2,7),(20,'Snazoria',NULL,6,2),(21,'Glimmer',NULL,8,10),(22,'Yuggoth',NULL,7,17),(23,'Pestilens',NULL,2,25),(24,'Main Facility',NULL,11,5),(25,'Terra',NULL,5,1),(26,'High Gob',NULL,4,19),(27,'Ancient Hab',NULL,10,4),(28,'America',NULL,5,1),(29,'Pharax',NULL,11,5),(30,'Loam Prima',NULL,4,19),(31,'Greed',NULL,11,5),(32,'Norkea',NULL,14,28),(33,'Zorkea',NULL,5,7),(34,'Bleep',NULL,10,4),(35,'Dwarrowdelf',NULL,8,21),(36,'Shehari',NULL,1,3),(37,'Rusalem',NULL,6,26),(38,'Scorch',NULL,1,22),(39,'Progress',NULL,3,21),(40,'Holy Gob',NULL,4,19),(41,'Great Melee',NULL,9,23),(42,'Greengreed',NULL,6,1),(43,'Cereb',NULL,9,25),(44,'Earth',NULL,5,1),(45,'Mother Qelp',NULL,4,25),(46,'Sacred Flower',NULL,15,27),(47,'Mort',NULL,14,28),(48,'Splorge Prime',NULL,4,19),(49,'Freeport',NULL,12,6),(50,'Great Bounty',NULL,4,10),(51,'Cleath',NULL,9,17),(52,'Blight',NULL,14,28),(53,'Blight',NULL,14,28),(54,'Poote',NULL,13,12),(55,'Blistox',NULL,2,20),(56,'Old Gys',NULL,10,4),(57,'Zorkea',NULL,5,7),(58,'Zorkea',NULL,5,7),(59,'Zorkea',NULL,5,7),(60,'Apex',NULL,14,28),(61,'Earth',NULL,5,8),(62,'Apex',NULL,14,28),(63,'Solaris Reborn',NULL,3,15),(64,'Glacium',NULL,7,11),(65,'Drakonia',NULL,2,18),(66,'Thalassia',NULL,4,19),(67,'Chimm',NULL,1,1),(68,'Terra',NULL,10,4),(69,'Verdant Exchange',NULL,9,29),(70,'Dwarrowdelf',NULL,8,21),(71,'Greed',NULL,11,5),(72,'Earth',NULL,5,1),(73,'Earth',NULL,5,1),(74,'Verdant Exchange',NULL,9,29),(75,'Glimmer',NULL,10,4),(76,'Silksteel Haven',NULL,14,22),(77,'Ez',NULL,3,10),(78,'Gay',NULL,3,10),(79,'Splorge Prime',NULL,4,19),(80,'America',NULL,5,1),(81,'Gay',NULL,3,10),(82,'Pharax',NULL,11,5),(83,'Greed',NULL,11,5),(84,'Graymarket',NULL,6,17),(85,'Apex',NULL,14,28),(86,'Verdant Haven',NULL,15,27),(87,'Verdant Haven',NULL,15,27),(88,'America',NULL,5,1),(89,'Holy Gob',NULL,4,19),(90,'Viridion Prime',NULL,6,26),(91,'Deliciae',NULL,3,1);
/*!40000 ALTER TABLE `homeworld` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `origin`
--

DROP TABLE IF EXISTS `origin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `origin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `origin`
--

LOCK TABLES `origin` WRITE;
/*!40000 ALTER TABLE `origin` DISABLE KEYS */;
INSERT INTO `origin` VALUES (1,'Prosperous Unification'),(2,'Mechanist'),(3,'Syncretic Evolution'),(4,'Remants'),(5,'Shattered Ring'),(6,'Void Dwellers'),(7,'Scion'),(8,'Galactic Doorstep'),(9,'Tree of Life'),(10,'On the Shoulders of Giants'),(11,'Calamitous Birth'),(12,'Resource Consolidation'),(13,'Common Ground'),(14,'Hegemon'),(15,'Doomsday'),(16,'Lost Colony'),(17,'Necrophage'),(18,'Here Be Dragons'),(19,'Ocean Paradise'),(20,'Progenitor Hive'),(21,'Subterranean'),(22,'Slingshot to the Stars'),(23,'Teachers of the Shroud'),(24,'Imperial Fiefdom'),(25,'Overtuned'),(26,'Knights of the Toxic God'),(27,'Life-Seeded'),(28,'Post-Apocalyptic'),(29,'Clone Army');
/*!40000 ALTER TABLE `origin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planet_class`
--

DROP TABLE IF EXISTS `planet_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planet_class` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planet_class`
--

LOCK TABLES `planet_class` WRITE;
/*!40000 ALTER TABLE `planet_class` DISABLE KEYS */;
INSERT INTO `planet_class` VALUES (1,'Desert World'),(2,'Arid World'),(3,'Savanna World'),(4,'Ocean World'),(5,'Continental World'),(6,'Tropical World'),(7,'Arctic World'),(8,'Alpine World'),(9,'Tundra World'),(10,'Relic World'),(11,'Shattered Ring World'),(12,'Orbital Habitats'),(13,'Machine World'),(14,'Tomb World'),(15,'Gaia World');
/*!40000 ALTER TABLE `planet_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species`
--

DROP TABLE IF EXISTS `species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `species` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `appearance` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_species_appearance` (`appearance`),
  CONSTRAINT `fk_species_appearance` FOREIGN KEY (`appearance`) REFERENCES `appearance` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species`
--

LOCK TABLES `species` WRITE;
/*!40000 ALTER TABLE `species` DISABLE KEYS */;
INSERT INTO `species` VALUES (1,'Saathid',6),(2,'Chimm',6),(3,'Ikaanan',5),(4,'Yldar',1),(5,'Byrd',5),(6,'Protectron',2),(7,'Groot',9),(8,'Replibot',2),(9,'Ezra',3),(10,'Fblthp',7),(11,'Zoif',2),(12,'Human',1),(13,'Thornmaw',9),(14,'Human',1),(15,'Kharnite',10),(16,'Human',1),(17,'Yhelli',12),(18,'Ryouka',6),(19,'Furbold',3),(20,'Snadge',7),(21,'Powe',5),(22,'Thule',7),(23,'Skay\'ve',13),(24,'Serenity Unit',2),(25,'Human',1),(26,'Blin\'Fin',12),(27,'Habib',6),(28,'American',5),(29,'Mumra',11),(30,'Beet',9),(31,'Sloggar',7),(32,'Nork',3),(33,'Samsunite',3),(34,'Blorp',2),(35,'Dwarrow',3),(36,'Mloriac',4),(37,'Rusalite',13),(38,'Mag\'moid',10),(39,'Rokk',10),(40,'Goblina',12),(41,'Ringo',4),(42,'Greenleaf',9),(43,'Cerebral Sludge',7),(44,'Human',1),(45,'Qelp',12),(46,'Laviosa',9),(47,'Radon',8),(48,'Zygote',7),(49,'Me-Me',4),(50,'Murk',12),(51,'Croid',11),(52,'Schrute',8),(53,'Schrute',8),(54,'Pooter',2),(55,'Noxicum',13),(56,'Gysian',11),(57,'Samsunite',3),(58,'Samsunite',3),(59,'Samsunite',3),(60,'Apexalite',11),(61,'Human',1),(62,'Apexalite',11),(63,'Phoenician',5),(64,'Crystalline',10),(65,'Drakonid',4),(66,'Sirene',12),(67,'Chimm',6),(68,'Human',1),(69,'Vendari',1),(70,'Dwarrow',3),(71,'Sloggar',7),(72,'Human',1),(73,'Human',1),(74,'Vendari',1),(75,'Powe',5),(76,'Arechnex',2),(77,'Ezra',3),(78,'Ezra',3),(79,'Zygote',7),(80,'American',5),(81,'Ezra',3),(82,'Mumra',11),(83,'Sloggar',7),(84,'Consumer',11),(85,'Apexalite',7),(86,'Gardyn',9),(87,'Gardyn',9),(88,'American',5),(89,'Goblina',12),(90,'Virentium',8),(91,'Saporite',5);
/*!40000 ALTER TABLE `species` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species_trait`
--

DROP TABLE IF EXISTS `species_trait`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `species_trait` (
  `species_id` bigint NOT NULL,
  `trait_id` bigint NOT NULL,
  PRIMARY KEY (`species_id`,`trait_id`),
  KEY `fk_species_trait_trait` (`trait_id`),
  CONSTRAINT `fk_species_trait_species` FOREIGN KEY (`species_id`) REFERENCES `species` (`id`),
  CONSTRAINT `fk_species_trait_trait` FOREIGN KEY (`trait_id`) REFERENCES `trait` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species_trait`
--

LOCK TABLES `species_trait` WRITE;
/*!40000 ALTER TABLE `species_trait` DISABLE KEYS */;
INSERT INTO `species_trait` VALUES (17,1),(26,1),(30,1),(40,1),(48,1),(50,1),(66,1),(79,1),(89,1),(7,2),(30,2),(50,2),(57,3),(58,3),(59,3),(63,3),(33,4),(35,4),(39,4),(60,4),(62,4),(70,4),(85,4),(1,5),(3,5),(18,5),(20,5),(22,5),(31,5),(36,5),(38,5),(43,5),(62,5),(66,5),(71,5),(83,5),(17,6),(19,6),(21,6),(23,6),(28,6),(29,6),(30,6),(31,6),(33,6),(35,6),(46,6),(48,6),(57,6),(58,6),(59,6),(69,6),(70,6),(71,6),(74,6),(75,6),(79,6),(80,6),(82,6),(83,6),(84,6),(88,6),(3,7),(35,7),(40,7),(70,7),(89,7),(1,8),(41,8),(7,9),(50,9),(56,9),(13,10),(12,11),(14,11),(16,11),(25,11),(28,11),(42,11),(44,11),(61,11),(68,11),(69,11),(72,11),(73,11),(74,11),(80,11),(84,11),(88,11),(5,12),(7,12),(17,12),(26,12),(27,12),(29,12),(30,12),(31,12),(48,12),(71,12),(79,12),(82,12),(83,12),(2,13),(18,13),(19,13),(27,13),(31,13),(67,13),(71,13),(83,13),(91,13),(5,14),(10,14),(26,14),(33,14),(35,14),(36,14),(40,14),(51,14),(57,14),(58,14),(59,14),(65,14),(70,14),(86,14),(87,14),(89,14),(9,15),(20,15),(22,15),(26,15),(41,15),(60,15),(77,15),(10,16),(20,16),(49,16),(13,17),(30,17),(47,17),(4,18),(5,18),(15,18),(22,18),(27,18),(56,18),(78,18),(81,18),(2,19),(9,19),(13,19),(35,19),(42,19),(60,19),(62,19),(67,19),(70,19),(77,19),(85,19),(38,20),(13,21),(15,21),(23,21),(28,21),(39,21),(55,21),(80,21),(88,21),(39,22),(51,22),(15,23),(64,23),(19,24),(38,24),(43,24),(45,24),(2,25),(10,25),(12,25),(14,25),(16,25),(25,25),(28,25),(44,25),(60,25),(61,25),(67,25),(68,25),(72,25),(73,25),(80,25),(88,25),(7,26),(18,26),(39,26),(52,26),(53,26),(56,26),(66,26),(69,26),(74,26),(4,27),(5,27),(29,27),(46,27),(65,27),(82,27),(86,27),(87,27),(90,27),(1,28),(28,28),(80,28),(88,28),(9,29),(10,29),(17,29),(21,29),(49,29),(65,29),(75,29),(77,29),(78,29),(81,29),(86,29),(87,29),(91,29),(20,30),(22,30),(23,30),(31,30),(32,30),(37,30),(43,30),(47,30),(50,30),(55,30),(71,30),(83,30),(40,31),(48,31),(79,31),(89,31),(3,32),(17,32),(18,32),(21,32),(42,32),(63,32),(64,32),(69,32),(74,32),(75,32),(78,32),(81,32),(90,32),(91,32),(5,33),(26,33),(32,33),(36,33),(29,34),(51,34),(56,34),(63,34),(82,34),(2,35),(19,35),(38,35),(45,35),(48,35),(66,35),(67,35),(79,35),(36,36),(63,36),(84,36),(2,37),(27,37),(37,37),(63,37),(67,37),(90,37),(37,38),(52,38),(53,38),(65,38),(66,38),(86,38),(87,38),(12,39),(14,39),(16,39),(21,39),(25,39),(36,39),(44,39),(46,39),(49,39),(60,39),(61,39),(62,39),(68,39),(72,39),(73,39),(75,39),(84,39),(85,39),(91,39),(90,40),(42,41),(47,41),(52,41),(53,41),(85,41),(7,42),(13,42),(43,50),(43,53),(23,54),(45,54),(23,56),(37,56),(45,56),(55,56),(47,57),(55,57),(55,58),(15,61),(64,62),(76,65),(11,66),(24,69),(24,70),(34,71),(76,71),(6,72),(8,73),(11,73),(11,74),(8,75),(54,75),(8,76),(76,76),(11,77),(34,78),(24,79),(8,80),(54,80),(76,81),(2,82),(7,82),(15,82),(27,82),(43,82),(45,82),(55,82),(67,82),(3,83),(49,83),(4,84),(41,84),(6,85),(8,85),(11,85),(24,85),(34,85),(54,85),(76,85),(15,86),(38,86),(39,86),(64,86),(18,87),(32,87),(47,87),(52,87),(53,87),(60,87),(62,87),(85,87),(22,88),(51,88),(84,88),(35,89),(39,89),(70,89),(69,90),(74,90);
/*!40000 ALTER TABLE `species_trait` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trait`
--

DROP TABLE IF EXISTS `trait`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trait` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trait`
--

LOCK TABLES `trait` WRITE;
/*!40000 ALTER TABLE `trait` DISABLE KEYS */;
INSERT INTO `trait` VALUES (1,'Aquatic'),(2,'Agrarian'),(3,'Ingenious'),(4,'Industrious'),(5,'Intelligent'),(6,'Thrifty'),(7,'Natural Engineers'),(8,'Natural Physicists'),(9,'Natural Sociologists'),(10,'Extremely Adaptive'),(11,'Adaptive'),(12,'Nonadaptive'),(13,'Rapid Breeders'),(14,'Slow Breeders'),(15,'Talented'),(16,'Quick Learners'),(17,'Slow Learners'),(18,'Traditional'),(19,'Quarrelsome'),(20,'Docile'),(21,'Unruly'),(22,'Very Strong'),(23,'Strong'),(24,'Weak'),(25,'Nomadic'),(26,'Sedentary'),(27,'Communal'),(28,'Solitary'),(29,'Charismatic'),(30,'Repugnant'),(31,'Conformists'),(32,'Deviants'),(33,'Venerable'),(34,'Enduring'),(35,'Fleeting'),(36,'Decadent'),(37,'Resilient'),(38,'Conservationist'),(39,'Wasteful'),(40,'Phototrophic'),(41,'Radiotrophic'),(42,'Budding'),(43,'Spliced Adaptability'),(44,'Juiced Power'),(45,'Farm Appendages'),(46,'Dedicated Miner'),(47,'Technical Talent'),(48,'Crafted Smiles'),(49,'Low Maintenance'),(50,'Augmented Intelligence'),(51,'Gene Mentorship'),(52,'Expressed Tradition'),(53,'Elevated Synapses'),(54,'Pre-Planned Growth'),(55,'Excessive Endurance'),(56,'Incubators'),(57,'Inorganic Breath'),(58,'Noxious'),(59,'Scintillating Skin'),(60,'Gaseous Breath'),(61,'Volatile Excretions'),(62,'Crystallization'),(63,'Power Drills'),(64,'Superconductive'),(65,'Efficient Processors'),(66,'Logic Engines'),(67,'Double-Jointed'),(68,'Bulky'),(69,'Enhanced Memory'),(70,'Emotion Emulators'),(71,'Uncanny'),(72,'Durable'),(73,'High Maintenance'),(74,'Learning Algorithms'),(75,'Repurposed Hardware'),(76,'Mass-Produced'),(77,'Custom-Made'),(78,'Recycled'),(79,'Luxurious'),(80,'Streamlined Protocols'),(81,'High Bandwidth'),(82,'Hive-Minded'),(83,'Void Dweller'),(84,'Latent Psionic'),(85,'Machine'),(86,'Lithoid'),(87,'Survivor'),(88,'Necrophage'),(89,'Cave Dweller'),(90,'Clone Soldier');
/*!40000 ALTER TABLE `trait` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-28 15:58:52
