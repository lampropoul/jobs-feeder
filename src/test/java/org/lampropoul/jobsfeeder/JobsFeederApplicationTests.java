package org.lampropoul.jobsfeeder;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.lampropoul.jobsfeeder.model.Company;
import org.lampropoul.jobsfeeder.model.Job;
import org.lampropoul.jobsfeeder.model.Location;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JobsFeederApplicationTests {

    private Job job;
    private TestRestTemplate restTemplate;
    private HttpHeaders headers;
    @LocalServerPort
    private int port;

    JobsFeederApplicationTests() {
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        job = new Job();
        job.setTitle("Backend Engineer");
        job.setCompany(new Company());
        job.setLocation(new Location());
    }

    private String createURLWithPort(String servicePath) {
        return "http://localhost:" + port + servicePath;
    }

    @Test
    public void createAndDeleteJob() {
        HttpEntity<Job> entity = new HttpEntity<>(job, headers);
        ResponseEntity<Job> response = restTemplate.exchange(createURLWithPort("/jobs"), HttpMethod.POST, entity, Job.class);
        job.setId(Objects.requireNonNull(response.getBody()).getId());
        assert response.getStatusCode() == HttpStatus.CREATED || response.getStatusCode() == HttpStatus.OK;
        response = restTemplate.exchange(createURLWithPort("/jobs"), HttpMethod.DELETE, entity, Job.class);
        assert response.getStatusCode() == HttpStatus.OK;
    }

}
