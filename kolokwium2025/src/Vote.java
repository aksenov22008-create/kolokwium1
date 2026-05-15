import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vote {
    private Map<Candidate,Integer> votesForCandidate=new HashMap<>();
    private List<Location> location = new ArrayList<>();

    public Vote(Map<Candidate, Integer> votesForCandidate, List<Location> location) {
        this.votesForCandidate = votesForCandidate;
        this.location = location;
    }
    public static Vote fromCsvLine(String line, List<Candidate> candidates){
        String[] fields = line.split(",");
        List<Location> loc=new  ArrayList<>();
        loc.add(new Location(fields[0],fields[1],fields[2]));
        Map<Candidate,Integer> cand=new HashMap<>();

        for (int i = 0;
             i < candidates.size();
             i++) {

            int votes =
                    Integer.parseInt(
                            fields[i + 3]
                    );

            cand.put(
                    candidates.get(i),
                    votes
            );
        }
        return new Vote(cand,loc);
    }
    public static class Location{
        private String wojewodztwo;
        private String powiat;
        private String gminy;

        public Location(String wojewodztwo, String powiat, String gminy) {
            this.wojewodztwo = wojewodztwo;
            this.powiat = powiat;
            this.gminy = gminy;
        }

        public String getWojewodztwo() {
            return wojewodztwo;
        }

        public String getPowiat() {
            return powiat;
        }

        public String getGminy() {
            return gminy;
        }
    }

}
