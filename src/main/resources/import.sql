/* Equipo */
insert into equipo (nombre) values ("River Plate");
insert into equipo (nombre) values ("Boca Juniors");
insert into equipo (nombre) values ("Independiente");
insert into equipo (nombre) values ("Racing Club");

/* Jugador */
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"juanArquero",1);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"matiasCampo",1);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,20,"pabloCampo",1);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.5,85,19,"ignacioCampo",1);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,55,18,"gastonCampo",1);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.95,95,32,"juanArquero",2);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,85,28,"matiasCampo",2);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,85,31,"pabloCampo",2);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.5,89,29,"ignacioCampo",2);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,90,27,"gastonCampo",2);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"juanArquero",3);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"matiasCampo",3);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,19,"pabloCampo",3);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.58,85,29,"ignacioCampo",3);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,95,38,"gastonCampo",3);

insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Arquero",1.88,95,21,"juanArquero",4);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.75,70,25,"matiasCampo",4);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.8,75,19,"pabloCampo",4);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.58,85,29,"ignacioCampo",4);
insert into jugador (posicion,altura,peso,edad,nombre,equipo_id) values("Campo",1.65,95,38,"gastonCampo",4);

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
/* usuarios */
insert into usuario (email,esAdmin,nombreUsuario,password) values ('admin@admin',true,'admin','admin');
insert into usuario (email,esAdmin,nombreUsuario,password,equipo_id) values ('equipo1@equipo1',false,'equipo1','equipo1',1);
insert into usuario (email,esAdmin,nombreUsuario,password,equipo_id) values ('equipo2@equipo2',false,'equipo2','equipo2',2);