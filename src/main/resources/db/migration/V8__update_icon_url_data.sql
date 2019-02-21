update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/kabali/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Kabali');
update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/banjo/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Banjo');
update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/suicide/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Suicide');
update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/pink/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Pink');
update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/kabali/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Kabali2');
update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/banjo/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Banjo2');
update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/suicide/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Suicide2');
update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/pink/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Pink2');
update  Movie set icon_url='https://img.spicinemas.in/resources/images/movies/banjo/150x207.jpg' where movie.ID IN(select Movie.id from Movie where name = 'Sultan2');

