package com.templates.valens.v1.repositories;

import com.templates.valens.v1.models.Candidate;
import com.templates.valens.v1.models.Position;
import com.templates.valens.v1.models.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IVoteRepository extends JpaRepository<Vote, UUID> {
    Page<Vote> findAllByPosition(Position position, Pageable pageable);
    Page<Vote> findAllByCandidate(Candidate candidate, Pageable pageable);
    Page<Vote> findAllByPositionAndCandidate(Position position, Candidate candidate, Pageable pageable);
}
