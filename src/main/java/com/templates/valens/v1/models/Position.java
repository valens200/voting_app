package com.templates.valens.v1.models;

import com.templates.valens.v1.audits.InitiatorAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Position  extends InitiatorAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    @ManyToMany(mappedBy = "positions", fetch = FetchType.EAGER)
    private Set<Candidate> candidates;

    @ManyToMany(mappedBy = "positions", fetch = FetchType.EAGER)
    private Set<VotingSession>  votingSessions;

    public Position(String name) {
        this.name = name;
    }

}
