-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-10-2017 a las 23:26:15
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
  `detalle` varchar(15) DEFAULT NULL,
  `id_tipo_elemento` int(100) NOT NULL COMMENT '                                                   ',
  PRIMARY KEY (`id`),
  KEY `id_tipo_elemento` (`id_tipo_elemento`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `elementos`
--

INSERT INTO `elementos` (`id`, `nombre`, `detalle`, `id_tipo_elemento`) VALUES
(1, 'windows 10', '', 5),
(2, 'ubuntu 16.04.3', '', 5),
(3, 'notebook', '', 3),
(4, 'netbook', '', 3),
(5, 'workbench', '', 6),
(7, 'smartphone', '', 7),
(9, 'Mueble de PC', '', 4),
(10, 'Word', NULL, 1),
(12, 'sdfsdf', NULL, 6);

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
  `id_categoria` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `dni`, `nombre`, `apellido`, `usuario`, `clave`, `habilitado`, `id_categoria`) VALUES
(1, '38745123', 'Fabian', 'Gabriel', 'fabi2017', '123456', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_elementos`
--

CREATE TABLE IF NOT EXISTS `tipo_elementos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombreCorto` varchar(15) NOT NULL,
  `cantMaxReservas` int(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `tipo_elementos`
--

INSERT INTO `tipo_elementos` (`id`, `nombreCorto`, `cantMaxReservas`) VALUES
(1, 'hardware', 4),
(3, 'ord. portatil', 8),
(4, 'mueble', 4),
(5, 'SO', 8),
(6, 'software', 5),
(7, 'telefono', 2),
(13, 'raro', 0),
(14, 'comun', 2);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `elementos`
--
ALTER TABLE `elementos`
  ADD CONSTRAINT `elementos_tipo_elementos` FOREIGN KEY (`id_tipo_elemento`) REFERENCES `tipo_elementos` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
