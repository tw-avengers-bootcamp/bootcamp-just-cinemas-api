package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.entities.StatusEntity;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class StatusRepositoryTest {

    @Autowired
    private
    StatusRepository statusRepository;

    @Test
    public void testIfStatusDataIsLoaded() {
        Assert.assertTrue(statusRepository.count() > 0);
    }

    @Test
    public void testFindByName() {
        List<StatusEntity> statuses = statusRepository.findByType("upcoming");
        Assert.assertNotNull(statuses);
        Assert.assertEquals(statuses.get(0).getName(), "upcoming");
    }

}
