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

CREATE TABLE correction (
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

CREATE TABLE parametre (
    id SERIAL PRIMARY KEY,
    id_matiere INT REFERENCES matiere(id),
    diff_seuil INT,
    id_operateur INT REFERENCES operateur(id),
    id_resolution INT REFERENCES resolution(id)
);

CREATE TABLE note (
    id SERIAL PRIMARY KEY,
    id_candidat INT REFERENCES candidat(id),
    id_matiere INT REFERENCES matiere(id),
    note NUMERIC(10,2)
);

CREATE TABLE note_final (
    id SERIAL PRIMARY KEY,
    id_candidat INT REFERENCES candidat(id),
    id_matiere INT REFERENCES matiere(id),
    note_final NUMERIC(10,2)
);