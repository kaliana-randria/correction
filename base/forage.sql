CREATE TABLE client(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    contact VARCHAR(100)
);

INSERT INTO client(nom, contact) VALUES
('RAKOTO', '034 10 300 01');
-- ('Ratiana', '0382347589');

CREATE TABLE demande(
    id SERIAL PRIMARY KEY,
    date TIMESTAMP,
    id_client INT REFERENCES client(id),
    lieu VARCHAR(100),
    district VARCHAR(100)
);

CREATE TABLE type_devis(
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(100)
);
INSERT INTO type_devis(libelle) VALUES
('ETUDE'),
('FORAGE');

CREATE TABLE devis(
    id SERIAL PRIMARY KEY,
    id_type_devis INT REFERENCES type_devis(id),
    date TIMESTAMP,
    id_demande INT REFERENCES demande(id)
);

CREATE TABLE devis_details(
    id SERIAL PRIMARY KEY,
    id_devis INT REFERENCES devis(id),
    libelle VARCHAR(100),
    prix_unitaire NUMERIC(10,2),
    quantite INT
);

CREATE TABLE statut(
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(100)
);

INSERT INTO statut(libelle) VALUES
('cree'),
('devis etude cree'),
('devis etude accepte'),
('devis forage cree'),
('devis forage accepte'),
('forage commence'),
('forage termine');

CREATE TABLE demande_statut(
    id SERIAL PRIMARY KEY,
    id_demande INT REFERENCES demande(id),
    id_statut INT REFERENCES statut(id),
    date TIMESTAMP
);
ALTER TABLE demande_statut 
ADD COLUMN observation VARCHAR(255);

ALTER TABLE demande_statut
ADD COLUMN duree_total INT,
ADD COLUMN duree_travaille INT;

CREATE TABLE reduction(
    id SERIAL PRIMARY KEY,
    valeur NUMERIC(10,2)
);
INSERT INTO reduction(valeur) VALUES(1000000);

-- CREATE TABLE chiffre_affaire(
--     id SERIAL PRIMARY KEY,
--     id_type_devis INT REFERENCES type_devis(id),
--     montant_global_devis NUMERIC(10,2)
-- );

CREATE TABLE chiffre_affaire_total(
    id SERIAL PRIMARY KEY,
    montant_global_devis_total NUMERIC(10,2)
);

CREATE TABLE horaire_travail (
    id SERIAL PRIMARY KEY,
    jour_semaine INT,
    debut_matin TIME,
    fin_matin TIME,
    debut_aprem TIME,
    fin_aprem TIME,
    actif BOOLEAN DEFAULT true
);
INSERT INTO horaire_travail(jour_semaine, debut_matin, fin_matin, debut_aprem, fin_aprem) VALUES
(1,'08:00','12:00','12:00','16:00'),
(2,'08:00','12:00','12:00','16:00'),
(3,'08:00','12:00','12:00','16:00'),
(4,'08:00','12:00','12:00','16:00'),
(5,'08:00','12:00','12:00','16:00');


CREATE TABLE level(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(20)
);
INSERT INTO level(nom) VALUES
('eleve'),
('critique');
-- level 1 : critique (rouge) / level 2 : eleve (jaune)


CREATE TABLE indicateur(
    id SERIAL PRIMARY KEY,
    id_statut1 INT REFERENCES statut(id),
    id_statut2 INT REFERENCES statut(id),
    interval1 INT,
    interval2 INT,
    level INT REFERENCES level(id)
);
INSERT INTO indicateur(id_statut1, id_statut2, interval1, interval2, level) VALUES
(1, 2, 8, 10, 1),
(1, 2, 24, 48, 2),
(2, 3, 4, 5, 1),
(2, 3, 6, 8, 2),
(3, 4, 1, 2, 1),
(3, 4, 3, 4, 2),
(4, 5, 4, 8, 1),
(4, 5, 10, 12, 2),
(5, 6, 20, 30, 1),
(5, 6, 30, 60, 2),
(6, 7, 60, 70, 1),
(6, 7, 80, 100, 2);

