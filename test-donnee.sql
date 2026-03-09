CREATE TABLE matiere (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    coeff INT
);

CREATE TABLE candidat (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    dtn DATE, 
    sexe CHAR(1)
);

CREATE TABLE correcteur (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    dtn DATE,
    sexe CHAR(1),
    adresse VARCHAR(255),
    cin VARCHAR(50)
);

CREATE TABLE resolution (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100)
);

CREATE TABLE operateur (
    id SERIAL PRIMARY KEY,
    operateur VARCHAR(100)
);

INSERT INTO operateur(operateur) VALUES
('<'),
('>');

CREATE TABLE parametre (
    id SERIAL PRIMARY KEY,
    id_matiere INT REFERENCES matiere(id),
    diff_seuil INT,
    id_operateur INT REFERENCES operateur(id),
    id_resolution INT REFERENCES resolution(id)
);
INSERT INTO parametre(id_matiere, diff_seuil, id_operateur, id_resolution) VALUES
(1, 3, 1, 1),
(1, 3, 2, 3);

CREATE TABLE note (
    id SERIAL PRIMARY KEY,
    id_candidat INT REFERENCES candidat(id),
    id_matiere INT REFERENCES matiere(id),
    id_correcteur INT REFERENCES correcteur(id),
    note NUMERIC(10,2)
);
INSERT INTO note(id_candidat, id_matiere, id_correcteur, note) VALUES
(1, 1, 1, 6),
(1, 1, 2, 7),
(1, 1, 3, 8);

CREATE TABLE note_final (
    id SERIAL PRIMARY KEY,
    id_candidat INT REFERENCES candidat(id),
    id_matiere INT REFERENCES matiere(id),
    note_final NUMERIC(10,2)
);