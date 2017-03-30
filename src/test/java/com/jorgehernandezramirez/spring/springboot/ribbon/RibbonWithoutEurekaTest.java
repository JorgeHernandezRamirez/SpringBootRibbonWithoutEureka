package com.jorgehernandezramirez.spring.springboot.ribbon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RibbonWithoutEurekaTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnAliveFromPingUrl() throws Exception {
        final String pingResult = testRestTemplate.getForEntity("/ping", String.class).getBody();
        assertEquals("Alive!", pingResult);
    }

    @Test
    public void shouldReturnAliveFromPingRestUrl() throws Exception {
        final String pingRestResult = testRestTemplate.getForEntity("/ping/rest", String.class).getBody();
        assertEquals("Alive!", pingRestResult);
    }

    @Test
    public void shouldReturnAliveFromPingRestRibbonUrl() throws Exception {
        final String pingRestResult = testRestTemplate.getForEntity("/ping/rest/ribbon", String.class).getBody();
        assertEquals("Alive!", pingRestResult);
    }
}
