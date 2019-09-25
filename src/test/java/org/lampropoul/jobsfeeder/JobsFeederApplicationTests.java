package org.lampropoul.jobsfeeder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lampropoul.jobsfeeder.model.Job;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobsFeederApplicationTests {

    private TestRestTemplate testRestTemplate = new TestRestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    @Test
    public void createJob() {
        Job job = new Job();
        job.setTitle("Backend Engineer");
        HttpEntity<Job> entity = new HttpEntity<>(job, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(createURLWithPort("/jobs/new"), HttpMethod.POST, entity, String.class);
        assert response != null;
    }

    private String createURLWithPort(String path) {
        return "http://localhost:" + port + path;
    }

}
