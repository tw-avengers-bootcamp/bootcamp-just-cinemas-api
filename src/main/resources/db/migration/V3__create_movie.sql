DROP TABLE IF EXISTS Status CASCADE;
CREATE TABLE IF NOT EXISTS Status (
       status_id serial PRIMARY KEY,
       status VARCHAR(25) CHECK (status IN ('now showing', 'upcoming')) DEFAULT 'upcoming'
);

DROP TABLE IF EXISTS Location CASCADE;
CREATE TABLE IF NOT EXISTS Location (
       location_id serial PRIMARY KEY,
       location VARCHAR(50)
);

DROP TABLE IF EXISTS LANGUAGE CASCADE;
CREATE TABLE IF NOT EXISTS LANGUAGE (
       language_id serial PRIMARY KEY,
       LANGUAGE VARCHAR(25)
);
DROP TABLE IF EXISTS Movie CASCADE;
CREATE TABLE IF NOT EXISTS Movie (
       movie_id serial PRIMARY KEY,
       movie_name VARCHAR(255) NOT NULL,
       synopsis TEXT NOT NULL,
       rating INTEGER,
       status_id INTEGER REFERENCES Status(status_id) ,
       language_id INTEGER REFERENCES language(language_id),
       banner_url TEXT
);



DROP TABLE IF EXISTS Still CASCADE;
CREATE TABLE IF NOT EXISTS Still (
       still_id serial PRIMARY KEY,
       still_url text,
       movie_id serial
);

DROP TABLE IF EXISTS Trailer CASCADE;
CREATE TABLE IF NOT EXISTS Trailer (
       trailer_id serial PRIMARY KEY,
       trailer_url text,
       movie_id serial
);

DROP TABLE IF EXISTS Experience CASCADE;
CREATE TABLE IF NOT EXISTS Experience (
       experience_id serial PRIMARY KEY,
       experience text
);



DROP TABLE IF EXISTS Banner CASCADE;


DROP TABLE IF EXISTS Movie_Location CASCADE;
CREATE TABLE IF NOT EXISTS Movie_Location (
       movie_location_id serial PRIMARY KEY,
       movie_id INTEGER REFERENCES movie(movie_id),
       location_id INTEGER REFERENCES location(location_id)
);

---trailer,stills

/*
DROP TABLE IF EXISTS Status CASCADE;
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


