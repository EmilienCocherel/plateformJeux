-- Ligne à décommanter si vous avez les droits pour créer une nouvelle base de données
-- CREATE DATABASE IF NOT EXISTS serveurDeJeux DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- USE serveurDeJeux;

CREATE TABLE JOUEUR (
  idJo decimal(6,0),
  pseudoJo varchar(10) unique,
  emailJo varchar(100),
  mdpJo varchar(100),
  activeJo char(1),
  PRIMARY KEY (idJo)
);

CREATE TABLE ETREAMI (
  idJo decimal(6,0),
  idJo1 decimal(6,0),
  PRIMARY KEY (idJo, idJo1)
);

CREATE TABLE MESSAGE (
  idMsg decimal(6,0),
  dateMsg datetime,
  contenuMsg text,
  luMsg char(1),
  idJo decimal(6,0),
  idJo1 decimal(6,0),
  PRIMARY KEY (idMsg)
);


CREATE TABLE INVITATION (
  idInv decimal(6,0),
  dateInv datetime,
  etatInv char(1),
  idJo decimal(6,0),
  idJo1 decimal(6,0),
  PRIMARY KEY (idInv)
);

CREATE TABLE PARTIE (
  idPa decimal(6,0),
  debutPa datetime,
  numEtape char(1),
  etatPartie text,
  idJeu decimal(6,0),
  idJo1 decimal(6,0),
  score1 VARCHAR(42),
  idJo2 decimal(6,0),
  score2 VARCHAR(42),
  PRIMARY KEY (idPa)
);

CREATE TABLE JEU (
  idJeu decimal(6,0),
  nomJeu varchar(20),
  regleJeu text,
  jarJeu blob,
  activeJeu char(1),
  idTy decimal(6,0),
  PRIMARY KEY (idJeu)
);

CREATE TABLE TYPEJEU (
  idTy decimal(6,0),
  nomTy varchar(20),
  PRIMARY KEY (idTy)
);

ALTER TABLE ETREAMI ADD FOREIGN KEY (idJo1) REFERENCES JOUEUR (idJo);
ALTER TABLE ETREAMI ADD FOREIGN KEY (idJo) REFERENCES JOUEUR (idJo);
ALTER TABLE MESSAGE ADD FOREIGN KEY (idJo1) REFERENCES JOUEUR (idJo);
ALTER TABLE MESSAGE ADD FOREIGN KEY (idJo) REFERENCES JOUEUR (idJo);
ALTER TABLE PARTIE ADD FOREIGN KEY (idJo1) REFERENCES JOUEUR (idJo);
ALTER TABLE PARTIE ADD FOREIGN KEY (idJo2) REFERENCES JOUEUR (idJo);
ALTER TABLE PARTIE ADD FOREIGN KEY (idJeu) REFERENCES JEU (idJeu);
ALTER TABLE INVITATION ADD FOREIGN KEY (idJo1) REFERENCES JOUEUR (idJo);
ALTER TABLE INVITATION ADD FOREIGN KEY (idJo) REFERENCES JOUEUR (idJo);
ALTER TABLE JEU ADD FOREIGN KEY (idTy) REFERENCES TYPEJEU (idTy);
