-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 11-Dez-2023 às 21:21
-- Versão do servidor: 8.0.31
-- versão do PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `alphasystem`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `credential`
--

DROP TABLE IF EXISTS `credential`;
CREATE TABLE IF NOT EXISTS `credential` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `lastAcess` date NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `credential`
--

INSERT INTO `credential` (`id`, `username`, `password`, `lastAcess`, `enabled`) VALUES
(108, '@anazaira', '17249174ced2a3c94f2fef06a258c453', '2023-08-29', 1),
(109, '@brunoyan', '3231c5184dac185bd99e1ff84e1ef75e', '2023-08-29', 1),
(110, '@caiowillian', 'ee2c589631a36256721ca129ac7b9a61', '2023-08-29', 1),
(121, 'luiz', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(130, 'andre', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(131, 'luizfreitas', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(132, '@sergiomonteiro', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(133, '@franciscodias', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(134, '@marinaassis', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(135, '@sandraporto', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(136, '@mariorosa', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(137, '@fernandoneves', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 0),
(138, '@isabelaalves', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 0),
(139, '@leandrocosta', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(140, '@isadoraluz', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(141, '@biancapaula', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(142, 'admin', '910481795e57aab3bc6297770ec349ee', '2023-12-01', 1),
(143, 'biblio01', '35d0fe365214cbc21f7bf6f12968124b', '2023-12-01', 1),
(144, 'leitor1', '1f57914a8b6a150d20f9e6190661941b', '2023-12-01', 1),
(145, 'lsr21', '910481795e57aab3bc6297770ec349ee', '2023-12-05', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `exemplar`
--

DROP TABLE IF EXISTS `exemplar`;
CREATE TABLE IF NOT EXISTS `exemplar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `livro_id` int DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `livro_id` (`livro_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `librarian`
--

DROP TABLE IF EXISTS `librarian`;
CREATE TABLE IF NOT EXISTS `librarian` (
  `id` bigint NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `librarian`
--

INSERT INTO `librarian` (`id`, `name`, `email`, `birthdate`) VALUES
(108, 'Ana Zaira', 'anazaira123@mail.com', '2000-01-01'),
(141, 'Bruna Bianca de Paula', 'brunabiancadepaula@ortovip.com.br', '1965-12-01'),
(143, 'Bibliotecário 01', 'bibliotecario01@mail.com', '2023-12-01'),
(145, 'Lucas Santos Ribeiro', 'lucasrib421@gmail.com', '2003-03-11');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

DROP TABLE IF EXISTS `livro`;
CREATE TABLE IF NOT EXISTS `livro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `authors` varchar(250) NOT NULL,
  `page` smallint NOT NULL,
  `year` smallint NOT NULL,
  `edition` tinyint NOT NULL,
  `qtdExemplares` int NOT NULL,
  `qtdExemplaresDisponiveis` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`id`, `title`, `authors`, `page`, `year`, `edition`, `qtdExemplares`, `qtdExemplaresDisponiveis`) VALUES
(1, 'Quarto de despejo', 'Carolina Maria de Jesus', 200, 1960, 1, 10, 10),
(2, 'Mundo em Caos', 'Patrick Ness', 450, 2019, 1, 10, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `reader`
--

DROP TABLE IF EXISTS `reader`;
CREATE TABLE IF NOT EXISTS `reader` (
  `id` bigint NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `reader`
--

INSERT INTO `reader` (`id`, `name`, `email`, `birthdate`) VALUES
(109, 'Bruno Yan', 'brunoyan123@mail.com', '2001-02-02'),
(110, 'Caio Willian', 'carloswillian123@mail.com', '2002-03-03'),
(132, 'Sérgio Antonio Monteiro', 'sergioantoniomonteiro@gamil.com', '2003-05-22'),
(133, 'Francisco Marcos Vinicius Dias', 'francisco_dias@paginacom.com.br', '2003-02-11'),
(134, 'Marina Carolina Liz Assis', 'marina-assis95@agrosb.com.br', '1998-03-10'),
(135, 'Sandra Aparecida Porto', 'sandra_porto@truckeixo.com.br', '1998-08-15'),
(136, 'Mário Joaquim da Rosa', 'mario_joaquim_darosa@tribunaimpressa.com.br', '1993-10-24'),
(137, 'Fernando Calebe das Neves', 'fernandocalebedasneves@padrejuliano.com', '1993-11-22'),
(138, 'Isabela Lara Alves', 'isabela_alves@mcpsolucoesgraficas.com.br', '2002-04-10'),
(139, 'Leandro André Costa', 'leandro-costa74@eccotrans.com.br', '1965-03-27'),
(140, 'Isadora Débora Olivia da Luz', 'isadoradeboradaluz@editorazap.com.br', '1965-03-08'),
(144, 'Leitor 01', 'leitor01@mail.com', '2023-12-01');

-- --------------------------------------------------------

--
-- Estrutura da tabela `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(69, 'Leitor'),
(70, 'Bibliotecario'),
(71, 'Administrador');

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL,
  `name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `birthdate` date NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_users_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `birthdate`, `role_id`) VALUES
(108, 'Ana Zaira', 'anazaira123@mail.com', '2000-01-01', 71),
(109, 'Bruno Yan', 'brunoyan123@mail.com', '2001-02-02', 69),
(110, 'Caio Willian', 'carloswillian123@mail.com', '2002-03-03', 69),
(121, 'Luiz Freitas', 'luizfreitas@mail.com', '2003-04-06', 71),
(130, 'André Felipe de Oliveira Lopes', 'afdol@aluno.ifnmg.edu.br', '2003-02-06', 71),
(131, 'Luiz Felipe Oliveira Freitas', 'lfof@aluno.ifnmg.edu.br', '2003-04-06', 71),
(132, 'Sérgio Antonio Monteiro', 'sergioantoniomonteiro@gamil.com', '2003-05-22', 69),
(133, 'Francisco Marcos Vinicius Dias', 'francisco_dias@paginacom.com.br', '2003-02-11', 69),
(134, 'Marina Carolina Liz Assis', 'marina-assis95@agrosb.com.br', '1998-03-10', 69),
(135, 'Sandra Aparecida Porto', 'sandra_porto@truckeixo.com.br', '1998-08-15', 69),
(136, 'Mário Joaquim da Rosa', 'mario_joaquim_darosa@tribunaimpressa.com.br', '1993-10-24', 69),
(137, 'Fernando Calebe das Neves', 'fernandocalebedasneves@padrejuliano.com', '1993-11-22', 69),
(138, 'Isabela Lara Alves', 'isabela_alves@mcpsolucoesgraficas.com.br', '2002-04-10', 69),
(139, 'Leandro André Costa', 'leandro-costa74@eccotrans.com.br', '1965-03-27', 69),
(140, 'Isadora Débora Olivia da Luz', 'isadoradeboradaluz@editorazap.com.br', '1965-03-08', 69),
(141, 'Bruna Bianca de Paula', 'brunabiancadepaula@ortovip.com.br', '1965-12-01', 70),
(142, 'admin', 'admin@mail.com', '2023-12-01', 71),
(143, 'Bibliotecário 01', 'bibliotecario01@mail.com', '2023-12-01', 70),
(144, 'Leitor 01', 'leitor01@mail.com', '2023-12-01', 69),
(145, 'Lucas Santos Ribeiro', 'lucasrib421@gmail.com', '2003-03-11', 70);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `librarian`
--
ALTER TABLE `librarian`
  ADD CONSTRAINT `librarian_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `reader`
--
ALTER TABLE `reader`
  ADD CONSTRAINT `reader_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Limitadores para a tabela `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `foreingKey` FOREIGN KEY (`id`) REFERENCES `credential` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
