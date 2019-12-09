package org.lampropoul.jobsfeeder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lampropoul.jobsfeeder.model.Company;
import org.lampropoul.jobsfeeder.model.Job;
import org.lampropoul.jobsfeeder.model.Location;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobsFeederApplicationTests {

    private Job job;
    private TestRestTemplate testRestTemplate;
    private HttpHeaders headers;
    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        testRestTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        job = new Job();
        job.setTitle("Backend Engineer");
        job.setCompany(new Company());
        job.setLocation(new Location());
    }

    @Test
    public void createJob() {
        HttpEntity<Job> entity = new HttpEntity<>(job, headers);
        ResponseEntity<Job> response = testRestTemplate.exchange(createURLWithPort("/jobs"), HttpMethod.POST, entity, Job.class);
        assert response.getStatusCode() == HttpStatus.CREATED || response.getStatusCode() == HttpStatus.OK;
    }

    private String createURLWithPort(String path) {
        return "http://localhost:" + port + path;
    }

}
