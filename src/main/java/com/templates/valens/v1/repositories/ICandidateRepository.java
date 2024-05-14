package com.templates.valens.v1.repositories;

import com.templates.valens.v1.models.Candidate;
import com.templates.valens.v1.models.Position;
import com.templates.valens.v1.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICandidateRepository extends JpaRepository<Candidate , UUID> {
    Page<Candidate> findAllByPositionsContains(Position position, Pageable pageable);
    Optional<Candidate> findByProfile(User profile);
}
