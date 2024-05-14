package com.templates.valens.v1.services;

import com.templates.valens.v1.dtos.requests.CreateCandidateDTO;
import com.templates.valens.v1.models.Candidate;
import com.templates.valens.v1.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ICandidateService {
    public Candidate create(CreateCandidateDTO dto);
    public Candidate update(CreateCandidateDTO dto, UUID candidateId);
    public void delete(UUID candidateId);

    Candidate getById(UUID candidateId);

    Candidate getByProfile(User profile);

    public List<Candidate> getAll();
    public Page<Candidate> getAllPaginated(Pageable pageable);
    public Page<Candidate> getAllByPosition(Pageable pageable, UUID positionId);
}
