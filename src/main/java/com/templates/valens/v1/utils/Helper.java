package com.templates.valens.v1.utils;
import com.templates.valens.v1.models.User;
import com.templates.valens.v1.models.Vote;
import java.util.*;

public class Helper {
    public static  Map<String, Map<String, Set<User>>> getGroupedVotes(List<Vote> votes){
        Map<String, Map<String, Set<User>>> groupedVotes = new HashMap<>();
        Map<String, Set<User>> votesAndCandidates = new HashMap<>();

        for(Vote vote : votes){
            String position = vote.getPosition().getName();
            String candidateName = vote.getCandidate().getProfile().getUserName();
            groupedVotes.computeIfAbsent(position, k -> new HashMap<>())
                    .computeIfAbsent(candidateName,k -> new HashSet<>())
                    .add(vote.getVoter());
        }
        return groupedVotes;
    }
}
