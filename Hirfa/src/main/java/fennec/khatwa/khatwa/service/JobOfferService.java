package fennec.khatwa.khatwa.service;


import fennec.khatwa.khatwa.dto.JobOfferDTO;
import fennec.khatwa.khatwa.model.JobOffer;
import fennec.khatwa.khatwa.model.JobRequest;
import fennec.khatwa.khatwa.model.User;
import fennec.khatwa.khatwa.repository.JobOfferRepository;
import fennec.khatwa.khatwa.repository.JobRequestRepository;
import fennec.khatwa.khatwa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOfferService {

    private final JobOfferRepository jobOfferRepository;

    private final  JobRequestRepository jobRequestRepository;

    private final UserRepository userRepository;

    public JobOfferService(JobOfferRepository jobOfferRepository, JobRequestRepository jobRequestRepository, UserRepository userRepository) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobRequestRepository = jobRequestRepository;
        this.userRepository = userRepository;
    }

    public JobOffer createJobOffer(JobOfferDTO jobOfferDTO) {
        JobRequest jobRequest = jobRequestRepository.findById(jobOfferDTO.getJobRequestId()).orElseThrow();
        User freelancer = userRepository.findById(jobOfferDTO.getFreelancerId()).orElseThrow();
        JobOffer jobOffer = new JobOffer();
        jobOffer.setJobRequest(jobRequest);
        jobOffer.setFreelancer(freelancer);
        jobOffer.setPrice(jobOfferDTO.getPrice());
        return jobOfferRepository.save(jobOffer);
    }

    public List<JobOffer> getAllJobOffers() {
        return jobOfferRepository.findAll();
    }
}