package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.helpers.FeederHelper;
import org.lampropoul.jobsfeeder.helpers.Response;
import org.lampropoul.jobsfeeder.model.Job;
import org.lampropoul.jobsfeeder.repositories.JobRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobsController {

    private JobRepository jobRepository;
    private FeederHelper<JobRepository, Job> feederHelper;

    public JobsController(JobRepository jobRepository, FeederHelper<JobRepository, Job> feederHelper) {
        this.jobRepository = jobRepository;
        this.feederHelper = feederHelper;
    }

    @PostMapping("/jobs/new")
    public Response<Job> create(@RequestBody Job job) {
        return feederHelper.saveAndGenerateResponse(jobRepository, job);
    }
}
