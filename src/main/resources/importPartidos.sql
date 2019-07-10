INSERT INTO `db`.`partido` (`id`) VALUES ('1');

INSERT INTO `db`.`partido` (`id`) VALUES ('2');

INSERT INTO equipo_partido VALUES (1 , 1);

INSERT INTO equipo_partido VALUES (2 , 1);


INSERT INTO equipo_partido VALUES (3 , 2);

INSERT INTO equipo_partido VALUES (4 , 2);

INSERT INTO `db`.`gol` (`id`, `cantidad`, `jugador_id`, `partido_id`) VALUES ('1', '7', '1', '1');

INSERT INTO `db`.`gol` (`id`, `cantidad`, `jugador_id`, `partido_id`) VALUES ('2', '5', '7', '1');

INSERT INTO `db`.`gol` (`id`, `cantidad`, `jugador_id`, `partido_id`) VALUES ('3', '3', '12', '2');

INSERT INTO `db`.`gol` (`id`, `cantidad`, `jugador_id`, `partido_id`) VALUES ('4', '1', '17', '2');

INSERT INTO `db`.`jugador_gol` (`Jugador_id`, `goles_id`) VALUES ('2', '1');

INSERT INTO `db`.`jugador_gol` (`Jugador_id`, `goles_id`) VALUES ('7', '2');
INSERT INTO `db`.`jugador_gol` (`Jugador_id`, `goles_id`) VALUES ('12', '3');

INSERT INTO `db`.`jugador_gol` (`Jugador_id`, `goles_id`) VALUES ('17', '4');


INSERT INTO `db`.`partido_gol` (`Partido_id`, `golesEquipo2_id`, `golesEquipo1_id`) VALUES ('1', '2', '1');

INSERT INTO `db`.`partido_gol` (`Partido_id`, `golesEquipo2_id`, `golesEquipo1_id`) VALUES ('2', '4', '3');

