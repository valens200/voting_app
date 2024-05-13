package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreateCandidateDTO;
import com.templates.valens.v1.models.Candidate;
import com.templates.valens.v1.services.ICandidateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CandidateServiceImpl  implements ICandidateService {
    @Override
    public Candidate create(CreateCandidateDTO dto) {
        return null;
    }

    @Override
    public Candidate update(CreateCandidateDTO dto, UUID candidateId) {
        return null;
    }

    @Override
    public void delete(UUID candidateId) {

    }

    @Override
    public List<Candidate> getAll() {
        return null;
    }

    @Override
    public Page<Candidate> getAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Candidate> getAllByPosition(Pageable pageable, UUID positionId) {
        return null;
    }
}
