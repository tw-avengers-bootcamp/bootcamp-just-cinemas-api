package spicinemas.api.db;

import org.jooq.*;
import org.junit.Test;
import org.mockito.Mockito;
import spicinemas.api.model.Experience;
import spicinemas.api.model.Language;
import spicinemas.api.model.Movie;




public class MovieRepositoryTest {
    private MovieRepository movieRepo;
    DSLContext dslContext;



    @Test
    public void shouldInsertUserInDb(){
    /*    String movieName = "Infinity War";
        Movie expectedMovie = new Movie();
        movieRepo.addMovie(expectedMovie);
        Movie actualMovie = movieRepo.getMovie(movieName);
        assertThat(actualMovie.getMovieName(), is(expectedMovie.getMovieName()));
        assertThat(actualMovie.getExperience().getName(), is(expectedMovie.getExperience().getName()));*/

        dslContext = Mockito.mock(DSLContext.class);

        String movieName = "Infinity War";
        Movie expectedMovie = new Movie();
        expectedMovie.setBannerUrl("testUrl");
        Experience expectedExperience=new Experience();
        expectedExperience.setName("atmos digital");
        expectedMovie.setExperiences(expectedExperience);
        Language language = new Language();
        language.setLanguage("tamil");
        expectedMovie.setLanguage(language);



        Record3 record = Mockito.mock(Record3.class);
        Mockito.when(record.into(Mockito.any(Movie.class))).thenReturn(expectedMovie);
        SelectConditionStep selectConditionStep = Mockito.mock(SelectConditionStep.class);
        Mockito.when(selectConditionStep.fetchOne()).thenReturn(record);

        SelectJoinStep selectJoinStep = Mockito.mock(SelectJoinStep.class);
        Mockito.when(selectJoinStep.where(Mockito.any(Condition.class))).thenReturn(selectConditionStep);

        SelectSelectStep selectSelectStep =Mockito.mock(SelectSelectStep.class);
        Mockito.when(selectSelectStep.from(Mockito.any(Table.class))).thenReturn(selectJoinStep);
        Mockito.when(dslContext.select(Mockito.any(Field.class),Mockito.any(Field.class),Mockito.any(Field.class))).thenReturn(selectSelectStep);
        MovieRepository movieRepo =new MovieRepository(dslContext);

      Movie movie=movieRepo.getMovie("test");
        Mockito.verify(dslContext, Mockito.times(1)).select(Mockito.any(Field.class),Mockito.any(Field.class),Mockito.any(Field.class));




    }
}