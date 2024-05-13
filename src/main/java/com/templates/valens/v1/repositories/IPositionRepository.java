package com.templates.valens.v1.repositories;
import com.templates.valens.v1.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IPositionRepository extends JpaRepository<Position, UUID> {
}
