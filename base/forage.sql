CREATE TABLE client(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    contact VARCHAR(100)
);

INSERT INTO client(nom, contact) VALUES
('RABE Jean', '034 10 300 01');
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
('devis forage cree');

-- INSERT INTO statut(libelle) VALUES
-- ('devis etude accepte'),
-- ('devis etude refuse'),
-- ('devis forage accepte'),
-- ('devis forage refuse');

CREATE TABLE demande_statut(
    id SERIAL PRIMARY KEY,
    id_demande INT REFERENCES demande(id),
    id_statut INT REFERENCES statut(id),
    date TIMESTAMP
);
ALTER TABLE demande_statut 
ADD COLUMN observation VARCHAR(255);

ALTER TABLE demande_statut 
ADD COLUMN duree_tsotra INT;

ALTER TABLE demande_statut 
ADD COLUMN duree_sarotra INT;

CREATE TABLE reduction(
    id SERIAL PRIMARY KEY,
    valeur NUMERIC(10,2)
);
INSERT INTO reduction(valeur) VALUES(1000000);

CREATE TABLE chiffre_affaire(
    id SERIAL PRIMARY KEY,
    id_type_devis INT REFERENCES type_devis(id),
    montant_global_devis NUMERIC(10,2)
);

CREATE TABLE chiffre_affaire_total(
    id SERIAL PRIMARY KEY,
    montant_global_devis_total NUMERIC(10,2)
);