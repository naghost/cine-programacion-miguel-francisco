-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2017 a las 23:05:27
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuentos`
--

CREATE TABLE `descuentos` (
  `IDDescuento` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `DiaSemana` varchar(20) NOT NULL,
  `Porcentaje` int(11) NOT NULL,
  `Temporal` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `descuentos`
--

INSERT INTO `descuentos` (`IDDescuento`, `Nombre`, `Descripcion`, `FechaInicio`, `FechaFin`, `DiaSemana`, `Porcentaje`, `Temporal`) VALUES
(1, 'asdf', 'asdf', '2017-06-06', '2017-06-06', '3', 0, 0),
(2, 'asdf', 'asdf', '2017-06-06', '2017-06-10', '3', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `IDEmpleado` int(11) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL,
  `Clave` varchar(20) NOT NULL,
  `Puesto` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`IDEmpleado`, `DNI`, `Nombre`, `Apellido`, `Clave`, `Puesto`) VALUES
(1, 'asdf', 'ads', '48245730x', 'Administrador', 'x');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

CREATE TABLE `entradas` (
  `IDEntrada` int(11) NOT NULL,
  `IDSesion` int(11) DEFAULT NULL,
  `IDSocio` int(11) DEFAULT NULL,
  `IDEmpleado` int(11) DEFAULT NULL,
  `IDDescuento` int(11) DEFAULT NULL,
  `IDPago` int(11) DEFAULT NULL,
  `Fila` int(11) DEFAULT NULL,
  `Columna` int(11) DEFAULT NULL,
  `Suplemento` tinyint(1) DEFAULT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `IDPagos` int(11) NOT NULL,
  `PrecioTotal` double NOT NULL,
  `Efectivo` double NOT NULL,
  `Tarjeta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `IDPelicula` int(11) NOT NULL,
  `Titulo` varchar(40) NOT NULL,
  `Genero` varchar(20) NOT NULL,
  `Director` varchar(20) NOT NULL,
  `Sinopsis` varchar(200) NOT NULL,
  `Estreno` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`IDPelicula`, `Titulo`, `Genero`, `Director`, `Sinopsis`, `Estreno`) VALUES
(1, 'fsfd', 'Documental', 'sdgf', 'sdfg', '2017-03-31'),
(2, 'qwe', 'Histórico', 'qwer', 'camvio', '2017-03-31'),
(3, 'qwe', 'Histórico', 'qwer', 'df', '2017-03-31'),
(4, 'fsfd', 'Biográfico', 'sdgf', 'sdfg', '2017-03-27'),
(5, 'qwe', 'Documental', 'we', 'qwe', '2017-06-26'),
(6, 'Hola 1', 'Aventura', 'Hola 2', 'Hola 3', '2019-06-28'),
(7, 'qwe', 'Documental', 'we', 'qwe', '2017-06-26'),
(8, 'fsfd', 'Documental', 'sdgf', 'sdfg', '2017-03-31'),
(9, 'fsfd', 'Biográfico', 'sdgf', 'sdfg', '2017-03-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precios`
--

CREATE TABLE `precios` (
  `IDPrecio` int(11) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `precios`
--

INSERT INTO `precios` (`IDPrecio`, `Nombre`, `Precio`) VALUES
(1, 'preci o', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `IDSalas` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Filas` int(11) NOT NULL,
  `Columnas` int(11) NOT NULL,
  `Audio` varchar(20) NOT NULL,
  `Video` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`IDSalas`, `Nombre`, `Filas`, `Columnas`, `Audio`, `Video`) VALUES
(1, 'holita', 12, 12, '1', 'asd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesiones`
--

CREATE TABLE `sesiones` (
  `IDSesion` int(11) NOT NULL,
  `IDSala` int(11) NOT NULL,
  `IDPelicula` int(11) NOT NULL,
  `IDPrecio` int(11) NOT NULL,
  `FechaHora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sesiones`
--

INSERT INTO `sesiones` (`IDSesion`, `IDSala`, `IDPelicula`, `IDPrecio`, `FechaHora`) VALUES
(34, 1, 2, 1, '2017-06-05 00:00:00'),
(35, 1, 2, 1, '2017-06-05 00:00:00'),
(36, 1, 2, 1, '2017-06-05 00:00:00'),
(37, 1, 2, 1, '2017-06-05 00:00:00'),
(38, 1, 2, 1, '2017-06-05 00:00:00'),
(39, 1, 3, 1, '2017-06-05 04:00:00'),
(40, 1, 3, 1, '2017-06-06 04:00:00'),
(41, 1, 3, 1, '2017-06-07 04:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `IDSocios` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(20) NOT NULL,
  `DNI` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`IDSocios`, `Nombre`, `Apellidos`, `DNI`) VALUES
(1, 'sfdg', 'sdfg', '48245730x');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  ADD PRIMARY KEY (`IDDescuento`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`IDEmpleado`);

--
-- Indices de la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD PRIMARY KEY (`IDEntrada`),
  ADD KEY `IDSesion` (`IDSesion`),
  ADD KEY `IDSocio` (`IDSocio`),
  ADD KEY `IDEmpleado` (`IDEmpleado`),
  ADD KEY `IDDescuento` (`IDDescuento`),
  ADD KEY `IDPago` (`IDPago`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`IDPagos`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`IDPelicula`);

--
-- Indices de la tabla `precios`
--
ALTER TABLE `precios`
  ADD PRIMARY KEY (`IDPrecio`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`IDSalas`);

--
-- Indices de la tabla `sesiones`
--
ALTER TABLE `sesiones`
  ADD PRIMARY KEY (`IDSesion`),
  ADD KEY `IDSala` (`IDSala`),
  ADD KEY `IDPelicula` (`IDPelicula`),
  ADD KEY `IDPrecio` (`IDPrecio`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`IDSocios`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  MODIFY `IDDescuento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `IDEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `entradas`
--
ALTER TABLE `entradas`
  MODIFY `IDEntrada` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `IDPagos` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `IDPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `precios`
--
ALTER TABLE `precios`
  MODIFY `IDPrecio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `salas`
--
ALTER TABLE `salas`
  MODIFY `IDSalas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `sesiones`
--
ALTER TABLE `sesiones`
  MODIFY `IDSesion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `IDSocios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `entradas_ibfk_1` FOREIGN KEY (`IDDescuento`) REFERENCES `descuentos` (`IDDescuento`),
  ADD CONSTRAINT `entradas_ibfk_2` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleados` (`IDEmpleado`),
  ADD CONSTRAINT `entradas_ibfk_3` FOREIGN KEY (`IDPago`) REFERENCES `pagos` (`IDPagos`),
  ADD CONSTRAINT `entradas_ibfk_4` FOREIGN KEY (`IDSesion`) REFERENCES `sesiones` (`IDSesion`),
  ADD CONSTRAINT `entradas_ibfk_5` FOREIGN KEY (`IDSocio`) REFERENCES `socios` (`IDSocios`);

--
-- Filtros para la tabla `sesiones`
--
ALTER TABLE `sesiones`
  ADD CONSTRAINT `sesiones_ibfk_1` FOREIGN KEY (`IDSala`) REFERENCES `salas` (`IDSalas`),
  ADD CONSTRAINT `sesiones_ibfk_2` FOREIGN KEY (`IDPrecio`) REFERENCES `precios` (`IDPrecio`),
  ADD CONSTRAINT `sesiones_ibfk_3` FOREIGN KEY (`IDPelicula`) REFERENCES `peliculas` (`IDPelicula`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
