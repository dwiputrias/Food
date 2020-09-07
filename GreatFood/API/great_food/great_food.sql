-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13 Mei 2019 pada 12.23
-- Versi Server: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `great_food`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `food`
--

CREATE TABLE `food` (
  `id` int(250) NOT NULL,
  `nama` varchar(250) NOT NULL,
  `harga` varchar(250) NOT NULL,
  `deskripsi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `food`
--

INSERT INTO `food` (`id`, `nama`, `harga`, `deskripsi`) VALUES
(1, 'Steik', '50000', 'Bistik atau steik adalah sepotong besar daging, biasanya daging sapi.'),
(2, 'Pasta', '35300', 'Pasta dijadikan berbagai hidangan setelah dimasak dengan cara direbus.'),
(3, 'Tiram', '24500', 'Tiram sangat mantap.'),
(4, 'Sate', '10000', 'Sate merupakan daging yang ditusuk di lidi.'),
(5, 'Sushi', '65000', 'Sushi merupakan makanan jepang'),
(6, 'Mie Ayam', '20000', 'Mie Ayam sangat enak'),
(7, 'Jajangmyeon', '28888', 'Jajangmyeon sangat enak'),
(8, 'Jajangmyeon', '25000', 'Jajangmyeon sangat enak.');

-- --------------------------------------------------------

--
-- Struktur dari tabel `lokasi`
--

CREATE TABLE `lokasi` (
  `id` int(250) NOT NULL,
  `nama_makanan` varchar(250) NOT NULL,
  `asal_makanan` varchar(250) NOT NULL,
  `lokasi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `lokasi`
--

INSERT INTO `lokasi` (`id`, `nama_makanan`, `asal_makanan`, `lokasi`) VALUES
(1, 'Sushi', 'Jepang', 'Renjiro Fusion'),
(2, 'Jajangmyeon', 'Korea', 'Jihwaja'),
(3, 'Tteokbokki', 'Korea', 'Hongdae Jopok Tteokbokki'),
(4, 'Risotto', 'Italia', 'Shangri-La');

-- --------------------------------------------------------

--
-- Struktur dari tabel `survey`
--

CREATE TABLE `survey` (
  `id_survey` int(250) NOT NULL,
  `nama` varchar(250) NOT NULL,
  `persen` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `survey`
--

INSERT INTO `survey` (`id_survey`, `nama`, `persen`) VALUES
(1, 'Sushi', '80%'),
(2, 'Jajangmyeon', '92%'),
(3, 'Steik', '89%'),
(4, 'pasta', '75%'),
(5, 'Sate', '100%'),
(6, 'Pasta', '85%');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lokasi`
--
ALTER TABLE `lokasi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `survey`
--
ALTER TABLE `survey`
  ADD PRIMARY KEY (`id_survey`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `lokasi`
--
ALTER TABLE `lokasi`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `survey`
--
ALTER TABLE `survey`
  MODIFY `id_survey` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
