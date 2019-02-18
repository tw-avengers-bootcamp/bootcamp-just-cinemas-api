DROP TABLE IF EXISTS Status;
CREATE TABLE IF NOT EXISTS Status (
       status_id serial PRIMARY KEY,
       status VARCHAR(25) CHECK (status IN ('now showing', 'upcoming')) DEFAULT 'upcoming'
);

DROP TABLE IF EXISTS Location;
CREATE TABLE IF NOT EXISTS Location (
       location_id serial PRIMARY KEY,
       location VARCHAR(50)
);

DROP TABLE IF EXISTS Still;
CREATE TABLE IF NOT EXISTS Still (
       still_id serial PRIMARY KEY,
       still_url text
);

DROP TABLE IF EXISTS Trailer;
CREATE TABLE IF NOT EXISTS Trailer (
       trailer_id serial PRIMARY KEY,
       trailer_url text
);

DROP TABLE IF EXISTS Experience;
CREATE TABLE IF NOT EXISTS Experience (
       experience_id serial PRIMARY KEY,
       experience text
);

DROP TABLE IF EXISTS LANGUAGE;
CREATE TABLE IF NOT EXISTS LANGUAGE (
       language_id serial PRIMARY KEY,
       LANGUAGE VARCHAR(25)
);

DROP TABLE IF EXISTS Banner;
CREATE TABLE IF NOT EXISTS Banner (
       banner_id serial PRIMARY KEY,
       banner_url text
);

DROP TABLE IF EXISTS Movie;
CREATE TABLE IF NOT EXISTS Movie (
       movie_id serial PRIMARY KEY,
       movie_name VARCHAR(255) NOT NULL,
       synopsis TEXT NOT NULL,
       rating INTEGER,
       status_id INTEGER REFERENCES Status(status_id) ,
       location_id INTEGER REFERENCES Location(location_id),
       language_id INTEGER REFERENCES language(language_id),
       banner_id INTEGER REFERENCES Banner(banner_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Movie_Location;
CREATE TABLE IF NOT EXISTS Movie_Location (
       movie_location_id serial PRIMARY KEY,
       movie_id INTEGER REFERENCES movie(movie_id),
       location_id INTEGER REFERENCES location(location_id)
);