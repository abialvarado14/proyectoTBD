-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 29-03-2018 a las 20:41:18
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `idEmpleado` int(11) NOT NULL,
  `nombreEmpleado` varchar(20) DEFAULT NULL,
  `apellidoEmpleado` varchar(20) DEFAULT NULL,
  `usuario` varchar(20) NOT NULL
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
CREATE TRIGGER `PRODUCTOS_AD` AFTER DELETE ON `productos` FOR EACH ROW INSERT INTO reg_productos(codigoProducto, codigoProveedor, categoria, costo, descripcion, fechaExpiracion, precioVenta) VALUES(OLD.codigoProducto, OLD.codigoProveedor, OLD.categoria, OLD.costo, OLD.descripcion, OLD.fechaExpiracion, OLD.precioVenta)
$$
DELIMITER ;

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

--
-- Volcado de datos para la tabla `reg_productos`
--

INSERT INTO `reg_productos` (`codigoProducto`, `codigoProveedor`, `categoria`, `costo`, `descripcion`, `fechaExpiracion`, `precioVenta`) VALUES
(1, 1, 'Limpieza', 3.5, 'Nada', '2018-03-29', 4.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(30) NOT NULL
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
-- Indices de la tabla `reg_productos`
--
ALTER TABLE `reg_productos`
  ADD PRIMARY KEY (`codigoProducto`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
