package com.realdolmen.spring.service;

import com.realdolmen.spring.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by cda5732 on 14/04/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("lars-test")
// TODO Select the right profile
public class ZooIntegrationTestCase {

    @Autowired
    private Zoo zoo;

    @Test
    public void shouldHaveAntwerpZooPropertiesFilledIn() {
        assertThat(zoo.getName(), is("Antwerp Zoo"));
        // TODO assert the Zoo values come from the test properties
    }

    @Test
    public void shouldHavePrice3_5() {
        assertEquals(3.5, zoo.getZooTicketPrice(), 0.001);
    }

    @Test
    public void shouldHaveOwnerNameAsterixTest() {
        assertEquals("Asterixtest", zoo.getZooOwnerName());
    }

    @Test
    public void shouldHaveZooName() { assertEquals("Pantheontest", zoo.getZooName()); }
}
