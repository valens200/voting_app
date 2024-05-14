package com.templates.valens.v1.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "postition_id")
    private Position position;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @OneToOne
    @JoinColumn(name = "voter_id")
    private User voter;

    public Vote(Candidate candidate, Position position, User voter) {
        this.candidate = candidate;
        this.position = position;
        this.voter = voter;
    }
}
