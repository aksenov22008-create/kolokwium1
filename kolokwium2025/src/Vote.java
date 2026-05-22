import java.util.*;

public class Vote {

    // Кандидат -> голоси
    private Map<Candidate,Integer>
            votesForCandidate =
            new HashMap<>();

    // Воєводство, повіт, гміна
    private List<String> location =
            new ArrayList<>();

    // Кеш суми
    private Integer totalVotes =
            null;


    // Створення Vote з csv
    public static Vote fromCsvLine(
            String line,
            List<Candidate> candidates){

        Vote vote =
                new Vote();

        String[] data =
                line.split(",");


        // Додаємо місце
        vote.location.add(data[0]);
        vote.location.add(data[1]);
        vote.location.add(data[2]);


        // Додаємо голоси
        for(int i=0;
            i<candidates.size();
            i++){

            Candidate candidate =
                    candidates.get(i);

            int votes =
                    Integer.parseInt(
                            data[i+3]
                    );

            vote.votesForCandidate.put(
                    candidate,
                    votes
            );
        }

        return vote;
    }


    // Голоси кандидата
    public int votes(
            Candidate candidate){

        return votesForCandidate
                .getOrDefault(
                        candidate,
                        0
                );
    }


    // Загальна сума
    private int totalVotes(){

        if(totalVotes==null){

            totalVotes=0;

            for(Integer value :
                    votesForCandidate.values()){

                totalVotes+=value;
            }
        }

        return totalVotes;
    }


    // Відсоток кандидата
    public double percentage(
            Candidate candidate){

        return votes(candidate)
                *100.0
                /totalVotes();
    }


    // Сумарний результат
    public static Vote summarize(
            List<Vote> voteList){

        return summarize(
                voteList,
                new ArrayList<>()
        );
    }


    // Сумарний результат з локацією
    public static Vote summarize(
            List<Vote> voteList,
            List<String> location){

        Vote summary =
                new Vote();

        summary.location =
                location;

        if(voteList.isEmpty()){

            return summary;
        }

        Set<Candidate> candidates =
                voteList
                        .get(0)
                        .votesForCandidate
                        .keySet();

        for(Candidate candidate :
                candidates){

            int sum=0;

            for(Vote vote :
                    voteList){

                sum+=vote.votes(
                        candidate
                );
            }

            summary.votesForCandidate
                    .put(
                            candidate,
                            sum
                    );
        }

        return summary;
    }


    // Фільтр по місцю
    public static List<Vote>
    filterByLocation(
            List<Vote> votes,
            List<String> location){

        List<Vote> result =
                new ArrayList<>();


        for(Vote vote : votes){

            boolean ok=true;

            for(int i=0;
                i<location.size();
                i++){

                if(!vote.location
                        .get(i)
                        .equals(
                                location.get(i)
                        )){

                    ok=false;
                }
            }

            if(ok){

                result.add(vote);
            }

        }

        return result;
    }


    public Map<Candidate,Integer>
    getVotesForCandidate(){

        return votesForCandidate;
    }


    @Override
    public String toString(){

        String result="";

        for(Candidate candidate :
                votesForCandidate.keySet()){

            result +=
                    candidate.name();

            result += " ";

            result +=
                    String.format(
                            "%.2f",
                            percentage(
                                    candidate
                            )
                    );

            result += "%\n";
        }

        return result;
    }

}