package com.templates.valens.v1.repositories;
import com.templates.valens.v1.models.Position;
import com.templates.valens.v1.models.VotingSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IPositionRepository extends JpaRepository<Position, UUID> {
    Page<Position> findAllByVotingSessionsContains(VotingSession votingSession, Pageable pageable);
    List<Position> findAllByVotingSessionsContains(VotingSession votingSession);

}
