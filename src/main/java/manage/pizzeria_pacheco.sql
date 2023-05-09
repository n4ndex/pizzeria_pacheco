-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2023 at 01:45 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pizzeria_pacheco`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `client_number` int(11) NOT NULL,
  `password` varchar(11) NOT NULL,
  `name` varchar(11) DEFAULT '',
  `surname` varchar(11) DEFAULT '',
  `address` varchar(11) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`client_number`, `password`, `name`, `surname`, `address`) VALUES
(123456789, 'password', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_code` int(11) NOT NULL,
  `order_type` varchar(11) DEFAULT '',
  `recieved` tinyint(1) NOT NULL DEFAULT 0,
  `client_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_code`, `order_type`, `recieved`, `client_number`) VALUES
(4, 'delivery', 0, 123456789),
(5, 'delivery', 0, 123456789),
(6, '', 0, 123456789);

-- --------------------------------------------------------

--
-- Table structure for table `pizzas`
--

CREATE TABLE `pizzas` (
  `pizza_code` int(11) DEFAULT 0,
  `pizza_name` varchar(11) DEFAULT '',
  `prize` double(11,2) DEFAULT 0.00,
  `size` varchar(11) DEFAULT 'mediana',
  `order_code` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pizzas`
--

INSERT INTO `pizzas` (`pizza_code`, `pizza_name`, `prize`, `size`, `order_code`) VALUES
(1, 'carbonara', 7.75, 'mediana', 0),
(2, 'barbacoa', 8.00, 'mediana', 0),
(3, 'jamonqueso', 5.99, 'mediana', 0),
(4, 'kebab', 7.80, 'mediana', 0),
(5, 'margarita', 4.50, 'mediana', 0),
(6, 'champiñones', 6.00, 'mediana', 0),
(1, 'carbonara', 7.75, 'mediana', 6),
(1, 'carbonara', 7.75, 'mediana', 6),
(2, 'barbacoa', 8.00, 'mediana', 6),
(2, 'barbacoa', 8.00, 'mediana', 6),
(3, 'jamonqueso', 5.99, 'mediana', 6),
(3, 'jamonqueso', 5.99, 'mediana', 6),
(4, 'kebab', 7.80, 'mediana', 6),
(4, 'kebab', 7.80, 'mediana', 6),
(5, 'margarita', 4.50, 'mediana', 6),
(5, 'margarita', 4.50, 'mediana', 6),
(6, 'champiñones', 6.00, 'mediana', 6),
(6, 'champiñones', 6.00, 'mediana', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`client_number`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
