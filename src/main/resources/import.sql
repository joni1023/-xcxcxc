/*Usuario*/
insert into usuario(email,password,nombreUsuario,esAdmin) values("admin@admin.com","admin","Admin",1);
insert into usuario(email,password,nombreUsuario,esAdmin) values("mgallardo@river.com","muñecogallardo","M_Gallardo",0);
insert into usuario(email,password,nombreUsuario,esAdmin) values("galfaro@boca.com","alfaro123","G_Alfaro",0);
insert into usuario(email,password,nombreUsuario,esAdmin) values("sbeccacece@rojo.com","rojo666","S_Becaccece",0);
insert into usuario(email,password,nombreUsuario,esAdmin) values("ecoudet@racing.com","chacho123","E_Coudet",0);
insert into usuario(email,password,nombreUsuario,esAdmin) values("japizzi@cuervo.com","boedo123","JA_Pizzi",0);
insert into usuario(email,password,nombreUsuario,esAdmin) values("equipo1@equipo.com","equipo1","EquipoOne",0);
insert into usuario(email,password,nombreUsuario,esAdmin) values("equipo2@equipo.com","equipo2","EquipoTwo",0);
insert into usuario(email,password,nombreUsuario,esAdmin) values("equipo3@equipo.com","equipo3","EquipoThree",0);

/*Torneo*/
INSERT INTO `db`.`torneo` (`nombre`) VALUES ("Copa Libertadores");
INSERT INTO `db`.`torneo` (`nombre`) VALUES ("Copa Sudamericana");

/* Equipo */
insert into equipo (nombre,usuario_id,torneo_id) values ("River Plate",2,1);
insert into equipo (nombre,usuario_id,torneo_id) values ("Boca Juniors",3,1);
insert into equipo (nombre,usuario_id,torneo_id) values ("Independiente",4,1);
insert into equipo (nombre,usuario_id,torneo_id) values ("Racing Club",5,1);
insert into equipo (nombre,usuario_id,torneo_id) values ("San Lorenzo",6,1);
insert into equipo (nombre,usuario_id,torneo_id) values ("Equipo 1",7,1);
insert into equipo (nombre,usuario_id,torneo_id) values ("Equipo 2",8,1);
insert into equipo (nombre,usuario_id,torneo_id) values ("Equipo 3",9,2);
/*Usuario-Equipo*/
UPDATE `usuario` SET  `equipo_id` = '1' WHERE `usuario`.`id` = 2; 
UPDATE `usuario` SET  `equipo_id` = '2' WHERE `usuario`.`id` = 3; 
UPDATE `usuario` SET  `equipo_id` = '3' WHERE `usuario`.`id` = 4; 
UPDATE `usuario` SET  `equipo_id` = '4' WHERE `usuario`.`id` = 5; 
UPDATE `usuario` SET  `equipo_id` = '5' WHERE `usuario`.`id` = 6;
UPDATE `usuario` SET  `equipo_id` = '6' WHERE `usuario`.`id` = 7; 
UPDATE `usuario` SET  `equipo_id` = '7' WHERE `usuario`.`id` = 8; 
UPDATE `usuario` SET  `equipo_id` = '8' WHERE `usuario`.`id` = 9;
/* Jugador */
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"Franco Armani",1);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"Javier Pinola",1);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,20,"Leo Ponzio",1);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.5,85,19,"Lucas Pratto",1);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,55,18,"Rafa Borre",1);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.95,95,38,"Esteban Andrada",2);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,85,36,"Carlos Izquierdoz",2);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,85,31,"Nahitan Nandez",2);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.5,89,37,"Mauro Zarate",2);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,90,33,"Dario Benedetto",2);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"Martin Campaña",3);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"Fabricio Bustos",3);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,19,"Pablo Perez",3);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.58,85,29,"Martin Benitez",3);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,95,38,"Silvio Romero",3);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,85,21,"Gabriel Arias",4);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.90,70,30,"Alejandro Donatti",4);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,21,"Marcelo Diaz",4);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.58,85,19,"Dario Cvitanich",4);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,75,28,"Lisandro Lopez",4);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"Nicolas Navarro",5);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"Fabricio Coloccini",5);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,35,"Fernando Belluschi",5);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.58,85,29,"Nicolas Blandi",5);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,95,19,"Adolfo Gaich",5);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"Jugador 11",6);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"Jugador 12",6);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,35,"Jugador 13",6);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.58,85,29,"Jugador 14",6);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,95,19,"Jugador 15",6);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"Jugador 21",7);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"Jugador 22",7);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,35,"Jugador 23",7);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.58,85,29,"Jugador 24",7);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,95,19,"Jugador 25",7);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"Jugador 31",8);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"Jugador 32",8);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,35,"Jugador 33",8);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.58,85,29,"Jugador 34",8);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,95,19,"Jugador 35",8);

/* Valoracion por edad */
/* Arquero */
insert into valoracionedad (menor20,de20a25,de26a30,de31a35,mayor35) values(8,9,10,8,5);
/* Campo */
insert into valoracionedad (menor20,de20a25,de26a30,de31a35,mayor35) values(8,9,10,8,5);

/* Valoracion por altura */
/* Arquero */
INSERT INTO valoracionaltura (menor150cm,entre150y160cm, entre160y170cm, entre170y180cm, entre180y190cm, mayor190cm) VALUES (5,5,5,7.5,10,4);
/* Campo */
INSERT INTO valoracionaltura (menor150cm,entre150y160cm, entre160y170cm,entre170y180cm, entre180y190cm, mayor190cm) VALUES (5,5,7.5,10,8,4);

/* Valoracion por peso y altura */
/* Arquero */
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("menos150",4,6,6,8,6,4);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("entre150y160",4,6,6,8,6,4);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("entre160y170",4,4,6,6,8,6);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("entre170y180",7,8,8.5,7,6,4);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("entre180y190",4,6,10,8.5,7,4);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("mas190",3,3,4,6,8,6);
/* Campo */
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("menos150",4,6,6,8,6,4);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("entre150y160",4,6,6,8,6,4);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("entre160y170",4,4,6,6,8,6);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("entre170y180",7,8,8.5,7,6,4);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("entre180y190",4,6,10,8.5,7,4);
INSERT INTO valoracionpesoaltura (altura,menos60,entre60y70,entre70y80, entre80y90, entre90y100, mas100) VALUES ("mas190",3,3,4,6,8,6);

insert into valoracionesgenerales (radioMedicion) values (2);
