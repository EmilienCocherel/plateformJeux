
CREATE TABLE PARTIETEST (
  idPa decimal(6,0),
  debutPa datetime,
  numEtape decimal(3,0),
  etatPartie text,
  idJeu decimal(6,0),
  idUt1 decimal(6,0),
  score1 VARCHAR(42),
  idUt2 decimal(6,0),
  score2 VARCHAR(42),
  PRIMARY KEY (idPa)
);

CREATE TABLE JEUTEST (
  idJeu decimal(6,0),
  nomJeu varchar(20),
  regleJeu text,
  jarJeu blob,
  activeJeu char(1),
  idTy decimal(6,0),
  PRIMARY KEY (idJeu)
);
