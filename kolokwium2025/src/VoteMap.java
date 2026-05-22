import java.util.HashMap;
import java.util.Map;

public class VoteMap
        extends VoivodeshipMap{

    // Результати голосування
    private Map<String,Vote>
            results =
            new HashMap<>();


    // Колір для кандидата
    private Map<Candidate,String>
            colors =
            new HashMap<>();


    public VoteMap(
            Map<String,Vote> results){

        this.results=
                results;
    }


    // Додаємо колір
    public void addColor(
            Candidate candidate,
            String color){

        colors.put(
                candidate,
                color
        );
    }


    protected String getColor(
            String voivodeship){

        Vote vote =
                results.get(
                        voivodeship
                );

        if(vote==null){

            return "gray";
        }

        Candidate winner=null;

        int maxVotes=0;


        for(Candidate candidate :
                vote
                        .getVotesForCandidate()
                        .keySet()){

            int votes =
                    vote.votes(
                            candidate
                    );

            if(votes>maxVotes){

                maxVotes=votes;

                winner=candidate;
            }

        }

        return colors.get(
                winner
        );
    }

}