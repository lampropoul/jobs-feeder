package org.lampropoul.jobsfeeder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.lampropoul.jobsfeeder.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JobsFeederApplicationTests {

    @Qualifier("webApplicationContext")
    @Autowired
    private ResourceLoader resourceLoader;

    private final ObjectMapper objectMapper;
    private TestRestTemplate restTemplate;
    private HttpHeaders headers;

    @LocalServerPort
    private int port;

    JobsFeederApplicationTests() {
        objectMapper = new ObjectMapper();
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    private HttpEntity<Job> getRequestEntity(String resourceFilename) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + resourceFilename);
        Job entity = objectMapper.readValue(resource.getFile(), Job.class);
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        return new HttpEntity<>(entity, headers);
    }

    private String createURLWithPort(String servicePath) {
        return "http://localhost:" + port + servicePath;
    }

    @Test
    public void createAndDeleteJob() throws IOException {
        HttpEntity<Job> entity = getRequestEntity("job_new.json");
        ResponseEntity<Job> response = restTemplate.exchange(
                createURLWithPort("/jobs"),
                HttpMethod.POST,
                entity,
                Job.class);
        Objects.requireNonNull(entity.getBody())
                .setId(
                        Objects.requireNonNull(
                                response.getBody()
                        ).getId()
                );
        assert response.getStatusCode() == HttpStatus.CREATED;
        response = restTemplate.exchange(createURLWithPort("/jobs"), HttpMethod.DELETE, entity, Job.class);
        assert response.getStatusCode() == HttpStatus.OK;
    }

}
