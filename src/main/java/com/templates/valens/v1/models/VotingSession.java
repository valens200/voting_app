package com.templates.valens.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class VotingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;

    private Date startDate;
    private Date endDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sessions_positions", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "position_id"))
    @JsonIgnore
    private List<Position> positions;
}
