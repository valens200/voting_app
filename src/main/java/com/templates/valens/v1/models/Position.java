package com.templates.valens.v1.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    @ManyToMany(mappedBy = "positions")
    private List<Candidate> candidates;

    @ManyToMany(mappedBy = "positions")
    private List<VotingSession>  votingSessions;

}
