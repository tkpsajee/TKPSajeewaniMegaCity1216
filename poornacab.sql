-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2025 at 08:25 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cab_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `booking_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `destination` varchar(100) NOT NULL,
  `distance` double NOT NULL,
  `total_fare` double NOT NULL,
  `driver_id` int(11) NOT NULL,
  `vc_id` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`booking_id`, `customer_id`, `destination`, `distance`, `total_fare`, `driver_id`, `vc_id`, `created_date`) VALUES
(1, 1, 'Jaffna', 444, 24420.000000000004, 0, 0, '2025-02-21 19:16:39'),
(2, 2, '6666', 8787, 483285.00000000006, 0, 0, '2025-02-21 19:17:11'),
(3, 3, 'Jaffna', 435535, 23954425.000000004, 0, 0, '2025-02-21 19:18:45'),
(4, 4, 'Jaffna', 67888, 3733840.0000000005, 0, 0, '2025-03-04 17:19:34'),
(5, 5, '34234', 234, 12870.000000000002, 0, 0, '2025-03-09 17:52:51'),
(6, 6, '435345', 34534, 1899370.0000000002, 0, 0, '2025-03-09 17:53:14');

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL,
  `model` varchar(50) NOT NULL,
  `driver_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `contact_no` varchar(15) NOT NULL,
  `email` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `name`, `address`, `nic`, `contact_no`, `email`, `username`, `password`) VALUES
(1, 'sumedha', 'Galahena, Magulagama', '44545454', '0765462237', '', '', ''),
(2, 'Kamal', 'Kottawa', '789878978', '786786887', '', '', ''),
(3, 'dasdad', 'Galahena, Magulagama', '44545454', '0765462237', '', '', ''),
(4, 'sumedha', 'Galahena, Magulagama', '44545454', '0765462237', '', '', ''),
(5, 'Anjalika De Mel', 'No.26, St Benedict Rd, Chilaw', '435345', '0775116781', '', '', ''),
(6, 'wwerwer', 'ewrwer', 's345345', '345345345', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `dd`
--

CREATE TABLE `dd` (
  `UserID` double NOT NULL DEFAULT 0,
  `us_fullname` varchar(100) DEFAULT NULL,
  `us_Password` varchar(50) DEFAULT NULL,
  `us_Usertype` varchar(50) DEFAULT NULL,
  `us_Address` varchar(100) DEFAULT NULL,
  `us_Email` varchar(100) DEFAULT NULL,
  `us_Contact_No` varchar(50) DEFAULT NULL,
  `us_NIC` varchar(50) DEFAULT NULL,
  `us_User_status` varchar(50) DEFAULT 'INACTIVE',
  `us_loginusername` varchar(50) DEFAULT NULL,
  `us_Created_by` varchar(50) DEFAULT NULL,
  `us_Created_date` timestamp NULL DEFAULT current_timestamp(),
  `us_Modified_by` varchar(50) DEFAULT NULL,
  `us_Modified_date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dd`
--

INSERT INTO `dd` (`UserID`, `us_fullname`, `us_Password`, `us_Usertype`, `us_Address`, `us_Email`, `us_Contact_No`, `us_NIC`, `us_User_status`, `us_loginusername`, `us_Created_by`, `us_Created_date`, `us_Modified_by`, `us_Modified_date`) VALUES
(1, 'Shelini Senevirathna', '1234', 'customer', 'Balangoda.', 'shelini@gmail.com', '0768584565', '200105798462', 'INACTIVE', 'shelini123', 'a1', '2025-03-13 04:09:28', NULL, NULL),
(0, 'Amal Gamage', 'a123', 'admin', '21/A,Nugegoda.', 'amal@gmail.com', '075984162', '20048951125784', 'INACTIVE', 'admin', '', '2025-03-13 06:24:35', NULL, NULL),
(0, 'Namal Perera', 'd123', 'driver', '24/A, Kandy', 'namal@gmail.com', '07894563289', '1999586249185', 'INACTIVE', 'namal', NULL, '2025-03-13 06:24:35', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `drivers`
--

CREATE TABLE `drivers` (
  `driver_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `dr_fullname` varchar(200) NOT NULL,
  `dr_email` varchar(200) NOT NULL,
  `dr_password` varchar(100) NOT NULL,
  `dr_address` varchar(200) NOT NULL,
  `dr_licence_no` varchar(20) NOT NULL,
  `dr_status` varchar(20) NOT NULL DEFAULT 'INACTIVE'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblbill`
--

CREATE TABLE `tblbill` (
  `Bill_id` int(11) NOT NULL,
  `b_start_meter_reading` int(50) DEFAULT NULL,
  `b_end_meter_reading` int(50) DEFAULT NULL,
  `b_date` date DEFAULT NULL,
  `b_grand_total` int(50) DEFAULT NULL,
  `b_disscount` int(50) DEFAULT NULL,
  `b_sub_total` int(50) DEFAULT NULL,
  `b_tax` int(50) DEFAULT NULL,
  `b_total` int(50) DEFAULT NULL,
  `b_bk_status` varchar(50) DEFAULT NULL,
  `b_Created_by` varchar(50) DEFAULT NULL,
  `b_Created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `b_Modified_by` varchar(50) DEFAULT NULL,
  `b_Modified_date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblbill`
--

INSERT INTO `tblbill` (`Bill_id`, `b_start_meter_reading`, `b_end_meter_reading`, `b_date`, `b_grand_total`, `b_disscount`, `b_sub_total`, `b_tax`, `b_total`, `b_bk_status`, `b_Created_by`, `b_Created_date`, `b_Modified_by`, `b_Modified_date`) VALUES
(1, 300, 500, '2025-03-18', 7500, 12, 7400, 3, 7380, NULL, NULL, '2025-03-16 03:20:15', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tblbooking`
--

CREATE TABLE `tblbooking` (
  `bk_id` int(11) NOT NULL,
  `bk_us_user_id` int(11) DEFAULT NULL,
  `bk_v_id` int(11) DEFAULT NULL,
  `bk_from_date` int(11) DEFAULT NULL,
  `bk_to_date` int(11) DEFAULT NULL,
  `bk_pickup_location` varchar(100) DEFAULT NULL,
  `bk_dropoff_location` varchar(100) DEFAULT NULL,
  `passengers` int(11) DEFAULT NULL,
  `cab_type` varchar(50) DEFAULT NULL,
  `trip_type` varchar(50) DEFAULT NULL,
  `bk_driver_us_UserID` int(11) DEFAULT NULL,
  `bk_created_by` varchar(50) DEFAULT NULL,
  `bk_created_date` timestamp NULL DEFAULT current_timestamp(),
  `bk_modified_by` varchar(50) DEFAULT NULL,
  `bk_modified_date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblbooking`
--

INSERT INTO `tblbooking` (`bk_id`, `bk_us_user_id`, `bk_v_id`, `bk_from_date`, `bk_to_date`, `bk_pickup_location`, `bk_dropoff_location`, `passengers`, `cab_type`, `trip_type`, `bk_driver_us_UserID`, `bk_created_by`, `bk_created_date`, `bk_modified_by`, `bk_modified_date`) VALUES
(1, 101, 201, 2023, 2023, '123 Main St, City A', '456 Elm St, City B', 2, 'Sedan', 'One-way', 301, '101', '2025-03-16 05:50:57', '101', NULL),
(2, 102, 202, 2023, 2023, '789 Oak St, City C', '123 Main St, City A', 4, 'SUV', 'Round-trip', 302, '102', '2025-03-16 05:50:57', '102', NULL),
(3, 103, 203, 2023, 2023, '456 Elm St, City B', '789 Oak St, City C', 3, 'Luxury', 'One-way', 303, '103', '2025-03-16 05:50:57', '103', NULL),
(4, 104, 204, 2023, 2023, '321 Pine St, City D', '654 Maple St, City E', 2, 'Sedan', 'Round-trip', 304, '104', '2025-03-16 05:50:57', '104', NULL),
(5, 105, 205, 2023, 2023, '654 Maple St, City E', '321 Pine St, City D', 5, 'SUV', 'One-way', 305, '105', '2025-03-16 05:50:57', '105', NULL),
(6, 106, 206, 2023, 2023, '987 Cedar St, City F', '123 Main St, City A', 3, 'Luxury', 'Round-trip', 306, '106', '2025-03-16 05:50:57', '106', NULL),
(7, 107, 207, 2023, 2023, '123 Main St, City A', '987 Cedar St, City F', 1, 'Sedan', 'One-way', 307, '107', '2025-03-16 05:50:57', '107', NULL),
(8, 108, 208, 2023, 2023, '456 Elm St, City B', '654 Maple St, City E', 4, 'SUV', 'Round-trip', 308, '108', '2025-03-16 05:50:57', '108', NULL),
(9, 109, 209, 2023, 2023, '789 Oak St, City C', '321 Pine St, City D', 2, 'Luxury', 'One-way', 309, '109', '2025-03-16 05:50:57', '109', NULL),
(10, 110, 210, 2023, 2023, '654 Maple St, City E', '987 Cedar St, City F', 3, 'Sedan', 'Round-trip', 310, '110', '2025-03-16 05:50:57', '110', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tblbookingdetail`
--

CREATE TABLE `tblbookingdetail` (
  `bd_id` int(11) NOT NULL,
  `bookind_id` int(11) NOT NULL,
  `odo_start` double NOT NULL,
  `odo_end` double NOT NULL,
  `triptype` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblbooking_invoice`
--

CREATE TABLE `tblbooking_invoice` (
  `bi_id` int(11) NOT NULL,
  `bi_us_UserID` int(11) DEFAULT NULL,
  `bi_bk_id` int(11) DEFAULT NULL,
  `bi_odo_start` int(11) DEFAULT NULL,
  `bi_odo_end` int(11) DEFAULT NULL,
  `bi_created_by` varchar(50) DEFAULT NULL,
  `bi_created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `bi_modified_by` varchar(50) DEFAULT NULL,
  `bi_modified_date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblusertype`
--

CREATE TABLE `tblusertype` (
  `ut_ID` int(11) NOT NULL,
  `ut_name` varchar(50) DEFAULT NULL,
  `ut_description` varchar(150) DEFAULT NULL,
  `ut_status` varchar(50) DEFAULT NULL,
  `ut_created_by` varchar(50) DEFAULT NULL,
  `ut_created_date` timestamp NULL DEFAULT current_timestamp(),
  `ut_modified_by` varchar(50) DEFAULT NULL,
  `ut_modified_date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblusertype`
--

INSERT INTO `tblusertype` (`ut_ID`, `ut_name`, `ut_description`, `ut_status`, `ut_created_by`, `ut_created_date`, `ut_modified_by`, `ut_modified_date`) VALUES
(1, 'Admin', 'Welcome to Admin', NULL, NULL, '2025-03-12 04:07:05', NULL, NULL),
(2, 'Driver', 'Welcome to Driver.', NULL, NULL, '2025-03-12 04:07:05', NULL, NULL),
(3, 'Customer', 'Welcome to Customer', NULL, NULL, '2025-03-12 04:07:27', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tblvehicle`
--

CREATE TABLE `tblvehicle` (
  `v_id` int(11) NOT NULL,
  `v_number` varchar(100) DEFAULT NULL,
  `v_type` varchar(50) DEFAULT NULL,
  `v_no_of_seats` int(50) DEFAULT NULL,
  `V_status` varchar(30) NOT NULL DEFAULT 'Active',
  `v_created_by` varchar(50) DEFAULT NULL,
  `v_created_date` timestamp NULL DEFAULT current_timestamp(),
  `v_modified_by` varchar(50) DEFAULT NULL,
  `v_modified_date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblvehicle`
--

INSERT INTO `tblvehicle` (`v_id`, `v_number`, `v_type`, `v_no_of_seats`, `V_status`, `v_created_by`, `v_created_date`, `v_modified_by`, `v_modified_date`) VALUES
(1, 'ABC-1234', 'Sedan', 4, 'Active', NULL, '2025-03-12 04:03:48', NULL, NULL),
(2, 'XYZ-5678', 'SUV', 7, 'Active', NULL, '2025-03-12 04:03:48', NULL, NULL),
(3, 'MNO-1122', 'Van', 8, 'Active', NULL, '2025-03-12 04:04:38', NULL, NULL),
(4, 'LMN-2345', 'Luxury', 5, 'Active', NULL, '2025-03-12 04:04:38', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tblvehicletype`
--

CREATE TABLE `tblvehicletype` (
  `vt_id` int(11) NOT NULL,
  `vt_name` varchar(50) DEFAULT NULL,
  `vt_description` varchar(100) DEFAULT NULL,
  `vt_default_fee(5km)` double DEFAULT NULL,
  `vt_per_charge(oneway)` int(11) DEFAULT NULL,
  `vt_per_charge(roundway)` int(11) DEFAULT NULL,
  `vt_created_by` varchar(50) DEFAULT NULL,
  `vt_created_date` timestamp NULL DEFAULT current_timestamp(),
  `vt_modified_by` varchar(50) DEFAULT NULL,
  `vt_modified_date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblvehicletype`
--

INSERT INTO `tblvehicletype` (`vt_id`, `vt_name`, `vt_description`, `vt_default_fee(5km)`, `vt_per_charge(oneway)`, `vt_per_charge(roundway)`, `vt_created_by`, `vt_created_date`, `vt_modified_by`, `vt_modified_date`) VALUES
(1, 'sedan', 'Comfortable - seater car, suitable for city travel.', 1000, 200, 150, NULL, '2025-03-12 03:49:02', NULL, NULL),
(2, 'SUV', 'Spacious and powerful, ideal for family trips.', 1500, 300, 250, NULL, '2022-03-01 03:49:02', NULL, NULL),
(3, 'Luxury', 'Premium car for high-end service', 3000, 500, 400, NULL, '2024-03-22 03:52:47', NULL, NULL),
(4, 'Van', 'Spacious vehicle, suitable for group transport', 2000, 350, 300, NULL, '2025-03-17 03:52:47', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserID` double NOT NULL,
  `us_fullname` varchar(100) DEFAULT NULL,
  `us_Password` varchar(50) DEFAULT NULL,
  `us_Usertype` varchar(50) DEFAULT NULL,
  `us_Address` varchar(100) DEFAULT NULL,
  `us_Email` varchar(100) DEFAULT NULL,
  `us_Contact_No` varchar(50) DEFAULT NULL,
  `us_NIC` varchar(50) DEFAULT NULL,
  `us_User_status` varchar(50) DEFAULT 'INACTIVE',
  `us_loginusername` varchar(50) DEFAULT NULL,
  `us_Created_by` varchar(50) DEFAULT NULL,
  `us_Created_date` timestamp NULL DEFAULT current_timestamp(),
  `us_Modified_by` varchar(50) DEFAULT NULL,
  `us_Modified_date` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `us_fullname`, `us_Password`, `us_Usertype`, `us_Address`, `us_Email`, `us_Contact_No`, `us_NIC`, `us_User_status`, `us_loginusername`, `us_Created_by`, `us_Created_date`, `us_Modified_by`, `us_Modified_date`) VALUES
(2, 'Amal Gamage', 'a123', 'admin', '21/A,Nugegoda.', 'amal@gmail.com', '075984162', '20048951125784', 'INACTIVE', 'admin', '', '2025-03-13 06:24:35', NULL, NULL),
(3, 'Namal Perera', 'd123', 'driver', '24/A, Kandy', 'namal@gmail.com', '07894563289', '1999586249185', 'INACTIVE', 'namal', NULL, '2025-03-13 06:24:35', NULL, NULL),
(5, 'John Doe', 'securePassword123', 'customer', NULL, 'john.doe@example.com', '1234567890', '123456789V', 'active', 'john_doe', NULL, '2025-03-13 08:15:39', NULL, NULL),
(6, 'John Doe', 'securePassword123', NULL, 'kandy', 'john.doe@example.com', '1234567890', '123456789V', 'INACTIVE', 'john_doe', NULL, '2025-03-13 11:05:46', NULL, NULL),
(7, 'Amaya Perera', 'amaya2', NULL, 'No.25/B, Nugegoda', 'amaya@gmail.com', '0789562385', '20016598745', 'INACTIVE', 'amaya1', NULL, '2025-03-13 11:44:57', NULL, NULL),
(8, 'Poorna Sajeewani', '1478', NULL, 'Dampe,Piliyandala.', 'poorna@gmail.com', '0769853621', '198526974832', 'INACTIVE', 'ppp11', NULL, '2025-03-13 11:45:56', NULL, NULL),
(9, 'Shriyani Munidasa', '2225', NULL, 'Galle', 'shriyani@gmail.com', '0774609774', '1962987456932', 'INACTIVE', 'shr222', NULL, '2025-03-13 11:50:29', NULL, NULL),
(10, 'Amaya Perera', '1596', NULL, 'No.25/B, Nugegoda', 'amaya@gmail.com', '0789562385', '20016598745', 'INACTIVE', 'ami', NULL, '2025-03-13 11:53:15', NULL, NULL),
(11, 'Gayani Perera', '9874', NULL, 'Homagama', 'gayani@gmail.com', '0774609774', '19968523974', 'INACTIVE', 'gaya', NULL, '2025-03-13 12:18:13', NULL, NULL),
(34, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 10:34:54', NULL, NULL),
(35, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 10:39:12', NULL, NULL),
(36, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 10:39:46', NULL, NULL),
(37, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 10:40:47', NULL, NULL),
(38, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:27:54', NULL, NULL),
(39, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:28:23', NULL, NULL),
(40, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:32:52', NULL, NULL),
(41, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:33:20', NULL, NULL),
(42, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:36:07', NULL, NULL),
(43, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:37:14', NULL, NULL),
(44, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:47:50', NULL, NULL),
(45, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:48:16', NULL, NULL),
(46, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:52:47', NULL, NULL),
(47, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:53:12', NULL, NULL),
(48, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:58:13', NULL, NULL),
(49, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 11:58:59', NULL, NULL),
(50, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 12:02:22', NULL, NULL),
(51, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 12:02:48', NULL, NULL),
(52, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 12:25:43', NULL, NULL),
(53, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 12:26:22', NULL, NULL),
(54, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 12:27:10', NULL, NULL),
(55, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 12:48:49', NULL, NULL),
(56, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 12:49:14', NULL, NULL),
(57, 'Amali Perera', '7890', NULL, 'Kandy', 'amali@gmail.com', '0785946258', '20015987452', 'INACTIVE', 'amali', NULL, '2025-03-15 15:04:44', NULL, NULL),
(58, 'Amali Perera', '7890', NULL, 'Kandy', 'amali@gmail.com', '0785946258', '20015987452', 'INACTIVE', 'amali', NULL, '2025-03-15 15:07:40', NULL, NULL),
(59, 'Kawya Perera', '7890', NULL, 'Anuradhapura', 'kawya@gmail.com', '0785946258', '20015987452', 'INACTIVE', 'amali', NULL, '2025-03-15 15:11:11', NULL, NULL),
(60, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 16:31:17', NULL, NULL),
(61, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 16:31:46', NULL, NULL),
(62, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 16:37:51', NULL, NULL),
(63, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 16:38:24', NULL, NULL),
(64, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 16:50:17', NULL, NULL),
(65, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 16:50:38', NULL, NULL),
(66, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:01:00', NULL, NULL),
(67, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:01:32', NULL, NULL),
(68, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:12:33', NULL, NULL),
(69, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:12:59', NULL, NULL),
(70, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:19:16', NULL, NULL),
(71, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:19:42', NULL, NULL),
(72, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:33:45', NULL, NULL),
(73, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:34:08', NULL, NULL),
(74, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:42:58', NULL, NULL),
(75, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 17:43:25', NULL, NULL),
(76, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 18:10:36', NULL, NULL),
(78, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 18:15:56', NULL, NULL),
(79, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 18:16:22', NULL, NULL),
(80, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 18:40:15', NULL, NULL),
(81, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 18:40:48', NULL, NULL),
(82, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 19:04:25', NULL, NULL),
(83, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-15 19:04:47', NULL, NULL),
(84, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-16 03:34:03', NULL, NULL),
(85, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-16 03:34:26', NULL, NULL),
(86, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-16 03:45:24', NULL, NULL),
(87, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-16 03:46:18', NULL, NULL),
(88, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-16 04:03:39', NULL, NULL),
(89, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-16 05:19:02', NULL, NULL),
(90, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-16 06:44:36', NULL, NULL),
(91, '', '', NULL, '', '', '', '', 'INACTIVE', '', NULL, '2025-03-16 06:44:46', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `customer_id_2` (`customer_id`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`car_id`),
  ADD KEY `driver_id` (`driver_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `drivers`
--
ALTER TABLE `drivers`
  ADD PRIMARY KEY (`driver_id`);

--
-- Indexes for table `tblbill`
--
ALTER TABLE `tblbill`
  ADD PRIMARY KEY (`Bill_id`);

--
-- Indexes for table `tblbooking`
--
ALTER TABLE `tblbooking`
  ADD PRIMARY KEY (`bk_id`);

--
-- Indexes for table `tblbookingdetail`
--
ALTER TABLE `tblbookingdetail`
  ADD PRIMARY KEY (`bd_id`);

--
-- Indexes for table `tblbooking_invoice`
--
ALTER TABLE `tblbooking_invoice`
  ADD PRIMARY KEY (`bi_id`);

--
-- Indexes for table `tblusertype`
--
ALTER TABLE `tblusertype`
  ADD PRIMARY KEY (`ut_ID`);

--
-- Indexes for table `tblvehicle`
--
ALTER TABLE `tblvehicle`
  ADD PRIMARY KEY (`v_id`);

--
-- Indexes for table `tblvehicletype`
--
ALTER TABLE `tblvehicletype`
  ADD PRIMARY KEY (`vt_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `drivers`
--
ALTER TABLE `drivers`
  MODIFY `driver_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblbill`
--
ALTER TABLE `tblbill`
  MODIFY `Bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tblbooking`
--
ALTER TABLE `tblbooking`
  MODIFY `bk_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tblbookingdetail`
--
ALTER TABLE `tblbookingdetail`
  MODIFY `bd_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tblusertype`
--
ALTER TABLE `tblusertype`
  MODIFY `ut_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tblvehicle`
--
ALTER TABLE `tblvehicle`
  MODIFY `v_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tblvehicletype`
--
ALTER TABLE `tblvehicletype`
  MODIFY `vt_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserID` double NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

--
-- Constraints for table `cars`
--
ALTER TABLE `cars`
  ADD CONSTRAINT `cars_ibfk_1` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`driver_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
