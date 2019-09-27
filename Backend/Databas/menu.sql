-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 27 sep 2019 kl 14:16
-- Serverversion: 10.4.6-MariaDB
-- PHP-version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `meals`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `week` int(100) NOT NULL,
  `mon_dish1` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `mon_dish2` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `tue_dish1` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `tue_dish2` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `wed_dish1` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `wed_dish2` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `thr_dish1` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `thr_dish2` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `fri_dish1` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `fri_dish2` varchar(128) COLLATE utf8_swedish_ci NOT NULL,
  `year` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Dumpning av Data i tabell `menu`
--

INSERT INTO `menu` (`id`, `week`, `mon_dish1`, `mon_dish2`, `tue_dish1`, `tue_dish2`, `wed_dish1`, `wed_dish2`, `thr_dish1`, `thr_dish2`, `fri_dish1`, `fri_dish2`, `year`) VALUES
(6, 39, 'Falafel serveras med myntayoghurt, bulgur och salladsbuffé', 'Köttbullar serveras med gräddsås, kokt potatis, rårörda lingon och salladsbuffé', 'Hemlagade rödbetsbiffar serveras med kall örtsås, buljongkokt matvete och salladsbuffé', 'Pankopanerad fisk serveras med kall örtsås, kokt potatis, gröna ärtor och salladsbuffé', 'Grönsakspytt serveras med hummus, stekt ägg, inlagda rödbetor och salladsbuffé', 'Kokt korv serveras md rotmos, senap och salladsbuffé', 'Lasagne tillagad på en sås av tomat, grönsaker och linser serveras med salladsbuffé', 'Grönsaksnuggets serveras med klyftpotatis, sweet chilisås och råkost', 'Currygryta med kål och kikärtor serveras med matvete och råkost', '\"Coq au vin\" Kycklinggryta med svamp serveras med gul couscous och råkost', 0);

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
