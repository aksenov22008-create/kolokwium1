import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ElectionTurn {
    private List<Candidate> candidateList;
    private List<Vote> votes;

    public ElectionTurn(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }
    public void populate(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            Vote vote =
                    Vote.fromCsvLine(
                            line,
                            candidateList
                    );

            votes.add(vote);
        }

        reader.close();
    }
}
