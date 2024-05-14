package com.templates.valens.v1.services;

import com.templates.valens.v1.dtos.requests.CreateVoteDTO;
import com.templates.valens.v1.models.User;
import com.templates.valens.v1.models.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface IVoteService {

    public Vote create(CreateVoteDTO dto);
    public Vote voteMany(List<CreateVoteDTO> voteDTOS);
    public Vote update(CreateVoteDTO dto,UUID voteId);
    public void delete(UUID id);
    public List<Vote> getAll();

    Vote getById(UUID voteId);

    public Page<Vote> getAllPaginated(Pageable pageable);

    Map<String, Map<String, Set<User>>> getResults(UUID sessionId);

    int countVotesByCandidate(UUID candidateId, UUID votingSessionId);

    public Page<Vote> getAllBYPosition(UUID positionId, Pageable pageable);
    public Page<Vote> getAllPositionAndCandidate(UUID positionId, UUID candidateId, Pageable pageable);
    public Page<Vote> getAllByCandidate(UUID candidateId, Pageable pageable);

}
