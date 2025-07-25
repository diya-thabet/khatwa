package fennec.khatwa.khatwa.controller;


import fennec.khatwa.khatwa.dto.JobRequestDTO;
import fennec.khatwa.khatwa.model.JobRequest;
import fennec.khatwa.khatwa.service.JobRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/job-requests")
public class JobRequestController {

    @Autowired
    private JobRequestService jobRequestService;

    @GetMapping
    public List<JobRequest> getAllJobRequests() {
        return jobRequestService.getAllJobRequests();
    }

    @PostMapping
    public JobRequest createJobRequest(@RequestBody JobRequestDTO jobRequestDTO) {
        return jobRequestService.createJobRequest(jobRequestDTO);
    }
}