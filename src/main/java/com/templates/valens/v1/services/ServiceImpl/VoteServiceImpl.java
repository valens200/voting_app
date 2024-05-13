package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreateVoteDTO;
import com.templates.valens.v1.models.Vote;
import com.templates.valens.v1.services.IVoteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoteServiceImpl implements IVoteService {
    @Override
    public Vote create(CreateVoteDTO dto) {
        return null;
    }

    @Override
    public Vote voteMany(List<CreateVoteDTO> voteDTOS) {
        return null;
    }

    @Override
    public Vote update(CreateVoteDTO dto, UUID voteId) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<Vote> getAll() {
        return null;
    }

    @Override
    public Page<Vote> getAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Vote> getAllBYPosition(UUID positionId) {
        return null;
    }

    @Override
    public Page<Vote> getAllPositionAndCandidate(UUID positionId, UUID candidateId) {
        return null;
    }

    @Override
    public Page<Vote> getAllByCandidate(UUID candidateId) {
        return null;
    }
}
