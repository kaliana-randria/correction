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