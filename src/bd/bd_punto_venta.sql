CREATE DATABASE ferreteriasacme;
USE ferreteriasacme;

CREATE TABLE `empleados` (
`id_empleado` varchar(13) NOT NULL ,
`nombre_empleado` varchar(50) NOT NULL,
`apellido_paterno_empleado` varchar(50) NOT NULL,
`apellido_materno_empleado` varchar(50) NOT NULL,
`calle_empleado` varchar(50) NOT NULL,
`colonia_empleado` varchar(50) NOT NULL,
`numero_exterior_empleado` varchar(5) NOT NULL,
`numero_interior_empleado` varchar(5) NOT NULL,
`rfc_empleado` varchar(15) NOT NULL,
`telefono_empleado` varchar(10) NOT NULL,
`crup_empleado` char(18) NOT NULL,
`numero_cuenta_empleado` varchar(18) NOT NULL,
`nss_empleado` varchar(11) NOT NULL,
`banco_empleado` varchar(50) NOT NULL,
`tipo_empleado` varchar(255) NOT NULL,
`usuario_empleado` varchar(50) NOT NULL,
`contraseña_empleado` varchar(100) NOT NULL,
`id_sucursal` varchar(255) NOT NULL,
`cp_empleado` varchar(5) NOT NULL,
PRIMARY KEY (`id_empleado`) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `clientes` (
`id_cliente` varchar(50) NOT NULL,
`nombre_cliente` varchar(50) NOT NULL,
`apellido_paterno_cliente` varchar(50) NOT NULL,
`apellido_materno_cliente` varchar(50) NOT NULL,
`telefono_cliente` varchar(10) NOT NULL,
`rfc_cliente` varchar(13) NOT NULL,
`calle_cliente` varchar(50) NOT NULL,
`colonia_cliente` varchar(50) NOT NULL,
`numero_exterior_cliente` int(5) NOT NULL,
`numero_interior_cliente` int(5) NOT NULL,
`codigo_postal_cliente` int(5) NOT NULL,
`email_cliente` varchar(255) NOT NULL,
`ciudad_cliente` varchar(30) NOT NULL,
`estado_cliente` varchar(30) NULL,
PRIMARY KEY (`id_cliente`) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `proveedores` (
`id_proveedor` varchar(13) NOT NULL,
`nombre_proveedor` varchar(50) NOT NULL,
`calle_proveedor` varchar(50) NOT NULL,
`numero_exterior_proveedor` int(5) NOT NULL,
`colonia_proveedor` varchar(50) NOT NULL,
`codigo_postal_proveedor` int(5) NOT NULL,
`telefono_proveedor` varchar(10) NOT NULL,
`email_proveedor` varchar(255) NOT NULL,
PRIMARY KEY (`id_proveedor`) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `productos` (
`id_producto` varchar(13) NOT NULL,
`nombre_producto` varchar(100) NOT NULL,
`tipo_producto` varchar(30) NOT NULL,
`descripcion_producto` varchar(255) NOT NULL,
`marca_producto` varchar(30) NOT NULL,
PRIMARY KEY (`id_producto`) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `almacen` (
`id_almacen` varchar(13) NOT NULL,
`id_producto` varchar(13) NOT NULL,
`id_sucursal` varchar(13) NOT NULL,
`existencias_almacen` int(11) NOT NULL,
PRIMARY KEY (`id_almacen`) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sucursal` (
`id_sucursal` varchar(13) NOT NULL,
`nombre_sucursal` varchar(50) NOT NULL,
`calle_sucursal` varchar(50) NOT NULL,
`colonia_sucursal` varchar(50) NOT NULL,
`numero_sucursal` varchar(50) NOT NULL,
`ciudad_sucursal` varchar(50) NOT NULL,
`telefono_sucursal` varchar(50) NOT NULL,
PRIMARY KEY (`id_sucursal`) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `compras` (
`id_compra` varchar(13) NOT NULL,
`fecha_compra` varchar(15) NOT NULL,
`id_empleado` varchar(13) NOT NULL,
`id_proveedor` varchar(13) NOT NULL,
`total_compra` double(15,2) NULL,
PRIMARY KEY (`id_compra`) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `detalle_compras_productos` (
`id_detalle_compras_productos` varchar(13) NOT NULL,
`id_compra` varchar(13) NOT NULL,
`id_producto` varchar(13) NOT NULL,
`cantidad_producto_compra` int(11) NOT NULL,
`subtotal_compra` double NOT NULL,
`total_compra` double NOT NULL,
PRIMARY KEY(`id_detalle_compras_productos`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ventas` (
`id_ventas` varchar(13) NOT NULL,
`id_cliente` varchar(13) NOT NULL,
`id_empleado` varchar(13) NOT NULL,
`fecha_venta` varchar(15) NOT NULL,
`total_venta` double(15,0) NOT NULL,
PRIMARY KEY(`id_ventas`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `detalle_compra_producto` (
`id_detalle_compra_producto` varchar(13) NOT NULL,
`id_ventas` varchar(13) NOT NULL,
`id_producto` varchar(13) NOT NULL,
`cantidad_producto_vendido` int(11) NOT NULL,
`precio_venta_producto` double(12,2) NOT NULL,
`total_venta_producto` double(12,2) NOT NULL,
PRIMARY KEY (`id_detalle_compra_producto`) 
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `almacen` ADD CONSTRAINT `id_producto_almacen` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);
ALTER TABLE `almacen` ADD CONSTRAINT `fk_sucursal_almacen_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`);
ALTER TABLE `detalle_compras_productos` ADD CONSTRAINT `fk_compras_detalle_compras_productos_1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`);
ALTER TABLE `detalle_compras_productos` ADD CONSTRAINT `fk_productos_detalle_compras_productos_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);
ALTER TABLE `compras` ADD CONSTRAINT `fk_empleados_compras_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`);
ALTER TABLE `ventas` ADD CONSTRAINT `fk_clientes_ventas_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);
ALTER TABLE `ventas` ADD CONSTRAINT `fk_empleados_ventas_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`);
ALTER TABLE `detalle_compra_producto` ADD CONSTRAINT `fk_ventas_detalle_compra_producto_1` FOREIGN KEY (`id_ventas`) REFERENCES `ventas` (`id_ventas`);
ALTER TABLE `detalle_compra_producto` ADD CONSTRAINT `fk_productos_detalle_compra_producto_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);
ALTER TABLE `compras` ADD CONSTRAINT `fk_proveedores_compras_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`);

CREATE USER 'dagasoft'@'localhost' IDENTIFIED BY 'ferreteriasacme';
GRANT ALL PRIVILEGES ON ferreteriasacme.* TO 'dagasoft'@'localhost';
FLUSH PRIVILEGES;

