package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreateVotingSessionDTO;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.VotingSession;
import com.templates.valens.v1.repositories.IVotingSessionRepository;
import com.templates.valens.v1.services.IVotingSessionService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VotingSessionServiceImpl extends ServiceImpl implements IVotingSessionService {
    private final IVotingSessionRepository sessionRepository;

    @Override
    public VotingSession create(CreateVotingSessionDTO sessionDTO) {
        try{
            session = new VotingSession(sessionDTO.getTitle(),sessionDTO.getStartDate(),sessionDTO.getEndDate());
            return sessionRepository.save(session);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public VotingSession update(CreateVotingSessionDTO sessionDTO, UUID sessionId) {
        try{
            session = this.getById(sessionId);
            session.setTitle(sessionDTO.getTitle());
            session.setStartDate(sessionDTO.getStartDate());
            session.setEndDate(sessionDTO.getEndDate());
            return sessionRepository.save(session);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public VotingSession getById(UUID sessionId){
        try{
            return sessionRepository.findById(sessionId).orElseThrow(()-> new NotFoundException("The session with the provided id is not found"));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public void delete(UUID sessionId) {
        try {
            session = this.getById(sessionId);
            sessionRepository.delete(session);
        }catch (Exception e){
            ExceptionsUtils.handleServiceExceptions(e);
            return;
        }
    }
    @Override
    public List<VotingSession> getAll() {
        try{
            return sessionRepository.findAll();
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public Page<VotingSession> getAllPaginated(Pageable pageable) {
        try{
            return sessionRepository.findAll(pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
}
