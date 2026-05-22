import java.io.*;
import java.util.*;

public class ElectionTurn {

    // Кандидати
    private List<Candidate>
            candidates;

    // Голоси
    private List<Vote>
            votes =
            new ArrayList<>();


    public ElectionTurn(
            List<Candidate> candidates){

        this.candidates=
                candidates;
    }


    // Завантаження csv
    public void populate(
            String path)
            throws Exception{

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(path)
                );

        reader.readLine();

        String line;

        while(
                (line=
                        reader.readLine())
                        !=null
        ){

            Vote vote =
                    Vote.fromCsvLine(
                            line,
                            candidates
                    );

            votes.add(vote);
        }

        reader.close();
    }


    // Підсумок всіх
    public Vote summarize(){

        return Vote.summarize(
                votes
        );
    }


    // Підсумок по місцю
    public Vote summarize(
            List<String> location){

        List<Vote> filteredVotes =
                Vote.filterByLocation(
                        votes,
                        location
                );

        return Vote.summarize(
                filteredVotes,
                location
        );
    }


    // Переможець
    public Candidate winner()
            throws NoWinnerException{

        Vote summary =
                summarize();

        for(Candidate candidate :
                candidates){

            if(summary
                    .percentage(
                            candidate
                    )>50){

                return candidate;
            }

        }

        throw new NoWinnerException();
    }


    // Два найкращих
    public List<Candidate>
    runoffCandidates(){

        Vote summary =
                summarize();

        List<Candidate> result =
                new ArrayList<>(
                        candidates
                );

        result.sort(
                (a,b)->
                        summary.votes(b)
                                -
                                summary.votes(a)
        );

        return result
                .subList(0,2);
    }

}