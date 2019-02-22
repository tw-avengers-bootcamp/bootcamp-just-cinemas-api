INSERT INTO Status(id, type) VALUES (1, 'now-showing');
INSERT INTO Status(id, type) VALUES (2, 'upcoming');

INSERT INTO Location(id, name) VALUES (1, 'Chennai');
INSERT INTO Location(id, name) VALUES (2, 'Bangalore');
INSERT INTO Location(id, name) VALUES (3, 'Mumbai');
INSERT INTO Location(id, name) VALUES (4, 'Madurai');


INSERT INTO Language(id, name) VALUES(1,'English');
INSERT INTO Language(id, name) VALUES(2,'Hindi');
INSERT INTO Language(id, name) VALUES(3,'Tamil');
INSERT INTO Language(id, name) VALUES(4,'Marathi');


--INSERT INTO Banner(banner_id, banner_url) VALUES (1,'https://img.spicinemas.in/resources/images/movies/Kabali/1000x320.jpg');
--INSERT INTO Banner(banner_id, banner_url) VALUES (2,'https://img.spicinemas.in/resources/images/movies/Sultan/1000x320.jpg');
--INSERT INTO Banner(banner_id, banner_url) VALUES (3,'https://img.spicinemas.in/resources/images/movies/Banjo/1000x320.jpg');
--INSERT INTO Banner(banner_id, banner_url) VALUES (4,'https://img.spicinemas.in/resources/images/movies/Suicide/1000x320.jpg');
--INSERT INTO Banner(banner_id, banner_url) VALUES (5,'https://img.spicinemas.in/resources/images/movies/Namadhu/1000x320.jpg');
--INSERT INTO Banner(banner_id, banner_url) VALUES (6,'https://img.spicinemas.in/resources/images/movies/Pelli/1000x320.jpg');
--INSERT INTO Banner(banner_id, banner_url) VALUES (7,'https://img.spicinemas.in/resources/images/movies/Pink/1000x320.jpg');
--INSERT INTO Banner(banner_id, banner_url) VALUES (8,'https://img.spicinemas.in/resources/images/movies/Remo/1000x320.jpg');
--INSERT INTO Banner(banner_id, banner_url) VALUES (9,'https://img.spicinemas.in/resources/images/movies/Inferno/1000x320.jpg');

INSERT INTO Movie(name, synopsis, rating, status_id, language_id, banner_url) VALUES('Kabali', ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tortor est, feugiat sit amet sagittis nec, viverra vehicula orci. Sed pulvinar imperdiet nunc vel fringilla. In ac facilisis orci. Ut suscipit nisl scelerisque elit finibus, sed auctor velit placerat. Mauris et lacus in felis finibus dictum vel non mauris. Integer feugiat augue vitae mauris ultricies sodales. Nam semper tincidunt viverra. Aliquam pellentesque dolor nec tortor semper, sed rhoncus magna tincidunt.', 5, 1, 3, 'https://img.spicinemas.in/resources/images/movies/Kabali/1000x320.jpg');

INSERT INTO Movie(name, synopsis, rating, status_id, language_id, banner_url) VALUES('Banjo', ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tortor est, feugiat sit amet sagittis nec, viverra vehicula orci. Sed pulvinar imperdiet nunc vel fringilla. In ac facilisis orci. Ut suscipit nisl scelerisque elit finibus, sed auctor velit placerat. Mauris et lacus in felis finibus dictum vel non mauris. Integer feugiat augue vitae mauris ultricies sodales. Nam semper tincidunt viverra. Aliquam pellentesque dolor nec tortor semper, sed rhoncus magna tincidunt.', 5, 1, 1, 'https://img.spicinemas.in/resources/images/movies/Sultan/1000x320.jpg');

INSERT INTO Movie(name, synopsis, rating, status_id, language_id, banner_url) VALUES('Suicide', ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tortor est, feugiat sit amet sagittis nec, viverra vehicula orci. Sed pulvinar imperdiet nunc vel fringilla. In ac facilisis orci. Ut suscipit nisl scelerisque elit finibus, sed auctor velit placerat. Mauris et lacus in felis finibus dictum vel non mauris. Integer feugiat augue vitae mauris ultricies sodales. Nam semper tincidunt viverra. Aliquam pellentesque dolor nec tortor semper, sed rhoncus magna tincidunt.', 5, 1, 1, 'https://img.spicinemas.in/resources/images/movies/Banjo/1000x320.jpg');

INSERT INTO Movie(name, synopsis, rating, status_id, language_id, banner_url) VALUES('Kabali', ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tortor est, feugiat sit amet sagittis nec, viverra vehicula orci. Sed pulvinar imperdiet nunc vel fringilla. In ac facilisis orci. Ut suscipit nisl scelerisque elit finibus, sed auctor velit placerat. Mauris et lacus in felis finibus dictum vel non mauris. Integer feugiat augue vitae mauris ultricies sodales. Nam semper tincidunt viverra. Aliquam pellentesque dolor nec tortor semper, sed rhoncus magna tincidunt.', 5, 1, 1, 'https://img.spicinemas.in/resources/images/movies/Suicide/1000x320.jpg');

INSERT INTO Movie(name, synopsis, rating, status_id, language_id, banner_url) VALUES('Kabali', ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tortor est, feugiat sit amet sagittis nec, viverra vehicula orci. Sed pulvinar imperdiet nunc vel fringilla. In ac facilisis orci. Ut suscipit nisl scelerisque elit finibus, sed auctor velit placerat. Mauris et lacus in felis finibus dictum vel non mauris. Integer feugiat augue vitae mauris ultricies sodales. Nam semper tincidunt viverra. Aliquam pellentesque dolor nec tortor semper, sed rhoncus magna tincidunt.', 5, 2, 1, 'https://img.spicinemas.in/resources/images/movies/Namadhu/1000x320.jpg');

INSERT INTO Movie(name, synopsis, rating, status_id, language_id, banner_url) VALUES('Pink', ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tortor est, feugiat sit amet sagittis nec, viverra vehicula orci. Sed pulvinar imperdiet nunc vel fringilla. In ac facilisis orci. Ut suscipit nisl scelerisque elit finibus, sed auctor velit placerat. Mauris et lacus in felis finibus dictum vel non mauris. Integer feugiat augue vitae mauris ultricies sodales. Nam semper tincidunt viverra. Aliquam pellentesque dolor nec tortor semper, sed rhoncus magna tincidunt.', 5, 1, 2, 'https://img.spicinemas.in/resources/images/movies/Pink/1000x320.jpg');

INSERT INTO movielocation(movie_id, location_id) VALUES(1, 1);
INSERT INTO movielocation(movie_id, location_id) VALUES(2, 2);
INSERT INTO movielocation(movie_id, location_id) VALUES(1, 3);
INSERT INTO movielocation(movie_id, location_id) VALUES(3, 4);

INSERT INTO Experience(id, type,movie_id) VALUES(1,'RDX, Dolby Atmos, SUB',1);
INSERT INTO Experience(id, type,movie_id) VALUES(2,'RDX 3D',2);
INSERT INTO Experience(id, type,movie_id) VALUES(3,'RDX, SUB',3);


INSERT INTO Still(id, url, movie_id) VALUES (1,'https://img.spicinemas.in/resources/images/movies/Kabali/150x207.jpg',1);
INSERT INTO Still(id, url, movie_id) VALUES (2,'https://img.spicinemas.in/resources/images/movies/Banjo/150x207.jpg',2);
INSERT INTO Still(id, url, movie_id) VALUES (3,'https://img.spicinemas.in/resources/images/movies/Suicide/150x207.jpg',3);
INSERT INTO Still(id, url, movie_id) VALUES (4,'https://img.spicinemas.in/resources/images/movies/Pelli/150x207.jpg',4);
INSERT INTO Still(id, url, movie_id) VALUES (5,'https://img.spicinemas.in/resources/images/movies/Pink/150x207.jpg',5);
INSERT INTO Still(id, url, movie_id) VALUES (6,'https://img.spicinemas.in/resources/images/movies/Remo/150x207.jpg',6);


INSERT INTO Trailer(id, url, movie_id) VALUES (1,'https://www.youtube.com/watch?v=JfbxcD6biOk',1);
INSERT INTO Trailer(id, url, movie_id) VALUES (2,'https://www.youtube.com/watch?v=JfbxcD6biOk',2);
INSERT INTO Trailer(id, url, movie_id) VALUES (3,'https://www.youtube.com/watch?v=JfbxcD6biOk',3);
INSERT INTO Trailer(id, url, movie_id) VALUES (4,'https://www.youtube.com/watch?v=JfbxcD6biOk',4);
INSERT INTO Trailer(id, url, movie_id) VALUES (5,'https://www.youtube.com/watch?v=JfbxcD6biOk',5);
INSERT INTO Trailer(id, url, movie_id) VALUES (6,'https://www.youtube.com/watch?v=JfbxcD6biOk',6);
