-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: db_app_empleos
-- ------------------------------------------------------
-- Server version	8.0.36

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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_empresa`
--

LOCK TABLES `tbl_empresa` WRITE;
/*!40000 ALTER TABLE `tbl_empresa` DISABLE KEYS */;
INSERT INTO `tbl_empresa` VALUES (10,'Tech Innovators','0987654321098','Ana García','Empresa líder en innovación tecnológica.','https://th.bing.com/th/id/OIP.MSyoDF9yrNXyX1DDxi6TxgHaE6?rs=1&pid=ImgDetMain','Innovación y tecnología a tu alcance','contacto@techinnovators.com','password123'),(11,'Eco Solutions','1122334455667','Carlos Romero','Soluciones ecológicas para un mejor mañana.','https://th.bing.com/th/id/OIP.MSyoDF9yrNXyX1DDxi6TxgHaE6?rs=1&pid=ImgDetMain','Tu aliado en sostenibilidad','info@ecosolutions.com','eco12345'),(12,'HealthCare Plus','2233445566778','Laura Martínez','Proveemos servicios de salud de alta calidad.','https://th.bing.com/th/id/OIP.MSyoDF9yrNXyX1DDxi6TxgHaE6?rs=1&pid=ImgDetMain','Cuidamos de ti','contact@healthcareplus.com','healthcare2023'),(13,'Global Logistics','3344556677889','Miguel Torres','Servicios de logística y transporte a nivel mundial.','https://th.bing.com/th/id/OIP.MSyoDF9yrNXyX1DDxi6TxgHaE6?rs=1&pid=ImgDetMain','Moviendo el mundo','support@globallogistics.com','logistics789'),(14,'EducaTech','4455667788990','Sofía Hernández','Desarrollo de soluciones educativas digitales.','https://th.bing.com/th/id/OIP.MSyoDF9yrNXyX1DDxi6TxgHaE6?rs=1&pid=ImgDetMain','Educación para el futuro','hello@educatech.com','educatech123'),(35,'Optimsoft','1234567897001','Marco Guayasamin','Una empresa de TI','https://th.bing.com/th/id/OIP.MSyoDF9yrNXyX1DDxi6TxgHaE6?rs=1&pid=ImgDetMain','Lo mejor es para ti','optimsoft@gmail.com','1234567897001'),(36,'MacDonalds','1234567890001','Ronald Macdonald','McDonald\'s es una de las cadenas de restaurantes de comida rápida más grandes y reconocidas del mundo. Fundada en 1940 en San Bernardino, California, por los hermanos Richard y Maurice McDonald, la empresa ha crecido exponencialmente y hoy en día tiene presencia en más de 100 países con miles de restaurantes.','https://i.ibb.co/hCyk37f/upload.jpg','I\'m lovin\' it','macdonal@gmail.com','1234567890001');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_provincia`
--

LOCK TABLES `tbl_provincia` WRITE;
/*!40000 ALTER TABLE `tbl_provincia` DISABLE KEYS */;
INSERT INTO `tbl_provincia` VALUES (1,'Pichincha'),(2,'Guayas'),(4,'Manabi'),(13,'Azuay'),(14,'Bolívar'),(15,'Cañar'),(16,'Carchi'),(17,'Chimborazo'),(18,'Cotopaxi'),(19,'El Oro'),(20,'Esmeraldas'),(21,'Galápagos'),(22,'Imbabura'),(23,'Loja'),(24,'Los Ríos'),(25,'Morona Santiago'),(26,'Napo'),(27,'Orellana'),(28,'Pastaza'),(29,'Santa Elena'),(30,'Santo Domingo de los Tsáchilas'),(31,'Sucumbíos'),(32,'Tungurahua'),(33,'Zamora Chinchipe');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tp_usuario`
--

LOCK TABLES `tbl_tp_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_tp_usuario` DISABLE KEYS */;
INSERT INTO `tbl_tp_usuario` VALUES (1,'Administrador'),(2,'Usuario');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuarios`
--

LOCK TABLES `tbl_usuarios` WRITE;
/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
INSERT INTO `tbl_usuarios` VALUES (15,'Mateo Llerena','mateollerena40@gmail.com','123','1755136510','https://www.nicepng.com/png/full/128-1280406_user-icon-png.png',NULL,'2024-08-09','?','A',1,1),(16,'Carlos Quiña','carlos@gmail.com','1755136510','1755136510','https://i.ibb.co/dKK7VF9/upload.jpg','2024-08-03','2024-08-09','M','A',2,2);
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-11 22:13:31
