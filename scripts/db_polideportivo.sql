-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2022 a las 00:25:31
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_polideportivo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `ID_ENTRENADOR` int(11) NOT NULL,
  `NOMBRE1` varchar(45) DEFAULT NULL,
  `NOMBRE2` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `ID_USUARIO_FK` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `ID_EQUIPO` int(11) NOT NULL,
  `NOMBRE_EQUIPO` varchar(50) DEFAULT NULL,
  `TORNEOS GANADOS` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`ID_EQUIPO`, `NOMBRE_EQUIPO`, `TORNEOS GANADOS`) VALUES
(1, 'fc barsa', 0),
(2, 'madrid fc', 0),
(3, 'madrid fcls', 3),
(4, 'fc ', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `ID_PAIS` int(11) NOT NULL,
  `NOMBRE_PAIS` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`ID_PAIS`, `NOMBRE_PAIS`) VALUES
(0, 'guatemala'),
(0, 'usa'),
(2, 'usa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_jugador`
--

CREATE TABLE `tipo_jugador` (
  `ID_TIPO_JUGADOR` int(11) NOT NULL,
  `NOMBRE_POSICION` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_jugador`
--

INSERT INTO `tipo_jugador` (`ID_TIPO_JUGADOR`, `NOMBRE_POSICION`) VALUES
(2, 'delantero'),
(2, 'delantero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_puesto`
--

CREATE TABLE `tipo_puesto` (
  `ID_TIPO_PUESTO` int(11) NOT NULL,
  `NOMBRE_PUESTO` varchar(60) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_puesto`
--

INSERT INTO `tipo_puesto` (`ID_TIPO_PUESTO`, `NOMBRE_PUESTO`, `SALARIO`) VALUES
(1, 'portero', 2000),
(2, 'tecnico', 1000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`ID_ENTRENADOR`),
  ADD KEY `FK_USUARIO_ENTRENADOR` (`ID_USUARIO_FK`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`ID_EQUIPO`);

--
-- Indices de la tabla `tipo_puesto`
--
ALTER TABLE `tipo_puesto`
  ADD PRIMARY KEY (`ID_TIPO_PUESTO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
