package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.errors.ErrorCode;
import org.lampropoul.jobsfeeder.helpers.FeederHelper;
import org.lampropoul.jobsfeeder.helpers.Response;
import org.lampropoul.jobsfeeder.model.Job;
import org.lampropoul.jobsfeeder.repositories.JobRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    private JobRepository jobRepository;
    private FeederHelper<JobRepository, Job> feederHelper;

    public JobsController(JobRepository jobRepository, FeederHelper<JobRepository, Job> feederHelper) {
        this.jobRepository = jobRepository;
        this.feederHelper = feederHelper;
    }

    @PostMapping
    public ResponseEntity<Job> create(@RequestBody Job job) {
        return feederHelper.saveAndGenerateResponse(jobRepository, job);
    }

    @DeleteMapping
    public ResponseEntity<Response<?>> delete(@RequestBody Job job) {
        Response<Job> response = new Response<>();
        try {
            jobRepository.delete(job);
            response.setObject(job);
        } catch (Exception e) {
            response.setError(ErrorCode.NOT_EXISTS.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
