package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreateVotingSessionDTO;
import com.templates.valens.v1.models.VotingSession;
import com.templates.valens.v1.services.IVotingSessionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VotingSessionServiceImpl implements IVotingSessionService {
    @Override
    public VotingSession create(CreateVotingSessionDTO sessionDTO) {
        return null;
    }

    @Override
    public VotingSession update(CreateVotingSessionDTO sessionDTO, UUID sessionId) {
        return null;
    }

    @Override
    public void delete(UUID sessionId) {

    }
    @Override
    public List<VotingSession> getAll() {
        return null;
    }
}
