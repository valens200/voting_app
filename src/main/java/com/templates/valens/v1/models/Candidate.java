package com.templates.valens.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Candidate  extends Person{
    @OneToOne
    @JoinColumn(name = "profile_id")
    private User profile;

    @OneToMany
    private List<Vote> votes;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "candidates_positions", joinColumns=@JoinColumn(name = "candidate_id"), inverseJoinColumns = @JoinColumn(name = "position_id"))
    @JsonIgnore
    private List<Position> positions;
}
