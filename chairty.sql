-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 09, 2019 at 05:40 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chairty`
--

-- --------------------------------------------------------

--
-- Table structure for table `image_table`
--

CREATE TABLE `image_table` (
  `id` int(11) NOT NULL,
  `image` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id`, `username`, `password`) VALUES
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_luar`
--

CREATE TABLE `tbl_luar` (
  `id` int(11) NOT NULL,
  `postId` varchar(15) NOT NULL,
  `keluar` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_luar`
--

INSERT INTO `tbl_luar` (`id`, `postId`, `keluar`) VALUES
(3, 'F111', 2000),
(4, 'F111', 10000),
(5, 'F111', 8500),
(6, 'F111', 30000),
(7, 'F111', 20000);

--
-- Triggers `tbl_luar`
--
DELIMITER $$
CREATE TRIGGER `trgkel` AFTER INSERT ON `tbl_luar` FOR EACH ROW UPDATE tbl_post
SET dana_terkumpul = dana_terkumpul - NEW.keluar
WHERE id =NEW.postId
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_post`
--

CREATE TABLE `tbl_post` (
  `id` varchar(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `deskirpsi` longtext NOT NULL,
  `dana_terkumpul` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_post`
--

INSERT INTO `tbl_post` (`id`, `user`, `judul`, `deskirpsi`, `dana_terkumpul`) VALUES
('F112', 'Doni.corp', 'bantu doni beli laptop', 'bantu beli laptop untuk kuliah di cicit', 170500);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaction`
--

CREATE TABLE `tbl_transaction` (
  `id` int(11) NOT NULL,
  `postId` varchar(11) NOT NULL,
  `name` char(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_transaction`
--

INSERT INTO `tbl_transaction` (`id`, `postId`, `name`, `email`, `amount`) VALUES
(2, 'F111', 'koko', 'okokok', 1000),
(3, 'F111', 'faiz', 'r@gmail.com', 20000),
(4, 'F112', 'faiz', 'r@GMAIL', 20000000),
(5, 'F112', 'dono', 'faiz@gmail.com', 9000000),
(6, 'F112', 'Joaquin', 'phoenix@joker.com', 1500),
(11, 'F111', 'donisetiawan', 'doni@gmail.com', 190000),
(12, 'F113', 'doni', 'asd@gmail.com', 20000),
(13, 'F111', 'qwer', 'qwer@Whail.com', 10000),
(14, 'F111', 'qwer', 'qwer@Whail.com', 10000),
(15, 'F111', 'qwer', 'qwer@Whail.com', 10000),
(16, 'F111', 'asdasassadsa', 'asdwq@gmail.com', 10000),
(17, 'F112', 'dqwe', 'dqw@gmail.com', 20000),
(18, 'F112', 'dqwe', 'dqw@gmail.com', 20000),
(19, 'F112', 'sadsad', 'asdasd@gmaol.com', 150500),
(20, 'F113', 'donisetiawan', 'dqw@gmail.com', 10000),
(21, 'F114', 'doni', 'asd@gmail.com', 70000),
(22, 'F111', 'asd', 'asd@gmail.com', 10000);

--
-- Triggers `tbl_transaction`
--
DELIMITER $$
CREATE TRIGGER `trgTrans` AFTER INSERT ON `tbl_transaction` FOR EACH ROW UPDATE tbl_post
SET dana_terkumpul = dana_terkumpul + NEW.amount
WHERE id =NEW.postId
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `image_table`
--
ALTER TABLE `image_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_luar`
--
ALTER TABLE `tbl_luar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kel` (`postId`);

--
-- Indexes for table `tbl_post`
--
ALTER TABLE `tbl_post`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `postId` (`postId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `image_table`
--
ALTER TABLE `image_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_luar`
--
ALTER TABLE `tbl_luar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_transaction`
--
ALTER TABLE `tbl_transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
