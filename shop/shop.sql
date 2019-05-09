-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2019 at 09:50 AM
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
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `banner`
--

CREATE TABLE `banner` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Link` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `banner`
--

INSERT INTO `banner` (`ID`, `Name`, `Link`) VALUES
(1, 'Banner 1', 'https://i.ibb.co/whj6D0r/ban1.png'),
(2, 'Banner 2', 'https://i.ibb.co/bzxyNGS/ban2.png'),
(3, 'Banner 3', 'https://i.ibb.co/x1G1C46/ban4.png');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Link` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`ID`, `Name`, `Link`) VALUES
(1, 'Mixed Drink', 'http://gongcha.com.vn/wp-content/uploads/2018/02/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png'),
(2, 'Ice Drink', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Chocolate-%C4%91%C3%A1-xay-1.png'),
(3, 'Topping', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Tr%C3%A2n-Ch%C3%A2u-Tr%E1%BA%AFng.png'),
(4, 'Original Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-Alisan-1.png'),
(5, 'Milk Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Hokkaido-1.png'),
(6, 'Special Drink', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-Milkfoam-1.png');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Link` text NOT NULL,
  `Price` float NOT NULL,
  `MenuId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ID`, `Name`, `Link`, `Price`, `MenuId`) VALUES
(1, 'Squash tea\r\n', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-Milkfoam-1.png', 3.75, 6),
(3, 'Oolong tea\r\n', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Oolong-Milkfoam-2.png', 3.75, 6),
(4, 'Alisan tea\r\n', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Alisan-Milkfoam-1.png', 3.75, 6),
(5, 'Earl tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Earl-Grey-Milkfoam-1.png', 3.75, 6),
(6, 'Black tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-%C4%90en-Milkfoam-1.png', 3.75, 6),
(7, 'Green tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Xanh-Milkfoam-1.png', 3.75, 6),
(8, 'Milk Tea Red Bean', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Matcha-%C4%91%E1%BA%ADu-%C4%91%E1%BB%8F-1.png', 3.75, 5),
(9, 'Milk Tea Oolong 3J', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Oolong-3J-1.png', 3.75, 5),
(10, 'Milk Tea Pudding Read Bean', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Pudding-%C4%91%E1%BA%ADu-%C4%91%E1%BB%8F-1.png', 3.75, 5),
(11, 'Milk Tea Chocolate', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Chocolate-1.png', 3.75, 5),
(12, 'Milk Tea Caramel', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Caramel-1.png', 3.75, 5),
(13, 'Milk Tea Black Pearl', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Caramel-1.png', 3.75, 5),
(14, 'Squash Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-Alisan-1.png', 3.75, 4),
(15, 'Squash Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-1.png', 3.75, 4),
(16, 'Earl Grey Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Early-Grey-1.png', 3.75, 4),
(17, 'Oolong Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Oolong-1.png', 3.75, 4),
(18, 'Black Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-%C4%90en-1.png', 3.75, 4),
(19, 'Green Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Xanh-1.png', 3.75, 4),
(20, 'QQ Green Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png', 3.75, 1),
(21, 'Lemon Ai-yu and White Pearl ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Chanh-Aiyu-tr%C3%A2n-ch%C3%A2u-tr%E1%BA%AFng-1.png', 3.75, 1),
(22, 'Pink Peach ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/imgpsh_fullsize.png', 3.75, 1),
(23, 'Fig Oolong Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Oolong-v%E1%BA%A3i-1.png', 3.75, 1),
(24, 'Fig Alisan Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Alisan-v%E1%BA%A3i-1.png', 3.75, 1),
(25, 'Mango Alisan Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Alisan-xo%C3%A0i-1.png', 3.75, 1),
(26, 'Lemon Green Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Xanh-%C4%91%C3%A0o-1.png', 3.75, 1),
(27, 'Lemon Alisan Green Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Xanh-%C4%91%C3%A0o-1.png', 3.75, 1),
(28, 'Peach Black Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/%C4%90en-%C4%91%C3%A0o-1.png', 3.75, 1),
(29, 'Peach Green Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Xanh-%C4%91%C3%A0o-1.png', 3.75, 1),
(30, 'Chocolate Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Chocolate-%C4%91%C3%A1-xay-1.png', 3.75, 2),
(31, 'Taro Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Khoai-m%C3%B4n-%C4%91%C3%A1-xay-1.png', 3.75, 2),
(32, 'Matcha Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Matcha-%C4%91%C3%A1-xay-1.png', 3.75, 2),
(33, 'Yakult Peach Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Yakult-%C4%91%C3%A1-xay-1.png', 3.75, 2),
(34, 'Mango Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Xo%C3%A0i-%C4%91%C3%A1-xay-1.png', 3.75, 2),
(35, 'Peach Tea Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-%C4%91%C3%A0o-%C4%91%C3%A1-tuy%E1%BA%BFt-fix.png', 3.75, 2),
(36, 'Milk Cream', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Kem-S%E1%BB%AFa.png', 2, 3),
(37, 'Vera', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Nha-%C4%90am.png', 2, 3),
(38, 'Seeds', 'http://gongcha.com.vn/wp-content/uploads/2018/03/H%E1%BA%A1t-%C3%89.png', 2, 3),
(39, 'Black Pearl', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Tr%C3%A2n-Ch%C3%A2u-%C4%90en.png', 2, 3),
(40, 'White Pearl', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Tr%C3%A2n-Ch%C3%A2u-Tr%E1%BA%AFng.png', 2, 3),
(41, 'Red Bean', 'http://gongcha.com.vn/wp-content/uploads/2018/03/%C4%90%E1%BA%ADu-%C4%90%E1%BB%8F.png', 2, 3),
(42, 'Jelly Black', 'http://gongcha.com.vn/wp-content/uploads/2018/03/S%C6%B0%C6%A1ng-s%C3%A1o.png', 2, 3),
(43, 'Jelly Brown', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Th%E1%BA%A1ch-N%C3%A2u.png', 2, 3),
(44, 'Jelly Fruits', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Th%E1%BA%A1ch-tr%C3%A1i-c%C3%A2y.png', 2, 3),
(45, 'Jelly Ai-yu', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Th%E1%BA%A1ch-Ai-yu.png', 2, 3),
(46, 'Jelly Coconut', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Th%E1%BA%A1ch-D%E1%BB%ABa.png', 2, 3),
(47, 'Pudding', 'http://gongcha.com.vn/wp-content/uploads/2018/03/%E5%B8%83%E4%B8%81-pudding.png', 2, 3),
(48, 'Combo 2', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Combo2loaihat-2.png', 2.5, 3),
(49, 'Combo 3', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Combo-3-lo%E1%BA%A1i-h%E1%BA%A1t.png', 2.5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Phone` varchar(20) NOT NULL,
  `avatarUrl` text NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Birthdate` date NOT NULL,
  `Address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Phone`, `avatarUrl`, `Name`, `Birthdate`, `Address`) VALUES
('+6287820897263', '', 'rezaaja', '1998-05-12', 'dimana saja'),
('+62895380856690', '+62895380856690.jpg', 'reza erbe', '1998-05-12', 'apa saja lah'),
('123456', 'sagiri(RB).png', 'erbe', '1998-05-12', 'kuningan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `MenuId` (`MenuId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `banner`
--
ALTER TABLE `banner`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`MenuId`) REFERENCES `menu` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
