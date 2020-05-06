-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 01:22 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf1`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctors1`
--

CREATE TABLE `doctors1` (
  `DID` int(10) NOT NULL,
  `Phone` varchar(25) NOT NULL,
  `Address` varchar(25) NOT NULL,
  `Specialization` varchar(25) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `Name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctors1`
--

INSERT INTO `doctors1` (`DID`, `Phone`, `Address`, `Specialization`, `Email`, `Name`) VALUES
(20, '071234', 'addd', 'special', 'doctor%40gmail', 'sanath123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctors1`
--
ALTER TABLE `doctors1`
  ADD PRIMARY KEY (`DID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctors1`
--
ALTER TABLE `doctors1`
  MODIFY `DID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
