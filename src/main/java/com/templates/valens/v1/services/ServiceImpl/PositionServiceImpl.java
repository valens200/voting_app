package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreatePositionDTO;
import com.templates.valens.v1.models.Position;
import com.templates.valens.v1.services.IPositionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PositionServiceImpl implements IPositionService {
    @Override
    public Position create(CreatePositionDTO dto) {
        return null;
    }

    @Override
    public Position update(CreatePositionDTO dto, UUID positionId) {
        return null;
    }

    @Override
    public void delete(UUID positionId) {

    }

    @Override
    public List<Position> getAll() {
        return null;
    }

    @Override
    public Page<Position> getAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public Position assignCandidate(UUID candidateId, UUID positionId) {
        return null;
    }

    @Override
    public Position removeCandidate(UUID candidateId, UUID positionId) {
        return null;
    }

    @Override
    public Position removeVotingSession(UUID sessionId, UUID positionId) {
        return null;
    }

    @Override
    public Position assignVotingSession(UUID sessionId, UUID positionId) {
        return null;
    }

    @Override
    public Page<Position> getAllBySession(UUID sessionId) {
        return null;
    }
}
