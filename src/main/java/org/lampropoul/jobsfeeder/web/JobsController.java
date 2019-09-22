package org.lampropoul.jobsfeeder.web;

import org.lampropoul.jobsfeeder.helpers.ControllersHelper;
import org.lampropoul.jobsfeeder.helpers.Response;
import org.lampropoul.jobsfeeder.model.Job;
import org.lampropoul.jobsfeeder.repositories.JobRepository;
import org.lampropoul.jobsfeeder.services.SequenceGeneratorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobsController {

    private JobRepository jobRepository;
    private SequenceGeneratorService sequenceGeneratorService;

    public JobsController(JobRepository jobRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.jobRepository = jobRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @PostMapping("/jobs/new")
    public Response<Job> create(@RequestBody Job job) {
        return new ControllersHelper<JobRepository, Job>().saveAndGenerateResponse(jobRepository, job, sequenceGeneratorService);
    }
}
