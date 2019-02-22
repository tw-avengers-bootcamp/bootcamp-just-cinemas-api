DROP TABLE IF EXISTS Show cascade;
create table SHOW(
  id serial  primary key,
  max_seats INTEGER,
  show_date DATE  DEFAULT current_date,
  amount INTEGER,
  movie_location_id INTEGER references movielocation(id)

);

DROP TABLE IF EXISTS orders cascade;
create table orders(
  id serial  primary key,
  show_id INTEGER REFERENCES show(id),
  seats INTEGER,
  email VARCHAR(50),
  order_date DATE DEFAULT CURRENT_TIMESTAMP,
  order_no VARCHAR(50)  NOT NULL unique
);


DROP TABLE IF EXISTS ticket cascade;
create table ticket(
  id serial  primary key,
  order_id INTEGER NOT NULL REFERENCES orders(id),
  ticket_no VARCHAR(50)  NOT NULL unique
);;








