package com.templates.valens.v1.services;


import com.templates.valens.v1.dtos.requests.CreateVotingSessionDTO;
import com.templates.valens.v1.models.VotingSession;

import java.util.List;
import java.util.UUID;

public interface IVotingSessionService {

    public VotingSession create(CreateVotingSessionDTO sessionDTO);
    public VotingSession update(CreateVotingSessionDTO sessionDTO,UUID sessionId);
    public void delete(UUID sessionId);
    public List<VotingSession> getAll();
}
