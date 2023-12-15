-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2023 at 04:14 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

create database pointofsales;
use pointofsales;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pointofsales`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_admin`
--

CREATE TABLE `data_admin` (
  `id_admin` int(25) NOT NULL,
  `nama_admin` varchar(25) DEFAULT NULL,
  `password_admin` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_admin`
--

INSERT INTO `data_admin` (`id_admin`, `nama_admin`, `password_admin`) VALUES
(1, 'Bobby', 123),
(2, 'Hafidz', 4646),
(3, 'Ridwan', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_barang`
--

CREATE TABLE `tabel_barang` (
  `id_barang` varchar(25) NOT NULL,
  `nama_barang` varchar(25) DEFAULT NULL,
  `brand_barang` varchar(25) DEFAULT NULL,
  `kategori_barang` varchar(25) DEFAULT NULL,
  `jumlah_barang` int(11) DEFAULT NULL,
  `harga_barang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tabel_barang`
--

INSERT INTO `tabel_barang` (`id_barang`, `nama_barang`, `brand_barang`, `kategori_barang`, `jumlah_barang`, `harga_barang`) VALUES
('BLP003', 'Bulpen Super', 'Faber Castell', 'Bulpen', 775, 5000),
('BLP005', 'Bolpenajaib', 'pilot', 'bolpen', 1999988, 3000),
('PGR001', 'Penggaris Butterfly 30cm', 'Butterfly', 'Penggaris', 118, 3000),
('PNS001', 'Pensil 2B', 'Kenko', 'Pensil', 99917, 4500);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_member`
--

CREATE TABLE `tabel_member` (
  `id_member` int(10) UNSIGNED NOT NULL,
  `nama_member` varchar(25) DEFAULT NULL,
  `nohp_member` varchar(15) DEFAULT NULL,
  `point_member` int(25) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tabel_member`
--

INSERT INTO `tabel_member` (`id_member`, `nama_member`, `nohp_member`, `point_member`) VALUES
(3, 'Hafidz', '082233', 675595),
(4, 'Bobby', '08121212', 2580),
(6, 'Ridwan', '08135978', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tabel_riwayat_pembelian`
--

CREATE TABLE `tabel_riwayat_pembelian` (
  `id_transaksi` int(25) NOT NULL,
  `id_admin` int(25) UNSIGNED NOT NULL,
  `id_member` int(10) UNSIGNED NOT NULL,
  `waktu_transaksi` varchar(25) DEFAULT NULL,
  `tanggal_transaksi` varchar(25) DEFAULT NULL,
  `nama_barang` varchar(50) DEFAULT NULL,
  `id_barang` varchar(25) DEFAULT NULL,
  `jumlah_beli_barang` varchar(25) DEFAULT NULL,
  `total_harga` varchar(25) DEFAULT NULL,
  `pembayaran` int(25) DEFAULT NULL,
  `kategori_barang` varchar(50) NOT NULL,
  `brand_barang` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tabel_riwayat_pembelian`
--

INSERT INTO `tabel_riwayat_pembelian` (`id_transaksi`, `id_admin`, `id_member`, `waktu_transaksi`, `tanggal_transaksi`, `nama_barang`, `id_barang`, `jumlah_beli_barang`, `total_harga`, `pembayaran`, `kategori_barang`, `brand_barang`) VALUES
(5, 2, 0, '11:06:10', '2023-12-15', 'Penggaris Butterfly 30cm - Pensil 2B - ', 'PGR001 - PNS001 - ', '2 - 3 - ', '6,000 - 7,500 - ', 14000, 'Penggaris - Pensil - ', 'Butterfly - Kenko - '),
(6, 1, 0, '16:04:02', '2023-12-15', 'Bulpen Super - Bolpenajaib - ', 'BLP003 - BLP005 - ', '15 - 12 - ', '75,000 - 36,000 - ', 120000, 'Bulpen - bolpen - ', 'Faber Castell - pilot - '),
(7, 1, 3, '16:05:21', '2023-12-15', 'Bulpen Super - ', 'BLP003 - ', '10 - ', '50,000 - ', 35000, 'Bulpen - ', 'Faber Castell - '),
(8, 1, 4, '16:08:19', '2023-12-15', 'Bulpen Super - ', 'BLP003 - ', '15 - ', '75,000 - ', 100000, 'Bulpen - ', 'Faber Castell - '),
(9, 1, 3, '22:01:27', '2023-12-15', 'Penggaris Butterfly 30cm - ', 'PGR001 - ', '10 - ', '30,000 - ', 21000, 'Penggaris - ', 'Butterfly - '),
(10, 1, 4, '22:05:24', '2023-12-15', 'Penggaris Butterfly 30cm - ', 'PGR001 - ', '20 - ', '60,000 - ', 54000, 'Penggaris - ', 'Butterfly - ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_admin`
--
ALTER TABLE `data_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tabel_barang`
--
ALTER TABLE `tabel_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tabel_member`
--
ALTER TABLE `tabel_member`
  ADD PRIMARY KEY (`id_member`);

--
-- Indexes for table `tabel_riwayat_pembelian`
--
ALTER TABLE `tabel_riwayat_pembelian`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tabel_member`
--
ALTER TABLE `tabel_member`
  MODIFY `id_member` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tabel_riwayat_pembelian`
--
ALTER TABLE `tabel_riwayat_pembelian`
  MODIFY `id_transaksi` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
