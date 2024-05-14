package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreateVoteDTO;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.Vote;
import com.templates.valens.v1.repositories.IVoteRepository;
import com.templates.valens.v1.services.*;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl extends ServiceImpl implements IVoteService {
    private final IVoteRepository voteRepository;
    private final ICandidateService candidateService;
    private final IPositionService positionService;
    private final IVotingSessionService sessionService;
    private final IUserService userService;

    @Override
    public Vote create(CreateVoteDTO dto) {
        try{
            user = userService.getLoggedInUser();
            candidate = candidateService.getById(dto.getCandidateId());
            position = positionService.getById(dto.getPositionId());
            vote = new Vote(candidate,position,user);
            return  voteRepository.save(vote);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Vote voteMany(List<CreateVoteDTO> voteDTOS) {
        try{
            for(CreateVoteDTO dto : voteDTOS){
                user = userService.getLoggedInUser();
                candidate = candidateService.getById(dto.getCandidateId());
                position = positionService.getById(dto.getPositionId());
                vote = new Vote(candidate,position,user);
                voteRepository.save(vote);
            }
            return null;
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Vote update(CreateVoteDTO dto, UUID voteId) {
        try{
            vote = this.getById(voteId);
            candidate = candidateService.getById(dto.getCandidateId());
            position = positionService.getById(dto.getPositionId());
            vote = new Vote(candidate,position,user);
            user = userService.getById(dto.getVoterId());
            vote.setCandidate(candidate);
            vote.setVoter(user);
            vote.setPosition(position);
            return voteRepository.save(vote);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public void delete(UUID id) {
        try{
            vote = this.getById(id);
            voteRepository.delete(vote);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
        }

    }

    @Override
    public List<Vote> getAll() {
        try{
            return this.voteRepository.findAll();
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public Vote getById(UUID voteId){
        try{
            return this.voteRepository.findById(voteId).orElseThrow(()-> new NotFoundException("The vote with the provided id is not found"));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Page<Vote> getAllPaginated(Pageable pageable) {
        try{
            return voteRepository.findAll(pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Page<Vote> getAllBYPosition(UUID positionId, Pageable pageable) {
        try{
            position = positionService.getById(positionId);
            return this.voteRepository.findAllByPosition(position, pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Page<Vote> getAllPositionAndCandidate(UUID positionId, UUID candidateId, Pageable pageable) {
        try{
            candidate = candidateService.getById(candidateId);
            position = positionService.getById(positionId);
            return voteRepository.findAllByPositionAndCandidate(position,candidate, pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public Page<Vote> getAllByCandidate(UUID candidateId, Pageable pageable) {
        try{
            candidate = candidateService.getById(candidateId);
            return voteRepository.findAllByCandidate(candidate, pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
}
