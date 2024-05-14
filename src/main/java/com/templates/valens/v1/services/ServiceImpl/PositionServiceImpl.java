package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreatePositionDTO;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.Position;
import com.templates.valens.v1.repositories.IPositionRepository;
import com.templates.valens.v1.services.ICandidateService;
import com.templates.valens.v1.services.IPositionService;
import com.templates.valens.v1.services.IVotingSessionService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl extends ServiceImpl implements IPositionService {
    private final IPositionRepository positionRepository;
    private final ICandidateService candidateService;
    private final IVotingSessionService sessionService;
    @Override
    public Position create(CreatePositionDTO dto) {
        try{
            position = new Position(dto.getName());
            return positionRepository.save(position);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Position update(CreatePositionDTO dto, UUID positionId) {
        try{
            position = this.getById(positionId);
            position.setName(dto.getName());
            return positionRepository.save(position);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public void delete(UUID positionId) {
        try{
            position = this.getById(positionId);
            positionRepository.delete(position);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
        }

    }

    @Override
    public List<Position> getAll() {
        try{
            return positionRepository.findAll();
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Position getById(UUID positionId) {
        try {
            return positionRepository.findById(positionId).orElseThrow(()->new NotFoundException("The position with the provided id is not found"));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Page<Position> getAllPaginated(Pageable pageable) {
        try{
            return positionRepository.findAll(pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Position assignCandidate(UUID candidateId, UUID positionId) {
        candidates = new HashSet<>();
        try{
            candidate = candidateService.getById(candidateId);
            position = this.getById(positionId);
            candidates = position.getCandidates();
            candidates.add(candidate);
            position.setCandidates(candidates);
            return positionRepository.save(position);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Position removeCandidate(UUID candidateId, UUID positionId) {
        candidates = new HashSet<>();
        try{
            candidate = candidateService.getById(candidateId);
            position = this.getById(positionId);
            candidates = position.getCandidates();
            candidates.remove(candidate);
            position.setCandidates(candidates);
            return positionRepository.save(position);

        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Position removeVotingSession(UUID sessionId, UUID positionId) {
        sessions = new HashSet<>();
        try{
            position = this.getById(positionId);
            session = sessionService.getById(sessionId);
            sessions = position.getVotingSessions();
            sessions.remove(session);
            position.setVotingSessions(sessions);
            return positionRepository.save(position);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Position assignVotingSession(UUID sessionId, UUID positionId) {
        sessions = new HashSet<>();
        try{
            position = this.getById(positionId);
            session = sessionService.getById(sessionId);
            sessions = position.getVotingSessions();
            sessions.add(session);
            position.setVotingSessions(sessions);
            return positionRepository.save(position);

        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }



    @Override
    public Page<Position> getAllBySession(UUID sessionId, Pageable pageable) {
        try{
            session = sessionService.getById(sessionId);
            return positionRepository.findAllByVotingSessionsContains(session,pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public List<Position> getAllBySession(UUID sessionId) {
        try{
            session = sessionService.getById(sessionId);
            return positionRepository.findAllByVotingSessionsContains(session);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
}
