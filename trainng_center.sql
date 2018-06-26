-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 26, 2018 at 01:38 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `trainng_center`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `title`, `price`) VALUES
(1, 'Core Java', 1000),
(2, 'PHP', 800),
(3, 'Angular JS', 1400),
(4, 'Node JS', 1600),
(7, 'Casandra', 2600),
(8, 'Laravel', 2000),
(16, '1000', 1000),
(18, 'IOS', 1200);

-- --------------------------------------------------------

--
-- Table structure for table `courses_students`
--

CREATE TABLE IF NOT EXISTS `courses_students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `student_id` (`student_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `courses_students`
--

INSERT INTO `courses_students` (`id`, `course_id`, `student_id`) VALUES
(4, 3, 3),
(9, 2, 16),
(10, 2, 17),
(11, 2, 18),
(12, 7, 19),
(13, 1, 20),
(14, 2, 21),
(15, 1, 22),
(17, 1, 24),
(18, 1, 25),
(19, 2, 26),
(20, 1, 27);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) DEFAULT NULL,
  `faculty` varchar(255) DEFAULT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `address` text,
  `gender` varchar(10) DEFAULT NULL,
  `registration_date` date NOT NULL,
  `Paid` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=28 ;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `phone`, `faculty`, `first_name`, `last_name`, `birthdate`, `address`, `gender`, `registration_date`, `Paid`) VALUES
(3, '01060798935', 'Agricalture', 'Mohamed', 'Abd El-salam', '2000-10-11', 'Sinai', 'female', '2017-10-24', 'No'),
(5, 'New ', 'New faculty', 'New First Name', 'New Last Name', '2017-10-24', 'New address', 'New Male', '2017-10-24', 'Yes'),
(6, 'New ', 'New faculty', 'New First Name', 'New Last Name', NULL, 'New address', 'New Male', '2017-10-24', 'Yes'),
(7, 'New ', 'New faculty', 'New First Name', 'New Last Name', NULL, 'New address', 'New Male', '2017-10-24', 'Yes'),
(8, '01060798580', 'Computers and informatics', 'new Student FirstN', '', NULL, 'Damietta, ezbet el-borg', 'male', '2017-10-24', 'Yes'),
(9, '01060798580', 'Computers and informatics', 'new Student FirstN', 'New Student LastN', NULL, 'Damietta, ezbet el-borg', 'male', '2017-10-24', 'Yes'),
(10, '01060798580', 'Computers and informatics', 'new Student FirstN', 'New Student LastN', NULL, 'Damietta, ezbet el-borg', 'male', '2017-10-24', 'Yes'),
(11, '01060798580', 'Computers and informatics', 'new Student FirstN', 'New Student LastN', NULL, 'Damietta, ezbet el-borg', 'male', '2017-10-24', 'Yes'),
(12, '01060798580', 'Computers and informatics', 'new Student FirstN', 'New Student LastN', NULL, 'Damietta, ezbet el-borg', 'male', '2017-10-24', 'Yes'),
(13, '01060798580', 'Computers and informatics', 'new Student FirstN', 'New Student LastN', NULL, 'Damietta, ezbet el-borg', 'male', '2017-10-24', 'Yes'),
(16, '1060798580', 'FCI', 'Refaat', 'aish', NULL, 'Al-a3sr', 'Male', '2018-06-26', 'Yes'),
(17, '10679566', 'FCI', 'Sayed', 'abdo', NULL, 'aswan', 'Male', '2018-06-26', 'Yes'),
(18, '1060798580', 'Computers and informatics', 'omar', 'gamal', NULL, 'Damietta, ezbet el-borg', 'Male', '2018-06-26', 'Not yet!!'),
(19, '01060798580', 'Computers and informatics', 'ahmed', 'mostafa', NULL, 'Damietta, ezbet el-borg', 'male', '2017-10-24', 'no'),
(20, '01060798580', 'Computers and informatics', 'Mosaad', 'el-khamesy', NULL, 'Damietta, ezbet el-borg', 'male', '2018-06-26', 'Yes'),
(21, '1060798580', 'FCI', 'mostafa', 'mahmoud', NULL, 'Damietta, ezbet el-borg', 'Male', '2018-06-26', 'Not yet!!'),
(22, '01060798580', 'dsdas', 'new student', 'last name for new ', NULL, 'dsadsadasd', 'Male', '2018-06-26', 'Yes'),
(24, '1060798580', 'Science', 'Salma', 'ahmed', NULL, 'new jersey', 'Female', '2018-06-26', 'Not yet!!'),
(25, '1060798590', 'safef', 'shimaa', 'asous', NULL, 'sadasda', 'Male', '2018-06-26', 'Yes'),
(26, '1060798590', 'safef', 'shimaa', 'asous', NULL, 'sadasda', 'Male', '2018-06-26', 'Yes'),
(27, '1060798580', 'Faculty of Arts', 'Hala', 'Fakher', NULL, 'Egypt,cairo', 'Female', '2018-06-26', 'Yes');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses_students`
--
ALTER TABLE `courses_students`
  ADD CONSTRAINT `courses_students_ibfk_5` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `courses_students_ibfk_6` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE CASCADE;
