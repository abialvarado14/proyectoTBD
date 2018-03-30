-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 30-03-2018 a las 05:00:13
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectotbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `nombreCliente` varchar(20) DEFAULT NULL,
  `apellidoCliente` varchar(20) DEFAULT NULL,
  `rtnCliente` int(11) DEFAULT NULL,
  `telefonoCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Disparadores `clientes`
--
DELIMITER $$
CREATE TRIGGER `ACTUALIZA_CLIENTES_BU` BEFORE UPDATE ON `clientes` FOR EACH ROW INSERT INTO clientes_actualizados(anteriorIdCliente, anteriorNombreCliente, anteriorApellidoCliente, anteriorRtnCliente, anteriorTelefonoCliente, nuevoIdCliente, nuevoNombreCliente, nuevoApellidoCliente, nuevoRtnCliente, nuevoTelefonoCliente, usuario, fechaModificacion)
VALUES(OLD.idCliente, OLD.nombreCliente, OLD.apellidoCliente, OLD.rtnCliente, OLD.telefonoCliente, NEW.idCliente, NEW.nombreCliente, NEW.apellidoCliente, NEW.rtnCliente, NEW.telefonoCliente, CURRENT_USER(), NOW())
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `CLIENTES_AD` AFTER DELETE ON `clientes` FOR EACH ROW INSERT INTO reg_clientes(idCliente, nombreCliente, apellidoCliente, rtnCliente, telefonoCliente) VALUES(OLD.idCliente, OLD.nombreCliente, OLD.apellidoCliente, OLD.rtnCliente, OLD.telefonoCliente)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes_actualizados`
--

CREATE TABLE `clientes_actualizados` (
  `anteriorIdCliente` int(11) NOT NULL,
  `anteriorNombreCliente` varchar(20) DEFAULT NULL,
  `anteriorApellidoCliente` varchar(20) DEFAULT NULL,
  `anteriorRtnCliente` int(11) DEFAULT NULL,
  `anteriorTelefonoCliente` int(11) DEFAULT NULL,
  `nuevoidCliente` int(11) NOT NULL,
  `nuevoNombreCliente` varchar(20) DEFAULT NULL,
  `nuevoApellidoCliente` varchar(20) DEFAULT NULL,
  `nuevoRtnCliente` int(11) DEFAULT NULL,
  `nuevoTelefonoCliente` int(11) DEFAULT NULL,
  `usuario` varchar(20) NOT NULL,
  `fechaModificacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `idEmpleado` int(11) NOT NULL,
  `nombreEmpleado` varchar(20) DEFAULT NULL,
  `apellidoEmpleado` varchar(20) DEFAULT NULL,
  `usuario` varchar(20) NOT NULL,
  `salario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Disparadores `empleados`
--
DELIMITER $$
CREATE TRIGGER `ACTUALIZA_EMPLEADOS_BU` BEFORE UPDATE ON `empleados` FOR EACH ROW INSERT INTO empleados_actualizados(anteriorIdEmpleado, anteriorNombreEmpleado, anteriorApellidoEmpleado, anteriorUsuario, anteriorSalario, nuevoIdEmpleado, nuevoNombreEmpleado, nuevoApellidoEmpleado, nuevoUsuario, nuevoSalario, usuarioEditor, fechaModificacion)
VALUES(OLD.idEmpleado, OLD.nombreEmpleado, OLD.apellidoEmpleado, OLD.usuario, OLD.salario, NEW.idEmpleado, NEW.nombreEmpleado, NEW.apellidoEmpleado, NEW.usuario, NEW.salario, CURRENT_USER(), NOW())
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `EMPLEADOS_AD` AFTER DELETE ON `empleados` FOR EACH ROW INSERT INTO reg_empleados(idEmpleado, nombreEmpleado, apellidoEmpleado, usuario, salario)
VALUES(OLD.idEmpleado, OLD.nombreEmpleado, OLD.apellidoEmpleado, OLD.usuario, OLD.salario)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados_actualizados`
--

CREATE TABLE `empleados_actualizados` (
  `anteriorIdEmpleado` int(11) NOT NULL,
  `anteriorNombreEmpleado` varchar(20) DEFAULT NULL,
  `anteriorApellidoEmpleado` varchar(20) DEFAULT NULL,
  `anteriorUsuario` varchar(20) NOT NULL,
  `anteriorSalario` float NOT NULL,
  `nuevoIdEmpleado` int(11) NOT NULL,
  `nuevoNombreEmpleado` varchar(20) DEFAULT NULL,
  `nuevoApellidoEmpleado` varchar(20) DEFAULT NULL,
  `nuevoUsuario` varchar(20) NOT NULL,
  `nuevoSalario` float NOT NULL,
  `usuarioEditor` varchar(20) NOT NULL,
  `fechaModificacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `codigoFactura` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `rtnCliente` int(11) DEFAULT NULL,
  `nombreCliente` varchar(20) DEFAULT NULL,
  `apellidoCliente` varchar(20) DEFAULT NULL,
  `cantidadProductos` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigoProducto` int(11) NOT NULL,
  `codigoProveedor` int(11) NOT NULL,
  `categoria` varchar(35) DEFAULT NULL,
  `costo` float NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `fechaExpiracion` date NOT NULL,
  `precioVenta` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Disparadores `productos`
--
DELIMITER $$
CREATE TRIGGER `ACTUALIZA_PRODUCTOS_BU` BEFORE UPDATE ON `productos` FOR EACH ROW INSERT INTO productosactualizados(anteriorCodigoProducto, anteriorCodigoProveedor, anteriorCategoria, anteriorCosto, anteriorDescripcion, anteriorFechaExpiracion, anteriorPrecioVenta, nuevoCodigoProducto, nuevoCodigoProveedor, nuevoCategoria, nuevoCosto, nuevoDescripcion, nuevoFechaExpiracion, nuevoPrecioVenta, usuario, fechaModificacion)
VALUES(OLD.codigoProducto, OLD.codigoProveedor, OLD.categoria, OLD.costo, OLD.descripcion, OLD.fechaExpiracion, OLD.precioVenta, NEW.codigoProducto, NEW.codigoProveedor, NEW.categoria, NEW.costo, NEW.descripcion, NEW.fechaExpiracion, NEW.precioVenta, CURRENT_USER(), NOW())
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `PRODUCTOS_AD` AFTER DELETE ON `productos` FOR EACH ROW INSERT INTO reg_productos(codigoProducto, codigoProveedor, categoria, costo, descripcion, fechaExpiracion, precioVenta) VALUES(OLD.codigoProducto, OLD.codigoProveedor, OLD.categoria, OLD.costo, OLD.descripcion, OLD.fechaExpiracion, OLD.precioVenta)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productosactualizados`
--

CREATE TABLE `productosactualizados` (
  `anteriorCodigoProducto` int(11) NOT NULL,
  `anteriorCodigoProveedor` int(11) NOT NULL,
  `anteriorCategoria` varchar(35) DEFAULT NULL,
  `anteriorCosto` float NOT NULL,
  `anteriorDescripcion` varchar(50) DEFAULT NULL,
  `anteriorFechaExpiracion` date NOT NULL,
  `anteriorPrecioVenta` float NOT NULL,
  `nuevoCodigoProducto` int(11) NOT NULL,
  `nuevoCodigoProveedor` int(11) NOT NULL,
  `nuevoCategoria` varchar(35) DEFAULT NULL,
  `nuevoCosto` float NOT NULL,
  `nuevoDescripcion` varchar(50) DEFAULT NULL,
  `nuevoFechaExpiracion` date NOT NULL,
  `nuevoPrecioVenta` float NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `codigoProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(20) DEFAULT NULL,
  `apellidoProveedor` varchar(20) DEFAULT NULL,
  `rtnProveedor` int(11) DEFAULT NULL,
  `telefonoProveedor` int(11) DEFAULT NULL,
  `direccionProveedor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Disparadores `proveedores`
--
DELIMITER $$
CREATE TRIGGER `ACTUALIZA_PROVEEDORES_BU` BEFORE UPDATE ON `proveedores` FOR EACH ROW INSERT INTO proveedores_actualizados(anteriorCodigoProveedor, anteriorNombreProveedor, anteriorApellidoProveedor, anteriorRtnProveedor, anteriorTelefonoProveedor, anteriorDireccionProveedor, nuevoCodigoProveedor, nuevoNombreProveedor, nuevoApellidoProveedor, nuevoRtnProveedor, nuevoTelefonoProveedor, nuevoDireccionProveedor, usuarioEditor, fechaModificacion)
VALUES(OLD.codigoProveedor, OLD.nombreProveedor, OLD.apellidoProveedor, OLD.rtnProveedor, OLD.telefonoProveedor, OLD.direccionProveedor, CURRENT_USER(), NOW())
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `PROVEEDORES_AD` AFTER DELETE ON `proveedores` FOR EACH ROW INSERT INTO reg_proveedores(codigoProveedor, nombreProveedor, apellidoProveedor, rtnProveedor, telefonoProveedor, direccionProveedor)
VALUES(OLD.codigoProveedor, OLD.nombreProveedor, OLD.apellidoProveedor, OLD.rtnProveedor, OLD.telefonoProveedor, OLD.direccionProveedor)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores_actualizados`
--

CREATE TABLE `proveedores_actualizados` (
  `anteriorCodigoProveedor` int(11) NOT NULL,
  `anteriorNombreProveedor` varchar(20) DEFAULT NULL,
  `anteriorApellidoProveedor` varchar(20) DEFAULT NULL,
  `anteriorRtnProveedor` int(11) DEFAULT NULL,
  `anteriorTelefonoProveedor` int(11) DEFAULT NULL,
  `anteriorDireccionProveedor` varchar(50) DEFAULT NULL,
  `nuevoCodigoProveedor` int(11) NOT NULL,
  `nuevoNombreProveedor` varchar(20) DEFAULT NULL,
  `nuevoApellidoProveedor` varchar(20) DEFAULT NULL,
  `nuevoRtnProveedor` int(11) DEFAULT NULL,
  `nuevoTelefonoProveedor` int(11) DEFAULT NULL,
  `nuevoDireccionProveedor` varchar(50) DEFAULT NULL,
  `usuarioEditor` varchar(20) NOT NULL,
  `fechaModificacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reg_clientes`
--

CREATE TABLE `reg_clientes` (
  `idCliente` int(11) NOT NULL,
  `nombreCliente` varchar(20) DEFAULT NULL,
  `apellidoCliente` varchar(20) DEFAULT NULL,
  `rtnCliente` int(11) NOT NULL,
  `telefonoCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reg_empleados`
--

CREATE TABLE `reg_empleados` (
  `idEmpleado` int(11) NOT NULL,
  `nombreEmpleado` varchar(20) DEFAULT NULL,
  `apellidoEmpleado` varchar(20) DEFAULT NULL,
  `usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reg_productos`
--

CREATE TABLE `reg_productos` (
  `codigoProducto` int(11) NOT NULL,
  `codigoProveedor` int(11) NOT NULL,
  `categoria` varchar(35) DEFAULT NULL,
  `costo` float NOT NULL,
  `descripcion` varchar(20) DEFAULT NULL,
  `fechaExpiracion` date NOT NULL,
  `precioVenta` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reg_proveedores`
--

CREATE TABLE `reg_proveedores` (
  `codigoProveedor` int(11) NOT NULL,
  `rtnProveedor` int(11) DEFAULT NULL,
  `telefonoProveedor` int(11) DEFAULT NULL,
  `direccionProveedor` varchar(20) DEFAULT NULL,
  `nombreProveedor` varchar(20) DEFAULT NULL,
  `apellidoProveedor` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `reg_proveedores`
--

INSERT INTO `reg_proveedores` (`codigoProveedor`, `rtnProveedor`, `telefonoProveedor`, `direccionProveedor`, `nombreProveedor`, `apellidoProveedor`) VALUES
(1, 0, 89131676, 'Bernardo Dazzi', 'Ilich', 'García');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reg_usuarios`
--

CREATE TABLE `reg_usuarios` (
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Disparadores `usuarios`
--
DELIMITER $$
CREATE TRIGGER `ACTUALIZA_USUARIOS_BU` BEFORE UPDATE ON `usuarios` FOR EACH ROW INSERT INTO usuarios_actualizados(anteriorUsuario, anteriorContraseña, nuevoUsuario, nuevoContraseña, usuarioEditor, fechaModificacion)
VALUES(OLD.usuario, OLD.contraseña, NEW.usuario, NEW.contraseña, CURRENT_USER(), NOW())
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `USUARIOS_AD` AFTER DELETE ON `usuarios` FOR EACH ROW INSERT INTO reg_usuarios(usuario, contraseña)
VALUES(OLD.usuario, OLD.contraseña)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_actualizados`
--

CREATE TABLE `usuarios_actualizados` (
  `anteriorUsuario` varchar(20) NOT NULL,
  `anteriorContraseña` varchar(30) NOT NULL,
  `nuevoUsuario` varchar(20) NOT NULL,
  `nuevoContraseña` varchar(30) NOT NULL,
  `usuarioEditor` varchar(20) NOT NULL,
  `fechaModificacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`codigoFactura`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigoProducto`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`codigoProveedor`);

--
-- Indices de la tabla `reg_clientes`
--
ALTER TABLE `reg_clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `reg_empleados`
--
ALTER TABLE `reg_empleados`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `reg_productos`
--
ALTER TABLE `reg_productos`
  ADD PRIMARY KEY (`codigoProducto`);

--
-- Indices de la tabla `reg_proveedores`
--
ALTER TABLE `reg_proveedores`
  ADD PRIMARY KEY (`codigoProveedor`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
