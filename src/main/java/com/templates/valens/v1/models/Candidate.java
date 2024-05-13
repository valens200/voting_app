package com.templates.valens.v1.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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

    public Candidate(String firstName, String lastName, String nationalId, String phoneNumber, String email){
        super(firstName,lastName,nationalId,phoneNumber, email);
    }
    public Candidate(){
        super();
    }
}
