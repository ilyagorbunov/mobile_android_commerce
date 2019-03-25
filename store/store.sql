-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 25, 2019 at 01:07 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_users_table`
--

CREATE TABLE `app_users_table` (
  `email` varchar(40) NOT NULL,
  `username` varchar(30) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `app_users_table`
--

INSERT INTO `app_users_table` (`email`, `username`, `pass`) VALUES
('hello@world.com', 'John', '123456'),
('cek@email.com', 'cek sound', 'gunakan');

-- --------------------------------------------------------

--
-- Table structure for table `electronic_products`
--

CREATE TABLE `electronic_products` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `price` int(11) NOT NULL,
  `brand` varchar(20) NOT NULL,
  `picture` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `electronic_products`
--

INSERT INTO `electronic_products` (`id`, `name`, `price`, `brand`, `picture`) VALUES
(1, 'iPad', 1000, 'Apple', 'ipad.png'),
(2, 'iPhone', 500, 'Apple', 'iphone.png'),
(3, 'iPod Touch', 300, 'Apple', 'ipodtouch.png'),
(4, 'iPod Shuffle', 100, 'Apple', 'ipodshuffle.png'),
(5, 'iPod Nano', 150, 'Apple', 'ipodnano.png'),
(6, 'Macbook Pro', 2000, 'Apple', 'macbookpro.png'),
(7, 'Macbook Air', 1500, 'Apple', 'macbookair.png'),
(8, 'Mac Pro', 3000, 'Apple', 'macpro.png'),
(9, 'Apple TV', 2000, 'Apple', 'appletv.png'),
(10, 'iMac', 2500, 'Apple', 'imac.png'),
(11, 'Apple Watch', 700, 'Apple', 'applewatch.png'),
(12, 'PS4', 200, 'Sony', 'ps4.png'),
(13, 'PS4 Pro', 300, 'Sony', 'ps4pro.png'),
(14, 'Xbox One S', 200, 'Microsoft', 'xboxones.png'),
(15, 'Xbox One X', 400, 'Microsoft', 'xboxonex.png');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `email` varchar(40) NOT NULL,
  `invoice_appointment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `invoice_num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`email`, `invoice_appointment_time`, `invoice_num`) VALUES
('cek@email.com', '2019-03-25 10:46:03', 1),
('cek@email.com', '2019-03-25 12:05:58', 2);

-- --------------------------------------------------------

--
-- Table structure for table `invoice_details`
--

CREATE TABLE `invoice_details` (
  `invoice_num` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice_details`
--

INSERT INTO `invoice_details` (`invoice_num`, `product_id`, `amount`) VALUES
(1, 2, 5),
(1, 15, 3),
(2, 2, 1),
(2, 13, 1);

-- --------------------------------------------------------

--
-- Table structure for table `temporary_place_order`
--

CREATE TABLE `temporary_place_order` (
  `email` varchar(40) NOT NULL,
  `product_id` int(20) NOT NULL,
  `amount` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_num`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
