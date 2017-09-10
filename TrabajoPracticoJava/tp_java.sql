-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-09-2017 a las 01:01:23
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tp_java`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `categoria`) VALUES
(1, 'encargado'),
(2, 'administrador'),
(3, 'usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `elementos`
--

CREATE TABLE IF NOT EXISTS `elementos` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time(6) NOT NULL,
  `detalle` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `elementos`
--

INSERT INTO `elementos` (`id`, `nombre`, `fecha`, `hora`, `detalle`) VALUES
(1, 'Hardware', '2017-08-02', '17:08:00.000000', ''),
(2, 'Ordenador portátil', '2017-03-15', '17:30:45.000000', ''),
(3, 'Sofware', '2016-12-22', '10:30:45.000000', ''),
(4, 'Sistema operativo', '2017-02-02', '12:30:05.000000', ''),
(5, 'Libro', '2015-10-22', '18:30:00.000000', ''),
(6, ' teléfono portátil ', '2017-05-13', '22:00:55.000000', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE IF NOT EXISTS `personas` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `habilitado` tinyint(1) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `dni`, `nombre`, `apellido`, `usuario`, `clave`, `habilitado`, `descripcion`) VALUES
(1, '38457968', 'Fabián', 'Lara', 'fabi2017', '123456', 1, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_elementos`
--

CREATE TABLE IF NOT EXISTS `tipo_elementos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombreCorto` varchar(15) NOT NULL,
  `cantMaxReservas` int(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `tipo_elementos`
--

INSERT INTO `tipo_elementos` (`id`, `nombreCorto`, `cantMaxReservas`) VALUES
(1, 'Windows 10', 4),
(2, 'Ubuntu 16.04.3', 5),
(3, 'Notebook', 8),
(4, 'Netbook', 8),
(5, 'Workbench', 2),
(6, 'Manual', 10),
(7, 'Smartphone', 4),
(8, 'Impresora', 5);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
