-- jugadores
-- arquero
INSERT INTO `db`.`jugador` (`posicion`, `altura`, `edad`, `fechaDeNacimiento`, `nombre`, `peso`) VALUES ('Arquero', '1.70', '25', '1990/01/01', 'juanarquero', '80.0');
INSERT INTO `db`.`jugador` (`posicion`, `altura`, `edad`, `fechaDeNacimiento`, `nombre`, `peso`) VALUES ('Arquero', '1.78', '25', '1990/01/01', 'nicoarquero', '110.0');
INSERT INTO `db`.`jugador` (`posicion`, `altura`, `edad`, `fechaDeNacimiento`, `nombre`, `peso`) VALUES ('Arquero', '1.58', '33', '1990/01/01', 'fedearquero', '110.0');
-- campo 
INSERT INTO `db`.`jugador` (`posicion`, `altura`, `edad`, `fechaDeNacimiento`, `nombre`, `peso`) VALUES ('Campo', '1.70', '25', '1990/01/01', 'juandefenza', '80.0');
INSERT INTO `db`.`jugador` (`posicion`, `altura`, `edad`, `fechaDeNacimiento`, `nombre`, `peso`) VALUES ('Campo', '1.78', '25', '1990/01/01', 'nicoenganche', '110.0');
INSERT INTO `db`.`jugador` (`posicion`, `altura`, `edad`, `fechaDeNacimiento`, `nombre`, `peso`) VALUES ('Campo', '1.58', '33', '1990/01/01', 'fedelateral', '110.0');



-- valoraciones edad
-- arqero
INSERT INTO `db`.`valoracionedad` (`de20a25`, `de26a30`, `de31a35`, `mayor35`, `menor20`) VALUES ('9.5', '10', '8.5', '7.5', '9.0');
-- campo
INSERT INTO `db`.`valoracionedad` (`de20a25`, `de26a30`, `de31a35`, `mayor35`, `menor20`) VALUES ('11', '9.0', '7.5', '4.5', '9.5');
-- valoraciones altura
-- arqero
INSERT INTO `db`.`valoracionaltura` (`entre150y160cm`, `entre160y170cm`, `entre170y180cm`, `entre180y190cm`, `mayor190cm`, `menor150cm`) VALUES ('7.0', '8.0', '9.5', '10', '12', '6.5');
-- campo
INSERT INTO `db`.`valoracionaltura` (`entre150y160cm`, `entre160y170cm`, `entre170y180cm`, `entre180y190cm`, `mayor190cm`, `menor150cm`) VALUES ('9.0', '9.5', '10', '11', '11.0', '8.0');
 -- valoracionpesoaltura por ahora es igual pero separe para tener posibilidad de cambiarlo
 -- arqero
 INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `menos60`) VALUES ('menos150', '9.5', '7.0', '2.0', '10');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`, `menos60`) VALUES ('entre150y160', '10', '9.0', '8.0', '6.0', '4.0', '9.5');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`) VALUES ('entre160y170', '9.0', '10', '11', '8.0', '6.0');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`) VALUES ('entre170y180', '9.5', '10', '11', '8.0', '7.0');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`) VALUES ('entre180y190', '8.0', '9.5', '10', '9.5', '8.0');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`) VALUES ('mas190', '8.0', '9.0', '9.5', '10');
-- campo
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `menos60`) VALUES ('menos150', '9.5', '7.0', '2.0', '10');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`, `menos60`) VALUES ('entre150y160', '10', '9.0', '8.0', '6.0', '4.0', '9.5');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`) VALUES ('entre160y170', '9.0', '10', '11', '8.0', '6.0');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`) VALUES ('entre170y180', '9.5', '10', '11', '8.0', '7.0');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre60y70`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`) VALUES ('entre180y190', '8.0', '9.5', '10', '9.5', '8.0');
INSERT INTO `db`.`valoracionpesoalturaa` (`altura`, `entre70y80`, `entre80y90`, `entre90y100`, `mas100`) VALUES ('mas190', '8.0', '9.0', '9.5', '10');
