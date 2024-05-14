package com.templates.valens.v1.services.ServiceImpl;
import com.templates.valens.v1.dtos.requests.CreateCandidateDTO;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.Candidate;
import com.templates.valens.v1.models.User;
import com.templates.valens.v1.repositories.ICandidateRepository;
import com.templates.valens.v1.repositories.IPositionRepository;
import com.templates.valens.v1.repositories.IUserRepository;
import com.templates.valens.v1.services.ICandidateService;
import com.templates.valens.v1.services.IUserService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import com.templates.valens.v1.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl extends ServiceImpl  implements ICandidateService {
    private final ICandidateRepository candidateRepository;
    private final IUserRepository userRepository;
    private final IUserService userService;
    private final IPositionRepository positionRepository;
    @Override
    public Candidate create(CreateCandidateDTO dto) {
        try{
            candidate = new Candidate(dto.getFirstName(), dto.getLastName(), dto.getNationalId(), dto.getPhoneNumber(), dto.getEmail());
            user = new User(dto.getEmail(), dto.getUserName(), SecurityUtils.HashString(dto.getPassword()));
            user = userRepository.save(user);
            candidate.setProfile(user);
            return candidateRepository.save(candidate);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Candidate update(CreateCandidateDTO dto, UUID candidateId) {
        try{
            candidate = this.getById(candidateId);

            user = userService.getByEmail(candidate.getEmail());

            user.setUserName(dto.getUserName());
            user.setEmail(dto.getEmail());
            user.setPassword(SecurityUtils.HashString(dto.getPassword()));
            user = userRepository.save(user);

            candidate.setFirstName(dto.getFirstName());
            candidate.setLastName(dto.getLastName());
            candidate.setNationalId(dto.getNationalId());
            candidate.setPhoneNumber(dto.getPhoneNumber());
            candidate.setProfile(user);
            return this.candidateRepository.save(candidate);

        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }



    @Override
    public void delete(UUID candidateId) {
        try {
           candidateRepository.deleteById(candidateId);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return;
        }
    }
    @Override
    public Candidate getById(UUID candidateId){
        try{
            return candidateRepository.findById(candidateId).orElseThrow(()-> new NotFoundException("The candidate with the provided id is not found."));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Candidate getByProfile(User profile){
        try{
            return candidateRepository.findByProfile(profile).orElseThrow(()-> new NotFoundException("The candidate with the provided profile is not found"));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public List<Candidate> getAll() {
        try{
            return candidateRepository.findAll();
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Page<Candidate> getAllPaginated(Pageable pageable) {
        try{
            return candidateRepository.findAll(pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Page<Candidate> getAllByPosition(Pageable pageable, UUID positionId) {
        try {
            position = positionRepository.findById(positionId).orElseThrow(()-> new NotFoundException("The positition with the provided id is not found"));
            return candidateRepository.findAllByPositionsContains(position,pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
}
