create table vehiculos(
codvehiculo int(4),
marca varchar(20),
modelo  varchar(40),
tipo varchar(5),
color varchar(15),
motor varchar(5),
cilindrada int(4),
fecha date,
matricula  varchar(15),
extras varchar(100),
precio decimal(8,2)
);

alter table vehiculos add constraint vehiculos_pk primary key(codvehiculo);

INSERT INTO vehiculos VALUES (100,'Opel','Corsa 1.2 Sport','C','Azul','G',1195,'1994/08/12','V-2360-DX','Antena  Eléctrica',14000);
INSERT INTO vehiculos VALUES (101,'Ford','Probe 2.0 16V','C','Blanco','G',1995,'1994/08/10','V-1010-PB','',39000);
INSERT INTO vehiculos VALUES (105,'Ford','Orion 1.8 Ghia','C','Rojo','D',1795,'1994/03/27','M-4578-DB','Aire  Acondicionado',21000);
INSERT INTO vehiculos VALUES (200,'Yamaha','FZR 1100','M','Blanco','G',1095,'1993/08/08','B-1222-HY','',11000);
INSERT INTO vehiculos VALUES (225,'Citroen','Xantia 16V','C','Negro','G',1995,'1994/05/17','A-7640- DU','Airbag',32000);
INSERT INTO vehiculos VALUES (260,'Ford','Escort 1.6 Ghia','C','Verde','D',1595,'22/02/1993/02/22','M-3543- NC','',20500);
INSERT INTO vehiculos VALUES (289,'Citroen','Zx Turbo-D','C','Amarillo','D',1795,'1993/12/20','B-7632-NX','Aire  Acondicionado',26000);
INSERT INTO vehiculos VALUES (348,'Honda','CBR 600','M','Negro','G',595,'1994/02/02','B-4876-KK','',6700);
INSERT INTO vehiculos VALUES (352,'Ford','Fiesta 1.4 CLX','C','Blanco','G',1395,'1990/05/20','M-8018- LJ','Elevalunas eléctrico',14500);
INSERT INTO vehiculos VALUES (390,'Renault','Clio 1.7 S','C','Blanco','D',1695,'1993/02/03','V-2565- NB','Elevalunas eléctrico',16000);
INSERT INTO vehiculos VALUES (480,'Kawasaki','GPZ 500','M','Negro','G',495,'1994/10/10','V-4371-ES','',3500);
INSERT INTO vehiculos VALUES (810,'Ford','Mondeo 1.8 GLX','C','Granate','G',1795,'1994/05/05','V-7642- DU','Elevalunas eléctrico',28600);
INSERT INTO vehiculos VALUES (822,'Audi','A4 1.9','C','Negro','G',1895,'1990/02/20','V-1234- LC','Climatizador',36000);
INSERT INTO vehiculos VALUES (860,'Peugeot','205 GTI','C','Rojo','G',1795,'1990/04/10','A-9834-LH','Cierre  Centralizado',21000);
INSERT INTO vehiculos VALUES (902,'Kawasaki','GPX 600','M','Rojo','G',595,'1990/07/13','A-3832-AM','',6200);
INSERT INTO vehiculos VALUES (1272,'Lancia','Delta Integrale','C','Blanco','G',1795,'1994/11/05','V-6345-DD','Full  Equipe',14500);
INSERT INTO vehiculos VALUES (1295,'Honda','CB 750','M','Negro','G',745,'1995/04/03','M-9683-HR','',9470);
INSERT INTO vehiculos VALUES (1312,'Chrysler','180','C','Azul','D',1795,'1993/03/16','B-2213-FD','',4500);
INSERT INTO vehiculos VALUES (1392,'Matra','Bagheera','C','Rojo','G',1795,'1991/04/23','M-4764-GH','Elevalunas  eléctrico',9000);
INSERT INTO vehiculos VALUES (1412,'Citroen','Ax Turbo-D','C','Negro','D',1795,'1992/02/11','A-9583- AD','Climatizador',6400);
INSERT INTO vehiculos VALUES (1450,'BMW','K-100','M','Verde','G',995,'1992/10/22','M-4334- AC','Portamaletas',9600);
INSERT INTO vehiculos VALUES (1488,'Mitsubishi','Eclipse GS 16V','C','Verde','G',1595,'1993/09/29','V-4753- EJ','Full Equipe',45000);
INSERT INTO vehiculos VALUES (1489,'Ford','Escort 1.6 CLD','C','Blanco','D',1595,'1994/07/10','M-9457- FF','Airbag',8950);
INSERT INTO vehiculos VALUES (1500,'Mercedes','C280','C','Gris','G',1995,'1994/09/01','B-5432-PC','Todos los  posibles',54000);
INSERT INTO vehiculos VALUES (1527,'Ford','Escort 1.3 CL','C','Azul','G',1295,'1992/12/22','V-7846-DF','Radio- Cassette',5600);
INSERT INTO vehiculos VALUES (1549,'Montesa','Enduro 250 H7','M','Blanco','G',245,'/1990/11/30','V-8945- CP','',1450);
INSERT INTO vehiculos VALUES (1599,'Nissan','Patrol','C','Blanco','G',1995,'1993/12/12','A-4874-CD','Aire  Acondicionado',19000);
INSERT INTO vehiculos VALUES (1605,'Opel','Omega 2.0 CD','C','Rojo','D',1995,'1993/09/19','B-4762-GH','Full  Equipe',17000);
INSERT INTO vehiculos VALUES (1633,'Nissan','Bluebird 2.0 SLX','C','Negro','G',1995,'1995/05(01','M-8746- PQ','Elevalunas eléctrico',18200);
INSERT INTO vehiculos VALUES (1649,'Renault','Voyager','C','Azul','G',1795,'1992/12/02','B-3476-KL','Aire  Acondicionado',23000);
INSERT INTO vehiculos VALUES (1655,'Suzuki','GS-750','M','Negro','G',745,'1990/03/12','B-9944-HJ','',5400);
INSERT INTO vehiculos VALUES (1678,'Renault','R-19 16V','C','Negro','G',1795,'1994/01vehiculos/31','V-8464-EF','Radio- Cassette',18000);
INSERT INTO vehiculos VALUES (1686,'Seat','850 Spider','C','Blanco','G',1295,'1990/01/11','A-7476-AA','',9500);
INSERT INTO vehiculos VALUES (1702,'Renault','Megane RN 1.4','C','Azul','G',1395,'1993/03/12','B-6694- KD','Climatizador',19000);
INSERT INTO vehiculos VALUES (1712,'Volkswagen','Polo','C','Azul','G',1295,'1995/09/03','V-4764-EH','Radio- Cassette',13000);
INSERT INTO vehiculos VALUES (1718,'Renault','Cinco','C','Negro','G',1095,'1990/11/22','B-7846-BB','',3450);
INSERT INTO vehiculos VALUES (1722,'Volkswagen','Multivan 4x4','C','Azul','G',1995,'1994/04/01','A-3484- AC','Climatizador',23000);
INSERT INTO vehiculos VALUES (1832,'Yamaha','Scooter','M','Negro','G',145,'1995/07/12','V-4723-EG','',1200);
INSERT INTO vehiculos VALUES (1945,'Volkswagen','Golf GTI','C','Azul','G',1395,'1992/03/03','M-7646-HI','Radio- Cassette',13500);
INSERT INTO vehiculos VALUES (1995,'Suzuki','GS 500','M','Negro','G',495,'1992/04/10','V-3357-DX','',7300);



COMMIT;