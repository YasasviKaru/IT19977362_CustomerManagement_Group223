-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 07:07 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `userID` int(11) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `accountNumber` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nic` varchar(20) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `userName` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`userID`, `firstName`, `lastName`, `accountNumber`, `email`, `nic`, `mobile`, `address`, `userName`, `password`) VALUES
(2, 'Yasasvi', 'Karunarathne', 100236, 'yasasvi12@gmail.com', '199985236100', '0716635298', '65/A, Nagahawatta, Eheliyagodaa', 'Prabhasha', 'Prabhasha1213'),
(3, 'Nalini', 'Hindurangala', 100476, 'nalinii12@gmail.com', '199985452019', '0771289715', '65/A, Awissawella Road, Ratnapura', 'Nalini', 'Nalini1213'),
(4, 'Janindu', 'Ariyasinghe', 100981, 'Janindu12@gmail.com', '19991237894', '0779815544', '36, Haggalla, Gampaha', 'Janindu', 'Janindu@1213'),
(5, 'Yasasvi', 'Karunarathne', 100236, 'yasasvi12@gmail.com', '199985236100', '0716635298', '65/A, Nagahawatta, Eheliyagoda', 'Prabhasha', 'Prabhasha12133'),
(6, 'Gethmi', 'Nisana', 100235, 'gethminisansa@gmail.com', '199885818745', '0714788569', '132/4,Alakeshwara Rd,Kotte', 'gethmi', 'gethmi123'),
(7, 'Janindu', 'Maleesha', 100265, 'janindu@gmail.com', '1999858874554', '0777652333', '57/K,Haggalla,Laggala', 'janindu', 'janindu123'),
(8, 'Nalini', 'Sandunika', 100228, 'nalini@gmail.com', '996233487V', '0718567209', '65/A,Temple Road,Eheliyagoda', 'nalini', 'nalini123'),
(11, 'Yasasvi', 'Karunarathne', 100894, 'yasasvikarunarathne@icloud.com', '983261272V', '0771037528', '#36, Dutugemunu Road, Moneragala', 'Yasasvi', 'Yasasvi'),
(12, 'Ramesh', 'Jayawardene', 100486, 'suresh@gmail.com', '11111111', '111', 'Malabe', 'Suresh', 'Prabhasha1213');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
