-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: dblimet
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

-- /*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
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
-- Table structure for table `JOUEUR`
--


/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JOUEUR`
--

/*!40000 ALTER TABLE `JOUEUR` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
-- /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-13 22:30:06
-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: dblimet
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

-- /*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
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
-- Table structure for table `MESSAGE`
--
DROP TABLE IF EXISTS JOUEUR;
DROP TABLE IF EXISTS `MESSAGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MESSAGE` (
  `idMsg` decimal(6,0) NOT NULL,
  `dateMsg` datetime DEFAULT NULL,
  `contenuMsg` text,
  `luMsg` char(1) DEFAULT NULL,
  `idUt1` decimal(6,0) DEFAULT NULL,
  `idUt2` decimal(6,0) DEFAULT NULL,
  PRIMARY KEY (`idMsg`),
  KEY `idUt1` (`idUt1`),
  KEY `idUt2` (`idUt2`),
  CONSTRAINT `MESSAGE_ibfk_1` FOREIGN KEY (`idUt1`) REFERENCES `JOUEUR` (idJo),
  CONSTRAINT `MESSAGE_ibfk_2` FOREIGN KEY (`idUt2`) REFERENCES `JOUEUR` (idJo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MESSAGE`
--

LOCK TABLES `MESSAGE` WRITE;
/*!40000 ALTER TABLE `MESSAGE` DISABLE KEYS */;
INSERT INTO `MESSAGE` VALUES (1,'2018-05-12 10:12:00','bla bla1','N',1,2),(2,'2018-05-12 10:12:12','bla bla2','N',1,2),(3,'2018-05-12 10:12:07','bla bla3','N',1,2),(4,'2018-05-12 10:12:18','bla bla4','N',2,1),(5,'2018-05-09 11:12:00','bla bla5','N',2,1),(6,'2018-05-09 10:24:00','bla bla6','N',3,2),(7,'2018-05-09 10:24:00','bla bla7','N',3,2),(8,'2018-05-09 10:25:05','bla bla8','N',4,1),(9,'2018-05-10 10:13:06','bla bla9','N',4,2),(10,'2018-05-10 10:12:07','bla bla10','N',5,4),(11,'2018-05-10 10:12:08','bla bla11','N',5,4),(12,'2018-05-11 12:12:10','bla bla12','N',5,1),(13,'2018-05-11 10:10:00','bla bla13','N',5,3),(14,'2018-05-11 10:12:00','bla bla14','N',1,4),(15,'2018-05-11 10:13:00','bla bla15','N',1,4),(16,'2018-05-11 10:15:00','bla bla16','N',4,2),(17,'2018-05-11 10:14:00','bla bla17','N',2,3);
/*!40000 ALTER TABLE `MESSAGE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-13 22:30:21


-- Ligne à décommanter si vous avez les droits pour créer une nouvelle base de données
-- CREATE DATABASE IF NOT EXISTS serveurDeJeux DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- USE serveurDeJeux;

DROP TABLE IF EXISTS ETREAMI;

CREATE TABLE ETREAMI (
  idJo decimal(6,0),
  idJo1 decimal(6,0),
  PRIMARY KEY (idJo, idJo1)
);


CREATE TABLE JOUEUR (
  idJo decimal(6,0) NOT NULL,
  pseudo varchar(16) DEFAULT NULL,
  motdepasse varchar(500) DEFAULT NULL,
  sexe char(1) DEFAULT NULL,
  abonne char(1) DEFAULT NULL,
  niveau decimal(1,0) DEFAULT NULL,
  avatar longblob,
  emailJo varchar(100) DEFAULT NULL,
  activeJo char(1) DEFAULT NULL,
  admin char(1) DEFAULT NULL,
  PRIMARY KEY (idJo),
  UNIQUE KEY idJo (idJo),
  UNIQUE KEY pseudo (pseudo),
  UNIQUE KEY emailJo (emailJo)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS RAPPORT;
CREATE TABLE RAPPORT (
  idRapport decimal(6,0),
  dateRapport varchar(40),
  titreRapport varchar(100),
  sujetRapport decimal(65),
  contenuRapport text,
  idJo decimal(6,0),
  PRIMARY KEY (idRapport)
);

DROP TABLE IF EXISTS INVITATION;

CREATE TABLE INVITATION (
  idInv decimal(6,0),
  dateInv datetime,
  etatInv char(1),
  idJo decimal(6,0),
  idJo1 decimal(6,0),
  idJeu decimal(6,0),
  PRIMARY KEY (idInv)
);

DROP TABLE IF EXISTS PARTIE;

CREATE TABLE PARTIE (
  idPa decimal(6,0),
  debutPa datetime,
  numEtape decimal(1,0),
  etatPartie text,
  idJeu decimal(6,0),
  idJo1 decimal(6,0),
  score1 decimal(6,0),
  idJo2 decimal(6,0),
  score2 decimal(6,0),
  PRIMARY KEY (idPa)
);

DROP TABLE IF EXISTS JEU;

CREATE TABLE JEU (
  idJeu decimal(6,0),
  nomJeu varchar(20),
  regleJeu text,
  jarJeu longblob,
  activeJeu char(1),
  idTy decimal(6,0),
  PRIMARY KEY (idJeu)
);

DROP TABLE IF EXISTS TYPEJEU;

CREATE TABLE TYPEJEU (
  idTy decimal(6,0),
  nomTy varchar(20),
  PRIMARY KEY (idTy)
);

ALTER TABLE ETREAMI ADD FOREIGN KEY (idJo1) REFERENCES JOUEUR (idJo);
ALTER TABLE ETREAMI ADD FOREIGN KEY (idJo) REFERENCES JOUEUR (idJo);
ALTER TABLE PARTIE ADD FOREIGN KEY (idJo1) REFERENCES JOUEUR (idJo);
ALTER TABLE PARTIE ADD FOREIGN KEY (idJo2) REFERENCES JOUEUR (idJo);
ALTER TABLE PARTIE ADD FOREIGN KEY (idJeu) REFERENCES JEU (idJeu);
ALTER TABLE INVITATION ADD FOREIGN KEY (idJo1) REFERENCES JOUEUR (idJo);
ALTER TABLE INVITATION ADD FOREIGN KEY (idJo) REFERENCES JOUEUR (idJo);
ALTER TABLE INVITATION ADD FOREIGN KEY (idJeu) REFERENCES JEU (idJeu);
-- ALTER TABLE JEU ADD FOREIGN KEY (idTy) REFERENCES TYPEJEU (idTy);

INSERT INTO JOUEUR VALUES (1,'mario','mario','M','O',1,'�PNG�','mario@gmail.com','O', 'O');
insert into TYPEJEU VALUES (1, 'test');
insert into RAPPORT values(1, '2018-05-11 10:04:18', 'titre rapport', 1, 'contenu raport', 1);
