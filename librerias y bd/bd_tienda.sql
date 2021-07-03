-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jul 03, 2021 at 07:03 PM
-- Server version: 5.7.32
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_tienda`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(8) DEFAULT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Dni`, `Nombres`, `Direccion`) VALUES
(1, '123', 'Cliente Frecuente', 'Los Alamos 345 Lima'),
(2, '12345678', 'Juan Alberto Ribero', 'Los Cardenales de Oyllo'),
(3, '1234567', 'Papa Francisco', 'El Vaticano'),
(4, '123456', 'Obama Belaunde', 'Carretera Central'),
(5, '1234', 'San Matero de Las Rosas', 'Puente Piedra Rosada'),
(6, '12345', 'Los Visitantes de Lurin', 'Puente Chicharoneria'),
(7, '123', 'Alvin', 'Calle 34'),
(8, '678', 'Pepe', 'Calle 34 # 345'),
(9, '555', 'Gerard Way', 'Calle 45 # 4343'),
(10, '345', 'Joaquin', 'Calle 345 # 45'),
(11, '123', 'Mike', 'Calle 13 x 45 y 67');

-- --------------------------------------------------------

--
-- Table structure for table `compras`
--

CREATE TABLE `compras` (
  `idCompra` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `FechaCompra` varchar(100) NOT NULL,
  `Monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `compras`
--

INSERT INTO `compras` (`idCompra`, `idProveedor`, `FechaCompra`, `Monto`) VALUES
(1, 1, '2021-06-15', 350);

-- --------------------------------------------------------

--
-- Table structure for table `detalle_compras`
--

CREATE TABLE `detalle_compras` (
  `idDetalleCompras` int(11) NOT NULL,
  `idCompras` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioCompra` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detalle_compras`
--

INSERT INTO `detalle_compras` (`idDetalleCompras`, `idCompras`, `idProducto`, `Cantidad`, `PrecioCompra`) VALUES
(1, 1, 3, 10, 350);

-- --------------------------------------------------------

--
-- Table structure for table `detalle_oferta`
--

CREATE TABLE `detalle_oferta` (
  `idDetalleOferta` int(11) NOT NULL,
  `idOferta` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `TipoOferta` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`IdDetalleVentas`, `IdVentas`, `IdProducto`, `Cantidad`, `PrecioVenta`) VALUES
(138, 83, 1, 2, 150),
(139, 84, 2, 2, 20),
(140, 85, 3, 5, 37),
(141, 86, 3, 2, 37),
(142, 87, 1, 1, 150),
(143, 88, 3, 1, 37),
(144, 89, 3, 1, 37),
(145, 89, 2, 1, 20),
(146, 90, 3, 1, 37),
(147, 91, 2, 1, 20),
(153, 96, 2, 1, 20),
(154, 97, 2, 1, 20),
(155, 98, 2, 1, 20),
(156, 99, 2, 1, 20),
(157, 100, 2, 1, 20),
(158, 101, 1, 1, 150),
(159, 102, 2, 1, 20),
(160, 103, 1, 1, 150),
(161, 104, 1, 1, 150),
(162, 104, 2, 1, 20),
(163, 105, 7, 1, 37),
(164, 106, 6, 1, 14),
(165, 107, 4, 5, 13),
(166, 108, 5, 3, 12),
(167, 108, 1, 2, 150),
(168, 109, 1, 1, 150);

-- --------------------------------------------------------

--
-- Table structure for table `ofertas`
--

CREATE TABLE `ofertas` (
  `idOferta` int(11) NOT NULL,
  `idTipoOferta` int(11) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `FechaInicio` varchar(100) NOT NULL,
  `FechaVigencia` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ofertas`
--

INSERT INTO `ofertas` (`idOferta`, `idTipoOferta`, `Descripcion`, `FechaInicio`, `FechaVigencia`) VALUES
(1, 1, '3 gansitos por 10 pesos', '2021-06-20', '2021-06-22');

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`IdProducto`, `Nombres`, `Precio`, `Stock`) VALUES
(1, 'Gansito', 150, 48),
(2, 'Charritos', 20, 57),
(3, 'Pepsi', 37, 0),
(4, 'Takis fuego', 13, 45),
(5, 'Doritos nacho', 12, 42),
(6, 'Hot nuts', 14, 97),
(7, 'Paketaxo', 37, 82),
(9, 'Lucas', 12, 0),
(10, 'Coca cola', 37, 200),
(11, 'Cheetos bolita', 8, 13),
(12, 'Mamut', 10, 12),
(13, 'Cheeto flaming hot', 8, 13),
(14, 'Tostitos', 10, 11),
(15, 'Picafresa', 11, 13),
(16, 'Leche', 27.5, 45),
(17, 'Jugo Jumex', 22, 12);

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `IdProveedor` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Telefono` varchar(100) NOT NULL,
  `Marca` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`IdProveedor`, `Nombre`, `Direccion`, `Telefono`, `Marca`) VALUES
(1, 'Juan', 'Calle 34 #111', '9991233455', 'Pepsi'),
(2, 'Pedro', 'Calle 23 # 111', '12323123123123', 'Coca'),
(3, 'Antonio', 'Calle 12 # 234234', '999603133', 'Gamesa'),
(4, 'Gustavo', 'Calle 34 Los Alamos', '9778978987', 'Santa fe');

-- --------------------------------------------------------

--
-- Table structure for table `vendedor`
--

CREATE TABLE `vendedor` (
  `IdVendedor` int(10) UNSIGNED NOT NULL,
  `Dni` varchar(8) NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  `User` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vendedor`
--

INSERT INTO `vendedor` (`IdVendedor`, `Dni`, `Nombres`, `Telefono`, `Estado`, `User`) VALUES
(1, '12345678', 'Empleado 0001', '988252459', '1', 'emp01'),
(2, '', 'Empleado 0002', '988252459', '1', 'Jo46'),
(3, '', 'Empleado 0003', '222222', '1', 'Em22');

-- --------------------------------------------------------

--
-- Table structure for table `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdVendedor` int(10) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ventas`
--

INSERT INTO `ventas` (`IdVentas`, `IdCliente`, `IdVendedor`, `NumeroSerie`, `FechaVentas`, `Monto`) VALUES
(83, 8, 1, '01', '2021-06-18', 300),
(84, 8, 1, '02', '2021-06-19', 40),
(85, 8, 1, '03', '2021-06-19', 185),
(86, 8, 1, '04', '2021-06-19', 74),
(87, 7, 1, '05', '2021-06-20', 150),
(88, 7, 1, '06', '2021-06-20', 37),
(89, 7, 1, '07', '2021-06-20', 57),
(90, 7, 1, '08', '2021-06-20', 37),
(91, 7, 1, '09', '2021-06-20', 20),
(96, 7, 1, '10', '2021-06-20', 20),
(97, 7, 1, '11', '2021-06-20', 20),
(98, 7, 1, '12', '2021-06-20', 20),
(99, 7, 1, '13', '2021-06-20', 20),
(100, 7, 1, '14', '2021-06-20', 20),
(101, 7, 1, '15', '2021-06-20', 150),
(102, 7, 1, '16', '2021-06-22', 20),
(103, 7, 1, '17', '2021-06-22', 150),
(104, 7, 1, '18', '2021-06-23', 170),
(105, 7, 1, '19', '2021-06-23', 37),
(106, 7, 1, '20', '2021-06-23', 14),
(107, 7, 1, '21', '2021-06-23', 65),
(108, 7, 1, '22', '2021-06-24', 336),
(109, 11, 1, '23', '2021-07-03', 150);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indexes for table `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `idProveedor` (`idProveedor`);

--
-- Indexes for table `detalle_compras`
--
ALTER TABLE `detalle_compras`
  ADD PRIMARY KEY (`idDetalleCompras`),
  ADD KEY `idProducto` (`idProducto`),
  ADD KEY `detalle_compras_ibfk_1` (`idCompras`);

--
-- Indexes for table `detalle_oferta`
--
ALTER TABLE `detalle_oferta`
  ADD PRIMARY KEY (`idDetalleOferta`);

--
-- Indexes for table `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`IdProducto`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`);

--
-- Indexes for table `ofertas`
--
ALTER TABLE `ofertas`
  ADD PRIMARY KEY (`idOferta`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`IdProveedor`);

--
-- Indexes for table `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`IdVendedor`);

--
-- Indexes for table `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `Ventas_FKIndex1` (`IdVendedor`),
  ADD KEY `Ventas_FKIndex2` (`IdCliente`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `compras`
--
ALTER TABLE `compras`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `detalle_compras`
--
ALTER TABLE `detalle_compras`
  MODIFY `idDetalleCompras` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `detalle_oferta`
--
ALTER TABLE `detalle_oferta`
  MODIFY `idDetalleOferta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=169;

--
-- AUTO_INCREMENT for table `ofertas`
--
ALTER TABLE `ofertas`
  MODIFY `idOferta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `IdProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `IdVendedor` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`IdProveedor`);

--
-- Constraints for table `detalle_compras`
--
ALTER TABLE `detalle_compras`
  ADD CONSTRAINT `detalle_compras_ibfk_1` FOREIGN KEY (`idCompras`) REFERENCES `compras` (`idCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IdVendedor`) REFERENCES `vendedor` (`IdVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
