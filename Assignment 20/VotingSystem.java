import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private LinkedHashMap<String, Integer> orderedVoteMap = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVoteMap = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVoteMap.put(candidate, orderedVoteMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    public Map<String, Integer> getVotes() {
        return voteMap;
    }

    public Map<String, Integer> getOrderedVotes() {
        return orderedVoteMap;
    }

    public Map<String, Integer> getSortedVotes() {
        return sortedVoteMap;
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        
        System.out.println("Vote Counts: " + votingSystem.getVotes());
        System.out.println("Votes in Order: " + votingSystem.getOrderedVotes());
        System.out.println("Sorted Votes: " + votingSystem.getSortedVotes());
    }
}
