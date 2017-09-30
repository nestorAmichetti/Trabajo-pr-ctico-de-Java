-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-09-2017 a las 02:59:49
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
  `detalle` varchar(15) DEFAULT NULL,
  `id_tipo_elemento` int(100) NOT NULL COMMENT '                                                   ',
  PRIMARY KEY (`id`),
  KEY `id_tipo_elemento` (`id_tipo_elemento`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `elementos`
--

INSERT INTO `elementos` (`id`, `nombre`, `fecha`, `hora`, `detalle`, `id_tipo_elemento`) VALUES
(1, 'windows 10', '2017-08-02', '17:08:00.000000', '', 5),
(2, 'ubuntu 16.04.3', '2017-03-15', '17:30:45.000000', '', 5),
(3, 'notebook', '2016-12-22', '10:30:45.000000', '', 3),
(4, 'netbook', '2017-02-02', '12:30:05.000000', '', 3),
(5, 'workbench', '2015-10-22', '18:30:00.000000', '', 6),
(6, 'biblia de C#', '2017-05-13', '22:00:55.000000', '', 2),
(7, 'smartphone', '2016-12-06', '17:00:10.000000', '', 7),
(8, 'impresora', '2017-08-01', '20:00:00.000000', '', 1),
(9, 'Mueble de PC', '2017-09-04', '13:08:22.000000', '', 4),
(10, 'Word', '2017-08-02', '20:00:00.000000', NULL, 1),
(11, 'Java 7', '2017-08-02', '10:30:00.000000', NULL, 8);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `tipo_elementos`
--

INSERT INTO `tipo_elementos` (`id`, `nombreCorto`, `cantMaxReservas`) VALUES
(1, 'hardware', 4),
(2, 'libro', 5),
(3, 'ord. portatil', 8),
(4, 'mueble', 4),
(5, 'SO', 8),
(6, 'software', 5),
(7, 'telefono', 2),
(11, 'libro', 0);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `elementos`
--
ALTER TABLE `elementos`
  ADD CONSTRAINT `elementos_ibfk_1` FOREIGN KEY (`id_tipo_elemento`) REFERENCES `elementos` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
