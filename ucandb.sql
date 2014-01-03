CREATE DATABASE  IF NOT EXISTS `ucandb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ucandb`;
-- MySQL dump 10.13  Distrib 5.5.24, for osx10.5 (i386)
--
-- Host: localhost    Database: ucandb
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `equipa`
--

DROP TABLE IF EXISTS `equipa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipa` (
  `codigo_equipa` int(11) NOT NULL AUTO_INCREMENT,
  `nome_equipa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_equipa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipa`
--

LOCK TABLES `equipa` WRITE;
/*!40000 ALTER TABLE `equipa` DISABLE KEYS */;
INSERT INTO `equipa` VALUES (1,'ValTeam'),(2,'AdiTeam');
/*!40000 ALTER TABLE `equipa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipa_funcionario`
--

DROP TABLE IF EXISTS `equipa_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipa_funcionario` (
  `codigo_equipa_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_funcionario` int(11) NOT NULL,
  `codigo_equipa` int(11) NOT NULL,
  PRIMARY KEY (`codigo_equipa_funcionario`,`codigo_funcionario`,`codigo_equipa`),
  KEY `fk_equipa_funcionario_funcionario1_idx` (`codigo_funcionario`),
  KEY `fk_equipa_funcionario_equipa1_idx` (`codigo_equipa`),
  CONSTRAINT `fk_equipa_funcionario_equipa1` FOREIGN KEY (`codigo_equipa`) REFERENCES `equipa` (`codigo_equipa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipa_funcionario_funcionario1` FOREIGN KEY (`codigo_funcionario`) REFERENCES `funcionario` (`codigo_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipa_funcionario`
--

LOCK TABLES `equipa_funcionario` WRITE;
/*!40000 ALTER TABLE `equipa_funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipa_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipa_responsavel`
--

DROP TABLE IF EXISTS `equipa_responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipa_responsavel` (
  `codigo_equipa_responsavel` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_equipa` int(11) NOT NULL,
  `codigo_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`codigo_equipa_responsavel`),
  KEY `fk_equipa_responsavel_equipa1_idx` (`codigo_equipa`),
  KEY `fk_equipa_responsavel_funcionario1_idx` (`codigo_funcionario`),
  CONSTRAINT `fk_equipa_responsavel_equipa1` FOREIGN KEY (`codigo_equipa`) REFERENCES `equipa` (`codigo_equipa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipa_responsavel_funcionario1` FOREIGN KEY (`codigo_funcionario`) REFERENCES `funcionario` (`codigo_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipa_responsavel`
--

LOCK TABLES `equipa_responsavel` WRITE;
/*!40000 ALTER TABLE `equipa_responsavel` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipa_responsavel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `codigo_estado` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Em intervenção'),(2,'Atribuido'),(3,'Transferido'),(4,'Fechado'),(5,'Não atribuido');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_intervencao`
--

DROP TABLE IF EXISTS `estado_intervencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_intervencao` (
  `codigo_estado_intervencao` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_estado_intervencao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_estado_intervencao`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_intervencao`
--

LOCK TABLES `estado_intervencao` WRITE;
/*!40000 ALTER TABLE `estado_intervencao` DISABLE KEYS */;
INSERT INTO `estado_intervencao` VALUES (1,'Por intervir'),(2,'Fechado'),(3,'Intervenção em curso');
/*!40000 ALTER TABLE `estado_intervencao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fecho_ticket`
--

DROP TABLE IF EXISTS `fecho_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fecho_ticket` (
  `codigo_fecho_ticket` int(11) NOT NULL,
  `comentario_fecho_ticket` varchar(45) DEFAULT NULL,
  `data_fecho_ticket` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_fecho_ticket`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fecho_ticket`
--

LOCK TABLES `fecho_ticket` WRITE;
/*!40000 ALTER TABLE `fecho_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `fecho_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_site`
--

DROP TABLE IF EXISTS `foto_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto_site` (
  `codigo_foto_site` int(11) NOT NULL AUTO_INCREMENT,
  `primeira_foto_site` varchar(45) DEFAULT NULL,
  `segunda_foto_site` varchar(45) DEFAULT NULL,
  `terceira_foto_site` varchar(45) DEFAULT NULL,
  `quarta_foto_site` varchar(45) DEFAULT NULL,
  `quinta_foto_Site` varchar(45) DEFAULT NULL,
  `codigo_site` int(11) NOT NULL,
  PRIMARY KEY (`codigo_foto_site`),
  KEY `fk_foto_site_site1_idx` (`codigo_site`),
  CONSTRAINT `fk_foto_site_site1` FOREIGN KEY (`codigo_site`) REFERENCES `site` (`codigo_site`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_site`
--

LOCK TABLES `foto_site` WRITE;
/*!40000 ALTER TABLE `foto_site` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `codigo_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_funcionario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Abelardo Hernani Barros'),(2,'Leonel Costa'),(3,'Vanilson de Brito Lourenço');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impacto`
--

DROP TABLE IF EXISTS `impacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impacto` (
  `codigo_impacto` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_impacto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_impacto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impacto`
--

LOCK TABLES `impacto` WRITE;
/*!40000 ALTER TABLE `impacto` DISABLE KEYS */;
INSERT INTO `impacto` VALUES (1,'Sem impacto nenhum'),(2,'Interrupção do sinal');
/*!40000 ALTER TABLE `impacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intervencao`
--

DROP TABLE IF EXISTS `intervencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao` (
  `codigo_intervencao` int(11) NOT NULL AUTO_INCREMENT,
  `comentario_intervencao` varchar(1000) DEFAULT NULL,
  `data_intervencao` date DEFAULT NULL,
  `codigo_estado_intervencao` int(11) NOT NULL,
  `codigo_equipa` int(11) NOT NULL,
  PRIMARY KEY (`codigo_intervencao`),
  KEY `fk_intervencao_estado_intervencao1_idx` (`codigo_estado_intervencao`),
  KEY `fk_intervencao_equipa1_idx` (`codigo_equipa`),
  CONSTRAINT `fk_intervencao_equipa1` FOREIGN KEY (`codigo_equipa`) REFERENCES `equipa` (`codigo_equipa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_intervencao_estado_intervencao1` FOREIGN KEY (`codigo_estado_intervencao`) REFERENCES `estado_intervencao` (`codigo_estado_intervencao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intervencao`
--

LOCK TABLES `intervencao` WRITE;
/*!40000 ALTER TABLE `intervencao` DISABLE KEYS */;
INSERT INTO `intervencao` VALUES (1,'Lorem ipsum',NULL,1,1),(2,'Facilisis lundium hac tincidunt mattis',NULL,1,1),(3,'Lorem ipsum data da intervenção...','2013-12-10',1,1);
/*!40000 ALTER TABLE `intervencao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prioridade`
--

DROP TABLE IF EXISTS `prioridade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prioridade` (
  `codigo_prioridade` int(11) NOT NULL,
  `tipo_prioridade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_prioridade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prioridade`
--

LOCK TABLES `prioridade` WRITE;
/*!40000 ALTER TABLE `prioridade` DISABLE KEYS */;
INSERT INTO `prioridade` VALUES (1,'P1'),(2,'P2'),(3,'P3');
/*!40000 ALTER TABLE `prioridade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `site` (
  `codigo_site` int(11) NOT NULL AUTO_INCREMENT,
  `nome_site` varchar(45) DEFAULT NULL,
  `codigo_tipo_site` int(11) NOT NULL,
  `latitude` int(11) DEFAULT NULL,
  `longitude` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_site`),
  KEY `fk_site_tipo_site1_idx` (`codigo_tipo_site`),
  CONSTRAINT `fk_site_tipo_site1` FOREIGN KEY (`codigo_tipo_site`) REFERENCES `tipo_site` (`codigo_tipo_site`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES (1,'1 Maio',1,NULL,NULL),(2,'11 Brigada',1,NULL,NULL),(3,'12 Sapú',1,NULL,NULL),(4,'14 Abril',1,NULL,NULL),(5,'21 de janeiro',1,NULL,NULL),(6,'Aeroporto',1,NULL,NULL),(7,'Aeroporto oeste',1,NULL,NULL),(8,'Afrochina',1,NULL,NULL),(9,'Alvalade centro',1,NULL,NULL),(10,'Ambriz',1,NULL,NULL),(11,'Asa branca',1,NULL,NULL),(12,'Aeroporto 4 de Fevereiro',3,NULL,NULL);
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `codigo_ticket` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_ticket` varchar(1000) DEFAULT NULL,
  `data_problema_ticket` date DEFAULT NULL,
  `codigo_estado` int(11) DEFAULT NULL,
  `codigo_prioridade` int(11) DEFAULT NULL,
  `codigo_impacto` int(11) DEFAULT NULL,
  `codigo_site` int(11) DEFAULT NULL,
  `codigo_funcionario` int(11) DEFAULT NULL,
  `codigo_equipa` int(11) DEFAULT NULL,
  `codigo_fecho_ticket` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_ticket`),
  KEY `fk_ticket_estado_idx` (`codigo_estado`),
  KEY `fk_ticket_prioridade1_idx` (`codigo_prioridade`),
  KEY `fk_ticket_impacto1_idx` (`codigo_impacto`),
  KEY `fk_ticket_site1_idx` (`codigo_site`),
  KEY `fk_ticket_funcionario1_idx` (`codigo_funcionario`),
  KEY `fk_ticket_equipa1_idx` (`codigo_equipa`),
  KEY `fk_ticket_fecho_ticket1_idx` (`codigo_fecho_ticket`),
  CONSTRAINT `fk_ticket_equipa1` FOREIGN KEY (`codigo_equipa`) REFERENCES `equipa` (`codigo_equipa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_estado` FOREIGN KEY (`codigo_estado`) REFERENCES `estado` (`codigo_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_fecho_ticket1` FOREIGN KEY (`codigo_fecho_ticket`) REFERENCES `fecho_ticket` (`codigo_fecho_ticket`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_funcionario1` FOREIGN KEY (`codigo_funcionario`) REFERENCES `funcionario` (`codigo_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_impacto1` FOREIGN KEY (`codigo_impacto`) REFERENCES `impacto` (`codigo_impacto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_prioridade1` FOREIGN KEY (`codigo_prioridade`) REFERENCES `prioridade` (`codigo_prioridade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_site1` FOREIGN KEY (`codigo_site`) REFERENCES `site` (`codigo_site`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (22,'Ultricies auctor eu et urna sit in sed, mid ','2013-12-30',2,2,1,3,2,1,NULL),(23,'Duis vel, porttitor tristique a in diam','2013-12-30',3,1,1,1,1,1,NULL),(26,'porttitor tortor, ut non scelerisque\r\n','2013-12-30',5,3,1,1,2,1,NULL),(27,'Magna nisi ac, lorem lundium sit natoque','2013-12-30',4,2,2,5,1,1,NULL),(29,'Tortor rhoncus tincidunt','2013-12-30',2,1,1,2,1,1,NULL),(30,'Vel, proin dapibus nec rhoncus enim! Lectus vel, cursus','2013-12-30',1,3,2,2,3,1,NULL),(31,'Urna elementum in elementum elementum ridiculus','2013-12-30',3,2,2,3,3,1,NULL),(32,'Lorem ipsum data do problema','2013-12-11',1,1,1,1,1,1,NULL);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_site`
--

DROP TABLE IF EXISTS `tipo_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_site` (
  `codigo_tipo_site` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_site` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo_tipo_site`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_site`
--

LOCK TABLES `tipo_site` WRITE;
/*!40000 ALTER TABLE `tipo_site` DISABLE KEYS */;
INSERT INTO `tipo_site` VALUES (1,'Bts'),(2,'Centro de comutação'),(3,'Edificios'),(4,'Lojas');
/*!40000 ALTER TABLE `tipo_site` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-11 15:23:06
