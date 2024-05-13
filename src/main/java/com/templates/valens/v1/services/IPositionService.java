package com.templates.valens.v1.services;

import com.templates.valens.v1.dtos.requests.CreatePositionDTO;
import com.templates.valens.v1.models.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IPositionService {
    public Position create(CreatePositionDTO dto);
    public Position update(CreatePositionDTO dto, UUID positionId);
    public void delete(UUID positionId);
    public List<Position> getAll();
    public Position getById(UUID positionId);
    public Page<Position> getAllPaginated(Pageable pageable);
    public Position assignCandidate(UUID candidateId, UUID positionId);
    public Position removeCandidate(UUID candidateId, UUID positionId);
    public Position removeVotingSession(UUID sessionId, UUID positionId);
    public Position assignVotingSession(UUID sessionId, UUID positionId);
    public Page<Position> getAllBySession(UUID sessionId);
}
