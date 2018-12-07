-- MySQL dump 10.16  Distrib 10.1.33-MariaDB, for Win32 (AMD64)
--
-- Host: noutectyspdf.ddns.net    Database: ferreteriasacme
-- ------------------------------------------------------
-- Server version	10.1.23-MariaDB-9+deb9u1

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
-- Current Database: `ferreteriasacme`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ferreteriasacme` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ferreteriasacme`;

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almacen` (
  `id_almacen` varchar(13) NOT NULL,
  `id_producto` varchar(13) NOT NULL,
  `id_sucursal` varchar(13) NOT NULL,
  `existencias_almacen` int(11) NOT NULL,
  PRIMARY KEY (`id_almacen`) USING BTREE,
  KEY `id_producto_almacen` (`id_producto`) USING BTREE,
  KEY `fk_sucursal_almacen_1` (`id_sucursal`) USING BTREE,
  CONSTRAINT `fk_sucursal_almacen_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`),
  CONSTRAINT `id_producto_almacen` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id_cliente` varchar(13) NOT NULL,
  `nombre_cliente` varchar(50) NOT NULL,
  `apellido_paterno_cliente` varchar(50) NOT NULL,
  `apellido_materno_cliente` varchar(50) NOT NULL,
  `telefono_cliente` varchar(10) NOT NULL,
  `rfc_cliente` varchar(13) NOT NULL,
  `calle_cliente` varchar(50) NOT NULL,
  `colonia_cliente` varchar(50) NOT NULL,
  `numero_exterior_cliente` varchar(5) NOT NULL,
  `numero_interior_cliente` varchar(5) NOT NULL,
  `codigo_postal_cliente` varchar(5) NOT NULL,
  `email_cliente` varchar(255) NOT NULL,
  `ciudad_cliente` varchar(30) NOT NULL,
  `estado_cliente` varchar(30) NOT NULL,
  PRIMARY KEY (`id_cliente`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('ACME-C0000001','Norberto','Paloma','Rodriguez','7751234567','PARL980606HHG','Orquidea','Las Glorias 1','242','12','43700','luis_norberto1998@gmail.com','Tulancingo','Hidalgo'),('ACME-C0000002','Luis Norberto','Flores','Garcia','5526897561','PARL980606HHG','Luis Ponce','La costeña','242','400','43633','norberto@gmail.com','Tulancingo','Veracruz'),('ACME-C0000003','Jocelyn','Flores','Badillo','775754561','FBOJ992201HHM','Enrique Ponce del Villar','El paraiso','5','200','43633','joceLyn@gmail.com','Tulancingo','Hidalgo'),('ACME-C0000004','Samuel','Trejo','Espindola','7756771656','TEIS950908HHG','Rojo gomez','La Guadalupe','0','178','43626','surysar@gmail.com','Pachuquilla','Hidalgo'),('ACME-C0000005','Luis','Garcia','Flores','7758925641','LUIB58255','Morelos','Paraiso','1520','32','43635','luis@gmail.com','Tulancingo','Hidalgo');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `id_compra` varchar(13) NOT NULL,
  `fecha_compra` varchar(15) NOT NULL,
  `id_empleado` varchar(13) NOT NULL,
  `id_proveedor` varchar(13) NOT NULL,
  `total_compra` double(15,2) DEFAULT NULL,
  PRIMARY KEY (`id_compra`) USING BTREE,
  KEY `fk_empleados_compras_1` (`id_empleado`) USING BTREE,
  KEY `fk_proveedores_compras_1` (`id_proveedor`) USING BTREE,
  CONSTRAINT `fk_empleados_compras_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  CONSTRAINT `fk_proveedores_compras_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compras_productos`
--

DROP TABLE IF EXISTS `detalle_compras_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_compras_productos` (
  `id_detalle_compras_productos` varchar(13) NOT NULL,
  `id_compra` varchar(13) NOT NULL,
  `id_producto` varchar(13) NOT NULL,
  `cantidad_producto_compra` int(11) NOT NULL,
  `subtotal_compra` double NOT NULL,
  `total_compra` double NOT NULL,
  PRIMARY KEY (`id_detalle_compras_productos`) USING BTREE,
  KEY `fk_compras_detalle_compras_productos_1` (`id_compra`) USING BTREE,
  KEY `fk_productos_detalle_compras_productos_1` (`id_producto`) USING BTREE,
  CONSTRAINT `fk_compras_detalle_compras_productos_1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `fk_productos_detalle_compras_productos_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compras_productos`
--

LOCK TABLES `detalle_compras_productos` WRITE;
/*!40000 ALTER TABLE `detalle_compras_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_compras_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ventas_producto`
--

DROP TABLE IF EXISTS `detalle_ventas_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_ventas_producto` (
  `id_detalle_venta_producto` varchar(13) NOT NULL,
  `id_ventas` varchar(13) NOT NULL,
  `id_producto` varchar(13) NOT NULL,
  `cantidad_producto_vendido` int(11) NOT NULL,
  `precio_venta_producto` double(12,2) NOT NULL,
  `total_venta_producto` double(12,2) NOT NULL,
  PRIMARY KEY (`id_detalle_venta_producto`) USING BTREE,
  KEY `fk_ventas_detalle_compra_producto_1` (`id_ventas`) USING BTREE,
  KEY `fk_productos_detalle_compra_producto_1` (`id_producto`) USING BTREE,
  CONSTRAINT `fk_productos_detalle_compra_producto_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  CONSTRAINT `fk_ventas_detalle_compra_producto_1` FOREIGN KEY (`id_ventas`) REFERENCES `ventas` (`id_ventas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ventas_producto`
--

LOCK TABLES `detalle_ventas_producto` WRITE;
/*!40000 ALTER TABLE `detalle_ventas_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_ventas_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `id_empleado` varchar(13) NOT NULL,
  `nombre_empleado` varchar(50) NOT NULL,
  `apellido_paterno_empleado` varchar(50) NOT NULL,
  `apellido_materno_empleado` varchar(50) NOT NULL,
  `calle_empleado` varchar(50) NOT NULL,
  `colonia_empleado` varchar(50) NOT NULL,
  `numero_exterior_empleado` varchar(5) NOT NULL,
  `numero_interior_empleado` varchar(5) NOT NULL,
  `rfc_empleado` varchar(15) NOT NULL,
  `telefono_empleado` varchar(10) NOT NULL,
  `curp_empleado` char(18) NOT NULL,
  `numero_cuenta_empleado` varchar(18) NOT NULL,
  `nss_empleado` varchar(11) NOT NULL,
  `banco_empleado` varchar(50) NOT NULL,
  `tipo_empleado` varchar(255) NOT NULL,
  `usuario_empleado` varchar(50) NOT NULL,
  `contrasena_empleado` varchar(100) NOT NULL,
  `id_sucursal` varchar(13) NOT NULL,
  `cp_empleado` varchar(5) NOT NULL,
  PRIMARY KEY (`id_empleado`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES ('1','Luis','Paloma','Rodriguez','Orquidea','Las Glorias','242','0','PARL980606HHG','7751234567','PARL980606HHGLDS04','12345','675645','Santander','Administrador','Luis1998','123','1','43700');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id_producto` varchar(13) NOT NULL,
  `nombre_producto` varchar(100) NOT NULL,
  `tipo_producto` varchar(30) NOT NULL,
  `descripcion_producto` varchar(255) NOT NULL,
  `marca_producto` varchar(30) NOT NULL,
  `precio_venta_producto` double(13,2) NOT NULL,
  PRIMARY KEY (`id_producto`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('1','Martillo Amarillo','Herramienta','60 cm de largo, mango de metal','Truper',200.00),('2','Pala ','Herramienta','1 metro de largo, mango de plastico','Truper',150.00);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `id_proveedor` varchar(13) NOT NULL,
  `nombre_proveedor` varchar(50) NOT NULL,
  `calle_proveedor` varchar(50) NOT NULL,
  `numero_exterior_proveedor` int(5) NOT NULL,
  `colonia_proveedor` varchar(50) NOT NULL,
  `codigo_postal_proveedor` int(5) NOT NULL,
  `telefono_proveedor` varchar(10) NOT NULL,
  `email_proveedor` varchar(255) NOT NULL,
  `ciudad_proveedor` varchar(50) NOT NULL,
  `estado_proveedor` varchar(50) NOT NULL,
  PRIMARY KEY (`id_proveedor`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('ACME-P0000001','Jocelyn','Enrique Ponce',32,'Industrial',43638,'7757824651','jocelyn@gmail.com','Hidalgo','Tulancingo');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id_sucursal` varchar(13) NOT NULL,
  `nombre_sucursal` varchar(50) NOT NULL,
  `calle_sucursal` varchar(50) NOT NULL,
  `colonia_sucursal` varchar(50) NOT NULL,
  `numero_sucursal` varchar(50) NOT NULL,
  `ciudad_sucursal` varchar(50) NOT NULL,
  `telefono_sucursal` varchar(50) NOT NULL,
  `codigo_postal_sucursal` varchar(5) NOT NULL,
  PRIMARY KEY (`id_sucursal`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES ('1','ACME TULANCINGO','Riva Palacio','Centro','200','Tulancingo','5567688','43680'),('2','ACME TULANCINGO','Cañada','Cañada','300','Tulancingo','5567688','43670');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `id_ventas` varchar(13) NOT NULL,
  `id_cliente` varchar(13) NOT NULL,
  `id_empleado` varchar(13) NOT NULL,
  `fecha_venta` varchar(15) NOT NULL,
  `total_venta` double(15,0) NOT NULL,
  PRIMARY KEY (`id_ventas`) USING BTREE,
  KEY `fk_clientes_ventas_1` (`id_cliente`) USING BTREE,
  KEY `fk_empleados_ventas_1` (`id_empleado`) USING BTREE,
  CONSTRAINT `fk_clientes_ventas_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `fk_empleados_ventas_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-06 18:51:04
