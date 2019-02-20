package spicinemas.api.db;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class LanguageRepositoryTest {

  @Autowired
  LanguageRepository languageRepository;


  @Test
  public void testLanguageDataIsLoaded(){
    Assert.assertTrue(languageRepository.count()>0);
  }


}
