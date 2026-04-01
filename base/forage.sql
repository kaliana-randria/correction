CREATE TABLE client(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    contact VARCHAR(100)
);

INSERT INTO client(nom, contact) VALUES
('Rakoto', '0392019834'),
('Ratiana', '0382347589');

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
-- INSERT INTO statut(libelle) VALUES
-- ('cree'),
-- ('devis etude cree'),
-- ('devis etude accepte'),
-- ('devis etude refuse'),
-- ('devis forage cree'),
-- ('devis forage accepte'),
-- ('devis forage refuse');

INSERT INTO statut(libelle) VALUES
('cree'),
('devis etude cree'),
('devis forage cree');

-- cree
-- etude cree
-- forage cree

CREATE TABLE demande_statut(
    id SERIAL PRIMARY KEY,
    id_demande INT REFERENCES demande(id),
    id_statut INT REFERENCES statut(id),
    date TIMESTAMP
);