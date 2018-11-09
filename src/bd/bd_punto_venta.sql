/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : ferreteriasacme

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 09/11/2018 08:28:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE ferreteriasacme;
USE ferreteriasacme;

-- ----------------------------
-- Table structure for almacen
-- ----------------------------
DROP TABLE IF EXISTS `almacen`;
CREATE TABLE `almacen`  (
  `id_almacen` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_producto` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_sucursal` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `existencias_almacen` int(11) NOT NULL,
  PRIMARY KEY (`id_almacen`) USING BTREE,
  INDEX `id_producto_almacen`(`id_producto`) USING BTREE,
  INDEX `fk_sucursal_almacen_1`(`id_sucursal`) USING BTREE,
  CONSTRAINT `fk_sucursal_almacen_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_producto_almacen` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for clientes
-- ----------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes`  (
  `id_cliente` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nombre_cliente` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `apellido_paterno_cliente` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `apellido_materno_cliente` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `telefono_cliente` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `rfc_cliente` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `calle_cliente` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `colonia_cliente` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `numero_exterior_cliente` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `numero_interior_cliente` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `codigo_postal_cliente` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `email_cliente` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `ciudad_cliente` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `estado_cliente` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id_cliente`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of clientes
-- ----------------------------
INSERT INTO `clientes` VALUES ('1', 'Norberto', 'Paloma', 'Rodriguez', '7751234567', 'PARL980606HHG', 'Orquidea', 'Las Glorias 1', '12', '242', '43700', 'luis_norberto1998@gmail.com', 'Tulancingo', 'Hidalgo');
INSERT INTO `clientes` VALUES ('2', 'Norberto', 'Paloma', 'Rodriguez', '7751234567', '7751234567', 'Orquidea', 'Las Glorias 1', '242', '242', '43700', 'norberto@gmail.com', 'Tulancingo', 'Hidalgo');

-- ----------------------------
-- Table structure for compras
-- ----------------------------
DROP TABLE IF EXISTS `compras`;
CREATE TABLE `compras`  (
  `id_compra` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `fecha_compra` varchar(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_empleado` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_proveedor` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `total_compra` double(15, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id_compra`) USING BTREE,
  INDEX `fk_empleados_compras_1`(`id_empleado`) USING BTREE,
  INDEX `fk_proveedores_compras_1`(`id_proveedor`) USING BTREE,
  CONSTRAINT `fk_proveedores_compras_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_empleados_compras_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for detalle_compra_producto
-- ----------------------------
DROP TABLE IF EXISTS `detalle_compra_producto`;
CREATE TABLE `detalle_compra_producto`  (
  `id_detalle_compra_producto` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_ventas` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_producto` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `cantidad_producto_vendido` int(11) NOT NULL,
  `precio_venta_producto` double(12, 2) NOT NULL,
  `total_venta_producto` double(12, 2) NOT NULL,
  PRIMARY KEY (`id_detalle_compra_producto`) USING BTREE,
  INDEX `fk_ventas_detalle_compra_producto_1`(`id_ventas`) USING BTREE,
  INDEX `fk_productos_detalle_compra_producto_1`(`id_producto`) USING BTREE,
  CONSTRAINT `fk_productos_detalle_compra_producto_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ventas_detalle_compra_producto_1` FOREIGN KEY (`id_ventas`) REFERENCES `ventas` (`id_ventas`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for detalle_compras_productos
-- ----------------------------
DROP TABLE IF EXISTS `detalle_compras_productos`;
CREATE TABLE `detalle_compras_productos`  (
  `id_detalle_compras_productos` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_compra` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_producto` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `cantidad_producto_compra` int(11) NOT NULL,
  `subtotal_compra` double NOT NULL,
  `total_compra` double NOT NULL,
  PRIMARY KEY (`id_detalle_compras_productos`) USING BTREE,
  INDEX `fk_compras_detalle_compras_productos_1`(`id_compra`) USING BTREE,
  INDEX `fk_productos_detalle_compras_productos_1`(`id_producto`) USING BTREE,
  CONSTRAINT `fk_productos_detalle_compras_productos_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_compras_detalle_compras_productos_1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for empleados
-- ----------------------------
DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados`  (
  `id_empleado` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nombre_empleado` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `apellido_paterno_empleado` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `apellido_materno_empleado` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `calle_empleado` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `colonia_empleado` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `numero_exterior_empleado` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `numero_interior_empleado` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `rfc_empleado` varchar(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `telefono_empleado` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `crup_empleado` char(18) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `numero_cuenta_empleado` varchar(18) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nss_empleado` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `banco_empleado` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `tipo_empleado` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `usuario_empleado` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `contraseña_empleado` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_sucursal` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `cp_empleado` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id_empleado`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for productos
-- ----------------------------
DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos`  (
  `id_producto` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nombre_producto` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `tipo_producto` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `descripcion_producto` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `marca_producto` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id_producto`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for proveedores
-- ----------------------------
DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE `proveedores`  (
  `id_proveedor` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nombre_proveedor` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `calle_proveedor` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `numero_exterior_proveedor` int(5) NOT NULL,
  `colonia_proveedor` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `codigo_postal_proveedor` int(5) NOT NULL,
  `telefono_proveedor` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `email_proveedor` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `ciudad_proveedor` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `estado_proveedor` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id_proveedor`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sucursal
-- ----------------------------
DROP TABLE IF EXISTS `sucursal`;
CREATE TABLE `sucursal`  (
  `id_sucursal` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nombre_sucursal` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `calle_sucursal` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `colonia_sucursal` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `numero_sucursal` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `ciudad_sucursal` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `telefono_sucursal` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id_sucursal`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ventas
-- ----------------------------
DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas`  (
  `id_ventas` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_cliente` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_empleado` varchar(13) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `fecha_venta` varchar(15) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `total_venta` double(15, 0) NOT NULL,
  PRIMARY KEY (`id_ventas`) USING BTREE,
  INDEX `fk_clientes_ventas_1`(`id_cliente`) USING BTREE,
  INDEX `fk_empleados_ventas_1`(`id_empleado`) USING BTREE,
  CONSTRAINT `fk_empleados_ventas_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_clientes_ventas_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

CREATE USER 'dagasoft'@'localhost' IDENTIFIED BY 'ferreteriasacme';
GRANT ALL PRIVILEGES ON ferreteriasacme.* TO 'dagasoft'@'localhost';
FLUSH PRIVILEGES;

