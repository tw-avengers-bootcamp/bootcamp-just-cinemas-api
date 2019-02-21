package spicinemas.api.db;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.entities.LanguageEntity;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class LanguageRepositoryTest {

  @Autowired
  private
  LanguageRepository languageRepository;


  @Test
  public void testLanguageDataIsLoaded(){
    LanguageEntity languageEntity = new LanguageEntity();
    languageEntity.setId(1L);
    languageEntity.setName("Tamil");
    languageRepository.save(languageEntity);
    Assert.assertNotNull(languageRepository.findOne(1L));
    Assert.assertEquals("Tamil",languageRepository.findOne(1L).getName());
  }


}
