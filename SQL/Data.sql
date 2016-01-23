-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 23 Janvier 2016 à 10:53
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `apocalypse`
--

-- --------------------------------------------------------

--
-- Structure de la table `likes`
--

CREATE TABLE IF NOT EXISTS `likes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPost` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `likeDate` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Contenu de la table `likes`
--

INSERT INTO `likes` (`id`, `idPost`, `idUser`, `likeDate`) VALUES
(23, 3, 14, 1815387752),
(25, 7, 14, 1819286145),
(26, 11, 14, 1819746757),
(28, 9, 14, 1823225258),
(30, 4, 14, 1823273398),
(31, 10, 14, 1824523915);

-- --------------------------------------------------------

--
-- Structure de la table `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Date` bigint(11) NOT NULL,
  `Content` text NOT NULL,
  `userId` int(11) NOT NULL,
  `isComment` tinyint(1) NOT NULL DEFAULT '0',
  `isCommentOf` int(11) NOT NULL DEFAULT '0',
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Contenu de la table `posts`
--

INSERT INTO `posts` (`Id`, `Date`, `Content`, `userId`, `isComment`, `isCommentOf`, `title`) VALUES
(3, 1953189980, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad <b>minim </b>veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. <br><br><br><br>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum', 3, 0, 0, 'Truc Bidule New - The Origin'),
(4, 1453189985, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum', 4, 0, 0, 'Un vrai Titre'),
(6, 1453189985, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum', 6, 0, 0, 'fdgdfgfd'),
(7, 1453189985, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum', 7, 0, 0, 'tghj;,jhgtr'),
(8, 1453189985, 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?', 8, 0, 0, 'sghj;kjjhs'),
(9, 1453189985, 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?', 9, 0, 0, '5874264853'),
(10, 1453189985, 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?', 10, 0, 0, 'fdshjhrgesfg'),
(11, 1453189985, '<u>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?</u>', 11, 0, 0, 'Titre en gros'),
(12, 1453189985, 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?', 12, 0, 0, '-(''-(''-('''),
(13, 1453189985, '<font color="#FF0000">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?</font>', 13, 0, 0, 'Last !'),
(14, 1453189985, 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?', 14, 0, 0, 'azefgthujytre'),
(15, 119515465, 'zerghftdre', 15, 0, 0, 'rthjtegdf'),
(16, 145699775, 'FEEEEEEEEEEEEURST', 16, 1, 3, 'PREUMS'),
(17, 145698736, 'NOOOOOON j''ai raté d''être le premier commentaire :''(', 17, 1, 3, 'DEUZ'),
(18, 1564549876, 'fsdg,hjkjhgfdseq', 18, 0, 0, 'fdgfdgfdgfd'),
(19, 1498756423, 'sqzdefgthujmlkjhugftds', 0, 0, 0, 'vbcvnvnvb'),
(20, 1498756423, 'sqzdefgthujmlkjhugftds', 0, 0, 0, 'rezrtryuyih'),
(21, 1498756423, 'szqdefghjklmùlkhujgtfdsefgthjklkjhgfd', 0, 0, 0, 'cvn, ;jhgt'),
(24, 1518575236, 'dfgthujkljhgft', 14, 0, 0, 'sdfghjkjhgfds'),
(25, 1542305973, 'jhgfhjblkm', 14, 0, 0, 'aszdefghjkhgfdesz'),
(26, 1782504405, 'szdefrgthyujpmù*\r\nùm^poliuytreds', 14, 0, 0, 'Un vrai Titre'),
(27, 1788681368, 'loulilol', 1, 1, 3, 'Truc Bidule New - The Origin - My Comment'),
(28, 1788869555, 'Coucou maman je passe sur internet !', 1, 1, 3, 'C''était trop bien ton post lol'),
(29, 12, 'Attrapez-les touuuuuuuuuuuus', 1, 1, 3, 'Pokémon'),
(30, 1789322519, 'WEEEEEEEEEESH', 1, 1, 4, 'OUAIS MAGGLE'),
(31, 1808035984, '<p><span style="background-color: rgb(255, 231, 206);"><br></span></p><p><span style="background-color: rgb(255, 231, 206);"><span style="font-style: italic;">\r\n                    Curabitur pretium tincidunt lacus. Nulla gravida \r\norci a odio. Nullam varius, turpis et commodo pharetra, est eros \r\nbibendum elit, nec luctus magna felis sollicitudin mauris. Integer in \r\nmauris eu nibh euismod gravida. Duis ac tellus et risus vulputate \r\nvehicula. Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper, \r\nligula eu tempor congue, eros est euismod turpis, id tincidunt sapien \r\nrisus a quam. Maecenas fermentum consequat mi. Donec fermentum. \r\nPellentesque malesuada nulla a mi. Duis sapien sem, aliquet nec, commodo\r\n eget, consequat quis, neque. Aliquam faucibus, elit ut dictum aliquet, \r\nfelis nisl adipiscing sapien, sed malesuada diam lacus eget erat. Cras \r\nmollis scelerisque nunc. Nullam arcu. Aliquam consequat. Curabitur augue\r\n lorem, dapibus quis, laoreet et, pretium ac, nisi. Aenean magna nisl, \r\nmollis quis, molestie eu, feugiat in, orci. In hac habitasse platea \r\ndictumst.\r\n                </span></span></p><p><span style="background-color: rgb(255, 231, 206);"><br></span></p>', 14, 0, 0, 'test'),
(32, 1808981733, '<p><span style="background-color: rgb(255, 255, 0);"><u><b><font face="Arial Black"><font color="#FF0000">aszdfgujkhjgfsdeqfg,njnk</font><br></font></b></u></span></p>', 14, 0, 0, 'PROUT'),
(33, 1809785394, '<p>azdefrgtyhujkhjgfterz<br></p>', 14, 0, 0, 'loooooooool'),
(34, 1809794724, 'Boston', 14, 0, 0, 'John'),
(35, 1815972, '<pre><b>UN POING C''EST TOUUUUUUUUUUUT</b><br></pre>', 14, 0, 0, 'Esh.');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(40) NOT NULL,
  `Mail` varchar(535) NOT NULL,
  `Password` varchar(40) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`),
  UNIQUE KEY `Mail` (`Mail`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`Id`, `Name`, `Mail`, `Password`) VALUES
(1, 'Chikara', 'chikara@lolilol.com', 'azerty'),
(2, 'Pingu', 'pingu@lolilol.com', 'azerty'),
(3, 'Pina', 'pina@lolilol.com', 'azerty'),
(4, 'Chrossowen', 'chrossowen@lolilol.com', 'azerty'),
(5, 'Tekzes', 'tekzes@lolilol.com', 'azerty'),
(6, 'Lilyan', 'lilyan@lolilol.com', 'azerty'),
(7, 'Aya', 'aya@lolilol.com', 'azerty'),
(8, 'Jeck', 'jeck@lolilol.com', 'azerty'),
(9, 'Rixek', 'rixek@lolilol.com', 'azerty'),
(10, 'Neiry', 'neiry@lolilol.com', 'azerty'),
(11, 'Sphyraen', 'sphyraen@lolilol.com', 'azerty'),
(12, 'Sphynaelle', 'sphynaelle@lolilol.com', 'azerty'),
(13, 'Nilina', 'nilina@lolilol.com', 'azerty'),
(14, 'Dirgan', 'dirgan@lolilol.com', 'azerty');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
