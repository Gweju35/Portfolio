--
-- Base de données du cas 'Transmusicales'
--

--
-- Initialisation du schéma :
--
DROP SCHEMA IF EXISTS transmusicales CASCADE;
CREATE SCHEMA transmusicales;
SET SCHEMA 'transmusicales';

--
-- Tables :
--
CREATE TABLE _groupe_artiste
(
   Id_Groupe_Artiste VARCHAR(3) NOT NULL,
   nom_groupe_artiste VARCHAR(40) NOT NULL,
   site_web VARCHAR,
   an_debut INTEGER NOT NULL,
   an_sortie_discographie INTEGER NOT NULL,
   p_origine VARCHAR(20),
   libelle_formation VARCHAR(30),
   type_ponctuel_m VARCHAR(20),
   type_principal_m VARCHAR(20),
   CONSTRAINT _groupe_artiste_pk PRIMARY KEY (Id_Groupe_Artiste)
);

CREATE TABLE _formation
(
   libelle_formation VARCHAR(30)  NOT NULL,
   
   CONSTRAINT _formation_pk PRIMARY KEY (libelle_formation)
);

CREATE TABLE _pays
(
   nom_p VARCHAR(20)  NOT NULL,
   CONSTRAINT _pays_pk PRIMARY KEY (nom_p)
);

CREATE TABLE _ville
(
   nom_v VARCHAR(20)  NOT NULL,
   nom_p VARCHAR(20)  NOT NULL,
   CONSTRAINT _ville_pk PRIMARY KEY (nom_v)
);

CREATE TABLE _edition
(
   nom_edition VARCHAR(20)  NOT NULL,
   annee_edition VARCHAR(10)  NOT NULL,
   CONSTRAINT _edition_pk PRIMARY KEY (nom_edition)
);

CREATE TABLE _lieu
(
   id_lieu VARCHAR(3) NOT NULL,
   nom_lieu VARCHAR(20) NOT NULL,
   accesPMR BOOLEAN NOT NULL,
   capacite_max INTEGER NOT NULL,
   type_lieu VARCHAR(20)  NOT NULL,
   nom_v VARCHAR(20)  NOT NULL,
   CONSTRAINT _lieu_pk PRIMARY KEY (id_lieu)
);

CREATE TABLE _representation
(
   numero_presentation VARCHAR(10)   NOT NULL,
   heure VARCHAR()  NOT NULL,
   date_representation DATE NOT NULL,
   Id_Groupe_Artiste VARCHAR(3)   NOT NULL,
   id_lieu VARCHAR(3) NOT NULL,
   no_concert VARCHAR(5) NOT NULL,
   CONSTRAINT _representation_pk PRIMARY KEY (numero_presentation)
);

CREATE TABLE _concert
(
   no_concert VARCHAR(10) NOT NULL,
   titre VARCHAR(40)  NOT NULL,
   resume VARCHAR(200)  NOT NULL,
   duree INTEGER  NOT NULL,
   tarif FLOAT  NOT NULL,
   type_m_c VARCHAR(20)   NOT NULL,
   nom_edition VARCHAR(20)  NOT NULL,
   CONSTRAINT _concert_pk PRIMARY KEY (no_concert)
);

CREATE TABLE _type_musique
(
   type_m VARCHAR(20)   NOT NULL,
   CONSTRAINT _type_musique PRIMARY KEY (type_m)
);

CREATE TABLE _annee
(
	an INTEGER   NOT NULL,
	CONSTRAINT _annee_pk PRIMARY KEY (an)
);

--
-- Contraintes :
--

alter table _groupe_artiste
  add constraint _groupe_artiste_fk1_annee
  foreign key(an_debut) references _annee(an);

alter table _groupe_artiste
  add constraint _groupe_artiste_fk2_annee
  foreign key(an_sortie_discographie) references _annee(an);

alter table _groupe_artiste
  add constraint _groupe_artiste_fk_pays
  foreign key(p_origine) references _pays(nom_p);

alter table _groupe_artiste
  add constraint _groupe_artiste_fk_formation
  foreign key(libelle_formation) references _formation(libelle_formation);

alter table _groupe_artiste
  add constraint _groupe_artiste_fk1_type_musique
  foreign key(type_ponctuel_m) references _type_musique(type_m);

alter table _groupe_artiste
  add constraint _groupe_artiste_fk2_type_musique
  foreign key(type_principal_m) references _type_musique(type_m);

alter table _representation
  add constraint _representation_fk_groupe_artiste
  foreign key(Id_Groupe_Artiste) references _groupe_artiste(Id_Groupe_Artiste);

alter table _representation
  add constraint _representation_fk_lieu
  foreign key(id_lieu) references _lieu(id_lieu);

alter table _representation
  add constraint _representation_fk_concert
  foreign key(no_concert) references _concert(no_concert);

alter table _concert
  add constraint _concert_fk_type_musique
  foreign key(type_m_c) references _type_musique(type_m);

alter table _concert
  add constraint _concert_fk_edition
  foreign key(nom_edition) references _edition(nom_edition);

alter table _edition
  add constraint _edition_fk_annee
  foreign key(annee_edition) references _annee(an);

  
alter table _ville
  add constraint _ville_fk_pays
  foreign key(nom_p) references _pays(nom_p);

alter table _lieu
  add constraint _lieu_fk_ville
  foreign key(nom_v) references _ville(nom_v);


