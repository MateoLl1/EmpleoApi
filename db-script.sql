-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_app_empleos
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `tbl_empresa`
--

DROP TABLE IF EXISTS `tbl_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_empresa` (
  `em_id` int NOT NULL AUTO_INCREMENT,
  `em_nombre` varchar(100) DEFAULT NULL,
  `em_ruc` varchar(13) DEFAULT NULL,
  `em_owner` varchar(100) DEFAULT NULL,
  `em_descripcion` longtext,
  `em_logo` varchar(100) DEFAULT NULL,
  `em_eslogan` longtext,
  `em_email` varchar(100) DEFAULT NULL,
  `em_password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`em_id`),
  UNIQUE KEY `em_id_UNIQUE` (`em_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_empresa`
--

LOCK TABLES `tbl_empresa` WRITE;
/*!40000 ALTER TABLE `tbl_empresa` DISABLE KEYS */;
INSERT INTO `tbl_empresa` VALUES (1,'Nombre de la Empresa','1234567890123','Nombre del Propietario','Descripción de la empresa','URL del logo','Eslogan de la empresa','email@empresa.com','contraseña'),(2,'Nombre de la Empresa','1234567890123','Nombre del Propietario','Descripción de la empresa','URL del logo','Eslogan de la empresa','email@empresa.com','contraseña'),(3,'Nombre de la Empresa','1234567890123','Nombre del Propietario','Descripción de la empresa','URL del logo','Eslogan de la empresa','email@empresa.com','contraseña'),(5,'Nombre de la Empresa','1234567890123','Nombre del Propietario','Descripción de la empresa','URL del logo','Eslogan de la empresa','email@empresa.com','contraseña'),(6,'Nombre de la Empresa','1234567890123','Nombre del Propietario','Descripción de la empresa','URL del logo','Eslogan de la empresa','email@empresa.com','contraseña'),(7,'Nombre de la Empresa','1234567890123','Nombre del Propietario','Descripción de la empresa','URL del logo','Eslogan de la empresa','email@empresa.com','contraseña'),(9,'Optimsoft','1234567890123','Mateo Llerena','Vende mote','Optimsoft.com','Vendomotebueno','optimsoft@gmail.com','123456');
/*!40000 ALTER TABLE `tbl_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_empresa_provincia`
--

DROP TABLE IF EXISTS `tbl_empresa_provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_empresa_provincia` (
  `em_id` int NOT NULL,
  `prov_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_empresa_has_tbl_provincia_tbl_provincia1_idx` (`prov_id`),
  KEY `fk_tbl_empresa_has_tbl_provincia_tbl_empresa1_idx` (`em_id`),
  CONSTRAINT `fk_tbl_empresa_has_tbl_provincia_tbl_empresa1` FOREIGN KEY (`em_id`) REFERENCES `tbl_empresa` (`em_id`),
  CONSTRAINT `fk_tbl_empresa_has_tbl_provincia_tbl_provincia1` FOREIGN KEY (`prov_id`) REFERENCES `tbl_provincia` (`prov_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_empresa_provincia`
--

LOCK TABLES `tbl_empresa_provincia` WRITE;
/*!40000 ALTER TABLE `tbl_empresa_provincia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_empresa_provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_oferta`
--

DROP TABLE IF EXISTS `tbl_oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_oferta` (
  `ofe_id` int NOT NULL AUTO_INCREMENT,
  `ofe_titulo` varchar(45) DEFAULT NULL,
  `ofe_subtitulo` varchar(100) DEFAULT NULL,
  `ofe_descripcion` longtext,
  `ofe_modalidad` varchar(45) DEFAULT NULL,
  `ofe_ubicacion` varchar(45) DEFAULT NULL,
  `ofe_area` varchar(100) DEFAULT NULL,
  `ofe_tiempo` varchar(45) DEFAULT NULL,
  `ofe_vacantes` int DEFAULT NULL,
  `ofe_experiencia` varchar(45) DEFAULT NULL,
  `ofe_salario` float DEFAULT NULL,
  `ofe_fe_registro` date DEFAULT NULL,
  `ofe_estado` varchar(1) DEFAULT NULL,
  `em_id` int NOT NULL,
  PRIMARY KEY (`ofe_id`),
  UNIQUE KEY `ofe_id_UNIQUE` (`ofe_id`),
  KEY `fk_tbl_oferta_tbl_empresa1_idx` (`em_id`),
  CONSTRAINT `fk_tbl_oferta_tbl_empresa1` FOREIGN KEY (`em_id`) REFERENCES `tbl_empresa` (`em_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_oferta`
--

LOCK TABLES `tbl_oferta` WRITE;
/*!40000 ALTER TABLE `tbl_oferta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_postulaciones`
--

DROP TABLE IF EXISTS `tbl_postulaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_postulaciones` (
  `ofe_id` int NOT NULL,
  `usu_id` int NOT NULL,
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_tbl_oferta_has_tbl_usuarios_tbl_usuarios1_idx` (`usu_id`),
  KEY `fk_tbl_oferta_has_tbl_usuarios_tbl_oferta1_idx` (`ofe_id`),
  CONSTRAINT `fk_tbl_oferta_has_tbl_usuarios_tbl_oferta1` FOREIGN KEY (`ofe_id`) REFERENCES `tbl_oferta` (`ofe_id`),
  CONSTRAINT `fk_tbl_oferta_has_tbl_usuarios_tbl_usuarios1` FOREIGN KEY (`usu_id`) REFERENCES `tbl_usuarios` (`usu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_postulaciones`
--

LOCK TABLES `tbl_postulaciones` WRITE;
/*!40000 ALTER TABLE `tbl_postulaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_postulaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_provincia`
--

DROP TABLE IF EXISTS `tbl_provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_provincia` (
  `prov_id` int NOT NULL AUTO_INCREMENT,
  `prov_nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`prov_id`),
  UNIQUE KEY `prov_id_UNIQUE` (`prov_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_provincia`
--

LOCK TABLES `tbl_provincia` WRITE;
/*!40000 ALTER TABLE `tbl_provincia` DISABLE KEYS */;
INSERT INTO `tbl_provincia` VALUES (1,'Pichincha'),(2,'Guayas'),(4,'Manabi');
/*!40000 ALTER TABLE `tbl_provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tp_usuario`
--

DROP TABLE IF EXISTS `tbl_tp_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tp_usuario` (
  `tp_us_id` int NOT NULL AUTO_INCREMENT,
  `tp_us_descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tp_us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tp_usuario`
--

LOCK TABLES `tbl_tp_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_tp_usuario` DISABLE KEYS */;
INSERT INTO `tbl_tp_usuario` VALUES (5,'Administrador'),(6,'Administrador'),(7,'Uusua');
/*!40000 ALTER TABLE `tbl_tp_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuarios`
--

DROP TABLE IF EXISTS `tbl_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuarios` (
  `usu_id` int NOT NULL AUTO_INCREMENT,
  `usu_nombre` varchar(100) DEFAULT NULL,
  `usu_email` varchar(100) DEFAULT NULL,
  `usu_password` varchar(100) DEFAULT NULL,
  `usu_cedula` varchar(10) DEFAULT NULL,
  `usu_imagen` varchar(100) DEFAULT NULL,
  `usu_fe_nacimiento` date DEFAULT NULL,
  `usu_fe_registro` date DEFAULT NULL,
  `usu_sexo` char(1) DEFAULT NULL,
  `usu_estado` char(1) DEFAULT NULL,
  `tp_us_id` int NOT NULL,
  `prov_id` int NOT NULL,
  PRIMARY KEY (`usu_id`),
  KEY `fk_tbl_usuarios_tbl_tp_usuario_idx` (`tp_us_id`),
  KEY `fk_tbl_usuarios_tbl_provincia1_idx` (`prov_id`),
  CONSTRAINT `fk_tbl_usuarios_tbl_provincia1` FOREIGN KEY (`prov_id`) REFERENCES `tbl_provincia` (`prov_id`),
  CONSTRAINT `fk_tbl_usuarios_tbl_tp_usuario` FOREIGN KEY (`tp_us_id`) REFERENCES `tbl_tp_usuario` (`tp_us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuarios`
--

LOCK TABLES `tbl_usuarios` WRITE;
/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
INSERT INTO `tbl_usuarios` VALUES (2,'Juan Pérez','juan.perez@example.com','securepassword','1234567890','http://example.com/imagen.jpg','1990-01-01','2023-01-01','M','A',5,1),(7,'Mateo','juan.perez@example.com','securepassword','1234567890','http://example.com/imagen.jpg','1990-01-01','2023-01-01','M','A',5,1);
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_app_empleos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-08 20:42:46
