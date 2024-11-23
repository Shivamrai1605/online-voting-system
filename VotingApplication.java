package com.example.voting;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
public class VotingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotingApplication.class, args);
    }

    // Load initial candidates
    @Bean
    CommandLineRunner initDatabase(CandidateRepository repository) {
        return args -> {
            repository.save(new Candidate("Candidate 1"));
            repository.save(new Candidate("Candidate 2"));
            repository.save(new Candidate("Candidate 3"));
        };
    }
}

// Candidate Entity
@Entity
class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int votes;

    public Candidate() {}

    public Candidate(String name) {
        this.name = name;
        this.votes = 0; // Default votes
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}

// Repository Interface
interface CandidateRepository extends JpaRepository<Candidate, Long> {}

// Service Layer
@Service
class CandidateService {

    private final CandidateRepository repository;

    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public List<Candidate> getAllCandidates() {
        return repository.findAll();
    }

    public Candidate voteForCandidate(Long id) {
        Candidate candidate = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Candidate not found with ID: " + id));
        candidate.setVotes(candidate.getVotes() + 1);
        return repository.save(candidate);
    }
}

// Controller
@RestController
@RequestMapping("/api/v1/voting")
class VotingController {

    private final CandidateService candidateService;

    public VotingController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // Endpoint to get all candidates
    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    // Endpoint to vote for a candidate
    @PostMapping("/vote/{id}")
    public ResponseEntity<String> voteForCandidate(@PathVariable Long id) {
        candidateService.voteForCandidate(id);
        return ResponseEntity.ok("Vote cast successfully!");
    }
}
