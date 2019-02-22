DROP TABLE IF EXISTS Status CASCADE;
CREATE TABLE IF NOT EXISTS Status (
       id serial PRIMARY KEY,
       type VARCHAR(25) CHECK (type IN ('now-showing', 'upcoming'))
);

DROP TABLE IF EXISTS Location CASCADE;
CREATE TABLE IF NOT EXISTS Location (
       id serial PRIMARY KEY,
       name VARCHAR(50)
);

DROP TABLE IF EXISTS LANGUAGE CASCADE;
CREATE TABLE IF NOT EXISTS LANGUAGE (
       id serial PRIMARY KEY,
       name VARCHAR(25)
);
DROP TABLE IF EXISTS Movie CASCADE;
CREATE TABLE IF NOT EXISTS Movie (
       id serial PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       synopsis TEXT NOT NULL,
       rating INTEGER,
       status_id INTEGER REFERENCES Status(id) ,
       language_id INTEGER REFERENCES language(id),
       banner_url TEXT
);



DROP TABLE IF EXISTS Still CASCADE;
CREATE TABLE IF NOT EXISTS Still (
       id serial PRIMARY KEY,
       url text,
       movie_id INTEGER REFERENCES movie(id)
);

DROP TABLE IF EXISTS Trailer CASCADE;
CREATE TABLE IF NOT EXISTS Trailer (
       id serial PRIMARY KEY,
       url text,
       movie_id INTEGER REFERENCES movie(id)
);

DROP TABLE IF EXISTS Experience CASCADE;
CREATE TABLE IF NOT EXISTS Experience (
       id serial PRIMARY KEY,
       type text,
       movie_id INTEGER REFERENCES movie(id)
);



DROP TABLE IF EXISTS Banner CASCADE;


DROP TABLE IF EXISTS movielocation CASCADE;
CREATE TABLE IF NOT EXISTS movielocation (
       id serial PRIMARY KEY,
       movie_id INTEGER REFERENCES movie(id),
       location_id INTEGER REFERENCES location(id),
       name VARCHAR(50)
);

---trailer,stills

/*
DROP TABLE IF EXISTS StatusRepository CASCADE;
DROP TABLE IF EXISTS Location CASCADE;
DROP TABLE IF EXISTS LANGUAGE CASCADE;
DROP TABLE IF EXISTS Movie CASCADE;
DROP TABLE IF EXISTS Still CASCADE;
DROP TABLE IF EXISTS Trailer CASCADE;
DROP TABLE IF EXISTS Experience CASCADE;
DROP TABLE IF EXISTS Banner CASCADE;


DROP TABLE IF EXISTS Movie_Location CASCADE;
DROP TABLE IF EXISTS SCHEMA_VERSION CASCADE;
DROP TABLE IF EXISTS SCHEMA_VERSION CASCADE;
*/

